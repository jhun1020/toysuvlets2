package com.jhunsuvlets.toysuvlets2.suvlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cookie/pracCookie")
public class pracCookie extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Cookie
        Cookie cookie_first = new Cookie("firstName", "이");
        Cookie cookie_second = new Cookie("secondName", "정훈");
        response.addCookie(cookie_first);
        response.addCookie(cookie_second);

 
      

        //display
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>CreateCookieServlets</div>");
        
        // get 쿠키
        // 쿠키는 어레이 형식이라 복수로 모두 받아오고 루프를 통해 모두 뽑아냄
        Cookie cookies[] = request.getCookies();
        for(Cookie cookie : cookies){
            String name = cookie.getName();
            String value = cookie.getValue();
            printWriter.println("<div>Cookie Name : " +name + "value : " + value + "</div>");
            
            // 쿠키 삭제
            if("secondName".equals(name)) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                
            }
                
            }
            printWriter.close();
        }


    }
    

