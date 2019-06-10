package com.taobao.yiwei.practise;

public class Singleton {
	
    private Singleton() {}  
  
    private static class SingletonFactory {  
        private static Singleton instance = new Singleton();  
    }
  
    public static Singleton getInstance() {  
        return SingletonFactory.instance;  
    }   
}
