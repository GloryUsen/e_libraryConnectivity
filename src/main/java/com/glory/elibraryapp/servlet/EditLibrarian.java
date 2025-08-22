package com.glory.elibraryapp.servlet;

import com.glory.elibraryapp.beans.LibrarianBean;
import com.glory.elibraryapp.dao.LibrarianDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EditLibrarian extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String smobile = request.getParameter("mobile");
        long mobile = Long.parseLong(smobile);

        LibrarianBean bean = new LibrarianBean(id, name, email, password, mobile);
        LibrarianDao.update(bean);
        response.sendRedirect("servlets.ViewLibrarian");

    }
}
