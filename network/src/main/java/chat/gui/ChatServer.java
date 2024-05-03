package chat.gui;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 7999;
	public static List<Writer> listWriters= new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0",PORT),10);
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket,listWriters).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void log(String message) {
		System.out.println("[Server] : "+message);
	}

}
