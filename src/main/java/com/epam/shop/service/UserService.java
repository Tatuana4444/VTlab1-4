package com.epam.shop.service;

import com.epam.shop.dao.UserDao;
import com.epam.shop.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * This class implements user functions
 */
public class UserService {


    /**
     * This method get user from DAO
     * @param login user's login
     * @param password user's password
     * @return list of users that has such login and password
     */
    public Optional<User> login(String login, String password) {
        UserDao dao = new UserDao();
        return dao.isAvailable(login,password);
    }
    public boolean isAvailable(int UserId) {
        UserDao dao = new UserDao();
        Optional<User> user = dao.isAvailable(UserId);
        return user.isPresent();
    }
    /**
     * This method register user in DAO
     * @param user user which needed to register
     */
    public void register(User user) {
        UserDao dao = new UserDao();
        dao.addUser(user);
    }

    public String getUser(int currUserId) {
        UserDao dao = new UserDao();
        Optional<User> user= dao.getUser(currUserId);
        if (!user.isPresent())
            return "";
        User u = user.get();
        StringBuilder data = new StringBuilder();
        String line = "----------------------------------------------------------------------\n";
        data.append(line);
        data.append(String.format("%5s %15s %15s %15s %15s %n", "id", "name", "login", "password", "role"));
            data.append(String.format("%5s %15s %15s %15s %15s %n",
                    u.getId(), u.getName(), u.getLogin(), u.getPassword(),u.getRole()));
        data.append(line);
        return data.toString();
    }

    public void changeUserName(int userId, String newUserName) {
        UserDao dao = new UserDao();
        dao.changeUserName(userId, newUserName);
    }

    public void changeUserLogin(int userId, String newUserLogin) {
        UserDao dao = new UserDao();
        dao.changeUserLogin(userId, newUserLogin);
    }

    public void changeUserPassword(int userId, String newUserPassword) {
        UserDao dao = new UserDao();
        dao.changeUserPassword(userId, newUserPassword);
    }

    public String getClients() {
        UserDao productDao = new UserDao();
        List<User> userList = productDao.getClients();
        StringBuilder data = new StringBuilder();
        String line = "----------------------------------------------------------------------\n";
        data.append(line);
        data.append(String.format("%5s %15s %15s %15s %15s %n", "id", "name", "login", "password", "role"));
        data.append(line);
        for (User u : userList) {
            data.append(String.format("%5s %15s %15s %15s %15s %n",
                    u.getId(), u.getName(), u.getLogin(), u.getPassword(),u.getRole()));
        }
        data.append(line);
        return data.toString();
    }

    public void setUserAsNull(int userId) {
        UserDao userDao = new UserDao();
        Optional<User> user= userDao.getUser(userId);
        if (!user.isPresent())
            return;
        userDao.SetAsNull(user.get());

    }


}
