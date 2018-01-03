package com.student;

import java.util.Arrays;

//����һ���࣬���࣬
//���֣��Ա����䣬��ߣ�����

class Person implements Comparable<Person> {
	
	//��Ա����
	private String name;
	private String sex;
	private int age;
	private int height;
	private int weight;
	
	//���캯��
	public Person(String name, String sex, int age, int height, int weight){
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	//��Ա����
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
	//��Ա����
	private String Major;
	
	//���캯��
	public Student(String name, String sex, int age, int height, int weight, String Major){
		super(name, sex, age, height, weight);
		this.Major = Major;
	}
	
	//��Ա����  
	public void setMajor(String Major){
		this.Major = Major;
	}
	
	public String getMajor(){
		return this.Major;
	}
	
	//��д���෽��
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
		pere[0] = new Person("Сǿ", "��", 23, 100, 65);
		pere[1] = new Person("Сǿ", "��", 23, 100, 65);
		pere[2] = new Person("Сǿ", "��", 23, 100, 65);
		pere[3] = new Person("Сǿ", "��", 23, 100, 65);
		pere[4] = new Person("Сǿ", "��", 23, 100, 65);
		
		Arrays.sort(pere); //����
		
		//����
		Arrays.sort(pere, (s1,s2) -> s2.getName().compareTo(s1.getName()));
		
		
		
		Person per = new Person("Сǿ", "��", 23, 100, 65);
		per.setName("��ǿ");
		String na = per.getName();
		System.out.println(na);
		
		System.out.println(per.toString());
	}
	
	
	
	
	
	
	
	
}
