package homework;

import java.time.LocalDateTime;
import java.util.Scanner;

public class homework {
	
	public static void main(String[] args) {	//main函数，程序从main函数开始执行
		Scanner scan = new Scanner(System.in);  //定义从键盘输入
		int[] array = new int[10];              //定义int数组
		for (int i = 0;i < array.length; ++i){  //for循环遍历数组
			array[i] = scan.nextInt();          //从键盘输入数据存入数组
		}
		homework obj = new homework();          //new一个homework对象
		obj.sort(array);                        //调用sort函数，对数组进行排序
		for (int i : array){                    //for循环遍历数组
			System.out.println(i);              //打印数组
		}
	}
	
	void sort(int[] arg) {                      //冒泡排序函数
		for (int i = 0; i < arg.length-1; ++i)  
			for (int j = 0; j < arg.length -i -1;j++ )
				if (arg[j] < arg[j+1]) {        //决定顺序还是倒序
					int tmp = arg[j];
					arg[j]=arg[j+1];
					arg[j+1]=tmp;
					}
		}
	}