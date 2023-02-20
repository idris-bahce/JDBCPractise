package org.example;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homework {

    private static ResultSet resultSet;

    public static List<Map<String, Object>> getQueryResultMap1() {
        List<Map<String, Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;

        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> colNameValueMap = new HashMap<>();
                for (int i = 1; i < rsmd.getColumnCount(); i++) {
                    colNameValueMap.put(rsmd.getColumnName(i), resultSet.getObject(i));
                }
                rowList.add(colNameValueMap);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowList;
    }

    public static List<Map<String, Object>> getQueryResultMap2() {
        List<Map<String,Object>> rowList = new ArrayList<>();
        ResultSetMetaData resultSetMetaData;
        try {
            resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()){
                Map<String, Object> columnNameValueMap = new HashMap<>();
                for (int i = 1; i < resultSetMetaData.getColumnCount(); i++) {
                    columnNameValueMap.put(resultSetMetaData.getColumnName(i),resultSet.getObject(i));
                }
                rowList.add(columnNameValueMap);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowList;
    }

    public static List<Map<String, Object>> getQueryResultMap3() {
        List<Map<String, Object>> rowList = new ArrayList<>();
        try {
            ResultSetMetaData rsmd = resultSet.getMetaData();
            while (resultSet.next()){
                Map<String, Object> columnNameValueMap = new HashMap<>();
                for (int i = 1; i < rsmd.getColumnCount(); i++) {
                    columnNameValueMap.put(rsmd.getColumnName(i),resultSet.getObject(i));
                }
                rowList.add(columnNameValueMap);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowList;
    }

    public static List<Map<String, Object>> getQueryResultMap4() {
        List<Map<String, Object>> rowList = new ArrayList<>();
        try {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()){
                Map<String, Object> columnNameValueMap = new HashMap<>();
                for (int i = 1; i < resultSetMetaData.getColumnCount(); i++) {
                    columnNameValueMap.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
                }
                rowList.add(columnNameValueMap);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowList;
    }

    public static List<Map<String, Object>> getQueryResultMap5() {
        List<Map<String, Object>> rowList = new ArrayList<>();
        try {
            ResultSetMetaData rsmd = resultSet.getMetaData();
            while (resultSet.next()){
                Map<String, Object> columnNameValueMap = new HashMap<>();
                for (int i = 1; i < rsmd.getColumnCount(); i++) {
                    columnNameValueMap.put(rsmd.getColumnName(i),resultSet.getObject(i));
                }
                rowList.add(columnNameValueMap);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowList;
    }
}
