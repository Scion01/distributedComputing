import java.rmi.server.UnicastRemoteObject;

//package rmi;

public class serverimp  extends UnicastRemoteObject implements serverintf{
	public  serverimp() throws Exception{
	}
	@Override
	public String upper(String s) throws Exception {
		return s.toUpperCase();
	}
	//if u dont extend UnicastRemoteObject then u wud get a marshalling exception.
	//remember, extend first and implement then without comma
	//the func implementation has a throw Exception
}
