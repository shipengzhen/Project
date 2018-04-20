package com.fly.jdbc;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * Fly的代码生成工具
 */
public class FlyCode {

	
	/**
	 * 生成一个仅供参考的insert函数
	 */
	public static String insert(String tableName){
		String modelName=one2xXX(tableName);
		
		List<String>columnList=getColumn(tableName);
		String sk="",sv="",sc="";	//列部分，值部分，参数部分
		for (String columnName : columnList) {
			sk+=columnName+",";
			sv+="?,";
			sc+=modelName+".get"+setget(columnName)+"(),";
		}

		String fnName="save("+one2Xxx(tableName)+" "+one2xXX(tableName)+")";	//函数和形参
		String sql=" insert into "+tableName+"("+oneLast2Drop(sk.toString())+
				") value ("+oneLast2Drop(sv.toString())+")";
		
		return getHanShu("增加一条记录", fnName, sql, oneLast2Drop(sc.toString()), 0, "");
	}
	
	/**
	 * 生成一个仅供参考的update函数(按主键修改)
	 */
	public static String update(String tableName){
		String modelName=one2xXX(tableName);
		List<String>columnList=getColumn(tableName);
		
		String pk=table_pk(tableName);	//主键
		String sk="",sc="";				//set参部分，args参数
		for (String columnName : columnList) {
			if(columnName.equals(pk)) {
				continue;
			}
			sk+=columnName+"=?,";
			sc+=modelName+".get"+setget(columnName)+"(),";
		}
		String fnName="update("+one2Xxx(tableName)+" "+one2xXX(tableName)+")";	//函数和形参
		String sql="update "+tableName+" set "+oneLast2Drop(sk)+" where "+pk+"=?";	//再加个主键
		sc+=modelName+".get"+setget(pk)+"(),";
		
		return getHanShu("修改一条记录(根据主键)", fnName, sql, oneLast2Drop(sc), 0, "");
	}
	
	/**
	 * 生成一个仅供参考的delete函数(按主键删除)
	 */
	public static String delete(String tableName) {
		String sql="delete from "+tableName+" where "+table_pk(tableName)+"=?";
		return getHanShu("删除一条记录(根据主键)","delete(int id)", sql, "id", 0, "");
	}

	/**
	 * 生成仅供参考的find函数 (findById findAll)
	 */
	public static String find(String tableName) {
		
		String sql_findById="select * from "+tableName+" where "+table_pk(tableName)+"=?";
		String findById=getHanShu("查询一条记录(根据主键)","findById(int id)", sql_findById, "id", 1, one2Xxx(tableName));
		
		String findAll=getHanShu("查询全部","findAll()", "select * from "+tableName, "", 2, one2Xxx(tableName));
		
		return findById+findAll;
	}

	/* * * * * 综合  * * * * */

