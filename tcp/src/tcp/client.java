//package tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client  {
		
		public static void main(String [] args) throws Exception{
			String inputSentence;
			String outputSentence;
			Socket clientSocket = new Socket("localhost",5002);
			Scanner sc = new Scanner(System.in);
			inputSentence = sc.nextLine();
			inputSentence+='\n';
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
			outToServer.writeBytes(inputSentence);
			outputSentence = inFromServer.readUTF();
			System.out.println("Modified Sentence: "+outputSentence+"\n");
			outToServer.flush();
			outToServer.close();
			clientSocket.close();
		}
}
