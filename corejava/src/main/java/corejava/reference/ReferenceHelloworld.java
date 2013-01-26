package corejava.reference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * immutable class is which it is no way to change its state after construction.
 * 
 */
public class ReferenceHelloworld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// =============Immutable object:===================================
		String str = new String("a");
		changeString(str);
		System.out.println(str);// result is still "a", String's value is passed
								// to the method instead of reference. String is
								// Immutable

		Integer integer = 1;
		changeInt(integer);
		System.out.println(integer);// result is still "1"

		List list = new ArrayList();
		changeList(list);
		System.out.println(list);// result still empty list

		// =============Mutable object:===================================

		Person p = new Person();
		p.setName("jimmy1");
		changePerson(p);
		System.out.println(p.getName()); // Already change to jimmy2

	}

	// =============Immutable object:===================================

	public static void changeString(String str) {
		System.out.println(str.hashCode());
		str = "b";
	}

	public static void changeInt(Integer integer) {
		System.out.println(integer.hashCode());
		integer = 2;
	}

	public static void changeList(List list) {
		list = null;
	}

	// =============Mutable object:===================================

	public static void changePerson(Person p) {
		p.setName("jimmy2");
	}

}

/**
 * All private fields in Person class should can't be change via outside call.
 * 
 * @author hejiaming
 *
 */
class Person {

	private String name;

	private Date date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This is a bad way to get Date object
	 * 
	 * because Date is mutable object, and outside the Person class, program can
	 * change Date object's state directly and destroy the private encapsulation
	 * of Person.
	 * 
	 */
	/*public Date getDate() {
		return date;
	}*/
	
	/**
	 * Good way to do this: return a defensive copy of Date object, and protect the interal private field
	 * of Date object and always enable encapsulation.
	 * @return
	 */
	public Date getDate() {
		return new Date(date.getTime());
	}
	

	public void setDate(Date date) {
		this.date = date;
	}

}