	/**
	 * 指定一张表的Model	
	 * <p>表名，字段形式(a-小写，A-大写，其余-不变)
	 */
	public static String model(String tableName,String way){
		boolean is_sql=false;		//是否导入Sql包
		Map<String,String>comments=comments(tableName);	//注释
		StringBuilder prop=new StringBuilder();			//prop
		StringBuilder setget=new StringBuilder();		//set和get
		StringBuilder sts=new StringBuilder();			//toString()函数
		try {
			String sql="select * from "+tableName+" where 1=0";
			ResultSetMetaData rsmd=Fly.getFly().getResultSet(sql).getMetaData();
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				String cType=JDBC2JT(rsmd.getColumnClassName(i+1));	//类型
				if(cType.equals("Date")||cType.equals("Timestamp")){is_sql=true;}
				
				String propName=rsmd.getColumnName(i+1);	//列名
				propName=toaA(propName, way);
				String comment=comments.get(propName);		//注释
				if(comment==null){comment="";}
				
				prop.append("\tprivate "+cType+" "+propName+";\t\t//"+comment+"\r\n");	//追加字段
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
		
		//最终组织
		String str="public class "+one2Xxx(tableName)+"{\r\n\r\n";	//头
		if(is_sql==true){
			str="import java.sql.*;\r\n\r\n"+str;
		}
		
		str+=prop+"\r\n";		//prop
		str+=setget+"\r\n";		//set get
		str+=sts+"\r\n";		//toString()
		str+="\r\n}\r\n";	//补底
		
		return str;
	}
	
	/**
	 * 一次性生产所有Model类，并IO到指定地址
	 * <p>所有表，形式，项目地址，包地址
	 */
	public static void modelAll(List<String>tables,String way,String projectPath,String packagePath) {
		int cg=0,sb=0;
		
		File wjj=new File(projectPath,packagePath.replace(".","\\"));		//创建路径
		wjj.mkdirs();
		System.out.println("Model(sum:"+tables.size()+")源路径"+wjj.getAbsolutePath()+"创建成功\n");
		
		for (String tableName : tables) {
			try {
				//创建文件
				String txt="package "+packagePath+";\r\n\r\n"+model(tableName, way);
				String filePath=wjj.getAbsolutePath()+"\\"+one2Xxx(tableName)+".java";
				writerOut(filePath, txt);
				
				cg++;
				System.out.println("表："+tableName+"  \t写入完成！");
				
			} catch (Exception e) {
				sb++;
				System.err.println("表："+tableName+"  \t写入失败！可能原因："+e.getMessage());
			}
		}
		
		System.out.println("\n共计"+tables.size()+"   成功："+cg+"  失败："+sb+"\r\n\r\n");
	}
	
	/**
	 * 指定一张表的接口
	 * <p>表名，形式(I@Dao-->IUserDao)，Model名字
	 */
	public static String intface(String tableName,String way) {
		String IName=way.replaceAll("@",tableName);
		String crud="";

		crud+="\t/** 新增一条记录 */\r\n";
		crud+="\tpublic int save("+tableName+" obj);\r\n\r\n";

		crud+="\t/** 删除一条记录(根据主键) */\r\n";
		crud+="\tpublic int delete(int id);\r\n\r\n";

		crud+="\t/** 修改一条记录(根据主键) */\r\n";
		crud+="\tpublic int update("+tableName+" obj);\r\n\r\n";
		
		crud+="\t/** 查询一条记录(根据主键) */\r\n";
		crud+="\tpublic "+tableName+" findById(int id);\r\n\r\n";
		
		crud+="\t/** 查询全部 */\r\n";
		crud+="\tpublic List<"+tableName+"> findAll();\r\n\r\n";
		
		String intface="import java.util.*;\r\n\r\n"
				+ "public interface "+IName+"{\r\n\r\n"+crud+"\r\n\r\n}\r\n";
		return intface;
	}
	/**
	 * 指定一张表的接口实现类
	 */
	public static String intfaceImpl(String tableName,String wayI,String wayImpl) {
		String IName=wayI.replaceAll("@",tableName);
		String ImplName=wayImpl.replaceAll("@",tableName);
		String crud="";
		
		//crud+="\tprivate SqlFly sy=Fly.getFly();\t//底层SqlFly对象\r\n\r\n";
		crud+="\t//底层SqlFly对象\r\n\tprivate SqlFly getFly() {\r\n\t\treturn Fly.getFly();\r\n\t}\r\n\r\n";
				
		crud+=insert(tableName);
		crud+=delete(tableName);
		crud+=update(tableName);
		crud+=find(tableName);

		String intfaceImpl="import com.fly.jdbc.*;\r\nimport java.util.*;\r\n\r\n"
				+ "public class "+ImplName+" implements "+IName+" {\r\n\r\n"+crud+"\r\n\r\n}\r\n";
		return intfaceImpl;
	}
	
	/**
	 * 一次性生成所有表的接口和实现类,并IO到指定地址
	 * <p>如果觉得参数过于复杂，可以试试makeCode的简洁性生产
	 */
	public static void intfaceAll(List<String>tables,String wayI,String wayImpl,
			String projectPath,String modelPath,String IPath,String ImplPath) {
			
			int gong=0,bai=0;	//成功和失败
			//I绝对地址和Impl绝对地址
			String f1=new File(projectPath,IPath.replace(".","\\")).getAbsolutePath();
			String f2=new File(projectPath,ImplPath.replace(".","\\")).getAbsolutePath();
			
			System.out.println("写入接口与实现类：table数量："+tables.size()+"\n");
			
			String fc="package "+IPath+";\r\n\r\n" +
						"import "+ImplPath+".*;\r\n\r\n"+
						"/**\r\n* 工厂类\r\n*/\r\n" +
						"public class FC{\r\n\r\n";		//工厂类
			
			for (String modelName : tables) {
				modelName=one2Xxx(modelName);
				String IName=wayI.replaceAll("@",modelName);		//接口名字
				String ImplName=wayImpl.replaceAll("@",modelName);	//接口实现类名字
				
				try {
					//写入接口
					String str="package "+IPath+";\r\n\r\n";
					str+="import "+modelPath+".*;\r\n";
					str+=intface(modelName, wayI);
					writerOut(f1+"\\"+IName+".java", str);
					
					//写入实现类
					String str2="package "+ImplPath+";\r\n\r\n";
					str2+="import "+modelPath+".*;\r\n";
					str2+="import "+IPath+".*;\r\n";
					str2+=intfaceImpl(modelName,wayI,wayImpl);
					writerOut(f2+"\\"+ImplName+".java", str2);
					
					System.out.println("Model("+modelName+")\t接口与实现类-->写入成功!");gong++;
					
					fc+="\tpublic static "+IName+" get"+IName+"(){\r\n";
					fc+="\t\treturn new "+ImplName+"();\r\n\t}\r\n\r\n";
					
				} catch (Exception e) {
					bai++;
					System.err.println("Model("+modelName+")\t接口或实现类写入失败！");
					e.printStackTrace();
				}
			};
			
			try {
				writerOut(f1+"\\FC.java", fc+"\r\n}");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("\n完成");
			System.out.println("总计： "+tables.size()+"  成功："+gong+"  失败："+bai+"\n");
	
	}
	
	/**
	 * 简洁性生产 --> 事实证明：约定胜于配置
	 * <p>参数，给个父包地址就好，如 com.www
	 */
	public static void makeCode(String pack) {
		FlyCode.modelAll(FlyCode.tables(), "ab", "src", pack+".model");
		FlyCode.intfaceAll(FlyCode.tables(), "I@Dao", "@DaoImpl", "src", pack+".model", pack+".dao", pack+".dao.impl");
	}

	/**
	 * 输出帮助
	 */
	public static String toHelp() {
		String help="\nimport com.fly.jdbc.FlyCode;";
		
		help+="\n\n//生成Model类示例\n";
		help+="FlyCode.modelAll(FlyCode.tables(),\"ab\",\"src\",\"com.www.model\");";
		
		help+="\n\n//生成Dao层示例\n";
		help+="FlyCode.intfaceAll(FlyCode.tables(),\"I@Dao\",\"@DaoImpl\",\"src\",\"com.www.model\",\"com.www.dao\",\"com.www.dao.impl\");";
		
		//help+="\n\n//生成Service层示例\n";
		//help+="FlyCode.intfaceAll(FlyCode.tables(),\"I@Service\",\"@ServiceImpl\",\"src\",\"com.www.model\",\"com.www.service\",\"com.www.service.impl\");";
		
		return help;
	}
	
	
	
	// 私货
	
	// 生成一个标准的Dao函数,函数模板
	// 注释,函数名字(带上形参),sql语句,参数列表,所调用方法(0-getUpdate,1-getModel,2-getList),形参,映射类型(增删改类型请给个"")
	private static String getHanShu(String zhushi, String FnName, String sql, String args, int fnWay, String ormType) {
		String returnFn = new String[] { "getUpdate", "getModel", "getList" }[fnWay];	//return调用方法
		String returnType = new String[] { "int", ormType, "List<" + ormType + ">" }[fnWay]; //return类型
		if(ormType.equals("")==false) {ormType=" "+ormType+".class,";}
		
		StringBuffer sb = new StringBuffer();
		sb.append("\t/** " + zhushi + " */\r\n"); // 注释
		sb.append("\tpublic " + returnType + " " + FnName + " {\r\n"); // 函数
		sb.append("\t\tString sql=\""+sql+"\";\r\n");		//sql语句
		sb.append("\t\tObject[] args={"+args+"};\r\n");		//参数列表
		sb.append("\t\treturn getFly()."+returnFn+"(sql,"+ormType+" args);\r\n");
		sb.append("\t}\r\n\r\n");
		
		return sb.toString();
	}
	//指定地址，写入指定内容
	private static void writerOut(String filePath,String txt) throws IOException {
		File model=new File(filePath);
		new File(model.getParent()).mkdirs();
		model.createNewFile();
		Writer fw=new FileWriter(model.getAbsolutePath());
		fw.write(txt);
		fw.flush();
		fw.close();
	}
	
	//将指定单词首字母大写;
	private static String one2Xxx(String str){
		return str.substring(0,1).toUpperCase()+str.substring(1,str.length());
	}
	//将指定单词首字母小写;
	private static String one2xXX(String str){
		return str.substring(0,1).toLowerCase()+str.substring(1,str.length());
	}
	//去掉单词最后一个字母
	private static String oneLast2Drop(String str) {
		return str.substring(0,str.length()-1);
	}
	//转换-->(a小写 A大写 其它不变)
	private static String toaA(String str,String way) {
		if(way.equals("a")){
			str=str.toLowerCase();
		}else if(way.equals("A")){
			str=str.toUpperCase();
		}
		return str;
	}
	//快速组织文档注释
	private static String toDoc(String str) {
		return "\t/**\r\n\t * "+str+"\r\n\t */\r\n";
	}
	//指定字符串的getter形式
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
	
	//获取当前数据库所有表的名字
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
	//获取一个表的所有字段名
	public static List<String>getColumn(String tableName) {
		List<String>columnList=new ArrayList<String>();
		String sql="select * from "+tableName+" where 1=0";
		try {
			ResultSetMetaData rsmd=Fly.getFly().getResultSet(sql).getMetaData();
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				String columnName=rsmd.getColumnName(i+1);	//列名
				columnList.add(columnName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return columnList;
	}
	//返回指定表中的主键列
	private static String table_pk(String tableName){
		try{
			DatabaseMetaData dbmd=Fly.getFly().getConnection().getMetaData();
			ResultSet rs=dbmd.getPrimaryKeys(null, null,tableName);
			String pk=null;
			if(rs.next()){
				pk=rs.getString("COLUMN_NAME");
			}
			if(pk==null) {
				pk=getColumn(tableName).get(0);	//没有就把它第一个列当主键
			}
			return pk;
		}catch (Exception e) {
			System.out.println("\t表"+tableName+"读取主键失败");
		}
		return "id";//默认就叫id吧
	}
	//获取指定表所有字段的注释信息，mysql专用,其它数据库读null
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
			//full关键字错误
		}
		return map;
	}
	//返回JDBC建议类型转换后的类型
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
