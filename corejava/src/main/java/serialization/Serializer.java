package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializer implements Serializable{
		
	//java.io.InvalidClassException: serialization.Serializer; local class incompatible: 
	//stream classdesc serialVersionUID = 5092091347849277395, local class serialVersionUID = 9131025113238683778
	
	String name;
	
	transient String password;
	
	static String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public static void setSex(String sex) {
		Serializer.sex = sex;
	}
	
	public static String getSex() {
		return sex;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tempFile = "c:/a.txt";

		Serializer object = new Serializer();
		object.setName("jimmy");
		object.setPassword("123");
		object.setSex("male");


		try {
			FileOutputStream fos = new FileOutputStream(tempFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(object);
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Serializer object2 = new Serializer();
		object2.setName("jimmy2");
		object2.setPassword("321");
		object2.setSex("female");
		
		try {
			FileOutputStream fos = new FileOutputStream(tempFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(object2);
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(tempFile);
			ObjectInputStream ois;
			ois = new ObjectInputStream(fis);
			Serializer object11 = (Serializer) ois.readObject();// java.io.WriteAbortedException
															// comes from here.
			ois.close();
			System.out.println("Deserialize object success: " + object11.getName() + ", " + object11.getPassword() + ", " + object11.getSex());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			new File(tempFile).delete();
		}
		
		try {
			fis = new FileInputStream(tempFile);
			ObjectInputStream ois;
			ois = new ObjectInputStream(fis);
			Serializer object12 = (Serializer) ois.readObject();// java.io.WriteAbortedException
															// comes from here.
			ois.close();
			System.out.println("Deserialize object success: " + object12.getName() + ", " + object12.getPassword() + ", " + object12.getSex());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new File(tempFile).delete();
		}
//		
		
		System.out.println("Please change Serializer's source code before deserialize the object to meet the problem.");
	}
	

	

}
