
public class SortingTest {

	public static void main(String[] args) {
		char[] array = "CHINA".toCharArray();       //定义一个存放字母的数组，.toCharArray()方法把字符串“SiYaQi”转化为字符数组
		System.out.println("Before Sorting:");       //打印一行提示：排序前
		for (int i = 0; i < array.length; ++i) {     //for循环遍历字符数组
			System.out.println(array[i]);            //打印字符
		}
		
		BubbleSort bsort = new BubbleSort(array);     //new一个冒泡排序的对象，并传入字符数组
		bsort.sort();                                 //调用冒泡排序函数，对数组进行排序
		
		System.out.println("After Sorting:");         //打印一行提示，排序后
		for (int i = 0; i < array.length; ++i) {       //for循环遍历数组
			System.out.println(array[i]);              //打印字符
		}

	}

}

class BubbleSort {                 //冒泡排序，对字母的排序有区分大小写
	private char[] data;           //定义存放字母的数组
	
	public BubbleSort(char[] data) {  //构造函数
		this.data = data;
	}
	
	public void sort() {               //冒泡排序，和第一个例题类似，这个从小到大排序
		for (int i = 0; i < data.length - 1; ++i) 
			for (int j = 0; j < data.length - i -1; ++j)
				if (data[j] > data[j+1]) {
					char tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
 				}
	}
}
