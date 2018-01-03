package com.student;

import java.util.Arrays;

//定义一个类，人类，
//名字，性别，年龄，身高，体重

class Person implements Comparable<Person> {
	
	//成员变量
	private String name;
	private String sex;
	private int age;
	private int height;
	private int weight;
	
	//构造函数
	public Person(String name, String sex, int age, int height, int weight){
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	//成员方法
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getAge(){
		return this.age;
	}
	
	//toString()
	public String toString(){
		return "name:" + this.name + "sex:" + this.sex + "age:" + this.age +"height:" + this.height + "weight:" + this.weight;
	}
	
	public int compareTo(Person o){
		return this.name.compareTo(o.name);
	}
}

class Student extends Person{
	//成员变量
	private String Major;
	
	//构造函数
	public Student(String name, String sex, int age, int height, int weight, String Major){
		super(name, sex, age, height, weight);
		this.Major = Major;
	}
	
	//成员方法  
	public void setMajor(String Major){
		this.Major = Major;
	}
	
	public String getMajor(){
		return this.Major;
	}
	
	//重写父类方法
	public String toString(){
		return "A student name:" + super.getName();
	}
	
	public boolean goToSchool(){
		if(super.getAge() > 7){
			return true;
		}else{
			return false;
		}
	}
}

class Main{
	
	public static void main(String[] args){
		Person[] pere = new Person[5];
		pere[0] = new Person("小强", "男", 23, 100, 65);
		pere[1] = new Person("小强", "男", 23, 100, 65);
		pere[2] = new Person("小强", "男", 23, 100, 65);
		pere[3] = new Person("小强", "男", 23, 100, 65);
		pere[4] = new Person("小强", "男", 23, 100, 65);
		
		Arrays.sort(pere); //排序
		
		//排序
		Arrays.sort(pere, (s1,s2) -> s2.getName().compareTo(s1.getName()));
		
		
		
		Person per = new Person("小强", "男", 23, 100, 65);
		per.setName("大强");
		String na = per.getName();
		System.out.println(na);
		
		System.out.println(per.toString());
	}
	
	
	
	
	
	
	
	
}
