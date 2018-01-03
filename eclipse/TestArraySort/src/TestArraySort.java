import java.util.Arrays;
import java.util.Comparator;

public class TestArraySort {

	public static void main(String[] args) {
		Athlete[] athlete = new Athlete[3];                 //定义一个运动员类型的数组
		athlete[0] = new Athlete("ZhangSan", 180, 70);      //存入三个运动员
		athlete[1] = new Athlete("LiSi", 166, 58);
		athlete[2] = new Athlete("WangWu", 175, 55);
		
		Arrays.sort(athlete);            //使用Array.sort()函数，对运动员进行排序，使用默认排序的比较标准

		for(Athlete a : athlete){        //for循环打印运动员
			System.out.println(a);
		}
		
		for(int i = 0; i < athlete.length; i++){
			System.out.println(athlete[i]);
		}
		
		Arrays.sort(athlete, new Comparator<Athlete>() {      //使用Array.sort()函数，对运动员进行排序

			@Override
			public int compare(Athlete o1, Athlete o2) {      //重写compare（）方法，设定排序标准为名字
				return o2.getName().compareTo(o1.getName());
			}
		});
		
		System.out.println(Arrays.toString(athlete));     //打印运动员信息，Arrays.toString（）方法，将数组中的所有运动员信息转化为字符串，统一打印
		
		Arrays.sort(athlete, new Comparator<Athlete>() {     //使用Array.sort()函数，对运动员进行排序

			@Override
			public int compare(Athlete o1, Athlete o2) {      //重写compare（）方法，设定排序标准为身高
				//return o1.getHeight() >= o2.getHeight() ? -1 : 1;
				return o2.getHeight() - o1.getHeight();
			}
		});
		
		System.out.println(Arrays.toString(athlete));         //打印运动员信息，Arrays.toString（）方法，将数组中的所有运动员信息转化为字符串，统一打印
		
		BasketballPlayer[] basketballPlayer = new BasketballPlayer[3];       //定义一个棒球运动员类型的数组
		basketballPlayer[0] = new BasketballPlayer("ZhangSan", 180, 70, 3);  //存入三个棒球运动元
		basketballPlayer[1] = new BasketballPlayer("LiSi", 166, 58, 4);
		basketballPlayer[2] = new BasketballPlayer("WangWu", 175, 55, 1);
		
		Arrays.sort(basketballPlayer);                     //使用Array.sort()函数，对棒球运动员进行排序，使用默认排序比较标准
		for(BasketballPlayer b : basketballPlayer)         //for循环打印棒球运动员信息
			System.out.println(b);
		
		Arrays.sort(basketballPlayer, new Comparator<Athlete>() {     //使用Array.sort()函数，对棒球运动员进行排序
			@Override
			public int compare(Athlete o1, Athlete o2) {             //重写compare（），设置棒球运动员的击球等级为排序标准
				BasketballPlayer b1 = (BasketballPlayer)o1;          //强制转换
				BasketballPlayer b2 = (BasketballPlayer)o2;          //强制转换
				//return b1.getShootLv() >= b2.getShootLv() ? -1 : 1;  //按击球登记从大到小排序
				return b2.getShootLv() - b1.getShootLv();
			}
		});
		
		System.out.println(Arrays.toString(basketballPlayer));       ////打印棒球运动员信息，Arrays.toString（）方法，将数组中的所有棒球运动员信息转化为字符串，统一打印
	}

}



class Athlete implements Comparable<Athlete> {    //定义一个Athlete运动员类，并实现Comparable接口，Comparable接口是java自带的，里面有一个自带的排序比较方法
	private String name;
	private int height;
	private int weight;
	
	public Athlete(String n, int h, int w) {    //构造函数
		this.name = n;
		this.height = h;
		this.weight = w;
	}
	
	public String getName() {   //获取名字
		return name;
	}
	
	public int getHeight() {    //获取身高
		return height;
	}
	
	public int getWeight() {    //获取体重
		return weight;
	}
	
	@Override
	public String toString() {   //重写toString（）方法，该方法在Object中存在
	   // System.out.printf("An Athlete %s with height of %d and weight of %d", name, height, weight);
		//System.out.println("An Athlete " + name + "with height of " + height + "and weight of " + weight);
		return String.format("An Athlete %s with height of %d and weight of %d", name, height, weight);
		
	}
	
	@Override
	public int compareTo(Athlete o) {   //重写compareTo（）方法，该方法在Comparable接口中存在，设置排序比较的标准
		//this放前面，从小到大； 传入的o放前面，从大到小
		return o.getName().compareTo(this.getName());   //设置名字为比较标准(String)
		
		//return this.getHeight()-o.getHeight();     //设置身高为比较标准（数值）
		
	}
}

class BasketballPlayer extends Athlete {   //定义一个棒球运动员类，继承自普通运动员类，间接实现Comparable接口
	private int shootLv;
	
	public BasketballPlayer(String n, int h, int w, int s) {  //构造函数
		super(n, h, w);     //引用普通运动员构造函数
		this.shootLv = s;
	}
	
	public int getShootLv() {   //获取击球等级
		return shootLv;
	}
	
	@Override
	public String toString() {    //重写toString（）方法，该方法在Comparable接口中存在
		return String.format("An BasketballPlayer %s with height of %d and weight of %d and shootLv of %d", this.getName(), this.getHeight(), this.getWeight(), this.shootLv);
	}
	
	@Override
	public int compareTo(Athlete o) {      //重写compareTo（）方法，该方法在Comparable接口中存在，设置排序比较的标准
		BasketballPlayer b = (BasketballPlayer)o;    //将普通运动员类强制转换为棒球运动员类
		//return this.shootLv > b.shootLv ? 1 : -1;    //比较标准为击球登记，等级高排前面
		return b.shootLv - this.shootLv;
	}
}
