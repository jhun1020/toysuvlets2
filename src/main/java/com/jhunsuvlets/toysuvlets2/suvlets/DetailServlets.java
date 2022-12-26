package com.jhunsuvlets.toysuvlets2.suvlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.jhunsuvlets.toysuvlets2.dao.DetailDB;

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

        
        // db
        DetailDB detailDB = new DetailDB();
        
        // HashMap<String, Object> question = null;
        // ArrayList<HashMap> answer = null;
        String questions_Uid = request.getParameter("QUESTIONS_UID");
        
        try {
            HashMap<String, Object> question = detailDB.getQuestion(questions_Uid);
            ArrayList<HashMap> answer = detailDB.getAnswer(questions_Uid);
 



        request.setAttribute("question", question);
        request.setAttribute("answer", answer);
        // RequestDispatcher requestDispatcher = request.getRequestDispatcher("/poll/test.jsp");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/poll/details.jsp");
        requestDispatcher.forward(request, response);
       
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

        // PrintWriter printWriter = response.getWriter();
        

        // printWriter.println(" <div> 확인용 </div>"); 
    }
    

}
