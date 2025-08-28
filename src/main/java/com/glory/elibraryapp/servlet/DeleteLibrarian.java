package com.glory.elibraryapp.servlet;

import com.glory.elibraryapp.dao.LibrarianDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet.DeleteLibrarian")

public class DeleteLibrarian extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        LibrarianDao.delete(id);
        response.sendRedirect("servlets.ViewLibrarian");
    }
}
