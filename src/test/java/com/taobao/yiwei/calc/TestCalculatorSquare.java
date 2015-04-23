package com.taobao.yiwei.calc;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class ) //设置了本测试类的运行器为Parameterized.class，因为此类需要多组数据，所以不能采用默认的运行器
public class TestCalculatorSquare {
	
	private static Calculator example = new Calculator();    
    private int param;    
    private int result;
    
    @SuppressWarnings("rawtypes")
	@Parameters//定义测试数据集合，前者param后者result
    public static Collection  data(){
        return Arrays.asList(new Object[][]{
                {2,4},
                {0,0},
                {-3,9},
            });
    }
    
    @Before
    public void setUp() throws Exception {
        example.clear();
    }

    @Test
    public void testSquare() {
        example.square(param);
        assertEquals(result, example.getResult());
    }
    
    //构造函数，对变量进行初始化，注意参数顺序应与定义的测试集合的参数顺序一致
    public TestCalculatorSquare(int param,int result){
        this.param = param;
        this.result = result;
    }

}
