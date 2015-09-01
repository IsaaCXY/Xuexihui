package com.example.administrator.huixuexiapp.entity;



import java.util.Date;

/**
 * Created by Administrator on 2015/8/23.
 */

public class ChengZhangRecord {

    private  Integer _Id;
    private Integer user_id;
    private String czh_content;
    private String czh_photo;
    private  String  czh_glory_photo;
    private  String czh_glory_content;
    private String czh_little_secret;
    private  String czh_create_time;
    private Integer czh_limit_status;

    public ChengZhangRecord(){

    }

    public Integer get_Id() {
        return _Id;
    }

    public void set_Id(Integer _Id) {
        this._Id = _Id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getCzh_content() {
        return czh_content;
    }

    public void setCzh_content(String czh_content) {
        this.czh_content = czh_content;
    }

    public String getCzh_photo() {
        return czh_photo;
    }

    public void setCzh_photo(String czh_photo) {
        this.czh_photo = czh_photo;
    }

    public String getCzh_glory_photo() {
        return czh_glory_photo;
    }

    public void setCzh_glory_photo(String czh_glory_photo) {
        this.czh_glory_photo = czh_glory_photo;
    }

    public String getCzh_glory_content() {
        return czh_glory_content;
    }

    public void setCzh_glory_content(String czh_glory_content) {
        this.czh_glory_content = czh_glory_content;
    }

    public String getCzh_little_secret() {
        return czh_little_secret;
    }

    public void setCzh_little_secret(String czh_little_secret) {
        this.czh_little_secret = czh_little_secret;
    }

    public String getCzh_create_time() {
        return czh_create_time;
    }

    public void setCzh_create_time(String czh_create_time) {
        this.czh_create_time = czh_create_time;
    }

    public Integer getCzh_limit_status() {
        return czh_limit_status;
    }

    public void setCzh_limit_status(Integer czh_limit_status) {
        this.czh_limit_status = czh_limit_status;
    }
}
