package com.jhunsuvlets.toysuvlets2.suvlets;

import java.util.HashMap;

public class SurveyInfo {
    public HashMap<String, String> getQuestion_list() {
        HashMap<String, String> question_list = new HashMap<String, String>();
        question_list.put("Q1", "해당 매장을 방문시 매장은 청결 하였습니까?");
        question_list.put("Q2", "주문시 직원은 고객님께 친절 하였습니까?");
        question_list.put("Q3", "주문하신 음료가 나오기까지 시간이 적당하였습니까?");
        question_list.put("Q4", "직원이 제조한 음료에 대해 맛은 좋았습니까?");
        question_list.put("Q5", "해당 매장을 다음에도 재방문 하실 의향이 있으십니까?");
        question_list.put("Q", "test");

        return question_list;
    } 

    public HashMap<String, String> getExample_list() {
        HashMap<String, String> question_list = new HashMap<String, String>();
        question_list.put("E1", "전혀 아니다");
        question_list.put("E2", "아니다");
        question_list.put("E3", "보통이다");
        question_list.put("E4", "그렇다");
        question_list.put("E5", "매우 그렇다");

        return question_list;
    } 
}
