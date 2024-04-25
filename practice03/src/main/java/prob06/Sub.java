package prob06;

public class Sub extends Calculator{
	public Sub(int a,int b) {
		super(a,b);
	}
	public int calculate() {
		return a - b;
	}
}
