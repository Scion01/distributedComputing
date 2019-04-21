//package rmi;
import java.rmi.*;
public interface serverintf extends Remote{
	String upper(String s) throws Exception;
	//remember the extends remote and exception
}
