package hibernate;

import hibernate.domain.Event;
import hibernate.domain.Person;

import java.sql.SQLException;
import java.util.List;

import org.h2.tools.Server;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class HibernateHelloworld {
	
	static SessionFactory factory = HibernateUtil.getSessionFactory();
	
	public static void main(String[] args) throws SQLException {
		
		
		Server server = Server.createWebServer();
		server.start();
		
		
		//Add event
		Event event = new Event();
        event.setTitle("title");
//        event.setDate(new Date());
        String eventid = addEvent(event);
        
       /* //Add person
		Person person = new Person();
		person.setAge(18);
		person.setFirstname("Jimmy");
		person.setLastname("He");
        String personId = addPerson(person);
        
        
        //Get all events
        List<Event> result = getEventsByTitle("title");
        String eventId = "";
        for (Event tempEvent : result) {
        	eventId = tempEvent.getId();
        	System.out.println(tempEvent.toString());
		}*/
        
        //Get Event by id
//        event = getEventById(eventid);
//        System.out.println(event.toString());
        
        event.setTitle("Updated...");
        
        addUpdateEvent(event);
        /*
        
        //associate person to event
        addPersonToEvent(personId, eventid);
        */
        
        
        
        System.out.println("End here for debug... check record in H2 console...");
        
    }
	
	
	public static String addEvent(Event event){
		//Between a session.beginTransaction() and session.getTransaction().commit(), it's consider a unit of work
		Session session = factory.getCurrentSession();
		session.beginTransaction();

        //Save a domain
        session.save(event);
        session.saveOrUpdate(event);
        session.getTransaction().commit();//both commit or rollback will close session in background.
        return event.getId();
	}
	
	
	public static String addPerson(Person person){
		//Between a session.beginTransaction() and session.getTransaction().commit(), it's consider a unit of work
		Session session = factory.getCurrentSession();
		session.beginTransaction();

        //Save a domain
        session.save(person);
        session.getTransaction().commit();//both commit or rollback will close session in background.
        return person.getId();
	}
	
	
	public static void addUpdateEvent(Event event){
		//Between a session.beginTransaction() and session.getTransaction().commit(), it's consider a unit of work
		Session session = factory.getCurrentSession();
		session.beginTransaction();

        //Save a domain
        session.saveOrUpdate(event);
        session.getTransaction().commit();//both commit or rollback will close session in background.
	}
	
	
	
	
	public static Event getEventById(String eventId){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		return (Event)session.load(Event.class, eventId);
	}
	
	
	
	
	public static List<Event> getEventsByTitle(String title){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession(); //After previous session is commit, this is another session.
		session.beginTransaction();//query also need transaction
		return session.createQuery("from Event as e where e.title = :title").setParameter("title", title).list();
	}
	
	public static void addPersonToEvent(String personId, String eventId){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Person person = (Person)session.load(Person.class, personId);
		Event event = (Event)session.load(Event.class, personId);
		
		person.getEvents().add(event);
		session.getTransaction().commit();
	}
	
	

}
