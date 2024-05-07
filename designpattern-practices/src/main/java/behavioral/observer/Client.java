package behavioral.observer;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Subject<Integer> intSubject = new Subject<>();

		intSubject.registerObserver(new Observer<Integer>() {
			@Override
			public void update(Integer val) {
				System.out.println("Observer01: " + val);
			}
		});
		
		
		// 추론할 수 있는 곳을 삭제
		// Observer는 함수가 하나만 있으므로 Override 부분 삭제
		// update 함수 파라미터 하나이므로 생략 가능
		// registerObserver의 파라미터 부분을 추론하여 삭제
		// functional interface
		intSubject.registerObserver(val -> System.out.println("Observer02: " + val));
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print(">> ");
			int val = scanner.nextInt();
			intSubject.changeSubject(val);
		}
	}

}
