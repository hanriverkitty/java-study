package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		char[] toChar = str.toCharArray();
		char[] reverseChar = new char[toChar.length];
		for(int i=0;i<toChar.length;i++) {
			reverseChar[i] = toChar[toChar.length-1-i];
		}
		/* 코드를 완성합니다 */
		return reverseChar;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println( array );
	}
}