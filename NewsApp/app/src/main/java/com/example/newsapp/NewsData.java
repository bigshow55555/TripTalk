package com.example.newsapp;

import java.io.Serializable;


// 직렬화  intent 할때도 간혹 쓰인다.
public class NewsData implements Serializable {

    private String title;
    private String urltoImage;
    private String content;

    // 변수들을 왜 private 했냐..? 데이터 캡슐화를 위해서, 즉 임의로 다른 클래스에서 접근해서 수정하지 못하게

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrltoImage() {
        return urltoImage;
    }

    public void setUrltoImage(String urltoImage) {
        this.urltoImage = urltoImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



}
