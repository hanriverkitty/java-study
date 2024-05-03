package chat.gui_split_improve;

import java.util.Base64;

public class Base64Test {

	public static void main(String[] args) {
		String str = "join";
		String encodedStr = Base64.getEncoder().encodeToString(str.getBytes());
		System.out.println("encoded string: " + encodedStr);
		
		str = "quit";
		encodedStr = Base64.getEncoder().encodeToString(str.getBytes());
		System.out.println("encoded string: " + encodedStr);
		
		str = "message";
		encodedStr = Base64.getEncoder().encodeToString(str.getBytes());
		System.out.println("encoded string: " + encodedStr);

	}

}
