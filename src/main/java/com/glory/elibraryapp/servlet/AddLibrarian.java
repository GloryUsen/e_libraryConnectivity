package com.glory.elibraryapp.servlet;


import com.glory.elibraryapp.beans.LibrarianBean;
import com.glory.elibraryapp.dao.LibrarianDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet.DeleteBook")
public class AddLibrarian extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Add Librarian </title> <");
        out.println("<link rel= 'stylesheet' href= 'bootstrap.min.css' />");
        out.println("</head>");
        out.println("<body>");

        request.getRequestDispatcher("gloadmin.html").include(request, response);
        out.println("<div class= 'container'>");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String smobile = request.getParameter("mobile");
        long mobile = Long.parseLong(smobile);

        LibrarianBean beans = new LibrarianBean(name, email, password, mobile);
        LibrarianDao.save(beans);

        out.println("<h4> Librarian added successfully!</h4>");
        request.getRequestDispatcher("addlibrarianform.html").include(request, response);


        out.println("</div>");
        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();


    }
}
