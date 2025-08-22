package com.glory.elibraryapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlets.LogoutAdmin")

public class LogoutAdmin extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        request.getSession().invalidate();
        response.sendRedirect("index.html");

    }
}
