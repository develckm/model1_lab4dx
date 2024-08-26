-- c## 공통사용자 접두사
CREATE USER c##lab4dx IDENTIFIED BY oracle
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP;

GRANT connect,resource,dba TO c##lab4dx;

-- 고객 테이블
CREATE TABLE c##lab4dx.Customer (
                                    customer_id NUMBER PRIMARY KEY,
                                    customer_name VARCHAR2(100) NOT NULL,
                                    customer_email VARCHAR2(100) UNIQUE NOT NULL,
                                    customer_phone VARCHAR2(20)
);

-- 제품 테이블
CREATE TABLE c##lab4dx.Product (
                                   product_id NUMBER PRIMARY KEY,
                                   product_name VARCHAR2(100) NOT NULL,
                                   product_price NUMBER NOT NULL -- 제품 가격을 정수로 변경
);

-- 주문 테이블
CREATE TABLE c##lab4dx.Orders (
                                  order_id NUMBER PRIMARY KEY,
                                  order_date DATE DEFAULT SYSDATE,
                                  customer_id NUMBER,
                                  product_id NUMBER,
                                  quantity NUMBER,
                                  FOREIGN KEY (customer_id) REFERENCES c##lab4dx.Customer(customer_id),
                                  FOREIGN KEY (product_id) REFERENCES c##lab4dx.Product(product_id)
);
-- 고객 데이터 삽입
INSERT INTO c##lab4dx.Customer (customer_id, customer_name, customer_email, customer_phone)
VALUES (1, '김철수', 'chulsu@example.com', '010-1234-5678');

INSERT INTO c##lab4dx.Customer (customer_id, customer_name, customer_email, customer_phone)
VALUES (2, '이영희', 'younghee@example.com', '010-2345-6789');

-- 제품 데이터 삽입
INSERT INTO c##lab4dx.Product (product_id, product_name, product_price)
VALUES (1, '노트북', 1500000);

INSERT INTO c##lab4dx.Product (product_id, product_name, product_price)
VALUES (2, '스마트폰', 800000);

-- 주문 데이터 삽입
INSERT INTO c##lab4dx.Orders (order_id, customer_id, product_id, quantity)
VALUES (1, 1, 1, 1);

INSERT INTO c##lab4dx.Orders (order_id, customer_id, product_id, quantity)
VALUES (2, 2, 2, 2);
