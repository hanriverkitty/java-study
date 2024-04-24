package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		/* 코드 작성 */
		int money = scanner.nextInt();
		System.out.println("금액: "+money);
		int idx=0;
		while(idx<MONEYS.length) {
			System.out.println(MONEYS[idx]+"원 : "+money/MONEYS[idx]+"개");
			money=money%MONEYS[idx];
			idx++;
		}
		scanner.close();
 	}
}