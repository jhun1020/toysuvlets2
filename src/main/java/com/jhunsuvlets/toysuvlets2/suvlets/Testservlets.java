package com.jhunsuvlets.toysuvlets2.suvlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/testSuvlets")
public class Testservlets extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");

            // datasInfor 가져오기
            // DatasInfor datasInfor = new DatasInfor();
            // HashMap<String, String> pracHashMap = datasInfor.getHashMap();
 
            // String map = pracHashMap.get("name");
            //display

            PrintWriter printWriter = response.getWriter();
            printWriter.println(" <html lang='en'>");
            printWriter.println(" <head>");
            printWriter.println(" <title>hun title</title>");
            printWriter.println(" </head>");
            printWriter.println(" <body>");
            // printWriter.println("<div>" + map +  "</div>");
                printWriter.println("<div>test div</div>");
            printWriter.println("</body>");
            printWriter.println(" </html>");

            printWriter.close();
        }
    
}
