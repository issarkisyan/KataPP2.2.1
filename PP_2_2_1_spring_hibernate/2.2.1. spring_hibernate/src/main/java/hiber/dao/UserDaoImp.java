package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public void add(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }
   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
/*
   public Car getByModelAndSeries(String model, int series) {
      //Query hql = sessionFactory.getCurrentSession().createQuery("from User u where u.model=:model and u.series=:series");
      //Query hql = sessionFactory.getCurrentSession().createQuery("select User from Car where User.Car.model=:model and User.Car.series=:series");
      Query hql = sessionFactory.getCurrentSession().createQuery("select u from Car u where u.model=:model and u.series=:series");
      hql.setParameter("model", model);
      hql.setParameter("series", series);
      return (Car) hql.getSingleResult();
   }

 */
   public User getByModelAndSeries(String model, int series) {
      Query hql = sessionFactory.getCurrentSession().createQuery("select u from User u inner join u.car c where c.model=:model and c.series=:series", User.class);
      hql.setParameter("model", model);
      hql.setParameter("series", series);
      return (User) hql.getSingleResult();
   }
}
