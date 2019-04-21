//package tcp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
	public static void main(String [] args) throws Exception{
		String inputSentence;
		String outputSentence;
		ServerSocket serverSocket = new ServerSocket(5002);
		while(true) {
			System.out.println("Waiting for a client ..."); 
			Socket connection = serverSocket.accept();
			System.out.println("Client accepted"); 
			Scanner sc = new Scanner(new InputStreamReader(connection.getInputStream()));
			DataOutputStream outfromserver = new DataOutputStream(connection.getOutputStream());
			String temp = sc.nextLine();
			System.out.println("String received: "+temp);
			temp = temp.toUpperCase();
			outfromserver.writeUTF(temp);
		}
	}
}
