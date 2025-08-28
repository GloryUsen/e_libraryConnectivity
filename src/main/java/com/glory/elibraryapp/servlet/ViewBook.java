package com.glory.elibraryapp.servlet;

import com.glory.elibraryapp.beans.BookBean;
import com.glory.elibraryapp.dao.BookDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/servlet.ViewBook")

public class ViewBook extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> View Book </title>");
        out.println("<link rel= 'stylesheet' href= ' boostrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");
        request.getRequestDispatcher("glolibrarian.html").include(request, response);

        out.println("<div class= ' container'>");
        List<BookBean> list = BookDao.view();

        out.println("<table class= 'table table-bordered table striped'>");
        out.println("<tr><th>Callno</th><th>Name</th><th>Author</th><th>Publisher</th><th>Quantity</th><th>Issued</th><th>Delete</th></tr>");
        for(BookBean bean:list){
            out.println("<tr><td>"+bean.getCallNo()+"</td><td>"+bean.getName()+"</td><td>"+bean.getAuthor()+"</td><td>"+bean.getPublish()+"</td><td>"+bean.getQuantity()+"</td><td>"+bean.getIssued()+"</td><td><a href='DeleteBook?callno="+bean.getCallNo()+"'>Delete</a></td></tr>");
        }
        out.println("</table>");

        out.println("</div>");


        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();

    }
}
