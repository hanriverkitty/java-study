package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nick;
	private Socket socket;
	private List<Writer> listWriters;

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		PrintWriter pw=null;
		try {

//		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
//		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
//		int remotePort = inetRemoteSocketAddress.getPort();
//		EchoServer.log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			while (true) {
				String request = br.readLine();
				if (request == null) {
					doQuit(pw);
					break;
				}
				String[] tokens = request.split(":");
				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], pw);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit(pw);
					break;
				} else {
					ChatServer.log("에러: 알수 없는 요청 (" + tokens[0] + " )");
				}
			}

		} catch (SocketException e) {
			doQuit(pw);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void doQuit(Writer writer) {
		removeWriter(writer);
		String data = nick + "님이 퇴장 하였습니다";
		broadcast(data);
	}

	private void removeWriter(Writer writer) {
		synchronized (listWriters) {
			PrintWriter printWriter = (PrintWriter) writer;
			printWriter.println("채팅이 종료되었습니다");
			printWriter.flush();
			listWriters.remove(writer);
		}
	}

	private void doMessage(String message) {
		// TODO Auto-generated method stub
		broadcast(nick+": "+message);
	}

	private void doJoin(String nick, Writer writer) {
		this.nick = nick;

		String data = nick + "님이 참여하였습니다";
		broadcast(data);

		/* writer pool에 저장 */
		addWriter(writer);

		// ack
		((PrintWriter) writer).println("join:ok");
		try {
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}

	}

	private void broadcast(String data) {
		synchronized (listWriters) {
			System.out.println(listWriters.size());
			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
				printWriter.flush();
			}

		}
	}

}
