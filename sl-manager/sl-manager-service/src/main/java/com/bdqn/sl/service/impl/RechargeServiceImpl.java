package com.bdqn.sl.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.sl.mapper.RechargeMapper;
import com.bdqn.sl.mapper.SysUserMapper;
import com.bdqn.sl.pojo.Recharge;
import com.bdqn.sl.pojo.SysUser;
import com.bdqn.sl.service.IrechargeService;

/**
 * 银行
 * @author lizhen
 */
@Service
public class RechargeServiceImpl implements IrechargeService {

	//银行
	@Autowired
	private RechargeMapper rechargeMapper;
	
	@Autowired
	private SysUserMapper sysUserMapper;		//用户
	/**
	 * 新增
	 */
	@Override
	public void AddRe(Recharge re) {
		re.setCreated(new Date());
		re.setStatus(1);  //完成	 状态
		 int i = rechargeMapper.insert(re);
		 if(i>0) {
			SysUser user = sysUserMapper.selectByPrimaryKey(re.getUserid());	//用户id 返回用户
			
			float newMoney=0;
			if(user.getYmoney()==null) {
				newMoney=re.getMoney();
			}else {
			
				float oldMoney=user.getYmoney();
				newMoney=re.getMoney()+oldMoney;
			}
			SysUser user1=new SysUser();			//新对象
			user1.setUserid(re.getUserid());		//用户id
			user1.setYmoney(newMoney);
			
			sysUserMapper.updateByPrimaryKeySelective(user1);	
			 
		 }
		
	}

}

















