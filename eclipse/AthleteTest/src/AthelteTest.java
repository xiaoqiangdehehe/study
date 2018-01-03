
public class AthelteTest {

	public static void main(String[] args) {
		Athlete ath[] = new Athlete[3];                          //定义一个存放运动员类型的数组
		ath[0] = new Athlete("大王", 180, 70);                   //存放一个普通运动员
		ath[1] = new BasketballPlayer("二王", 210, 105, 3);      //存放一个篮球运动员
		ath[2] = new BaseballPlayer("三王", 185, 79, 4);         //存放一个棒球运动员
		for(int i = 0; i < 3; i++){                              //遍历打印运动员信息
			System.out.println(ath[i].getDescription());
		}
	}

}

class Athlete {            //定义一个Athlete运动员类
	
	private String name;
	private int h;
	private int w;
	
	public Athlete(String name, int h, int w) {
		this.name = name;
		this.h = h;
		this.w = w;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getHeight() {
		return this.h;
	}
	
	public int getWeight() {
		return this.w;
	}
	
	public String getDescription() {
		return "A Athlete " + this.name + " Name with height of " + this.h + " and weight of " + this.w;
	}
}

class BasketballPlayer extends Athlete {      //定义一个篮球运动员类，继承自运动员类
	private int shootLv;
	public BasketballPlayer(String name, int h, int w, int shootLv) {
		super(name, h ,w);
		this.shootLv = shootLv;
	}
	
	public String getDescription() {            //获取篮球运动员投篮等级
		return "A Basketball player " + this.getName() + " Name whth shooting level of " + this.shootLv;
	}
}

class BaseballPlayer extends Athlete {        //定义一个棒球运动元，继承自运动员类
	private int hitLv;
	public BaseballPlayer(String name, int h, int w, int hitLv) {
		super(name, h, w);
		this.hitLv = hitLv;
	}
	
	public String getDescription() {           //获取棒球运动元的击球等级
		return "A Baseball player " + this.getName() + " Name with hitting level of " + this.hitLv; 
	}
}