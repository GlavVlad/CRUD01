package glavvlad.crud01.dao;

import glavvlad.crud01.model.User;
import glavvlad.crud01.services.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<User> findAllUsers() {
        return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }
    
    public List<User> userForOnePage(int page) {
        int itemsOnPage = UserService.itemOnPage;
        String query = "select * from user limit " + itemsOnPage + " offset " + (page-1)*itemsOnPage;
        return (List<User>) sessionFactory.getCurrentSession().createSQLQuery(query).addEntity(User.class).list();
    }

    public User getUser(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void deleteUser(int id) {
        sessionFactory.getCurrentSession().delete(getUser(id));
    }

    public List<User> searchUsers(String name) {
        String query = "select * from user where name like '%"+name+"%'";
        return sessionFactory.getCurrentSession().createSQLQuery(query).addEntity(User.class).list();
    }
}
