import java.time.*;

/**
 * This program tests the Employee class.
 * @version 1.12 2015-05-08
 * @author Cay Horstmann
 */
public class EmployeeTest
{
   public static void main(String[] args)
   {
	   Employee e1 = new Employee();
	   Employee e2 = new Employee("James", 100000, 1950, 1, 1);
	   
	   //System.out.println("hello" + 5);

	   
      // fill the staff array with three Employee objects
      Employee[] staff = new Employee[3];

      staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
      staff[1] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
      staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
      
      System.out.println(staff[0].equals(staff[1]));

      // raise everyone's salary by 5%
      for (Employee e : staff)
         e.raiseSalary(5);

      // print out information about all Employee objects
      for (Employee e : staff)
         System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay="
               + e.getHireDay());
   }
}

class Employee
{
   private String name;
   private double salary;
   private LocalDate hireDay;
   
   /**
   * The Senior Member
   */
   public static final int SENIOR = 1;

   /**
   * The Junior Member
   */
   public static final int JUNIOR = 0;

   
// DefaultConstructor
   public Employee() {
   }


   public Employee(String n, double s, int year, int month, int day)
   {
      name = n;
      salary = s;
      hireDay = LocalDate.of(year, month, day);
   }
   
   public void setName(String name){
	   this.name = name;
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public LocalDate getHireDay()
   {
      return hireDay;
   }

   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }
   
   public static void swapV2(Employee x, Employee y) {
	     String tmp = x.getName();
	     x.setName(y.getName());
	     y.setName(tmp);
	   }

   
   //重载
   public void sort(int[] data) {
	   for (int i = 0; i < data.length - 1; ++i)
	   		for (int j = 0; j < data.length - i -1; ++j)
	   			if (data[j] > data[j+1]) {
	   				int tmp = data[j];
	   				data[j] = data[j+1];
	   				data[j+1] = tmp;
	   	   }
	   }

	   public void sort(double[] data) {
	   for (int i = 0; i < data.length - 1; ++i)
		   for (int j = 0; j < data.length - i -1; ++j)
			   if (data[j] > data[j+1]) {
				   double tmp = data[j];
				   data[j] = data[j+1];
				   data[j+1] = tmp;
			   }
	   }


		   public boolean equals(Object obj) {
			   
			   //判断obj是不是比较对象
			   if (!(obj instanceof Employee))
				   return false;
			   
			   //强制转换
			   Employee e = (Employee)obj;
			   
			   
			   return name.equals(e.name) && hireDay.equals(e.hireDay) && salary == e.salary;
			   
			   
			   
		   }


	   
	   
	   
}
