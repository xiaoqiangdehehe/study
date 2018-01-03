
public class AthelteTest {

	public static void main(String[] args) {
		Athlete ath[] = new Athlete[3];                          //����һ������˶�Ա���͵�����
		ath[0] = new Athlete("����", 180, 70);                   //���һ����ͨ�˶�Ա
		ath[1] = new BasketballPlayer("����", 210, 105, 3);      //���һ�������˶�Ա
		ath[2] = new BaseballPlayer("����", 185, 79, 4);         //���һ�������˶�Ա
		for(int i = 0; i < 3; i++){                              //������ӡ�˶�Ա��Ϣ
			System.out.println(ath[i].getDescription());
		}
	}

}

class Athlete {            //����һ��Athlete�˶�Ա��
	
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

class BasketballPlayer extends Athlete {      //����һ�������˶�Ա�࣬�̳����˶�Ա��
	private int shootLv;
	public BasketballPlayer(String name, int h, int w, int shootLv) {
		super(name, h ,w);
		this.shootLv = shootLv;
	}
	
	public String getDescription() {            //��ȡ�����˶�ԱͶ���ȼ�
		return "A Basketball player " + this.getName() + " Name whth shooting level of " + this.shootLv;
	}
}

class BaseballPlayer extends Athlete {        //����һ�������˶�Ԫ���̳����˶�Ա��
	private int hitLv;
	public BaseballPlayer(String name, int h, int w, int hitLv) {
		super(name, h, w);
		this.hitLv = hitLv;
	}
	
	public String getDescription() {           //��ȡ�����˶�Ԫ�Ļ���ȼ�
		return "A Baseball player " + this.getName() + " Name with hitting level of " + this.hitLv; 
	}
}