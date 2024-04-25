package prob06;

public abstract class Calculator {
	protected int a;
	protected int b;
	public Calculator(int a, int b) {
		this.a = a;
		this.b = b;
	}
	 public abstract int calculate();
}
