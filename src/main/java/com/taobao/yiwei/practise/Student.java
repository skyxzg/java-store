package com.taobao.yiwei.practise;


import lombok.Getter;
import lombok.Setter;

public class Student extends Person {

	@Getter
	@Setter
	private String grade;

	public void say() {
		System.out.println("I am " + getName() + ", grade " + getGrade());
	}
}
