package chapter03;

public class Swaptest01 {

	public static void main(String[] args) {
		int i = 10;
		int j = 20;
		
		System.out.println(i+", "+j);
		int temp;
		temp = i;
		i = j;
		j = temp;
		System.out.println(i+", "+j);
		
	}

}
