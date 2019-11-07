package com.epam.shop.service;

import com.epam.shop.dao.UserDao;
import com.epam.shop.entity.User;

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

    public void changeUserName(int currUserId, String newUserName) {
        UserDao dao = new UserDao();
        dao.changeUserName(currUserId, newUserName);
    }

    public void changeUserLogin(int currUserId, String newUserLogin) {
        UserDao dao = new UserDao();
        dao.changeUserLogin(currUserId, newUserLogin);
    }

    public void changeUserPassword(int currUserId, String newUserPassword) {
        UserDao dao = new UserDao();
        dao.changeUserPassword(currUserId, newUserPassword);
    }
}
