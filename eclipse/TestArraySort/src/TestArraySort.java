import java.util.Arrays;
import java.util.Comparator;

public class TestArraySort {

	public static void main(String[] args) {
		Athlete[] athlete = new Athlete[3];                 //����һ���˶�Ա���͵�����
		athlete[0] = new Athlete("ZhangSan", 180, 70);      //���������˶�Ա
		athlete[1] = new Athlete("LiSi", 166, 58);
		athlete[2] = new Athlete("WangWu", 175, 55);
		
		Arrays.sort(athlete);            //ʹ��Array.sort()���������˶�Ա��������ʹ��Ĭ������ıȽϱ�׼

		for(Athlete a : athlete){        //forѭ����ӡ�˶�Ա
			System.out.println(a);
		}
		
		for(int i = 0; i < athlete.length; i++){
			System.out.println(athlete[i]);
		}
		
		Arrays.sort(athlete, new Comparator<Athlete>() {      //ʹ��Array.sort()���������˶�Ա��������

			@Override
			public int compare(Athlete o1, Athlete o2) {      //��дcompare�����������趨�����׼Ϊ����
				return o2.getName().compareTo(o1.getName());
			}
		});
		
		System.out.println(Arrays.toString(athlete));     //��ӡ�˶�Ա��Ϣ��Arrays.toString�����������������е������˶�Ա��Ϣת��Ϊ�ַ�����ͳһ��ӡ
		
		Arrays.sort(athlete, new Comparator<Athlete>() {     //ʹ��Array.sort()���������˶�Ա��������

			@Override
			public int compare(Athlete o1, Athlete o2) {      //��дcompare�����������趨�����׼Ϊ���
				//return o1.getHeight() >= o2.getHeight() ? -1 : 1;
				return o2.getHeight() - o1.getHeight();
			}
		});
		
		System.out.println(Arrays.toString(athlete));         //��ӡ�˶�Ա��Ϣ��Arrays.toString�����������������е������˶�Ա��Ϣת��Ϊ�ַ�����ͳһ��ӡ
		
		BasketballPlayer[] basketballPlayer = new BasketballPlayer[3];       //����һ�������˶�Ա���͵�����
		basketballPlayer[0] = new BasketballPlayer("ZhangSan", 180, 70, 3);  //�������������˶�Ԫ
		basketballPlayer[1] = new BasketballPlayer("LiSi", 166, 58, 4);
		basketballPlayer[2] = new BasketballPlayer("WangWu", 175, 55, 1);
		
		Arrays.sort(basketballPlayer);                     //ʹ��Array.sort()�������԰����˶�Ա��������ʹ��Ĭ������Ƚϱ�׼
		for(BasketballPlayer b : basketballPlayer)         //forѭ����ӡ�����˶�Ա��Ϣ
			System.out.println(b);
		
		Arrays.sort(basketballPlayer, new Comparator<Athlete>() {     //ʹ��Array.sort()�������԰����˶�Ա��������
			@Override
			public int compare(Athlete o1, Athlete o2) {             //��дcompare���������ð����˶�Ա�Ļ���ȼ�Ϊ�����׼
				BasketballPlayer b1 = (BasketballPlayer)o1;          //ǿ��ת��
				BasketballPlayer b2 = (BasketballPlayer)o2;          //ǿ��ת��
				//return b1.getShootLv() >= b2.getShootLv() ? -1 : 1;  //������ǼǴӴ�С����
				return b2.getShootLv() - b1.getShootLv();
			}
		});
		
		System.out.println(Arrays.toString(basketballPlayer));       ////��ӡ�����˶�Ա��Ϣ��Arrays.toString�����������������е����а����˶�Ա��Ϣת��Ϊ�ַ�����ͳһ��ӡ
	}

}



class Athlete implements Comparable<Athlete> {    //����һ��Athlete�˶�Ա�࣬��ʵ��Comparable�ӿڣ�Comparable�ӿ���java�Դ��ģ�������һ���Դ�������ȽϷ���
	private String name;
	private int height;
	private int weight;
	
	public Athlete(String n, int h, int w) {    //���캯��
		this.name = n;
		this.height = h;
		this.weight = w;
	}
	
	public String getName() {   //��ȡ����
		return name;
	}
	
	public int getHeight() {    //��ȡ���
		return height;
	}
	
	public int getWeight() {    //��ȡ����
		return weight;
	}
	
	@Override
	public String toString() {   //��дtoString�����������÷�����Object�д���
	   // System.out.printf("An Athlete %s with height of %d and weight of %d", name, height, weight);
		//System.out.println("An Athlete " + name + "with height of " + height + "and weight of " + weight);
		return String.format("An Athlete %s with height of %d and weight of %d", name, height, weight);
		
	}
	
	@Override
	public int compareTo(Athlete o) {   //��дcompareTo�����������÷�����Comparable�ӿ��д��ڣ���������Ƚϵı�׼
		//this��ǰ�棬��С���� �����o��ǰ�棬�Ӵ�С
		return o.getName().compareTo(this.getName());   //��������Ϊ�Ƚϱ�׼(String)
		
		//return this.getHeight()-o.getHeight();     //�������Ϊ�Ƚϱ�׼����ֵ��
		
	}
}

class BasketballPlayer extends Athlete {   //����һ�������˶�Ա�࣬�̳�����ͨ�˶�Ա�࣬���ʵ��Comparable�ӿ�
	private int shootLv;
	
	public BasketballPlayer(String n, int h, int w, int s) {  //���캯��
		super(n, h, w);     //������ͨ�˶�Ա���캯��
		this.shootLv = s;
	}
	
	public int getShootLv() {   //��ȡ����ȼ�
		return shootLv;
	}
	
	@Override
	public String toString() {    //��дtoString�����������÷�����Comparable�ӿ��д���
		return String.format("An BasketballPlayer %s with height of %d and weight of %d and shootLv of %d", this.getName(), this.getHeight(), this.getWeight(), this.shootLv);
	}
	
	@Override
	public int compareTo(Athlete o) {      //��дcompareTo�����������÷�����Comparable�ӿ��д��ڣ���������Ƚϵı�׼
		BasketballPlayer b = (BasketballPlayer)o;    //����ͨ�˶�Ա��ǿ��ת��Ϊ�����˶�Ա��
		//return this.shootLv > b.shootLv ? 1 : -1;    //�Ƚϱ�׼Ϊ����Ǽǣ��ȼ�����ǰ��
		return b.shootLv - this.shootLv;
	}
}
