package com.taobao.yiwei.practise;

import java.lang.reflect.Method;
import java.time.Period;

import org.apache.commons.lang3.Validate;

public class GenericSample {

	private static Long unitId;

    public static void main(String[] args) {

		System.out.println("upgrade_checker.py".split("\\.")[0]);

		System.out.println("".getBytes());

		//Validate.isTrue(unitId > 0, "invalid unit id %s", unitId);

		try {
			Student student = build(Student.class);

			test(student);

			student.setGrade("2");
			student.say();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void test(Student student) {
		if (student instanceof Person) {
			System.out.println("hello");
		} else {
			System.out.println("world");
		}
	}



	private static <T extends Person> T build(Class<T> clazz) throws IllegalAccessException, InstantiationException {
		Person person = clazz.newInstance();
		// 设置必填字段
		person.setName("Bill"); // 必填字段，如果正常，返回OK

		return (T)person;
	}
}
