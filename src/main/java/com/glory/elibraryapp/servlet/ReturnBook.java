package com.glory.elibraryapp.servlet;

import com.glory.elibraryapp.dao.BookDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlets.ReturnBook")

public class ReturnBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.sendRedirect("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> Return Book </title>");
        out.println("<link rel= 'stylesheet' href= 'boostrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");
        request.getRequestDispatcher("glolibrarian.html").include(request, response);

        out.println("<div class=' container'>");
        String callNo = request.getParameter("callNo");
        String sstudentId= request.getParameter("studentid");
        int studentid = Integer.parseInt(sstudentId);


        int i = BookDao.returnBook(callNo, studentid);
        if (i > 0){
            out.println("<h3> Book return successfully </h3>");

        } else {
            out.println("<h3> Sorry, unable to return book </h3><p> We may have shortage of books. Kindly visit later.</p>");
        }
        out.println("</div>");


        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();
    }
}
