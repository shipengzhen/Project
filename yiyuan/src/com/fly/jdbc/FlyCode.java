package com.fly.jdbc;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * Fly�Ĵ������ɹ���
 */
public class FlyCode {

	
	/**
	 * ����һ�������ο���insert����
	 */
	public static String insert(String tableName){
		String modelName=one2xXX(tableName);
		
		List<String>columnList=getColumn(tableName);
		String sk="",sv="",sc="";	//�в��֣�ֵ���֣���������
		for (String columnName : columnList) {
			sk+=columnName+",";
			sv+="?,";
			sc+=modelName+".get"+setget(columnName)+"(),";
		}

		String fnName="save("+one2Xxx(tableName)+" "+one2xXX(tableName)+")";	//�������β�
		String sql=" insert into "+tableName+"("+oneLast2Drop(sk.toString())+
				") value ("+oneLast2Drop(sv.toString())+")";
		
		return getHanShu("����һ����¼", fnName, sql, oneLast2Drop(sc.toString()), 0, "");
	}
	
	/**
	 * ����һ�������ο���update����(�������޸�)
	 */
	public static String update(String tableName){
		String modelName=one2xXX(tableName);
		List<String>columnList=getColumn(tableName);
		
		String pk=table_pk(tableName);	//����
		String sk="",sc="";				//set�β��֣�args����
		for (String columnName : columnList) {
			if(columnName.equals(pk)) {
				continue;
			}
			sk+=columnName+"=?,";
			sc+=modelName+".get"+setget(columnName)+"(),";
		}
		String fnName="update("+one2Xxx(tableName)+" "+one2xXX(tableName)+")";	//�������β�
		String sql="update "+tableName+" set "+oneLast2Drop(sk)+" where "+pk+"=?";	//�ټӸ�����
		sc+=modelName+".get"+setget(pk)+"(),";
		
		return getHanShu("�޸�һ����¼(��������)", fnName, sql, oneLast2Drop(sc), 0, "");
	}
	
	/**
	 * ����һ�������ο���delete����(������ɾ��)
	 */
	public static String delete(String tableName) {
		String sql="delete from "+tableName+" where "+table_pk(tableName)+"=?";
		return getHanShu("ɾ��һ����¼(��������)","delete(int id)", sql, "id", 0, "");
	}

	/**
	 * ���ɽ����ο���find���� (findById findAll)
	 */
	public static String find(String tableName) {
		
		String sql_findById="select * from "+tableName+" where "+table_pk(tableName)+"=?";
		String findById=getHanShu("��ѯһ����¼(��������)","findById(int id)", sql_findById, "id", 1, one2Xxx(tableName));
		
		String findAll=getHanShu("��ѯȫ��","findAll()", "select * from "+tableName, "", 2, one2Xxx(tableName));
		
		return findById+findAll;
	}

	/* * * * * �ۺ�  * * * * */

