//package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class server {
	public static void main (String [] args) throws RemoteException, MalformedURLException {
		try {
		serverimp serverimp = new serverimp();
		Naming.rebind("Server", serverimp);
		}catch(Exception e) {
			
		}
		//the above exceptions can just be Exception
	}
}
