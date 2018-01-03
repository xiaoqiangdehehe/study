
public class PersonStudentTest {

	public static void main(String[] args) {
		Student hanmei = new Student(15001, "Han Mei", "man", 21, "E-Commerce", 4.0);   //new一个Student对象
		System.out.println(hanmei.getID());      //打印身份证号码
		System.out.println(hanmei.getName());
		System.out.println(hanmei.getGender());
		System.out.println(hanmei.getAge());
		System.out.println(hanmei.getMajor());
		System.out.println(hanmei.getGpa());
		System.out.println(hanmei.toString());   //打印学生信息
		
		Person lilei = new Person(11111, "Li Lei", "man", 20);    //new一个Person对象
		System.out.println(lilei.getID());       //打印身份证号码
		System.out.println(lilei.getName());
		System.out.println(lilei.getGender());
		System.out.println(lilei.getAge());
		System.out.println(lilei.toString());    //打印具体信息
	}

}

class Person {               //定义一个Person类
	private int ID;           //成员变量
	private String name;
	private String gender;
	private int age;
	
	public Person(int ID, String name, String gender, int age) {   //构造函数
		this.ID = ID;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public String getName() {      //返回名字
		return name;
	}
	
	public String getGender() {     //返回性别
		return gender;
	}
	
	public int getID() {             //返回身份证号码
		return ID;
	}
	
	public int getAge() {            //返回年龄
		return age;
	}
	
	public String toString() {       //定义函数，返回具体信息
		return getID() + " " + getName() + " " + getGender() + " " + getAge();
	}
}

class Student extends Person {        //Student类继承Person类
	private String major;             //在Person类基础上，增加专业和gpa两个成员变量
	private double gpa;
	
	public Student(int ID, String name, String gender, int age, String major, double gpa) {   //构造函数
		super(ID, name, gender, age);   //使用super，调用继承自Person类的构造函数
		this.major = major;             //对新添加的成员变量赋值
		this.gpa = gpa;
	}
	
	public String getMajor() {         //返回专业
		return major;
	}
	
	public double getGpa() {           //返回gpa
		return gpa;
	}
	
	public String toString() {         //返回学生信息
		return super.toString() + " " + getMajor() + " " + getGpa();   //使用super.toString()函数调用Person类的函数，再加上学生的专业和gpa信息
	}
}