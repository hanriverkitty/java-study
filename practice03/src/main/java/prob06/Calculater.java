package prob06;

public abstract class Calculater {
	protected int a;
	protected int b;
	public Calculater(int a, int b) {
		this.a = a;
		this.b = b;
	}
	 public abstract int calculate();
}
