package com.jhunsuvlets.toysuvlets2.suvlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/poll/PollServlet")
public class DetailServlets extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        SurveyInfo surveyInfo = new SurveyInfo();
        HashMap<String, String> question_list = surveyInfo.getQuestion_list();
        request.setAttribute("question_list", question_list);
        request.setAttribute("testName", "testSuccess");
        // RequestDispatcher requestDispatcher = request.getRequestDispatcher("/poll/details.jsp");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/poll/details.jsp");
        requestDispatcher.forward(request, response);
       


        // PrintWriter printWriter = response.getWriter();
        

        // printWriter.println(" <div> 확인용 </div>"); 
    }
    

}
