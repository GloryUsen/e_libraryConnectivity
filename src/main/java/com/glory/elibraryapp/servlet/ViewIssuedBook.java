package com.glory.elibraryapp.servlet;

import com.glory.elibraryapp.beans.IssueBookBean;
import com.glory.elibraryapp.dao.BookDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/servlet.ViewIssuedBook")

public class ViewIssuedBook extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> View Issued Book </title>");
        out.println("link rel= 'stylesheet' href= 'boostrap.min.css'/>");
        out.println("</head>");
        out.println("<body>");
        request.getRequestDispatcher("glolibrarian.html").include(request, response);

        out.println("<div class= 'container'");

        List<IssueBookBean> list = BookDao.viewIssuedBook();

        out.println("<table class='table table-bordered table-striped'>");
        out.println("<tr><th>Callno</th><th>Student Id</th><th>Student Name</th><th>Student Mobile</th><th>Issued Date</th><th>Return Status</th></tr>");
        for(IssueBookBean bean:list){
            out.println("<tr><td>"+bean.getCallNo()+"</td><td>"+bean.getStudentId()+"</td><td>"+bean.getStudentName()+"</td><td>"+bean.getStudentMobile()+"</td><td>"+bean.getIssuedDate()+"</td><td>"+bean.getReturnsStatus()+"</td></tr>");
        }

        out.println("</table>");
        out.println("</div>");

        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();


    }
}
