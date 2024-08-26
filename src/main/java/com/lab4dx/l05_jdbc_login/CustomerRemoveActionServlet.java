package com.lab4dx.l05_jdbc_login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/customerRemoveAction.do")
public class CustomerRemoveActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        String url="jdbc:oracle:thin:@localhost:1521:XE ";
        String driver="oracle.jdbc.driver.OracleDriver";
        String user="c##lab4dx";
        String pass="oracle";
        Connection conn=null;
        PreparedStatement pstmt=null; //쿼리에 ? 를 작성하고 파라미터를 대입
        int remove=0; //수정 성공시 0이상이 반환
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            pstmt=conn.prepareStatement("DELETE FROM CUSTOMER where CUSTOMER_ID=?");
            pstmt.setInt(1,Integer.parseInt(id));
            remove=pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(remove>0){
            resp.sendRedirect("./customerList.do"); //삭제 성공시 리스트
        }else{
            resp.sendRedirect("./customerModify.do"); //실패시 다시 수정 폼
        }
    }
}
