package hibernate.domain;

import java.util.HashSet;
import java.util.Set;

public class Person {
	
	private String id;
	
	private int age;
	
	private String firstname;
	
	private String lastname;

	private Set<Event> events = new HashSet<Event>();
	
	private Set<String> emailAddresses = new HashSet<String>();

	
	public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
	public Set<String> getEmailAddresses() {
		return emailAddresses;
	}
	
	public void setEmailAddresses(Set<String> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}
	
}
