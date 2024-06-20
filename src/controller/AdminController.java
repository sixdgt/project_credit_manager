package controller;
import dao.impl.AdminDAOImpl;
import dao.AdminDAO;

public class AdminController {
    // controller attributes
    public String username;
    public String password;
    
    public boolean doLogin(AdminController ac){
        boolean status = false;
        AdminDAO ad = new AdminDAOImpl();
        if(ad.login(ac)){
            status = true;
        }
        return status;
    }
}
