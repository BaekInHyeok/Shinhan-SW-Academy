package com.shinhan.day13;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {

	private static ServerSocket serverSocket = null;

	public static void main(String[] args) {
		System.out.println("----------------------------");
		System.out.println("서버시작, 종료는 q 입력 후 엔터");
		System.out.println("----------------------------");

		startServer();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			String key = scanner.nextLine();
			if (key.toLowerCase().equals("q")) {
				break;
			}
		}
		scanner.close();

		stopServer();
	}

	public static void startServer() {
		// TODO Auto-generated method stub
		Thread thread = new Thread() {
			public void run() {
				try {
					serverSocket = new ServerSocket(50001);
					System.out.println("서버 시작됨");

					while (true) {
						System.out.println("\n서버 연결 요청을 기다림\n");
						Socket socket = serverSocket.accept();

						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("서버-" + isa.getHostName() + " 연결요청 수락");

						// 네트워크에서 들어온 문자를 읽기
						DataInputStream dis = new DataInputStream(socket.getInputStream());
						String message = dis.readUTF();
						System.out.println("받은메시지:" + message);

						// 네트워크에 들어온 문자를 보내기
						DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
						dos.writeUTF(message + "@@@@");
						dos.flush();

						socket.close();
						System.out.println("서버-" + isa.getHostName() + " 연결 종료");
					}
				} catch (IOException e) {
					System.out.println("[서버]" + e.getMessage());
				}
			}
		};
		thread.start();
	}

	public static void stopServer() {
		try {
			serverSocket.close();
			System.out.println("서버 종료됨");
		} catch (IOException e) {
		}
	}
}
