
public class studentTest {
	
	public static void main(String[] arg) {
		Student[] stu = new Student[4];              //����һ�����Student������
		stu[0] = new Student(150001, "HanMei", 'F', 19, "E-Commerce", 3, 6);     //newѧ��������ŵ���������
		stu[1] = new Student(150002, "LiLei", 'M', 20, "E-Commerce", 4, 6);
		stu[2] = new Student(160001, "Tom", 'M', 19, "Bioinformatics", 1, 6);
		stu[3] = new Student(160002, "Jerry", 'M', 18, "Bioinformatics", 2, 6);
		stu[0].enroll("DB");         //���ÿγ�
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
		for(Student s : stu) {         //��ѧ����Ϣ��ӡ����
			System.out.print("id=" + s.getId() + ",name=" + s.getName() + ",gender="
		                           + s.getGender() + ",age=" + s.getAge() + ",major="
					               + s.getMajor() + ",gpa=" + s.getGpa() + ",course=");
			s.getCourses();            //��ӡ�γ�
			System.out.print("\n");
		}
	}
}

class Student{
	long id;              //��Ա����
	String name;
	char gender;
	int age;
	String major;
	double gpa;
	String[] courses;
	
	public Student(long id, String name, char gender,int age, String major, double gpa, int maxCourses) {     //���캯��
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.major = major;
		this.gpa = gpa;
		courses = new String[maxCourses];
	}
	
	public double getId() {       //��ȡѧ��
		return id;
	}
	
	public String getName() {     //��ȡ����
		return name;
	}
	
	public char getGender() {     //��ȡ�Ա�
		return gender;
	}
	
	public int getAge() {          //��ȡ����
		return age;
	}
	
	public String getMajor() {     //��ȡרҵ
		return major;
	}
	
	public double getGpa() {        //��ȡgpa
		return gpa;
	}
	
	public void getCourses() {       //��ȡ�γ̲���ӡ����
		for(int i = 0; i < courses.length; ++i) {
			if(courses[i] != null) {
				System.out.print(courses[i] + " ");
			}
		}
	}
	
	boolean enroll(String course) {    //���ÿγ�
		for(int i = 0; i < courses.length; ++i) {
			if(courses[i] == null) {
				courses[i] = course;
				return true;
			}
		}
		return false;
	}
	
}
