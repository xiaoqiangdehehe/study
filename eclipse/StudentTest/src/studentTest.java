
public class studentTest {
	
	public static void main(String[] arg) {
		Student[] stu = new Student[4];              //定义一个存放Student的数组
		stu[0] = new Student(150001, "HanMei", 'F', 19, "E-Commerce", 3, 6);     //new学生，并存放到数组里面
		stu[1] = new Student(150002, "LiLei", 'M', 20, "E-Commerce", 4, 6);
		stu[2] = new Student(160001, "Tom", 'M', 19, "Bioinformatics", 1, 6);
		stu[3] = new Student(160002, "Jerry", 'M', 18, "Bioinformatics", 2, 6);
		stu[0].enroll("DB");         //设置课程
		stu[0].enroll("Java");
		stu[0].enroll("Econmics");
		stu[1].enroll("DB");
		stu[1].enroll("Java");
		stu[1].enroll("Data Structures");
		stu[2].enroll("Java");
		stu[2].enroll("Data Structures");
		stu[2].enroll("Biology");
		stu[3].enroll("DB");
		stu[3].enroll("Java");
		stu[3].enroll("Data Structures");
		for(Student s : stu) {         //将学生信息打印出来
			System.out.print("id=" + s.getId() + ",name=" + s.getName() + ",gender="
		                           + s.getGender() + ",age=" + s.getAge() + ",major="
					               + s.getMajor() + ",gpa=" + s.getGpa() + ",course=");
			s.getCourses();            //打印课程
			System.out.print("\n");
		}
	}
}

class Student{
	long id;              //成员变量
	String name;
	char gender;
	int age;
	String major;
	double gpa;
	String[] courses;
	
	public Student(long id, String name, char gender,int age, String major, double gpa, int maxCourses) {     //构造函数
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.major = major;
		this.gpa = gpa;
		courses = new String[maxCourses];
	}
	
	public double getId() {       //获取学号
		return id;
	}
	
	public String getName() {     //获取姓名
		return name;
	}
	
	public char getGender() {     //获取性别
		return gender;
	}
	
	public int getAge() {          //获取年龄
		return age;
	}
	
	public String getMajor() {     //获取专业
		return major;
	}
	
	public double getGpa() {        //获取gpa
		return gpa;
	}
	
	public void getCourses() {       //获取课程并打印出来
		for(int i = 0; i < courses.length; ++i) {
			if(courses[i] != null) {
				System.out.print(courses[i] + " ");
			}
		}
	}
	
	boolean enroll(String course) {    //设置课程
		for(int i = 0; i < courses.length; ++i) {
			if(courses[i] == null) {
				courses[i] = course;
				return true;
			}
		}
		return false;
	}
	
}
