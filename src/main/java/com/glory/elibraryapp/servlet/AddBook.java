package com.glory.elibraryapp.servlet;

import com.glory.elibraryapp.beans.BookBean;
import com.glory.elibraryapp.dao.BookDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AddBook extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Add Book From</title>");
        out.println("<link rel= 'stylesheet' href= 'bootstrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");
        request.getRequestDispatcher("glolibrarian.html").include(request, response);

        out.println("<div class='container'>");
        String callNo = request.getParameter("callNo");
        String name = request.getParameter("name");
        String auth = request.getParameter("author");
        String publish = request.getParameter("publisher");
        String squan = request.getParameter("quantity");
        int quantity = Integer.parseInt(squan);

        BookBean bean = new BookBean(callNo, name, auth, publish,quantity, 1);
        int i = BookDao.save(bean);
        if (i > 0){
            out.println("<h3>Book saved successfully</h3>");
        }

        request.getRequestDispatcher("addbookform.html").include(request, response);
        out.println("</div>");

        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();
    }

}
