package com.jhunsuvlets.toysuvlets2.suvlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/testSuvlets")
public class testsuvlets extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");

            //display
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<div>hello test site</div>");
            printWriter.close();
        }
    
}