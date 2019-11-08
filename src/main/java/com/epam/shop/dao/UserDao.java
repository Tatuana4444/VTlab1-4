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
    private List<User> users = SingletonOnlineShop.getInstance().getUser();

    /**
     * Setter for user
     *
     * @param user user which need to add
     */
    public void addUser(User user) {
        this.users.add(user);
    }



    /**
     * Check This method check available user
     *
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
    public Optional<User> isAvailable(int userId) {
        return users.stream()
                .filter(u -> userId ==u.getId())
                .findFirst();
    }

    public Optional<User> getUser(int currUserId) {
        return users.stream()
                .filter(u -> currUserId ==u.getId())
                .findFirst();
    }

    public boolean changeUserName(int userId, String newUserName) {
        return users.stream()
                .map(p->{
                    if (p.getId()==userId){
                        p.setName(newUserName);
                        return true;
                    }
                    return false;
                })
                .count()==1;
    }

    public boolean changeUserLogin(int userId, String newUserLogin) {
        return users.stream()
                .map(p->{
                    if (p.getId()==userId){
                        p.setLogin(newUserLogin);
                        return true;
                    }
                    return false;
                })
                .count()==1;
    }

    public boolean changeUserPassword(int userId, String newUserPassword) {
        return users.stream()
                .map(p->{
                    if (p.getId()==userId){
                        p.setPassword(newUserPassword);
                        return true;
                    }
                    return false;
                })
                .count()==1;
    }


    public List<User> getClients() {
        return users.stream()
                .filter(u -> u.getRole().equals("client"))
                .collect(Collectors.toList());
    }

    public void SetAsNull(User user) {
        this.users.remove(user);
    }
}
