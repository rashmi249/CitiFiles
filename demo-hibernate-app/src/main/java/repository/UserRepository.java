package repository;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.User;
import service.UserNotFoundException;
import utils.HibernateUtil;

public class UserRepository {

	private static final SessionFactory sessionfactory =HibernateUtil.getSessionFactory();
	
	public void saveUser(User user) {
		
		//obtain the session object and then persists entity object
		Session session =sessionfactory.openSession();
		session.beginTransaction();
		
		//persist the users object
		session.save(user);
		
		session.getTransaction().commit();
	}
	
	public User findByUserId(long id) throws UserNotFoundException {
		Session session =sessionfactory.openSession();
		 session.beginTransaction();
		User user = session.get(User.class, id);
		  if (user == null) {
	            throw new UserNotFoundException("User Not Found");
	        }
		 session.getTransaction().commit();
		return user;
	}
	
	public void updateUser(User user) throws UserNotFoundException {
		Session session= sessionfactory.openSession();
		session.beginTransaction();
		session.update(user);
	 session.getTransaction().commit();
	}
	
	public void updateUserwithGet(long id) {
		Session session =sessionfactory.openSession();
		session.beginTransaction();
		User returnedEnity = session.get(User.class, id);
	}


	public void deleteUser(long id) throws UserNotFoundException {
		Session session =sessionfactory.openSession();
		session.beginTransaction();
		User user = session.get(User.class, id);
		 if (user != null) {
	            session.delete(user);
	        } else {
	            throw new UserNotFoundException("USER NOT AVAILABLE");
	        }
	        session.getTransaction().commit();
	}
	
	
	public void loadEntity(long id) {
        Session session = sessionfactory.openSession();
      //    session.beginTransaction();
          //Load
          User user =session.load(User.class, 1L);
         try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
          System.out.println("User ID= "+user.getId());
          System.out.println("User Name= "+user.getFirstName());
       //   session.getTransaction().commit();           
    }
	
	public void fetchLimitedResult() { 
		 
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Users");
		query.setFirstResult(5);
		query.setMaxResults(10);
		List<User> list = query.getResultList();
		for(User user: list) {            
		   System.out.println(user);
		   }
		}
	
//	public List<User> findAllUsers() {
    //    List<User> usersList;
     //   Session session = sessionfactory.openSession();
     //   session.beginTransaction();
   //     Query query = session.createQuery("from Users");
  //      usersList = query.list();
     //   session.getTransaction().commit();
  //      return usersList;
   // }
	
	//Criteriaaaaaaaaaaa
	
	public List<User> getUserListUsingCriteria() {
        Session session = sessionfactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);
        Root<User> root = cr.from(User.class);
        cr.select(root);
        Query query = session.createQuery(cr);
        return query.getResultList();

 

    }
	
	public List<User> criratiaQueryByName() {
	    System.out.println("get user by name like.....");
	    Session   session =sessionfactory.openSession();
	    CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<User> cr = cb.createQuery(User.class);
	    Root<User> root = cr.from(User.class);
	//    cr.select(root).where(cb.like(root.get("firstName"), "%sa%"));
	//    query.select(root).where(builder.like(root.get("name"), keyword + "%"));
cr.orderBy(cb.asc(root.get("firstName")));
	 

	    Query query = session.createQuery(cr);
	    List<User> results = query.getResultList();
	   return results;
	}

}
