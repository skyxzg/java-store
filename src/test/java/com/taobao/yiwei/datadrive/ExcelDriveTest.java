package com.taobao.yiwei.datadrive;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.taobao.yiwei.datadrive.filerunners.DataResource;
import com.taobao.yiwei.datadrive.filerunners.FileRunner;
import com.taobao.yiwei.log.BaseTest;


@RunWith(FileRunner.class)
public class ExcelDriveTest extends BaseTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@DataResource(file="src/test/resources/excel_cases/testcases.xls", sheet="function")
	public void test_01(Map<String, String> map) {
//		log.info("caseName is {}", map.get("caseName"));
		assertTrue(true);
		for (String key : map.keySet()) {
			log.info(key + ":" + map.get(key));
		}
	}

	@Test
	@DataResource(file="src/test/resources/excel_cases/testcases.xls", sheet="param")
	public void test_02(Map<String, String> map) {
		log.info("caseDesc is {}", map.get("caseDesc"));
	}
	

	@Test
	@DataResource(file="src/test/resources/excel_cases/testcases.csv")
	public void test_03(Map<String, String> map) {
		log.info("caseDesc is {}", map.get("caseDesc"));
	}
}
