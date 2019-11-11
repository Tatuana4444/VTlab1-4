package com.epam.shop.dao;

import com.epam.shop.entity.User;
import com.epam.shop.singelton.SingletonOnlineShop;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This class realize UserDAO
 */
public class UserDao {
    /**
     * List of users
     */
    private List<User> users = SingletonOnlineShop.getInstance().getUser();

    /**
     * Setter for user
     * @param user user which need to add
     */
    public void addUser(User user) {
        this.users.add(user);
    }



    /**
     * Check This method check available user
     * @param login    user's login
     * @param password user's password
     * @return list of product which have such login and password
     */
    public Optional<User> isAvailable(String login, String password) {
        return users.stream()
                .filter(u -> password.equals(u.getPassword())
                        && login.equals(u.getLogin()))
                .findFirst();
    }

    /**
     * Find user by id
     * @param userId user id
     * @return user with such id or null
     */
    public Optional<User> isAvailable(int userId) {
        return users.stream()
                .filter(u -> userId ==u.getId())
                .findFirst();
    }

    /**
     * Edit user name
     * @param userId user id
     * @param newUserName new user name
     * @return true if edit was success, otherwise false
     */
    public boolean changeUserName(int userId, String newUserName) {
        return users.stream()
                .filter(p->{
                    if (p.getId()==userId){
                        p.setName(newUserName);
                        return true;
                    }
                    return false;
                })
                .count()==1;
    }

    /**
     * Edit user login
     * @param userId user if
     * @param newUserLogin new login
     * @return true if edit was success, otherwise false
     */
    public boolean changeUserLogin(int userId, String newUserLogin) {
        return users.stream()
                .filter(p->{
                    if (p.getId()==userId){
                        p.setLogin(newUserLogin);
                        return true;
                    }
                    return false;
                })
                .count()==1;
    }

    /**
     * Edit user password
     * @param userId user id
     * @param newUserPassword new password
     * @return true if edit was success, otherwise false
     */
    public boolean changeUserPassword(int userId, String newUserPassword) {
        return users.stream()
                .filter(p->{
                    if (p.getId()==userId){
                        p.setPassword(newUserPassword);
                        return true;
                    }
                    return false;
                })
                .count()==1;
    }

    /**
     * Find clients
     * @return list of clients
     */
    public List<User> getClients() {
        return users.stream()
                .filter(u -> u.getRole().equals("client"))
                .collect(Collectors.toList());
    }

    /**
     * Set user as null
     * @param user user that needs to set null
     */
    public void SetAsNull(User user) {
        this.users.remove(user);
    }
}
