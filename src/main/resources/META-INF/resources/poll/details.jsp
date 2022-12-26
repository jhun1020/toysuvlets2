<%@ page import="java.util.HashMap, java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="./css/commons.css" />
  </head>
  <body>
  <%-- 캐스팅 안해서 계속 오류났다 잊지 말 것 --%>
  <% 
  HashMap<String, Object> question = (HashMap<String, Object>)request.getAttribute("question"); 
  ArrayList<HashMap> answer = (ArrayList<HashMap>)request.getAttribute("answer"); 
  %>

    <div class="container">
      <!-- buttons -->
      <div class="buttons">
      <%-- orders를 두고 현재와 비교해서 next를 누르면 orders+1 호출, 출력  <->  prev -1 호출 출력 --%>
        <button><a href="/poll/PollServlet?QUESTIONS_UID=Q <%= (int)question.get("ORDERS")-1 %> ">Prev</a></button>
        <button><a href="/poll/PollServlet?QUESTIONS_UID=Q <%= (int)question.get("ORDERS")+1 %> ">Next</a></button>
      </div>

      <!-- poll contents -->
      <div>
        <%-- question --%>
         <div>
         <%= question.get("ORDERS") %>. <%= question.get("QUESTION") %>
         </div>

        <%-- answer --%>
         <div>
          <% for(int i=0; i<answer.size(); i++){ %>
            <div><input type="radio" class="form-check-input" name="answer_radio" id="<%= answer.get(i).get("EXAMPLE_UID") %>" value="<%= answer.get(i).get("EXAMPLE_UID") %>"/>
           <label for="<%= answer.get(i).get("EXAMPLE_UID") %>" class="form-check-label">
           (<%= answer.get(i).get("ORDERS") %>) <%= answer.get(i).get("EXAMPLE") %>
           </label>
      </div>

          <% } %>
         </div>
      </div>
    </div>
    <script src="../../../static/js/details.js"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
