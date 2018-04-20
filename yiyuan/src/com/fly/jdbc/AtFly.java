package com.fly.jdbc;

import java.lang.annotation.*;

/**
 * Fly��ORMע�⣬��עmodel�����ݿ�Ĺ�ϵ
 * <p>�ٸ����ӣ���Userʵ�����У� 
 * <p>@FlyAt(column="userId")
 * <br/>int id;
 * <br/>@FlyAt(orm=false)
 * <br/>String sex;
 * <p/>����������idӳ��ı�����ΪuserId������sex�������ܽ������ӳ�� 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE})
public @interface AtFly {

	/* * * * * * * * * * * * * ӳ����� * * * * * * * * * * * * * * * * * * * * */
	/**
	 * Fly�����ֶε��ܿ��أ���ע�������Ƿ�Ӧ����ӳ��
	 */
	public boolean orm() default true;
	
	/**
	 * ��ע���ֶ���save()������ķ�ʽ,Ĭ��ȡֵ���
	 * <br/>save=s:0�����ȡ0���
	 * <br/>save=getId�������this.getId()����
	 * <br/>save=no�������Ե�
	 */
	public String save() default "";
	
	/**
	 * ��ע���ֶ���update()������ķ�ʽ,Ĭ��ȡֵ���
	 * <br/>update=s:0�����ȡ0���
	 * <br/>update=getId�������this.getId()����
	 * <br/>update=no�������Ե�
	 */
	public String update()default "";
	

	/**
	 * ��ע���ֶ��ڱ�setʱ�ķ�ʽ,Ĭ��ֱ�Ӹ�ֵ
	 * <br/>set=setId;�������this.setId(v)������ֵ
	 */
	public String set()default "";
	
	
	/* * * * * * * * * * * * * ���Ĺ�ϵ * * * * * * * * * * * * * * * * * * * * */
	/**
	 * ��ע�����ĸ��ֶ���������Ĭ��id
	 */
	public String pk()default "id";

	/**
	 * ��ע��������Ӧ�ı�����Ĭ������ͬ��
	 */
	public String table()default "";
	
	/**
	 * ��ע�����������ݿ�������Ӧ�ı�������Ĭ��������ͬ��
	 */
	public String column()default "";


}
