package com.yy.dao;

import com.yy.dao.impl.*;

/**
* π§≥ß¿‡
*/
public class FC{

	public static IDoctorDao getIDoctorDao(){
		return new DoctorDaoImpl();
	}

	public static IFayaoDao getIFayaoDao(){
		return new FayaoDaoImpl();
	}

	public static IGuahaoDao getIGuahaoDao(){
		return new GuahaoDaoImpl();
	}

	public static IJurDao getIJurDao(){
		return new JurDaoImpl();
	}

	public static IKeromeDao getIKeromeDao(){
		return new KeromeDaoImpl();
	}

	public static IMenuDao getIMenuDao(){
		return new MenuDaoImpl();
	}

	public static IPayDao getIPayDao(){
		return new PayDaoImpl();
	}

	public static IPayredDao getIPayredDao(){
		return new PayredDaoImpl();
	}

	public static IRoleDao getIRoleDao(){
		return new RoleDaoImpl();
	}

	public static IUseeDao getIUseeDao(){
		return new UseeDaoImpl();
	}

	public static IYaoDao getIYaoDao(){
		return new YaoDaoImpl();
	}

	public static IZhuyuanDao getIZhuyuanDao(){
		return new ZhuyuanDaoImpl();
	}


}