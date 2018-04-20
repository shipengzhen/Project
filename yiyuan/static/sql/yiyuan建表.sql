#---------------- 枣庄医院管理系统 ----------------
DROP DATABASE IF EXISTS yiyuan;
CREATE DATABASE yiyuan;
USE yiyuan;

#---------------- 建表 ----------------

# 1、Menu 资源菜单表
DROP TABLE IF EXISTS Menu;
CREATE TABLE Menu(
	`mid`		INT	 PRIMARY KEY AUTO_INCREMENT COMMENT '菜单项ID - 主键，自增',
	`text`		VARCHAR(20) UNIQUE NOT NULL 	COMMENT '项名称',
	href		VARCHAR(50)	NOT NULL 	COMMENT '项URL路径,相对于/jsp/',
	myx		INT 	 	NOT NULL 	COMMENT '项是否有效 - (1有效,0无效)'			
);

# 2、Role 角色表
DROP TABLE IF EXISTS Role;
CREATE TABLE Role(
	rid		INT PRIMARY KEY AUTO_INCREMENT	 	COMMENT 'ID - 主键，自增',
	rname		VARCHAR(50) UNIQUE NOT NULL		COMMENT '角色名称',
	rstate		INT		NOT NULL		COMMENT '状态(1启用,0禁用)'		
);

# 3、Jur 权限分配表 [对多对]
DROP TABLE IF EXISTS Jur;
CREATE TABLE Jur(
	Jid		INT PRIMARY KEY AUTO_INCREMENT 	COMMENT 'id好 - 主键，自增',
	rid		INT 		 NOT NULL	COMMENT '角色ID - 外键',
	`mid`		INT 		 NOT NULL	COMMENT '菜单项ID - 好的',
	
	FOREIGN KEY(rid) REFERENCES Role(rid),
	FOREIGN KEY(`mid`) REFERENCES Menu(`mid`)
);

# 4、Usee 用户表
DROP TABLE IF EXISTS Usee;
CREATE TABLE Usee(
	uid		INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID - 主键,自增1000,1 ',
	uname		VARCHAR(20) UNIQUE NOT NULL	COMMENT '登录昵称 - 唯一 ', 
	PASSWORD	VARCHAR(20)	 NOT NULL	COMMENT '密码',
	ustate		INT 		 NOT NULL	COMMENT '账号状态 -> 1正常,0禁用',
	uzsname		VARCHAR(10)	 NOT NULL	COMMENT	'真实姓名',
	uemail		VARCHAR(50)	 NOT NULL	COMMENT '邮箱',
	rid		INT		 		COMMENT '所属角色ID，外键',
	
	FOREIGN KEY(rid) REFERENCES Role(rid)
);
ALTER TABLE Usee AUTO_INCREMENT=1000;	#自增从1000开始

# 5、KeRome科室表（急诊科，骨科……）
DROP TABLE IF EXISTS KeRome;
CREATE TABLE KeRome(
	kid		INT PRIMARY KEY AUTO_INCREMENT COMMENT '科室ID - 主键,自增 ',
	kname		VARCHAR(20) NOT NULL	COMMENT '科室名称'
);

# 6、Doctor 门诊医生
DROP TABLE IF EXISTS Doctor;
CREATE TABLE Doctor(
	did		INT PRIMARY KEY AUTO_INCREMENT COMMENT '医生编号 - 主键，自增(1000,1)',
	d_zsname	VARCHAR(20)	NOT NULL	COMMENT '医生姓名 - 唯一',
	d_card		VARCHAR(20) 	NOT NULL	COMMENT '身份证号',
	d_phone		VARCHAR(11)	NOT NULL	COMMENT '手机号',
	d_zuoji		VARCHAR(20) 	NOT NULL	COMMENT '座机',
	d_sex		VARCHAR(2)  	NOT NULL	COMMENT '性别',
	d_csday		TIMESTAMP 	NOT NULL	COMMENT '出生年月日',
	d_age		INT 		NOT NULL	COMMENT '年龄',
	d_email		VARCHAR(50) 	NOT NULL	COMMENT '电子邮箱',
	d_xueli		VARCHAR(10) 	NOT NULL  	COMMENT '学历',
	d_beizhu	VARCHAR(500) 	NOT NULL	COMMENT '备注',

	kid		INT 		NOT NULL	COMMENT '所属科室id，外键',
	uid		INT 		NOT NULL	COMMENT '所属user账号ID，外键',
	
	FOREIGN KEY(kid) REFERENCES KeRome(kid)
	#FOREIGN KEY(uid) REFERENCES Usee(uid)
);
#ALTER TABLE Doctor AUTO_INCREMENT=1000;		#自增从1000开始

