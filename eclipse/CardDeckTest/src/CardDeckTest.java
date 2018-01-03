import java.util.Scanner;

public class CardDeckTest {
	public static void main(String[] args) {
        CardDeck cd = new CardDeck();          //new一副扑克牌对象，通过构造函数直接洗好牌
        System.out.println("请问抽取第几张牌:");   //打印：请问抽取第几张牌
		Scanner s = new Scanner(System.in);         //定义从键盘输入
        int playerNum= s.nextInt();                //从键盘输入数值，并赋值给变量
        boolean win = cd.PK(playerNum);            //调用一副扑克牌的.pk()方法，将抽取的牌与电脑随机抽取的牌比较大小，将返回值赋值给变量win
        if(win)                                    //如果结果为true，打印你赢了，否则打印你输了
        	System.out.println("你赢了");
        else
        	System.out.println("你输了");
	}
}

class Card {                 //一张扑克牌的类
	private int suit;        //定义一个整型变量，用来存放花色
	private int value;       //定义一个整型变量，用来存放数值
	
	public Card(int s, int v) {  //构造函数
		suit = s;
		value = v;
	}
	
	public int getSuit() {      //获取花色
		return suit;
	}
	
	public int getValue() {      //获取数值
		return value;
	}
}


class CardDeck {                 //一副扑克牌的类
	private Card[] cards;        //定义存放扑克牌的数组
	public CardDeck() {          //构造函数，生成52张牌，并洗牌
		cards = new Card[52];    //把存放扑克牌的数组初始化
		int k = 0;               //定义变量k，作为扑克牌数组的下标，用来遍历扑克牌数组
		for(int i = 1; i < 14; ++i) {     //生成不同花色，不同数值的52张牌
			for(int j = 0; j < 4; ++j){
				cards[k++] = new Card(j, i);
			}
		}
		shuffle();                //调用shuffle（）方法，进行洗牌
		System.out.println("牌已经洗好了！");  //打印：牌已经洗好了！
	}
	
	private void shuffle() {          //洗牌函数
		for(int i = 0; i < 52; ++i) {      //遍历52张牌
			int replacement = (int)(Math.random() * 52);     //随机抽取一张牌
			swap(i , replacement);        //调用swap函数，将遍历的牌与随机抽取的拍进行交换
		}
	}
	
	public Card drawRand() {              //随机抽取一张牌
		return cards[(int)(Math.random() * 52)];
	}
	
	public Card drawManually(int i) {     //抽取第i张牌
		return cards[i - 1];
	}
	
	private void swap(int i, int j) {      //交换第i，j两张牌
		Card tmp = cards[i];
		cards[i] = cards[j];
		cards[j] = tmp;
	}
	
	public boolean PK(int i) {              //抽取第i张牌，与电脑随机抽取的牌比较大小
		boolean pk = false;                 //定义存放输赢的boolean型变量，默认为false（输）
		Card card1 = drawManually(i);       //从键盘输入一个值i，抽取第i张牌
		System.out.printf("你抽取的牌为（%d, %d）\n", card1.getSuit(), card1.getValue());         //打印用户抽取的牌，包括花色和数值
		Card card2 = drawRand();            //（电脑）随机抽取一张牌
		System.out.printf("电脑抽取的牌为（%d, %d）\n", card2.getSuit(), card2.getValue());       //打印电脑抽取的牌，包括花色和数值
		if(card1.getSuit() > card2.getSuit())       //先比较花色
			pk = true;                              //如果花色大，则将变量pk赋值为true（赢）
		else if(card1.getSuit() ==card2.getSuit())   //如果花色相同
			if(card1.getValue() > card2.getValue())  //比较数值大小
				pk = true;                           //如果数值大，则将变量pk赋值为true（赢）
		return pk;                  //返回结果
	}
}