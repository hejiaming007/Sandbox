package com;

import java.util.Properties;

import javax.naming.InitialContext;

public class EjbClient {

	/**
	 * Start up glass fish server, install the ejb jar to the server.
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:3700");
		
		props.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
		props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
		props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

		props.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");

		InitialContext ctx = new InitialContext(props);
		HelloWorld2Remote helloworld = (HelloWorld2Remote) ctx.lookup("java:global/ejbHelloWorld/myBean1");
		System.out.println(helloworld.sayHello());
		
		
	}
}
