package com.lab4dx.l05_jdbc_login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/customerDetail.do")
public class CustomerDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id"); //customer_id가 파라미터로 온다.

        //db 접속하려면 각 db 회사에서 제공하는 드라이버 다운받아야한다.
        String url="jdbc:oracle:thin:@localhost:1521:XE ";
        String driver="oracle.jdbc.driver.OracleDriver";
        String user="c##lab4dx";
        String pass="oracle";
        Connection conn=null;
        PreparedStatement pstmt=null; //쿼리에 ? 를 작성하고 파라미터를 대입
        ResultSet rs=null;
        CustomerDto customer=null; //아직 데이터가 없다
        try {
            Class.forName(driver); //DriverManager 가 db에 접속할때 동적으로 생성하는 객체를 명시
            conn=DriverManager.getConnection(url,user,pass); //sqlplus c##lab4dx/oralce;
            pstmt=conn.prepareStatement("select * from CUSTOMER WHERE CUSTOMER_ID=?");
            pstmt.setInt(1,Integer.parseInt(id));
            rs=pstmt.executeQuery();

            if (rs.next()) {//유니크나 프라이머리키로 조회하면 1개만 나오기 때문
                customer = new CustomerDto();
                customer.setCustomerEmail(rs.getString("CUSTOMER_EMAIL"));
                customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
                customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
                customer.setCustomerPhone(rs.getString("CUSTOMER_PHONE"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("customer", customer);//뷰템플릿에(**객체를 넘겨줄 수 있다.)

        req.getRequestDispatcher("/customerDetail.jsp").forward(req, resp);
        //이 서블릿이 뷰를 응답하지 않고 뷰템플릿인 jsp에 응답을 위입하겠다.
    }
}
