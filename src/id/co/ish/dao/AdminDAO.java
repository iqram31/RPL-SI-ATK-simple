/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.ish.dao;

import id.co.ish.entity.Admin;

/**
 *
 * @author Iqram
 */
public interface AdminDAO {
    Admin login (String username, String password);
}
