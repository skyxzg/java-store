package com.taobao.yiwei.oo;

public class Override {

	public static void main(String[] args) {
	      Animal a = new Animal(); // Animal 对象
	      Animal b = new Dog(); // Dog 对象

	      a.move(); // 执行 Animal 类的方法
	      b.move(); //执行 Dog 类的方法 （编译期间，因为Animal类中存在move方法，所以能编译成功，然而运行时，Java虚拟机(JVM)指定对象的类型并且运行该对象的方法。）
	      //b.bark(); //编译期间，因为Animal类中不存在bark方法，所以报错
	}

}

class Animal{

   public void move(){
       System.out.println("动物可以移动");
   }
}

class Dog extends Animal{

   public void move(){
//	   super.move();  //应用super类的方法
       System.out.println("狗可以跑和走");
   }
   
   public void bark(){
       System.out.println("狗可以吠叫");
   }
}