	/**
	 * ָ��һ�ű��Model	
	 * <p>�������ֶ���ʽ(a-Сд��A-��д������-����)
	 */
	public static String model(String tableName,String way){
		boolean is_sql=false;		//�Ƿ���Sql��
		Map<String,String>comments=comments(tableName);	//ע��
		StringBuilder prop=new StringBuilder();			//prop
		StringBuilder setget=new StringBuilder();		//set��get
		StringBuilder sts=new StringBuilder();			//toString()����
		try {
			String sql="select * from "+tableName+" where 1=0";
			ResultSetMetaData rsmd=Fly.getFly().getResultSet(sql).getMetaData();
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				String cType=JDBC2JT(rsmd.getColumnClassName(i+1));	//����
				if(cType.equals("Date")||cType.equals("Timestamp")){is_sql=true;}
				
				String propName=rsmd.getColumnName(i+1);	//����
				propName=toaA(propName, way);
				String comment=comments.get(propName);		//ע��
				if(comment==null){comment="";}
				
				prop.append("\tprivate "+cType+" "+propName+";\t\t//"+comment+"\r\n");	//׷���ֶ�
				setget.append(toDoc("@return "+comment));	//getter
				setget.append("\tpublic "+cType+" get"+setget(propName)+"(){\r\n\t\treturn "+propName+";\r\n\t}\r\n");
				setget.append(toDoc("@param "+propName+" "+comment));	//setter
				setget.append("\tpublic "+one2Xxx(tableName)+" set"+setget(propName)+"("+cType+" "+propName+") {\r\n\t\tthis."+propName+"="+propName+";\r\n\t\treturn this;\r\n\t}\r\n");
				sts.append("\t\t\t\t\" ,"+propName+"=\" + "+propName+" + \r\n");	//toString()
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//toString()
		String sts_head="\t/* (non-Javadoc)\r\n\t * @see java.lang.Object#toString()\r\n\t */\r\n\t@Override\r\n";
		sts_head+="\tpublic String toString() {\r\n\t\treturn \""+one2Xxx(tableName+" [");
		try {
			sts=new StringBuilder(sts.substring(7,sts.length()-3));
		} catch (Exception e) {	}
		sts.insert(0,sts_head);
		sts.append(" \"]\";\r\n\t}\r\n");
		
		//������֯
		String str="public class "+one2Xxx(tableName)+"{\r\n\r\n";	//ͷ
		if(is_sql==true){
			str="import java.sql.*;\r\n\r\n"+str;
		}
		
		str+=prop+"\r\n";		//prop
		str+=setget+"\r\n";		//set get
		str+=sts+"\r\n";		//toString()
		str+="\r\n}\r\n";	//����
		
		return str;
	}
	
	/**
	 * һ������������Model�࣬��IO��ָ����ַ
	 * <p>���б���ʽ����Ŀ��ַ������ַ
	 */
	public static void modelAll(List<String>tables,String way,String projectPath,String packagePath) {
		int cg=0,sb=0;
		
		File wjj=new File(projectPath,packagePath.replace(".","\\"));		//����·��
		wjj.mkdirs();
		System.out.println("Model(sum:"+tables.size()+")Դ·��"+wjj.getAbsolutePath()+"�����ɹ�\n");
		
		for (String tableName : tables) {
			try {
				//�����ļ�
				String txt="package "+packagePath+";\r\n\r\n"+model(tableName, way);
				String filePath=wjj.getAbsolutePath()+"\\"+one2Xxx(tableName)+".java";
				writerOut(filePath, txt);
				
				cg++;
				System.out.println("��"+tableName+"  \tд����ɣ�");
				
			} catch (Exception e) {
				sb++;
				System.err.println("��"+tableName+"  \tд��ʧ�ܣ�����ԭ��"+e.getMessage());
			}
		}
		
		System.out.println("\n����"+tables.size()+"   �ɹ���"+cg+"  ʧ�ܣ�"+sb+"\r\n\r\n");
	}
	
	/**
	 * ָ��һ�ű�Ľӿ�
	 * <p>��������ʽ(I@Dao-->IUserDao)��Model����
	 */
	public static String intface(String tableName,String way) {
		String IName=way.replaceAll("@",tableName);
		String crud="";

		crud+="\t/** ����һ����¼ */\r\n";
		crud+="\tpublic int save("+tableName+" obj);\r\n\r\n";

		crud+="\t/** ɾ��һ����¼(��������) */\r\n";
		crud+="\tpublic int delete(int id);\r\n\r\n";

		crud+="\t/** �޸�һ����¼(��������) */\r\n";
		crud+="\tpublic int update("+tableName+" obj);\r\n\r\n";
		
		crud+="\t/** ��ѯһ����¼(��������) */\r\n";
		crud+="\tpublic "+tableName+" findById(int id);\r\n\r\n";
		
		crud+="\t/** ��ѯȫ�� */\r\n";
		crud+="\tpublic List<"+tableName+"> findAll();\r\n\r\n";
		
		String intface="import java.util.*;\r\n\r\n"
				+ "public interface "+IName+"{\r\n\r\n"+crud+"\r\n\r\n}\r\n";
		return intface;
	}
	/**
	 * ָ��һ�ű�Ľӿ�ʵ����
	 */
	public static String intfaceImpl(String tableName,String wayI,String wayImpl) {
		String IName=wayI.replaceAll("@",tableName);
		String ImplName=wayImpl.replaceAll("@",tableName);
		String crud="";
		
		//crud+="\tprivate SqlFly sy=Fly.getFly();\t//�ײ�SqlFly����\r\n\r\n";
		crud+="\t//�ײ�SqlFly����\r\n\tprivate SqlFly getFly() {\r\n\t\treturn Fly.getFly();\r\n\t}\r\n\r\n";
				
		crud+=insert(tableName);
		crud+=delete(tableName);
		crud+=update(tableName);
		crud+=find(tableName);

		String intfaceImpl="import com.fly.jdbc.*;\r\nimport java.util.*;\r\n\r\n"
				+ "public class "+ImplName+" implements "+IName+" {\r\n\r\n"+crud+"\r\n\r\n}\r\n";
		return intfaceImpl;
	}
	
	/**
	 * һ�����������б�Ľӿں�ʵ����,��IO��ָ����ַ
	 * <p>������ò������ڸ��ӣ���������makeCode�ļ��������
	 */
	public static void intfaceAll(List<String>tables,String wayI,String wayImpl,
			String projectPath,String modelPath,String IPath,String ImplPath) {
			
			int gong=0,bai=0;	//�ɹ���ʧ��
			//I���Ե�ַ��Impl���Ե�ַ
			String f1=new File(projectPath,IPath.replace(".","\\")).getAbsolutePath();
			String f2=new File(projectPath,ImplPath.replace(".","\\")).getAbsolutePath();
			
			System.out.println("д��ӿ���ʵ���ࣺtable������"+tables.size()+"\n");
			
			String fc="package "+IPath+";\r\n\r\n" +
						"import "+ImplPath+".*;\r\n\r\n"+
						"/**\r\n* ������\r\n*/\r\n" +
						"public class FC{\r\n\r\n";		//������
			
			for (String modelName : tables) {
				modelName=one2Xxx(modelName);
				String IName=wayI.replaceAll("@",modelName);		//�ӿ�����
				String ImplName=wayImpl.replaceAll("@",modelName);	//�ӿ�ʵ��������
				
				try {
					//д��ӿ�
					String str="package "+IPath+";\r\n\r\n";
					str+="import "+modelPath+".*;\r\n";
					str+=intface(modelName, wayI);
					writerOut(f1+"\\"+IName+".java", str);
					
					//д��ʵ����
					String str2="package "+ImplPath+";\r\n\r\n";
					str2+="import "+modelPath+".*;\r\n";
					str2+="import "+IPath+".*;\r\n";
					str2+=intfaceImpl(modelName,wayI,wayImpl);
					writerOut(f2+"\\"+ImplName+".java", str2);
					
					System.out.println("Model("+modelName+")\t�ӿ���ʵ����-->д��ɹ�!");gong++;
					
					fc+="\tpublic static "+IName+" get"+IName+"(){\r\n";
					fc+="\t\treturn new "+ImplName+"();\r\n\t}\r\n\r\n";
					
				} catch (Exception e) {
					bai++;
					System.err.println("Model("+modelName+")\t�ӿڻ�ʵ����д��ʧ�ܣ�");
					e.printStackTrace();
				}
			};
			
			try {
				writerOut(f1+"\\FC.java", fc+"\r\n}");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("\n���");
			System.out.println("�ܼƣ� "+tables.size()+"  �ɹ���"+gong+"  ʧ�ܣ�"+bai+"\n");
	
	}
	
	/**
	 * ��������� --> ��ʵ֤����Լ��ʤ������
	 * <p>����������������ַ�ͺã��� com.www
	 */
	public static void makeCode(String pack) {
		FlyCode.modelAll(FlyCode.tables(), "ab", "src", pack+".model");
		FlyCode.intfaceAll(FlyCode.tables(), "I@Dao", "@DaoImpl", "src", pack+".model", pack+".dao", pack+".dao.impl");
	}

	/**
	 * �������
	 */
	public static String toHelp() {
		String help="\nimport com.fly.jdbc.FlyCode;";
		
		help+="\n\n//����Model��ʾ��\n";
		help+="FlyCode.modelAll(FlyCode.tables(),\"ab\",\"src\",\"com.www.model\");";
		
		help+="\n\n//����Dao��ʾ��\n";
		help+="FlyCode.intfaceAll(FlyCode.tables(),\"I@Dao\",\"@DaoImpl\",\"src\",\"com.www.model\",\"com.www.dao\",\"com.www.dao.impl\");";
		
		//help+="\n\n//����Service��ʾ��\n";
		//help+="FlyCode.intfaceAll(FlyCode.tables(),\"I@Service\",\"@ServiceImpl\",\"src\",\"com.www.model\",\"com.www.service\",\"com.www.service.impl\");";
		
		return help;
	}
	
	
	
	// ˽��
	
	// ����һ����׼��Dao����,����ģ��
	// ע��,��������(�����β�),sql���,�����б�,�����÷���(0-getUpdate,1-getModel,2-getList),�β�,ӳ������(��ɾ�����������"")
	private static String getHanShu(String zhushi, String FnName, String sql, String args, int fnWay, String ormType) {
		String returnFn = new String[] { "getUpdate", "getModel", "getList" }[fnWay];	//return���÷���
		String returnType = new String[] { "int", ormType, "List<" + ormType + ">" }[fnWay]; //return����
		if(ormType.equals("")==false) {ormType=" "+ormType+".class,";}
		
		StringBuffer sb = new StringBuffer();
		sb.append("\t/** " + zhushi + " */\r\n"); // ע��
		sb.append("\tpublic " + returnType + " " + FnName + " {\r\n"); // ����
		sb.append("\t\tString sql=\""+sql+"\";\r\n");		//sql���
		sb.append("\t\tObject[] args={"+args+"};\r\n");		//�����б�
		sb.append("\t\treturn getFly()."+returnFn+"(sql,"+ormType+" args);\r\n");
		sb.append("\t}\r\n\r\n");
		
		return sb.toString();
	}
	//ָ����ַ��д��ָ������
	private static void writerOut(String filePath,String txt) throws IOException {
		File model=new File(filePath);
		new File(model.getParent()).mkdirs();
		model.createNewFile();
		Writer fw=new FileWriter(model.getAbsolutePath());
		fw.write(txt);
		fw.flush();
		fw.close();
	}
	
	//��ָ����������ĸ��д;
	private static String one2Xxx(String str){
		return str.substring(0,1).toUpperCase()+str.substring(1,str.length());
	}
	//��ָ����������ĸСд;
	private static String one2xXX(String str){
		return str.substring(0,1).toLowerCase()+str.substring(1,str.length());
	}
	//ȥ���������һ����ĸ
	private static String oneLast2Drop(String str) {
		return str.substring(0,str.length()-1);
	}
	//ת��-->(aСд A��д ��������)
	private static String toaA(String str,String way) {
		if(way.equals("a")){
			str=str.toLowerCase();
		}else if(way.equals("A")){
			str=str.toUpperCase();
		}
		return str;
	}
	//������֯�ĵ�ע��
	private static String toDoc(String str) {
		return "\t/**\r\n\t * "+str+"\r\n\t */\r\n";
	}
	//ָ���ַ�����getter��ʽ
	private static String setget(String str){
		if(str==null||str.equals("")){
			return str;
		}
		if(str.length()==1||str.charAt(1)=='_'||str.charAt(1)=='$'){
			return one2Xxx(str);
		}
		if(Character.isLowerCase(str.charAt(0))&&Character.isLowerCase(str.charAt(1))){
			return one2Xxx(str);
		}else {
			return str;
		}
	}
	
	//��ȡ��ǰ���ݿ����б������
	public static List<String>tables(){
		List<String>tables=new ArrayList<String>();
		try {
			DatabaseMetaData dbmd=Fly.getFly().getConnection().getMetaData();
	    	ResultSet rs = dbmd.getTables(null, null, null, new String[] { "TABLE" });
	    	while(rs.next()){
	    		tables.add(rs.getString("TABLE_NAME"));
	    	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return tables;
	}
	//��ȡһ����������ֶ���
	public static List<String>getColumn(String tableName) {
		List<String>columnList=new ArrayList<String>();
		String sql="select * from "+tableName+" where 1=0";
		try {
			ResultSetMetaData rsmd=Fly.getFly().getResultSet(sql).getMetaData();
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				String columnName=rsmd.getColumnName(i+1);	//����
				columnList.add(columnName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return columnList;
	}
	//����ָ�����е�������
	private static String table_pk(String tableName){
		try{
			DatabaseMetaData dbmd=Fly.getFly().getConnection().getMetaData();
			ResultSet rs=dbmd.getPrimaryKeys(null, null,tableName);
			String pk=null;
			if(rs.next()){
				pk=rs.getString("COLUMN_NAME");
			}
			if(pk==null) {
				pk=getColumn(tableName).get(0);	//û�оͰ�����һ���е�����
			}
			return pk;
		}catch (Exception e) {
			System.out.println("\t��"+tableName+"��ȡ����ʧ��");
		}
		return "id";//Ĭ�Ͼͽ�id��
	}
	//��ȡָ���������ֶε�ע����Ϣ��mysqlר��,�������ݿ��null
	private static Map<String,String> comments(String tableName){
		Map<String,String>map=new HashMap<String, String>();
		try {
			ResultSet rs =Fly.getFly().getResultSet("show full columns from " + tableName);
			while (rs.next()) {
				String key=rs.getString("Field");
				String comment=rs.getString("Comment");
				if(comment.equals("")==false){
					map.put(key, comment);
				}
			}
		} catch (Exception e) {
			//full�ؼ��ִ���
		}
		return map;
	}
	//����JDBC��������ת���������
	private static String JDBC2JT(String cType) {
		if(cType.equals("java.lang.Integer")){
			return "int";
		}else if(cType.equals("java.sql.Timestamp")||cType.equals("java.sql.Date")){
			return "Timestamp";
		}else if(cType.equals("java.sql.Double")){
			return "double";
		}else{
			return "String";
		}
	}
		
		
}
