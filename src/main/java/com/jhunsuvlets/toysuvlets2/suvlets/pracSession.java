package com.jhunsuvlets.toysuvlets2.suvlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// /session/pracSession?username=jhun1020&password=5701    파라미터 받아온 주소값
@WebServlet(urlPatterns = "/session/pracSession")
public class pracSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
       
       //display
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>CreateSessionServlets</div>");

        if("jhun1020".equals(username) && "5701".equals(password)){
            // 맞다면 로그인  
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("username", username);
            httpSession.setAttribute("password", password);
            printWriter.println("<div>"+username + ", " + password +"</div>");
        } else {
            // 아니라면 fail 출력
            printWriter.println("<div>Fail</div>");
        }


        printWriter.close();


    }
}
