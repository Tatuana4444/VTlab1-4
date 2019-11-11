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

    /**
     * Check user available
     * @param UserId user id
     * @return true if there is user with such id, otherwise false
     */
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

    /**
     * Get information about user
     * @param currUserId user id
     * @return information about user
     */
    public String getUser(int currUserId) {
        UserDao dao = new UserDao();
        Optional<User> user= dao.isAvailable(currUserId);
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

    /**
     * Edit user name
     * @param userId user id
     * @param newUserName new user name
     */
    public void changeUserName(int userId, String newUserName) {
        UserDao dao = new UserDao();
        dao.changeUserName(userId, newUserName);
    }

    /**
     * Edit user login
     * @param userId user id
     * @param newUserLogin new user login
     */
    public void changeUserLogin(int userId, String newUserLogin) {
        UserDao dao = new UserDao();
        dao.changeUserLogin(userId, newUserLogin);
    }

    /**
     * Edit user password
     * @param userId user if
     * @param newUserPassword new user password
     */
    public void changeUserPassword(int userId, String newUserPassword) {
        UserDao dao = new UserDao();
        dao.changeUserPassword(userId, newUserPassword);
    }

    /**
     * Get information about clients
     * @return information about clients
     */
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

    /**
     * Set user with such id as null
     * @param userId user id
     */
    public void setUserAsNull(int userId) {
        UserDao userDao = new UserDao();
        Optional<User> user= userDao.isAvailable(userId);
        if (!user.isPresent())
            return;
        userDao.SetAsNull(user.get());

    }


}
