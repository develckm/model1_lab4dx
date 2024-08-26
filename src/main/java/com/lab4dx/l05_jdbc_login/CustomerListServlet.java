package com.lab4dx.l05_jdbc_login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/customerList.do")
public class CustomerListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //db 접속하려면 각 db 회사에서 제공하는 드라이버 다운받아야한다.
        String url="jdbc:oracle:thin:@localhost:1521:XE ";
        String driver="oracle.jdbc.driver.OracleDriver";
        String user="c##lab4dx";
        String pass="oracle";
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        List<CustomerDto> customers=null; //아직 데이터가 없다
        try {
            Class.forName(driver); //DriverManager 가 db에 접속할때 동적으로 생성하는 객체를 명시
            conn=DriverManager.getConnection(url,user,pass); //sqlplus c##lab4dx/oralce;
            stmt=conn.createStatement(); //질의를 할 준비
            rs=stmt.executeQuery("SELECT * FROM CUSTOMER");//Select == query
            //오류없이 실행됨!
            customers=new ArrayList<CustomerDto>();
            while (rs.next()) { //Iterator.next()
                CustomerDto customer = new CustomerDto();
                customer.setCustomerEmail(rs.getString("CUSTOMER_EMAIL"));
                customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
                customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
                customer.setCustomerPhone(rs.getString("CUSTOMER_PHONE"));
                customers.add(customer);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //resp.getWriter().println(customers);

        req.setAttribute("customers", customers);//뷰템플릿에(**객체를 넘겨줄 수 있다.)

        req.getRequestDispatcher("/customerList.jsp").forward(req, resp);
        //이 서블릿이 뷰를 응답하지 않고 뷰템플릿인 jsp에 응답을 위입하겠다.
    }
}
