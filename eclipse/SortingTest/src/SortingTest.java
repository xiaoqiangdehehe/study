
public class SortingTest {

	public static void main(String[] args) {
		char[] array = "CHINA".toCharArray();       //����һ�������ĸ�����飬.toCharArray()�������ַ�����SiYaQi��ת��Ϊ�ַ�����
		System.out.println("Before Sorting:");       //��ӡһ����ʾ������ǰ
		for (int i = 0; i < array.length; ++i) {     //forѭ�������ַ�����
			System.out.println(array[i]);            //��ӡ�ַ�
		}
		
		BubbleSort bsort = new BubbleSort(array);     //newһ��ð������Ķ��󣬲������ַ�����
		bsort.sort();                                 //����ð�����������������������
		
		System.out.println("After Sorting:");         //��ӡһ����ʾ�������
		for (int i = 0; i < array.length; ++i) {       //forѭ����������
			System.out.println(array[i]);              //��ӡ�ַ�
		}

	}

}

class BubbleSort {                 //ð�����򣬶���ĸ�����������ִ�Сд
	private char[] data;           //��������ĸ������
	
	public BubbleSort(char[] data) {  //���캯��
		this.data = data;
	}
	
	public void sort() {               //ð�����򣬺͵�һ���������ƣ������С��������
		for (int i = 0; i < data.length - 1; ++i) 
			for (int j = 0; j < data.length - i -1; ++j)
				if (data[j] > data[j+1]) {
					char tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
 				}
	}
}
