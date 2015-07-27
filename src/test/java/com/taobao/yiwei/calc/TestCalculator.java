package com.taobao.yiwei.calc;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestCalculator {
	
	private static Calculator example = new Calculator();

	@Before//在每个测试方法执行前先执行的方法
    public void setUp() throws Exception {
        example.clear();
    }
    
    @After//在每个测试方法执行后立刻执行的方法
    public void setDown(){
        System.out.println("over");
    }
    
    @BeforeClass //在类加载的时候调用的方法，必须public和static的，只调用一次
    public static void start(){
        System.out.println("start class");
    }
    
    @AfterClass //在类结束的时候调用的方法，必须public和static的，只调用一次
    public static void destory(){
        System.out.println("destory class");
    }
    
    @Test
    public void testAdd() {
        example.add(2);
        example.add(3);
        assertEquals(5, example.getResult());
    }

    @Test
    public void testSubstract() {
        example.add(10);
        example.substract(2);
        assertEquals(8, example.getResult());
    }

    @Ignore//因该方法暂未实现而忽略测试
    @Test
    public void testMultiply() {
        fail("Not yet implemented");
    }

    @Test
    public void testDivide() {
        example.add(8);
        example.divide(2);
        assertEquals(4, example.getResult());
    }
    
    @Test(timeout = 1000)//设置时间限制，单位是毫秒，超时即算测试失败
    public void testsquareRoot(){
        example.squareRoot(4);
        assertEquals(2, example.getResult());
    }

    @Test(expected = ArithmeticException.class)//测试是否能如期抛出该异常
    public void divideByZero(){
        example.divide(0);//除数为0，如能正确抛出异常，则测试通过，否则测试失败
    }

}
