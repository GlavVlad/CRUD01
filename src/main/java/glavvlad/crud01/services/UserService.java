package glavvlad.crud01.services;


import glavvlad.crud01.dao.UserDao;
import glavvlad.crud01.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserService {
    public static final int itemOnPage = 20;

    @Autowired
    private UserDao dao;

    public List<User> userForOnePage(int page) {
        return dao.userForOnePage(page);
    }

    public int numberOfPages() {
        int x = dao.findAllUsers().size();
        return x % itemOnPage == 0 ? x / itemOnPage : x / itemOnPage + 1;
    }

    public User getUser(int id) {
        return dao.getUser(id);
    }

    public void updateUser(User user) {
        dao.updateUser(user);
    }

    public void addUser(User user) {
        dao.addUser(user);
    }

    public void deleteUser(int id) {
        dao.deleteUser(id);
    }

    public List<User> searchUser(String name) {
        return dao.searchUsers(name);
    }
}
