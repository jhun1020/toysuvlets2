<%@ page import="java.util.HashMap, java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <!-- /poll/details.jsp -->
    <%-- <%@ include file="/poll/PollServlet" %> --%>
    <div>
      <div class="button">
        <button id="prev">Prev</button>
        <button id="next">Next</button>
      </div>  
        <%-- ?firstName=jhun --%>
      <% String test = (String)request.getAttribute("testName");
         HashMap<String, String> test2 = (HashMap<String, String>)request.getAttribute("question_list"); 
         String test3 = (String)request.getParameter("firstName");  %>
      <div> <%= test %> </div>
      <div> <%= test3 %> </div>
      <div> <%= test2.get("Q1") %> </div>
      <% String tText = "Q2"; %>
      <div> <%= test2.get(tText) %></div>
    </div>
    <hr>
    <div>
       <%-- <a href="/poll/PollServlet?QUESTIONS_UID=Q1">Q1</a>
    <% String QUESTIONS_UID = (String)request.getParameter("QUESTIONS_UID");%>
     <% String question_list = test2.get(QUESTIONS_UID); %>
       <div> <%= question_list %> </div> --%>
    </div>
    <hr>
      <div> 
        <% String uidTag = "Q1"; %>
        <button>Prev</button>
        <button> <a href="/poll/PollServlet?QUESTIONS_UID=<%=uidTag %>">Next</a></button>
        <%-- uidTag값 --%>
      </div>
      <div>
        <div><%= test2.get(uidTag) %></div>
    
      </div>
  </body>
</html>
