package com;
import javax.ejb.Remote;

@Remote
public interface HelloWorld2Remote {

	public String sayHello();
	
}
