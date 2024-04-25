package prob06;

import java.util.Scanner;

public class CalcApp{

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while( true ) {
			/*  코드를 완성 합니다 */
			System.out.print( ">> " );
			String expression = scanner.nextLine();
			
			if( "quit".equals( expression ) ) {
				break;
			}
			
			String[] tokens = expression.split( " " );
			
			if( tokens.length != 3 ) {
				System.out.println( ">> 알 수 없는 식입니다.");
				continue;
			}
			
			int lValue = Integer.parseInt( tokens[ 0 ] );
			int rValue = Integer.parseInt( tokens[ 2 ] );
			
			switch( tokens[ 1 ] ) {
				case "+" : {
					Calculator add = new Add(lValue, rValue);
					System.out.println( ">> " + add.calculate());
					
					break;
				}
				case "-" : {
					Calculator sub = new Sub(lValue, rValue);
					System.out.println( ">> " + sub.calculate());
					
					break;
				}
				case "*" : {
					Calculator mul = new Mul(lValue, rValue);
					System.out.println( ">> " + mul.calculate());
					
					break;					
				}
				case "/" : {
					Calculator div = new Div(lValue, rValue);
					System.out.println( ">> " + div.calculate());
					
					break;
				}
				default :  {
					System.out.println( ">> 알 수 없는 연산입니다.");
				}
			}
		}
		
		scanner.close();

	}

}
