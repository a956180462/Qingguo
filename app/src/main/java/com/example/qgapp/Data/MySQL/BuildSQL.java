package com.example.qgapp.Data.MySQL;

import java.sql.ResultSet;

public interface BuildSQL {
    public ResultSet SELECT(String sql)throws qgSqlException;
    public long UPDATE(String sql);
}
