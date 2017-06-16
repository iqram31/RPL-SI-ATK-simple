/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ish.daoimpl;

import id.co.ish.dao.AdminDAO;
import id.co.ish.entity.Admin;
import id.co.ish.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iqram
 */
public class AdminDAOImpl implements AdminDAO {
    private final Connection conn;
    
    public AdminDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }
    
    @Override
    public Admin login(String username, String password) {
           Admin admin = null;
           PreparedStatement state = null;
           String SELECT = "SELECT * FROM admin WHERE "
                + "username = ? AND password = ?";
            
        try {
            state = conn.prepareStatement(SELECT);
            state.setString(1, username);
            state.setString(2, password);
            ResultSet result = state.executeQuery();
            if (result != null && result.next()) {
                admin = new Admin();
                admin.setUsername(result.getString(1));
                admin.setPassword(result.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admin;
    }
    
}
