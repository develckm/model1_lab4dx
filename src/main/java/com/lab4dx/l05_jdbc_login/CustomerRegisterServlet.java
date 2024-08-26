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

@WebServlet("/customerRegister.do")
public class CustomerRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/customerRegister.jsp").forward(req, resp);
    }

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
        int insert=0; //수정 성공시 0이상이 반환
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            pstmt=conn.prepareStatement("insert into customer (CUSTOMER_ID,CUSTOMER_NAME,CUSTOMER_EMAIL,CUSTOMER_PHONE)values(?,?,?,?)");
            pstmt.setInt(1,Integer.parseInt(id));
            pstmt.setString(2,name);
            pstmt.setString(3,email);
            pstmt.setString(4,phone);
            insert=pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(insert>0){
            resp.sendRedirect("./customerDetail.do?id="+id); //등록 성공시 상세
        }else{
            resp.sendRedirect("./customerRegister.do"); //실패시 다시 수정 폼
        }
    }
}
