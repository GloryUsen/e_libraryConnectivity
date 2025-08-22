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

@WebServlet("/servlets.IssueBook")

public class IssueBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE.html>");
        out.println("html");
        out.println("<head>");
        out.println("<title> Add Book Form </title>");
        out.println("<link rel= 'stylesheet' href= 'boostrap.min.css'/>");
        out.println("</head>");
        out.println("</body>");
        request.getRequestDispatcher("glolibrarian.html").include(request, response);

        out.println("<div class= 'container'>");
        String callNo = request.getParameter("callno");
        String studentid = request.getParameter("studentId");
        String studentname = request.getParameter("studentname");
        String sstudentmobile = request.getParameter("studentmobile");
        long studentmobile = Long.parseLong(sstudentmobile);

        IssueBookBean newIssuedBook = new IssueBookBean(callNo, studentid, studentname, studentmobile);

        int i = BookDao.issueBook(newIssuedBook);
        if (i > 0){
            out.println("<h3>Book issued successfully</h3>");

        } else {
            out.println("<h3> Sorry, unable to issue book.</h3><p>We may have shortage of books. Kindly visit later.</p>");

        }
        out.println("</div>");

        request.getRequestDispatcher("footer.html").include(request, response);
        out.close();


    }

}
