package com.shinhan.day13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("----client가 서버에 요청-----");
		Socket socket = new Socket("192.168.0.100",50001);
		
		System.out.println("클라이언트 서버 연결 성공");
		
		String message = "나는 자바가 좋아";
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(message+"@@@@");
		dos.flush();
		System.out.println("Client sent message to Server");

		DataInputStream dis = new DataInputStream(socket.getInputStream());
		String recievemessage = dis.readUTF();
		System.out.println("받은메시지:"+recievemessage);
		
		
		socket.close();
		System.out.println("서버 연결 종료");
		System.out.println("----client END-----");

		//END
	}

}
