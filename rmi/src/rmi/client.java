//package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class client {
		public static void main(String [] args) throws Exception {
			String serverurl = "rmi://"+args[0]+"/Server";
			serverintf serverintf  = (serverintf) Naming.lookup(serverurl);
			String name = "nishant";
			System.out.println("Server Output: "+serverintf.upper(name));
			//to run compile all
			//rmic intf
			//rmiregistry
			//java server
			//java client localhost
		}
}
