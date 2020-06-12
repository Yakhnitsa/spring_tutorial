package com.yurets_y.spring_tutor_001.aop_aspectj_annotations;

import org.springframework.stereotype.Component;

@Component("MySql-connection")
public class DatabaseConnection {

    public void connect(String url){
        System.out.println("Connection to URL: " + url);
    }

    public String proceed(String query){
        return "Proceeding query '" + query + "'";
    }

    public void disconnect(){
        System.out.println("Disconnect from server");
    }
}
