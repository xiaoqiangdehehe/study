package homework;

import java.time.LocalDateTime;
import java.util.Scanner;

public class homework {
	
	public static void main(String[] args) {	//main�����������main������ʼִ��
		Scanner scan = new Scanner(System.in);  //����Ӽ�������
		int[] array = new int[10];              //����int����
		for (int i = 0;i < array.length; ++i){  //forѭ����������
			array[i] = scan.nextInt();          //�Ӽ����������ݴ�������
		}
		homework obj = new homework();          //newһ��homework����
		obj.sort(array);                        //����sort�������������������
		for (int i : array){                    //forѭ����������
			System.out.println(i);              //��ӡ����
		}
	}
	
	void sort(int[] arg) {                      //ð��������
		for (int i = 0; i < arg.length-1; ++i)  
			for (int j = 0; j < arg.length -i -1;j++ )
				if (arg[j] < arg[j+1]) {        //����˳���ǵ���
					int tmp = arg[j];
					arg[j]=arg[j+1];
					arg[j+1]=tmp;
					}
		}
	}