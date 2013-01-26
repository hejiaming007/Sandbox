package com;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloWorld2
 */
@Stateless(name="myBean1") //ejb name, If not specify this ejb name, default use this class's name as ejb name
@Remote(HelloWorld2Remote.class)
@Local(HelloWorld2Remote.class) //implement local and remote interface, for can both remote and local call
public class HelloWorld2 implements HelloWorld2Remote {

    /**
     * Default constructor. 
     */
    public HelloWorld2() {
        // TODO Auto-generated constructor stub
    }
    
    public String sayHello(){
    	return "hello";
    }

}
