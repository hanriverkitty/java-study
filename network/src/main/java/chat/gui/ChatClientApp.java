package chat.gui;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int PORT = 7999;
	
	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;

		while (true) {

			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();

			if (!name.isEmpty()) {
				break;
			}

			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}

		scanner.close();
		// 2. socket 생성
		socket = new Socket();

		// 3. 연결
		try {
			socket.connect(new InetSocketAddress(SERVER_IP, PORT));
		} catch (IOException e) {
			e.printStackTrace();
		}

		new ChatWindow(name,socket).show();
	}

}
