package com.epam.shop.session;

/**
 * Implements session
 */
public class Session {
    /**
     * Current user id
     */
    private  static int currUserId;

    /**
     * Getter for current user id
     * @return current user id
     */
    public static int getCurrUserId() {
        return currUserId;
    }

    /**
     * Setter current user id
     * @param currUserId current user id
     */
    public static void setCurrUserId(int currUserId) {
        Session.currUserId = currUserId;
    }
}
