package prob02;

public class Goods {
	public String drink;
	public int price;
	public int count;
	
	public Goods(String drink,int price,int count) {
		this.drink = drink;
		this.price = price;
		this.count = count;
	}
	public String getDrink() {
		return drink;
	}
	public int getPrice() {
		return price;
	}
	public int getCount() {
		return count;
	}
	
	public void show() {
		System.out.println(drink+" (가격: "+price+"원) 이 "+count+"개 입고 되었습니다.");
	}
}
