package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요: ");
		int sc = scanner.nextInt();
		int sum=0;
		for(int i=sc;i>0;i-=2) {
			sum+=i;
		}
		System.out.println("결과 값: "+ sum);
		/* 코드 작성 */
		
		scanner.close();
	}
}
