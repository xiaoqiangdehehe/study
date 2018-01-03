import java.util.Scanner;

public class CardDeckTest {
	public static void main(String[] args) {
        CardDeck cd = new CardDeck();          //newһ���˿��ƶ���ͨ�����캯��ֱ��ϴ����
        System.out.println("���ʳ�ȡ�ڼ�����:");   //��ӡ�����ʳ�ȡ�ڼ�����
		Scanner s = new Scanner(System.in);         //����Ӽ�������
        int playerNum= s.nextInt();                //�Ӽ���������ֵ������ֵ������
        boolean win = cd.PK(playerNum);            //����һ���˿��Ƶ�.pk()����������ȡ��������������ȡ���ƱȽϴ�С��������ֵ��ֵ������win
        if(win)                                    //������Ϊtrue����ӡ��Ӯ�ˣ������ӡ������
        	System.out.println("��Ӯ��");
        else
        	System.out.println("������");
	}
}

class Card {                 //һ���˿��Ƶ���
	private int suit;        //����һ�����ͱ�����������Ż�ɫ
	private int value;       //����һ�����ͱ��������������ֵ
	
	public Card(int s, int v) {  //���캯��
		suit = s;
		value = v;
	}
	
	public int getSuit() {      //��ȡ��ɫ
		return suit;
	}
	
	public int getValue() {      //��ȡ��ֵ
		return value;
	}
}


class CardDeck {                 //һ���˿��Ƶ���
	private Card[] cards;        //�������˿��Ƶ�����
	public CardDeck() {          //���캯��������52���ƣ���ϴ��
		cards = new Card[52];    //�Ѵ���˿��Ƶ������ʼ��
		int k = 0;               //�������k����Ϊ�˿���������±꣬���������˿�������
		for(int i = 1; i < 14; ++i) {     //���ɲ�ͬ��ɫ����ͬ��ֵ��52����
			for(int j = 0; j < 4; ++j){
				cards[k++] = new Card(j, i);
			}
		}
		shuffle();                //����shuffle��������������ϴ��
		System.out.println("���Ѿ�ϴ���ˣ�");  //��ӡ�����Ѿ�ϴ���ˣ�
	}
	
	private void shuffle() {          //ϴ�ƺ���
		for(int i = 0; i < 52; ++i) {      //����52����
			int replacement = (int)(Math.random() * 52);     //�����ȡһ����
			swap(i , replacement);        //����swap�����������������������ȡ���Ľ��н���
		}
	}
	
	public Card drawRand() {              //�����ȡһ����
		return cards[(int)(Math.random() * 52)];
	}
	
	public Card drawManually(int i) {     //��ȡ��i����
		return cards[i - 1];
	}
	
	private void swap(int i, int j) {      //������i��j������
		Card tmp = cards[i];
		cards[i] = cards[j];
		cards[j] = tmp;
	}
	
	public boolean PK(int i) {              //��ȡ��i���ƣ�����������ȡ���ƱȽϴ�С
		boolean pk = false;                 //��������Ӯ��boolean�ͱ�����Ĭ��Ϊfalse���䣩
		Card card1 = drawManually(i);       //�Ӽ�������һ��ֵi����ȡ��i����
		System.out.printf("���ȡ����Ϊ��%d, %d��\n", card1.getSuit(), card1.getValue());         //��ӡ�û���ȡ���ƣ�������ɫ����ֵ
		Card card2 = drawRand();            //�����ԣ������ȡһ����
		System.out.printf("���Գ�ȡ����Ϊ��%d, %d��\n", card2.getSuit(), card2.getValue());       //��ӡ���Գ�ȡ���ƣ�������ɫ����ֵ
		if(card1.getSuit() > card2.getSuit())       //�ȱȽϻ�ɫ
			pk = true;                              //�����ɫ���򽫱���pk��ֵΪtrue��Ӯ��
		else if(card1.getSuit() ==card2.getSuit())   //�����ɫ��ͬ
			if(card1.getValue() > card2.getValue())  //�Ƚ���ֵ��С
				pk = true;                           //�����ֵ���򽫱���pk��ֵΪtrue��Ӯ��
		return pk;                  //���ؽ��
	}
}