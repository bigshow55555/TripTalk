package com.example.twipee_triptalk.TripTalk.Board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SimpleDB {

    private static Map<String, ArticleVO> db = new HashMap<String, ArticleVO>();

    public static void addArticle(String index, ArticleVO articleVO)
    {
        db.put(index,articleVO);
    }

    public static ArticleVO getArticle(String index)
    {
        return db.get(index);
    }

    public static List<String> getIndexes(){
        Iterator<String> keys = db.keySet().iterator();

        List<String> keylist = new ArrayList<String>();
        String key = "";
        while (keys.hasNext()){
            key= keys.next();
            keylist.add(key);
        }

        return keylist;
    }


}
