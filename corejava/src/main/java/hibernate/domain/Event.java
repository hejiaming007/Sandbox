package hibernate.domain;

import java.sql.Timestamp;

public class Event {

	private String id;

	private String title;

	private Timestamp date;

	public Event() {
	}

	public String getId() {
		return id;
	}

	/**
	 * Id is maintain by hibernate internal, so use private modifier
	 * 
	 * @param id
	 */
	private void setId(String id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:" + id + " title:"+ title + " date:" + date;
	}

}