package com.fly.jdbc;

import java.lang.annotation.*;

/**
 * Fly的ORM注解，标注model与数据库的关系
 * <p>举个栗子，在User实体类中： 
 * <p>@FlyAt(column="userId")
 * <br/>int id;
 * <br/>@FlyAt(orm=false)
 * <br/>String sex;
 * <p/>将代表，属性id映射的表列名为userId，属性sex将不接受结果集的映射 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE})
public @interface AtFly {

	/* * * * * * * * * * * * * 映射相关 * * * * * * * * * * * * * * * * * * * * */
	/**
	 * Fly处理字段的总开关，标注此属性是否应用于映射
	 */
	public boolean orm() default true;
	
	/**
	 * 标注此字段在save()函数里的方式,默认取值输出
	 * <br/>save=s:0代表恒取0输出
	 * <br/>save=getId代表调用this.getId()函数
	 * <br/>save=no代表被忽略掉
	 */
	public String save() default "";
	
	/**
	 * 标注此字段在update()函数里的方式,默认取值输出
	 * <br/>update=s:0代表恒取0输出
	 * <br/>update=getId代表调用this.getId()函数
	 * <br/>update=no代表被忽略掉
	 */
	public String update()default "";
	

	/**
	 * 标注此字段在被set时的方式,默认直接赋值
	 * <br/>set=setId;代表调用this.setId(v)函数赋值
	 */
	public String set()default "";
	
	
	/* * * * * * * * * * * * * 与表的关系 * * * * * * * * * * * * * * * * * * * * */
	/**
	 * 标注此类哪个字段是主键，默认id
	 */
	public String pk()default "id";

	/**
	 * 标注此类所对应的表名，默认与类同名
	 */
	public String table()default "";
	
	/**
	 * 标注此属性在数据库中所对应的表列名，默认与属性同名
	 */
	public String column()default "";


}
