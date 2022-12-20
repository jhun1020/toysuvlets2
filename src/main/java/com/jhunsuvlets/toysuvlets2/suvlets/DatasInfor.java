package com.jhunsuvlets.toysuvlets2.suvlets;

import java.util.ArrayList;
import java.util.HashMap;

public class DatasInfor {
    // 해시맵
    public HashMap<String, String> getHashMap() {

        HashMap<String, String> pracHashMap = new HashMap<String, String>();

        pracHashMap.put("name", "이정훈!");
        pracHashMap.put("id", "001");

        return pracHashMap;

    }
    // 어레이
    public ArrayList<String> getArrayList() {
        ArrayList<String> pracArrayList = new ArrayList<String>();
        pracArrayList.add("no1");
        pracArrayList.add("no2");
        pracArrayList.add("no3");
        return pracArrayList;
    }

    // 해시맵 오브젝트
    public HashMap<String, Object> getBundle(){
        DatasInfor datasInfor = new DatasInfor();
        HashMap<String, String> pracHashMap = datasInfor.getHashMap();
        ArrayList<String> pracArrayList = datasInfor.getArrayList();

        HashMap<String, Object> pracBundle = new HashMap<>();
        pracBundle.put("pracHashMap", pracHashMap);
        pracBundle.put("pracArrayList", pracArrayList);

        return pracBundle;

    }
}
