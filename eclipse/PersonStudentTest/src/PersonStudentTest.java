
public class PersonStudentTest {

	public static void main(String[] args) {
		Student hanmei = new Student(15001, "Han Mei", "man", 21, "E-Commerce", 4.0);   //newһ��Student����
		System.out.println(hanmei.getID());      //��ӡ���֤����
		System.out.println(hanmei.getName());
		System.out.println(hanmei.getGender());
		System.out.println(hanmei.getAge());
		System.out.println(hanmei.getMajor());
		System.out.println(hanmei.getGpa());
		System.out.println(hanmei.toString());   //��ӡѧ����Ϣ
		
		Person lilei = new Person(11111, "Li Lei", "man", 20);    //newһ��Person����
		System.out.println(lilei.getID());       //��ӡ���֤����
		System.out.println(lilei.getName());
		System.out.println(lilei.getGender());
		System.out.println(lilei.getAge());
		System.out.println(lilei.toString());    //��ӡ������Ϣ
	}

}

class Person {               //����һ��Person��
	private int ID;           //��Ա����
	private String name;
	private String gender;
	private int age;
	
	public Person(int ID, String name, String gender, int age) {   //���캯��
		this.ID = ID;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public String getName() {      //��������
		return name;
	}
	
	public String getGender() {     //�����Ա�
		return gender;
	}
	
	public int getID() {             //�������֤����
		return ID;
	}
	
	public int getAge() {            //��������
		return age;
	}
	
	public String toString() {       //���庯�������ؾ�����Ϣ
		return getID() + " " + getName() + " " + getGender() + " " + getAge();
	}
}

class Student extends Person {        //Student��̳�Person��
	private String major;             //��Person������ϣ�����רҵ��gpa������Ա����
	private double gpa;
	
	public Student(int ID, String name, String gender, int age, String major, double gpa) {   //���캯��
		super(ID, name, gender, age);   //ʹ��super�����ü̳���Person��Ĺ��캯��
		this.major = major;             //������ӵĳ�Ա������ֵ
		this.gpa = gpa;
	}
	
	public String getMajor() {         //����רҵ
		return major;
	}
	
	public double getGpa() {           //����gpa
		return gpa;
	}
	
	public String toString() {         //����ѧ����Ϣ
		return super.toString() + " " + getMajor() + " " + getGpa();   //ʹ��super.toString()��������Person��ĺ������ټ���ѧ����רҵ��gpa��Ϣ
	}
}