package com.taobao.yiwei.calc;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class) //指定了此测试类的运行器
@Suite.SuiteClasses({ //指定了要同时运行哪些测试类
	TestCalculator.class,
	TestCalculatorSquare.class
})
public class CalculatorAllTest {	
}
