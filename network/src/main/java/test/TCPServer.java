package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. Server Socket 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩(binding)
			// socket에 InetSocketAddress[InetAddress(IPAddress)+port] 를 바인딩 한다
			// IPAddress: 0.0.0.0: 특정 호스트 IP(네트워크 대역)를 바인딩 하지 않는다.
			// 10은 백로그 (accept() 처리 도중에 연결요청하는 애들을 큐에 대기시킨다)
			serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000), 10);

			// 3. accept
			Socket socket = null;
			try {
				socket = serverSocket.accept(); // blocking
				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remotePort + "]");
				System.out.println("연결!");

				// 4. IO Stream 받아오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				// 5. 데이터 읽기
				while (true) {
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer); // 읽는 순간 blocking이 풀린다

					if (readByteCount == -1) {
						// 클라이언트가 정상적으로 종료(close() 호출)
						System.out.println("[server] closed by client");
						break;
					}

					String data = new String(buffer, 0, readByteCount, "UTF-8");
					System.out.println("[server] received: " + data);

					// 6. 데이터 쓰기
					os.write(data.getBytes("utf-8"));

					// SocketException 이 발생하는 부분
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					os.write(data.getBytes("utf-8"));
				}

			} catch (SocketException e) {
				System.out.println("[server] SocketException : " + e);
			} catch (IOException e) {
				System.out.println("[server] error : " + e);
			} finally {
				try {
					if (socket != null && !socket.isClosed()) {
						socket.close();
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			System.out.println("[server] error: " + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
