package com.glory.elibraryapp.servlet;

import com.glory.elibraryapp.beans.BookBean;
import com.glory.elibraryapp.dao.BookDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/servlet.DeleteBook")

public class DeleteBook extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        BookDao.delete(request.getParameter("callNo"));
        response.sendRedirect("servlet.ViewBook");
    }
}
