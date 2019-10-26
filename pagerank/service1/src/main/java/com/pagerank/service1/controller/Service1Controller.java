package com.pagerank.service1.controller;

import com.pagerank.service1.utils.Matrix;
import com.pagerank.service1.utils.Node;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/service1")
public class Service1Controller {
    @GetMapping("/cpuBiggest")
    public int[][] cpuBiggest(){
        return cpuTest1(500, 500);
    }

    @GetMapping("/meaningless")
    public String meaningless(){
        return "ok";
    }

    public int[][] cpuTest1(int i1,int j1){
        int[][] ma1 = Matrix.createMatrix(i1,j1);
        int[][] ma2 = Matrix.createMatrix(i1,j1);
        int[][] m3 = new int[i1][j1];
        try {
            m3 = Matrix.multiplication(ma1, ma2);
        }catch (Exception e){

        }
        return m3;
    }

    public String memoryTest(int count) {
        Node[] nodes = new Node[count];
        for (int i = 0; i < count; i++) {
            nodes[i] = new Node();
        }
        return "ok";
    }

    private static Connection getConn() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://119.23.52.13:3306/SpringCloud_Sell?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "HT123asd";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    @GetMapping("/insert")
    public static int insert() {

        Connection conn = getConn();
        int i = 0;
        String sql = "insert into user_info (id,username,password,openid,role,create_time,update_time) values(?,?,?,?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, UUID.randomUUID().toString().replace("-", "").toLowerCase());
            pstmt.setString(2, "a");
            pstmt.setString(3, "wangzehuai");
            pstmt.setString(4, UUID.randomUUID().toString().replace("-", "").toLowerCase());
            pstmt.setInt(5, 1);
            java.util.Date a = new java.util.Date();
            pstmt.setTimestamp(6, new Timestamp(a.getTime()));
            pstmt.setTimestamp(7, new Timestamp(a.getTime()));
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @GetMapping("/update")
    public static int update() {
        Connection conn = getConn();
        int i = 0;
        String sql = "update user_info set username='" + "a" + "' where password='" + "wangzehuai" + "'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("resutl: " + i);
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @GetMapping("/getAll")
    public static Integer getAll() {

        Connection conn = getConn();
        String sql = "select * from user_info";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            System.out.println("============================");
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                    if ((i == 2) && (rs.getString(i).length() < 8)) {
                        System.out.print("\t");
                    }
                }
            }
            System.out.println("============================");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/delete")
    public static int delete() {
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            arr.add(UUID.randomUUID().toString());
        }
        Connection conn = getConn();
        int i = 0;
        String sql = "delete from user_info order by id desc limit 1";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("resutl: " + i);
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

}
