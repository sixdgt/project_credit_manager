package dao;

import controller.AdminController;

public interface AdminDAO {
    /**
     * @param ac
     * abstract method to handle login functionality for Admin User
     * @return 
     */
    public abstract boolean login(AdminController ac);
}
