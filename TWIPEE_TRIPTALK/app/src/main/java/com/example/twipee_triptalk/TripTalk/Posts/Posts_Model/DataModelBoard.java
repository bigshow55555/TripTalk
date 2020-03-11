package com.example.twipee_triptalk.TripTalk.Posts.Posts_Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataModelBoard implements Serializable { //시리얼 라이즈 공부하기 - 클래스 같은걸 한번에 넘길때 (직렬화 라고 함.)

    public String location;
    public String board_type;
    public String data_created;
    public String photo_id;
    public String user_id;
    public List<DataModelLike> like_values = new ArrayList<>();




    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBoard_type() {
        return board_type;
    }

    public void setBoard_type(String board_type) {
        this.board_type = board_type;
    }

    public String getData_created() {
        return data_created;
    }

    public void setData_created(String data_created) {
        this.data_created = data_created;
    }

    public String getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(String photo_id) {
        this.photo_id = photo_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public List<DataModelLike> getLike_values() {
        return like_values;
    }

    public void setLike_values(List<DataModelLike> like_values) {
        this.like_values = like_values;
    }






}
