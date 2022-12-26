package com.jhunsuvlets.toysuvlets2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class DetailDB {
    // mysql과 연결 출력할 값들을 변수에 저장

    // 번들로 저장
    public HashMap<String, Object> getQuestion(String Q_UID) throws SQLException{
        Commons commons = new Commons();
        Statement statement = commons.getStatement();
        
        // query
        String query = "SELECT * FROM QUESTIONS_LIST WHERE QUESTIONS_UID = '"+Q_UID+"'";

            ResultSet resultSet = statement.executeQuery(query);

        
        HashMap<String, Object>questions_list = null;
        while(resultSet.next()){
            questions_list = new HashMap<>();
            questions_list.put("QUESTIONS_UID", resultSet.getString("QUESTIONS_UID"));
            questions_list.put("QUESTIONS",resultSet.getString("QUESTIONS"));
            questions_list.put("ORDERS",resultSet.getInt("ORDERS"));
        }

        
        return questions_list;


}

    public ArrayList<HashMap> getAnswer(String Q_UID) throws SQLException {
        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT * FROM ANSWERS INNER JOIN EXAMPLE_LIST " +
        " ON ANSWERS.EXAMPLE_UID = EXAMPLE_LIST.EXAMPLE_UID " +
       " WHERE QUESTIONS_UID = '"+Q_UID+"'";

       ResultSet resultSet = statement.executeQuery(query);


        ArrayList<HashMap> answers_list = new ArrayList<>();
        HashMap<String, Object> answer = null;
        while(resultSet.next()){
            answer = new HashMap<>();
            answer.put("EXAMPLE_UID", resultSet.getString("EXAMPLE_UID"));
            answer.put("EXAMPLE",resultSet.getString("EXAMPLE"));
            answer.put("ORDERS",resultSet.getInt("ORDERS"));

            answers_list.add(answer);
        }

        return answers_list;
        


    }


}
