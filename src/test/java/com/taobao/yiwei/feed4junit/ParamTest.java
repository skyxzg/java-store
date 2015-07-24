package com.taobao.yiwei.feed4junit;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.databene.benerator.anno.Source;

@RunWith(ExcelDrive.class) 
public class ParamTest {

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
	@Source("src/test/resources/feed4junit_cases/testcases.xlsx")
	public void test(String caseName, String caseDesc, String isRun) {
		System.out.println("caseName:" + caseName);
		System.out.println("caseDesc:" + caseDesc);
		System.out.println("isRun:" + isRun);
	}

}
