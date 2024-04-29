package prob01;

public class Printer {
//	public void println(int num) {
//		System.out.println(num);
//	}
//
//	public void println(double num) {
//		System.out.println(num);
//	}
//
//	public void println(boolean num) {
//		System.out.println(num);
//	}
//
//	public void println(String num) {
//		System.out.println(num);
//	}
	
	public <T> void println(T t) {
		System.out.println(t);
	}
	public <T> void println(T... ts) {
		for(T t : ts) {
			System.out.println(t);
		}
	}
	
	public int sum(Integer ... nums) {
		int s = 0;
		for(Integer n : nums) {
			s += n;
		}
		return s;
	}
}
