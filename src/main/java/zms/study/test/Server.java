package zms.study.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server{
	private static ServerSocket serverSocket;
	private static InetSocketAddress inetSocketAddress;
	@SuppressWarnings("static-access")
	private Server(ServerSocket serverSocket,InetSocketAddress inetSocketAddress){
		this.serverSocket = serverSocket;
		this.inetSocketAddress = inetSocketAddress;
	}
	public static Server getServer(ServerSocket serverSocket,InetSocketAddress inetSocketAddress){
		return new Server(serverSocket,inetSocketAddress);
	}
	
	public static void endServer(){
		if(serverSocket != null){
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void receive(){
		new Thread(()->{
			Socket socket = null;
			InputStream inputStream = null;
			try {
				serverSocket.bind(inetSocketAddress);
				socket = serverSocket.accept();
				while(true){
					inputStream = socket.getInputStream();
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
	public static void send(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Socket socket = null;
				OutputStream outputStream = null;
				Scanner scanner = new Scanner(System.in);
				try {
					serverSocket.bind(inetSocketAddress);
					socket = serverSocket.accept();
					while(true){
						outputStream = socket.getOutputStream();
						outputStream.write(scanner.next().getBytes());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}).start();
	}
}
