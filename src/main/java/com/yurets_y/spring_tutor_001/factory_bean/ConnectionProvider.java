package com.yurets_y.spring_tutor_001.factory_bean;

import java.sql.Connection;

public interface ConnectionProvider {
    Connection getConnection();
    void setConnection(Connection connection);
    void closeConnection();
}