# 7、GuaHao 挂号记录表-也可以叫病历表
DROP TABLE IF EXISTS GuaHao;
CREATE TABLE GuaHao(
	gid		INT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID号，主键，自增(1001)',
	gname		VARCHAR(20)	NOT NULL	COMMENT '挂号人姓名',
	g_card		VARCHAR(20) 	NOT NULL	COMMENT '身份证号',
	g_shebao	VARCHAR(50) 	NOT NULL	COMMENT '社保号',
	g_money		DOUBLE		NOT NULL	COMMENT '挂号费',
	g_phone		VARCHAR(11)	NOT NULL	COMMENT '联系电话',
	g_zifei		INT 		NOT NULL	COMMENT '是否自费 - 1是 2否',
	g_sex		VARCHAR(2)  	NOT NULL	COMMENT '性别',
	g_age		INT 		NOT NULL	COMMENT '年龄',
	g_zhiye		VARCHAR(50)	 		COMMENT '职业',
	g_cf		INT 		NOT NULL	COMMENT '初诊还是复诊,1初 2复',
	g_beizhu	VARCHAR(500) 	NOT NULL	COMMENT '备注',
	g_status  	VARCHAR(20) 	NOT NULL 	COMMENT '状态(已挂号,已住院,已出院,已退号)',
	g_data		TIMESTAMP DEFAULT CURRENT_TIMESTAMP	COMMENT '挂号日期',
	
	kid 		INT 		NOT NULL	COMMENT '所挂科室ID，外键',
	did		INT 		NOT NULL	COMMENT '主治医生ID',
	FOREIGN KEY(kid) REFERENCES KeRome(kid),
	FOREIGN KEY(did) REFERENCES Doctor(did)
);
ALTER TABLE GuaHao AUTO_INCREMENT=1000;		#自增从1000开始

# 8、ZhuYuan 住院记录表
DROP TABLE IF EXISTS ZhuYuan;
CREATE TABLE ZhuYuan(
	zid		INT	 PRIMARY KEY AUTO_INCREMENT COMMENT 'ID号，主键，自增',
	z_huli		VARCHAR(50)	 NOT NULL	COMMENT '护理',
	z_cw		VARCHAR(50)	 NOT NULL	COMMENT '床位号',
	z_yajin		VARCHAR(50) 	NOT NULL	COMMENT '交付押金，也即余额',
	z_zydate	TIMESTAMP DEFAULT CURRENT_TIMESTAMP	 NOT NULL	COMMENT '入院时间',
	z_zy_state	VARCHAR(20) 	NOT NULL	COMMENT '住院状态(已住院，已出院)',
	z_js_state	VARCHAR(20) 	NOT NULL	COMMENT '结算状态(未结算，已结算)',
	
	gid		INT 		NOT NULL	COMMENT '病例ID，外键',
	FOREIGN KEY(gid) REFERENCES GuaHao(gid)
);

# 9、Pay 收费项目表
DROP TABLE IF EXISTS Pay;
CREATE TABLE Pay(
	pid		INT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID号，主键，自增',
	pname		VARCHAR(20) UNIQUE NOT NULL 	COMMENT '收费项名称',
	pmoney		DOUBLE 		NOT NULL	COMMENT '收费金额',
	pdate		TIMESTAMP	NOT NULL	COMMENT '创建日期'
);

# 10、PayRed 收费项目登记表 [多对多] -> 哪个病号进行了哪个收费项目
DROP TABLE IF EXISTS PayRed;
CREATE TABLE PayRed(
	prid		INT PRIMARY KEY AUTO_INCREMENT  COMMENT 'ID号，主键，自增',
	pdate		TIMESTAMP DEFAULT CURRENT_TIMESTAMP	NOT NULL	COMMENT '收费日期',
	
	gid		INT		NOT NULL	COMMENT '病历号ID，外键',
	pid		INT		NOT NULL	COMMENT '收费项目ID，外键',
	FOREIGN KEY(gid) REFERENCES GuaHao(gid),
	FOREIGN KEY(pid) REFERENCES Pay(pid)
);

# 11、Yao	药品管理
DROP TABLE IF EXISTS Yao;
CREATE TABLE Yao(
	yno		VARCHAR(50)	PRIMARY KEY 	COMMENT '药品编号,自定义编号，主键',
	y_img		VARCHAR(50)			COMMENT '药品图片名称',
	y_jj		DOUBLE		NOT NULL	COMMENT '进价',
	y_sj		DOUBLE		NOT NULL	COMMENT '售价',
	y_name		VARCHAR(50) 	NOT NULL	COMMENT '药品名称',
	y_type		INT 		NOT NULL	COMMENT '药品类型(1-处方药，2-中药，3-西药)',
	y_ms		VARCHAR(100) 	NOT NULL	COMMENT '简单描述',
	y_baozhi	INT 		NOT NULL	COMMENT '保质期,单位/月',
	y_xxms		VARCHAR(500) 	NOT NULL	COMMENT '详细描述',
	y_sccs		VARCHAR(100) 	NOT NULL 	COMMENT '生产厂商',
	y_state		VARCHAR(100) 	NOT NULL  	COMMENT '药品状态(销售中,维护中)',
	y_kucun		INT 		NOT NULL	COMMENT '库存'
);

# 12、FaYao 在线发药记录表
DROP TABLE IF EXISTS FaYao;
CREATE TABLE FaYao(
	fid		INT PRIMARY KEY AUTO_INCREMENT 	COMMENT 'id，主键,自增',
	gid		INT 		NOT NULL	COMMENT '病号ID，外键',
	yno		VARCHAR(50) 	NOT NULL	COMMENT '药品编号，外键',
	f_num		INT 		NOT NULL	COMMENT '该发多少',
	f_ynum		INT 		NOT NULL	COMMENT '已经发了多少',
	f_wnum		INT 		NOT NULL	COMMENT '还剩多少没发',
	
	FOREIGN KEY(gid) REFERENCES GuaHao(gid),
	FOREIGN KEY(yno) REFERENCES Yao(yno)
);















