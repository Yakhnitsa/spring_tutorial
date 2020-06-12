package com.yurets_y.spring_tutor_001.aop_aspectj_annotations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class DaoService {

    public DatabaseConnection connection;

    public void connectToDB(){
        connection.connect("My SQL URL connection");
    }

    public void saveToDB(){
        connection.proceed("INSERT INTO DB_EXAMPLE ....");
    }
    public void disconnectFromDB(){
        connection.disconnect();
    }

    @Autowired
    public void setConnection(DatabaseConnection connection) {
        this.connection = connection;
    }
}
