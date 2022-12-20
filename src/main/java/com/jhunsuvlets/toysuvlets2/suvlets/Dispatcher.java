package com.jhunsuvlets.toysuvlets2.suvlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dispatcher")
public class Dispatcher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String hiddenParam = request.getParameter("hiddenParam");

           // Dispatcher?hiddenParam=searchFormServlet      (주소창)

            // 히든의 값에 따라 분기
        // if("pracCookie".equals(hiddenParam)){
        //     response.sendRedirect("/pracCookie");
        //     // a태그와 같은 기능,  파라미터를 포함시켜서 보낼수 없음
        // } else if("pracSession".equals(hiddenParam)){
        //     request.setAttribute("firstName", "jhunlab");
        //         }
        // else{
//normal display
String message = "hellow dispatcher class";
PrintWriter printWriter = response.getWriter();
printWriter.println("<div>" + message + "</div>");

printWriter.close();
        // }
    }
}
