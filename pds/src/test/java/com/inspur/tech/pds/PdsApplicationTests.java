package com.inspur.tech.pds;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.inspur.tech.pds.service.IDisposeInfoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PdsApplicationTests {

	@Autowired
	private IDisposeInfoService disposeInfoService;

	/**
	 * @方法名 dipBasicInfo void
	 * @功能描述 基本信息
	 * @创建人 施鹏振
	 * @创建时间 2019年1月13日上午9:41:37
	 */
	@Test
	public void dipBasicInfo() {
		File file = new File("C:\\Users\\xiaomi\\Desktop\\基本信息.xls");
		boolean dipBasicInfo = disposeInfoService.dipBasicInfo(file);
		System.out.println(dipBasicInfo);
	}

	/**
	 * @方法名 dipHorizontalTopicInfo void
	 * @功能描述 横向课题
	 * @创建人 施鹏振
	 * @创建时间 2019年1月13日上午9:42:51
	 */
	@Test
	public void dipHorizontalTopicInfo() {
		File file = new File("C:\\Users\\xiaomi\\Desktop\\横向课题.xls");
		boolean dipHorizontalTopicInfo = disposeInfoService.dipHorizontalTopicInfo(file);
		System.out.println(dipHorizontalTopicInfo);
	}

	@Test
	public void dipScientificGuaranteeInfo() {
		File file = new File("C:\\Users\\xiaomi\\Desktop\\科研保障.xls");
		boolean dipScientificGuaranteeInfo = disposeInfoService.dipScientificGuaranteeInfo(file);
		System.out.println(dipScientificGuaranteeInfo);
	}

}
