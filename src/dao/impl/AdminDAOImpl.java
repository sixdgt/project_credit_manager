package dao.impl;

import controller.AdminController;
import dao.AdminDAO;
import dbconfig.DbConnection;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.AdminModel;

public class AdminDAOImpl implements AdminDAO {

    DbConnection connect = null;

    public AdminDAOImpl() {
        this.connect = DbConnection.getConnection();
    }

    @Override
    public boolean login(AdminController ac) {
        boolean status = false;
        AdminModel am = new AdminModel();
        try {
            String sql = "SELECT * FROM admin WHERE admin_username='" + ac.username + "'";
            ResultSet rs = this.connect.selectQueryBuilder(sql);
            while (rs.next()) {
                // here `admin_username` is a column name of table admin
                am.setAdminUsername(rs.getString("admin_username"));
                am.setAdminId(rs.getInt("admin_id"));
                am.setAdminPassword(rs.getString("admin_password"));
            }
            if (am.getAdminUsername() == null || am.getAdminPassword() == null) {
                status = false;
            } else {
                if (am.getAdminUsername().equals(ac.username)
                        && am.getAdminPassword().equals(ac.password)) {
                    status = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return status;
    }

}
