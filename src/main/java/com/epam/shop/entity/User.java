

package com.epam.shop.entity;

import java.util.Objects;

public class User extends Entity{

    protected String name;
    protected String login;
    protected String password;
    protected String role;


    /**
     * Getter for user name
     * @return user name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for user name
     * @param value user name
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Getter for user login
     * @return user login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Setter for user login
     * @param value user login
     */
    public void setLogin(String value) {
        this.login = value;
    }

    /**
     * Getter for user password
     * @return user password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for user password
     * @param value user password
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Getter for product password
     * @return product password
     */
    public String getRole() {
        return role;
    }

    /**
     * Setter for product role
     * @param value new role
     */
    public void setRole(String value) {
        this.role = value;
    }
    /**
     * Compare object with this user
     * @param o object with which it will be compare
     * @return it will return true if objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(role, user.role);
    }
    /**
     * Do hash code
     * @return hash code of user
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, login, password, role);
    }
}
