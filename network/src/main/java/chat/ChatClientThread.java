package chat;

import java.io.BufferedReader;
import java.io.IOException;

public class ChatClientThread extends Thread {
	private BufferedReader bufferedReader;

	public ChatClientThread(BufferedReader br) {
		this.bufferedReader = br;
	}

	@Override
	public void run() {
		/* reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리) */
		String data;
		try {
			while (true) {
				data = bufferedReader.readLine();
				if (data == null) {
					System.out.println("[client] : suddenly closed by server");
					break;
				}
				if(data.contains("join")) {
					continue;
				}
				if("채팅이 종료되었습니다".equals(data)) {
					return;
				}
				System.out.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}

	}

}
