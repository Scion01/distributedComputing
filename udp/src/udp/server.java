package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class server {
	public static void main(String [] args) throws Exception{
		DatagramSocket serversock = new DatagramSocket(10001);
		byte [] rec = new byte[1024];
		byte [] send = new byte[1024];
		while(true) {
			DatagramPacket packet = new DatagramPacket(rec, rec.length);
			serversock.receive(packet);
			String clientinput = new String(packet.getData());
			InetAddress ip = packet.getAddress();
			System.out.printf("String recieved is: %s\n",clientinput);
			DatagramPacket sendpacket =new  DatagramPacket(clientinput.toUpperCase().getBytes(), clientinput.length(), ip, packet.getPort());
			serversock.send(sendpacket);
		}
	}
}
