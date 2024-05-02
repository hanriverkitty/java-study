package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClient {

	private static final String SERVER_IP = "127.0.0.1";
	private static final int PORT = 7999;

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		try {
			
			// 1. 키보드 연결
			scanner = new Scanner(System.in);
			
			// 2. socket 생성
			socket = new Socket();
			
			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, PORT));
			
			// 4. reader/writer 생성
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			// 5 join 프로토콜
			System.out.print("닉네임>>");
			String nick = scanner.nextLine();
			pw.println("join:" + nick);
			pw.flush();

			// 6. ChatClientThread 시작
			new ChatClientThread(br).start();
			
			// 7. 키보드 입력처리
			while (true) {
				String input = scanner.nextLine();

				if ("quit".equals(input)) {
					pw.println("quit");
					break;
				} else {
					// 9. 메시지 처리
					pw.println("message:"+input);
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ChatServer.log("error:" + ex);
		} finally {
			// 10. 자원정리
			try {
				scanner.close();
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
