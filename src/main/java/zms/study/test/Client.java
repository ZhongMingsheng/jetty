package zms.study.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client{
	private static Socket clientSocket;

	private Client(Socket socket){
		clientSocket = socket;
	}
	
	public static Client getClient(Socket socket){
		return new Client(socket);
	}
	
	public static void endClient(){
		if(clientSocket != null){
			try {
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void receive(){
		new Thread(()->{
			InputStream inputStream = null;
			try {
				while(true){
					inputStream = clientSocket.getInputStream();
					byte[] b = new byte[1024];
					int len = 0;
					while((len = inputStream.read(b))!= -1){
						System.out.print(new String (b,0,len));
					}
					System.out.println();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}
	@SuppressWarnings("resource")
	public static void send(){
		new Thread(()->{
			OutputStream outputStream = null;
			Scanner scanner = new Scanner(System.in);
			try {
				outputStream = clientSocket.getOutputStream();
				outputStream.write(scanner.next().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
