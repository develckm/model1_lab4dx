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

@WebServlet("/customerModifyAction.do")
public class CustomerModifyActionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        String url="jdbc:oracle:thin:@localhost:1521:XE ";
        String driver="oracle.jdbc.driver.OracleDriver";
        String user="c##lab4dx";
        String pass="oracle";
        Connection conn=null;
        PreparedStatement pstmt=null; //쿼리에 ? 를 작성하고 파라미터를 대입
        int update=0; //수정 성공시 0이상이 반환
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            pstmt=conn.prepareStatement("update customer set CUSTOMER_NAME=?,CUSTOMER_EMAIL=?,CUSTOMER_PHONE=? where CUSTOMER_ID=?");
            pstmt.setString(1,name);
            pstmt.setString(2,email);
            pstmt.setString(3,phone);
            pstmt.setInt(4,Integer.parseInt(id));
            update=pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(update>0){
            resp.sendRedirect("./customerDetail.do?id="+id); //수정 성공시 상세
        }else{
            resp.sendRedirect("./customerModify.do"); //실패시 다시 수정 폼
        }
    }
}
