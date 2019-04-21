package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
	public static void main(String [] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		DatagramSocket socket = new DatagramSocket();
		byte [] senddata = input.getBytes();
		InetAddress ip = InetAddress.getByName("localhost");
		DatagramPacket packet = new DatagramPacket(senddata, senddata.length, ip, 10001);
		socket.send(packet);
		byte [] recdata = new byte[1024];
		DatagramPacket rpacket = new DatagramPacket(recdata, recdata.length);
		socket.receive(rpacket);
		String out = new String(rpacket.getData());
		System.out.printf("The output string is: %s\n",out);
	}
}
