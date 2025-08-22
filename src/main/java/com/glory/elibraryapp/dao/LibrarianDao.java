package com.glory.elibraryapp.dao;

import com.glory.elibraryapp.beans.LibrarianBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibrarianDao {
    public static int save(LibrarianBean beans){
        int status = 0;
        try {
            Connection con = Provider.getPostgresConnection();
            PreparedStatement states = con.prepareStatement("insert into e librarian (id, name, email, password, mobile) values (?,?,?,?,?)");
            states.setString(1, "1");
            states.setString(2, beans.getName());
            states.setString(3, beans.getEmail());
            states.setString(4, beans.getPassword());
            states.setLong(5, beans.getMobile());

            status = states.executeUpdate();
            con.close();


        } catch (Exception saving) {
            System.out.println(saving);

        }

        return status;
    }

    public static int update(LibrarianBean beans){
        int status = 0;
        try {
            Connection connection = Provider.getPostgresConnection();
            PreparedStatement stare = connection.prepareStatement("update e librarian set name=?,email=?,password=?,mobile=?, where id=?");
            stare.setString(1, beans.getName());
            stare.setString(2, beans.getEmail());
            stare.setString(3, beans.getPassword());
            stare.setLong(4, beans.getMobile());
            stare.setInt(5, beans.getId());
            status = stare.executeUpdate();
            connection.close();


        } catch (Exception updating) {
            System.out.println(updating);

        }

        return status;
    }

    public static List<LibrarianBean> view(){
        List<LibrarianBean> list = new ArrayList<>();
        try {

            Connection con = Provider.getPostgresConnection();
            PreparedStatement states = con.prepareStatement("select * from e_librarian");
            ResultSet setting = states.executeQuery();

            while (setting.next()){
                LibrarianBean bean = new LibrarianBean();
                bean.setId(setting.getInt("id"));
                bean.setEmail(setting.getString("email"));
                bean.setMobile(setting.getLong("mobile"));
                bean.setPassword(setting.getString("password"));
                bean.setName(setting.getString("name"));
                list.add(bean);
            }

            con.close();

        } catch (Exception viewing) {
            System.out.println(viewing);

        }
        return list;
    }

    public static LibrarianBean viewById(int id){
        LibrarianBean bean = new LibrarianBean();
        try {
            Connection connecting = Provider.getPostgresConnection();
            PreparedStatement preparing = connecting.prepareStatement("select * from e_librarian where id=?");
            preparing.setInt(1, id);

            ResultSet resting = preparing.executeQuery();
            if (resting.next()){
                bean.setId(resting.getInt(1));
                bean.setName(resting.getString(2));
                bean.setEmail(resting.getString(3));
                bean.setMobile(resting.getLong(4));
                bean.setPassword(resting.getString("password"));
            }

            connecting.close();
        } catch (Exception viewingId) {
            System.out.println(viewingId);

        }
        return bean;
    }

    public static int delete(int id){
        int status = 0;
        try {
            Connection connections = Provider.getPostgresConnection();
            PreparedStatement pap = connections.prepareStatement("delete from e_librarian where id=?");
            pap.setInt(1, id);
            status = pap.executeUpdate();
            connections.close();
        } catch (Exception delete) {
            System.out.println(delete);

        }

        return status;
    }

    public static boolean authenticate(String email, String password ){
        boolean status = false;
        try {
            Connection convic = Provider.getPostgresConnection();
            PreparedStatement stap = convic.prepareStatement("select * from e_librarian where email=? and password=?");
            stap.setString(1, email);
            stap.setString(2, password);
            ResultSet set = stap.executeQuery();
            if (set.next()){
                status = true;

            }
            convic.close();

        } catch (Exception auth) {
            System.out.println(auth);

        }

        return status;
    }
}

