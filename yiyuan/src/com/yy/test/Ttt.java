package com.yy.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.fly.jdbc.Fly;
import com.yy.dao.FC;
import com.yy.model.Doctor;
import com.yy.model.Menu;
import com.yy.model.Payred;
import com.yy.model.Role;
import com.yy.model.Usee;
import com.yy.util.Page;

public class Ttt {
	public static void main(String[] args) {
		
		
		for (Object obj : FC.getIPayredDao().getByTJ(new Page(1, 10), 1002)) {
			System.out.println(obj);
			System.out.println(((Payred)obj).getPname());
		}
		
		

		

		
		/*List<Integer>mids=new ArrayList<Integer>();
		mids.add(2);
		mids.add(3);
		
		System.out.println(FC.getIRoleDao().save(new Role().setRname("ÐÂ½¨2").setRstate(1), mids));
*/
	}
	
	public static void ss(Object...aaa) {
		System.out.println(aaa.length);
	}
	
	
}
