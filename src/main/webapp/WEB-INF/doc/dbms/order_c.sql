/**********************************/
/* Table Name: ȸ����� */
/**********************************/
DROP TABLE grade CASCADE CONSTRAINTS;

CREATE TABLE grade (
  gradeno  NUMBER(7)     NOT NULL,   -- ��� ��ȣ
  gname    VARCHAR(20)   NOT NULL,   -- ��� �̸�
  accum    NUMBER(3,3)   NOT NULL,   -- ������
  PRIMARY KEY (gradeno)
);


DROP SEQUENCE grade_seq;

CREATE SEQUENCE grade_seq
    START WITH 1                -- ���۹�ȣ
    INCREMENT BY 1            -- ������
    MAXVALUE 999999999     -- �ִ밪
    CACHE 2                         -- 2���� �޸𸮿����� ���
    NOCYCLE;                       -- �ٽ� 1���� �����Ǵ°��� ����
    
INSERT INTO grade(gradeno, gname, accum)
VALUES(grade_seq.nextval, '���̾�', 0.005);

INSERT INTO grade(gradeno, gname, accum)
VALUES(grade_seq.nextval, '�ǹ�', 0.01);

INSERT INTO grade(gradeno, gname, accum)
VALUES(grade_seq.nextval, '���', 0.03);

INSERT INTO grade(gradeno, gname, accum)
VALUES(grade_seq.nextval, '�÷�', 0.05);

INSERT INTO grade(gradeno, gname, accum)
VALUES(grade_seq.nextval, '���̾�', 0.07);
    
select * from grade;

commit;
/**********************************/
/* Table Name: ȸ�� */
/**********************************/
DROP TABLE members CASCADE CONSTRAINTS;

CREATE TABLE members (
  memberno NUMBER(6)     NOT NULL, -- ȸ�� ��ȣ, ���ڵ带 �����ϴ� �÷�
  gradeno  NUMBER(7)     DEFAULT 1 NOT NULL, -- ��� ��ȣ
  id       VARCHAR(20)   NOT NULL UNIQUE, -- ���̵�, �ߺ� �ȵ�, ���ڵ带 ���� 
  passwd   VARCHAR(60)   NOT NULL, -- �н�����, ������ ����
  mname    VARCHAR(20)   NOT NULL, -- ����, �ѱ� 10�� ���� ����
  nickname VARCHAR(20)   NOT NULL UNIQUE, -- �г���
  email    VARCHAR(60)   NOT NULL UNIQUE, -- �̸��� �ּ�, �ߺ� �Ұ�
  tel      VARCHAR(14)   NOT NULL, -- ��ȭ��ȣ
  zipcode  VARCHAR(5)        NULL, -- �����ȣ, 12345
  address1 VARCHAR(80)       NULL, -- �ּ� 1
  address2 VARCHAR(50)       NULL, -- �ּ� 2
  birth    VARCHAR(14)       NULL, -- �������
  points   NUMBER(7)     DEFAULT 0 NOT NULL, -- ������
  mdate    DATE          NOT NULL, -- ������    
  PRIMARY KEY (memberno),                     -- �ѹ� ��ϵ� ��
  FOREIGN KEY (gradeno) REFERENCES grade (gradeno)
);

UPDATE members
SET gradeno=1
WHERE memberno = 1;

DROP SEQUENCE members_seq;

CREATE SEQUENCE members_seq
    START WITH 1                -- ���۹�ȣ
    INCREMENT BY 1            -- ������
    MAXVALUE 999999999     -- �ִ밪
    CACHE 2                         -- 2���� �޸𸮿����� ���
    NOCYCLE;                       -- �ٽ� 1���� �����Ǵ°��� ����

SELECT * FROM members;

/**********************************/
/* Table Name: ��ǰī�װ� */
/**********************************/

DROP TABLE cate_gory;

CREATE TABLE cate_gory(
    goryno                             NUMBER(10)    NOT NULL    PRIMARY KEY,
    name                                   VARCHAR2(100)     NOT NULL,
    seqno                                NUMBER(10)    DEFAULT 1     NOT NULL,
    printout                             CHAR(1)     DEFAULT 'Y'     NOT NULL,
    rdate                                  DATE    NOT NULL,
    cnt                                    NUMBER(10)    DEFAULT 0     NOT NULL
);

DROP SEQUENCE gory_seq;

CREATE SEQUENCE gory_seq
    START WITH 1                -- ���۹�ȣ
    INCREMENT BY 1            -- ������
    MAXVALUE 999999999     -- �ִ밪
    CACHE 2                         -- 2���� �޸𸮿����� ���
    NOCYCLE;                       -- �ٽ� 1���� �����Ǵ°��� ����

select * from cate_gory;
    
commit;
/**********************************/
/* Table Name: ��ǰ */
/**********************************/

DROP TABLE product CASCADE CONSTRAINTS;

CREATE TABLE product(
    p_no                    NUMBER(10)     NOT NULL    PRIMARY KEY,
    goryno                  NUMBER(10)     NOT NULL,
    p_name                 VARCHAR2(100)     NOT NULL,
    p_printout              CHAR(1)    DEFAULT 'Y'     NULL,
    p_date                   DATE    NULL,
    p_price                  NUMBER(10)    DEFAULT 0    NOT NULL,
    p_unit                    NUMBER(10)     NULL,
    p_capacity               VARCHAR2(100)     NULL,
    p_delivery                VARCHAR2(50)     NULL,
    p_allergy_info           clob                  NULL,
    p_expiration_date      VARCHAR2(100)    NULL,
    p_detailed               clob      NULL,
    p_quantity               NUMBER(10)    NULL,
    hits                        NUMBER(7)    DEFAULT 0     NULL,
    searchword                    VARCHAR2(300)  NULL,
    file1                                   VARCHAR(100)          NULL,
    thumb1                              VARCHAR(100)          NULL,
    size1                                 NUMBER(10)      DEFAULT 0 NULL,         
     FOREIGN KEY (goryno) REFERENCES cate_gory (goryno)
);

DROP SEQUENCE p_seq;

CREATE SEQUENCE p_seq
    START WITH 1                -- ���۹�ȣ
    INCREMENT BY 1            -- ������
    MAXVALUE 999999999     -- �ִ밪
    CACHE 2                         -- 2���� �޸𸮿����� ���
    NOCYCLE;                       -- �ٽ� 1���� �����Ǵ°��� ����

INSERT INTO product(p_no)
VALUES(1);
INSERT INTO product(p_no)
VALUES(2);
INSERT INTO product(p_no)
VALUES(3);

select * from product;

SELECT p_no, p_name, p_price, thumb1
  FROM product
  WHERE p_no = 1;

COMMENT ON TABLE product is '��ǰ';
COMMENT ON COLUMN product.p_no is '��ǰ ��ȣ';
COMMENT ON COLUMN product.goryno is 'ī�װ� ��ȣ';
COMMENT ON COLUMN product.p_name is '��ǰ �̸�';
COMMENT ON COLUMN product.p_seqno is '��� ����';
COMMENT ON COLUMN product.p_printout is '��� ���';
COMMENT ON COLUMN product.p_date is '�����';
COMMENT ON COLUMN product.p_price is '��ǰ ����';
COMMENT ON COLUMN product.p_unit is '��ǰ �Ǹ� ����';
COMMENT ON COLUMN product.p_capacity is '��ǰ �뷮/�߷�';
COMMENT ON COLUMN product.p_delivery  is '��ǰ ��� ����';
COMMENT ON COLUMN product.p_allergy_info is '��ǰ �˷����� ����';
COMMENT ON COLUMN product.p_expiration_date is '��ǰ �������';
COMMENT ON COLUMN product.p_detailed is '��ǰ �� ����';

/**********************************/
/* Table Name: coupon */
/**********************************/
DROP TABLE coupon;

CREATE TABLE coupon(
      couponno                    NUMBER(10)       NOT NULL       PRIMARY KEY,
      coupon_name               VARCHAR2(100)    NOT NULL UNIQUE,           
      coupon_cost                 NUMBER(10)        NOT NULL                             
);

DROP SEQUENCE coupon_seq;

CREATE SEQUENCE coupon_seq
    START WITH 1                -- ���۹�ȣ
    INCREMENT BY 1            -- ������
    MAXVALUE 999999999     -- �ִ밪
    CACHE 2                         -- 2���� �޸𸮿����� ���
    NOCYCLE;                       -- �ٽ� 1���� �����Ǵ°��� ����
    
COMMENT ON TABLE coupon is '��ǰ';
COMMENT ON COLUMN coupon.couponno is '���� ��ȣ';
COMMENT ON COLUMN coupon.coupon_name is '���� �̸�';
COMMENT ON COLUMN coupon.coupon_cost is '���� ����';


INSERT INTO coupon(couponno, coupon_name, coupon_cost)
VALUES(coupon_seq.nextval, '1000�� ����', 1000);

INSERT INTO coupon(couponno, coupon_name, coupon_cost)
VALUES(coupon_seq.nextval, '3000�� ����', 3000);

INSERT INTO coupon(couponno, coupon_name, coupon_cost)
VALUES(coupon_seq.nextval, '5000�� ����', 5000);

INSERT INTO coupon(couponno, coupon_name, coupon_cost)
VALUES(coupon_seq.nextval, '10000�� ����', 10000);

SELECT couponno, coupon_name, coupon_cost, r
FROM (
        SELECT couponno, coupon_name, coupon_cost, rownum as r
        FROM coupon)
WHERE r >= 1 AND r <= 3;

DELETE FROM coupon
WHERE couponno = 1;

UPDATE coupon
SET coupon_name='�¿찡 ���!', coupon_cost=50000
WHERE couponno=6;

SELECT * FROM coupon;

SELECT coupon_name, coupon_cost
FROM coupon
WHERE coupon_name LIKE '%10000�� ����%';

commit;

/**********************************/
/* Table Name: coupon */
/**********************************/
DROP TABLE m_coupon;

CREATE TABLE m_coupon(
      m_couponno    NUMBER(10)       NOT NULL       PRIMARY KEY, 
      memberno       NUMBER(10)       NOT NULL,
      couponno        NUMBER(10)       NOT NULL,
      FOREIGN KEY (memberno) REFERENCES members (memberno),
      FOREIGN KEY (couponno) REFERENCES coupon (couponno) ON DELETE CASCADE
);

DROP SEQUENCE m_coupon_seq;

CREATE SEQUENCE m_coupon_seq
    START WITH 1                -- ���۹�ȣ
    INCREMENT BY 1            -- ������
    MAXVALUE 999999999     -- �ִ밪
    CACHE 2                         -- 2���� �޸𸮿����� ���
    NOCYCLE;                       -- �ٽ� 1���� �����Ǵ°��� ����
    
COMMENT ON TABLE m_coupon is '��ǰ';
COMMENT ON COLUMN m_coupon.m_couponno is 'ȸ���� ���� ��ȣ';
COMMENT ON COLUMN m_coupon.memberno is 'ȸ�� ��ȣ';
COMMENT ON COLUMN m_coupon.couponno is '���� ��ȣ';

INSERT INTO m_coupon(m_couponno, memberno, couponno)
VALUES(m_coupon_seq.nextval, 1, 1);

INSERT INTO m_coupon(m_couponno, memberno, couponno)
VALUES(m_coupon_seq.nextval, 1, 2);

INSERT INTO m_coupon(m_couponno, memberno, couponno)
VALUES(m_coupon_seq.nextval, 1, 3);

INSERT INTO m_coupon(m_couponno, memberno, couponno)
VALUES(m_coupon_seq.nextval, 1, 4);

SELECT * FROM m_coupon;
commit;
SELECT couponno, coupon_name, coupon_cost
FROM coupon
WHERE couponno IN (SELECT couponno FROM m_coupon
           WHERE memberno=1);

SELECT couponno FROM m_coupon
WHERE memberno=1;

commit;

/**********************************/
/* Table Name: ��ٱ��� */
/**********************************/

DROP TABLE basket;

CREATE TABLE basket (
    basketno                NUMBER(10)                      NOT NULL       PRIMARY KEY,
    memberno              NUMBER(10)                      NOT NULL,
    p_no                      NUMBER(10)                     NOT NULL,
    p_name                  VARCHAR2(100)                  NOT NULL,
    cnt                        NUMBER(10)                      NOT NULL,
    p_price                 NUMBER(10)                       NOT NULL,
    pay                       NUMBER(10)      DEFAULT 0   NOT NULL,
    thumb1                VARCHAR2(100)                     NOT NULL,
    p_quantity               NUMBER(10)                       NOT NULL,
    basket_date              DATE                                NOT NULL,
    FOREIGN KEY (p_no) REFERENCES product (p_no),
    FOREIGN KEY (memberno) REFERENCES members (memberno)
);

DROP SEQUENCE basket_seq;

CREATE SEQUENCE basket_seq
    START WITH 1                -- ���۹�ȣ
    INCREMENT BY 1            -- ������
    MAXVALUE 999999999     -- �ִ밪
    CACHE 2                         -- 2���� �޸𸮿����� ���
    NOCYCLE;                       -- �ٽ� 1���� �����Ǵ°��� ����
    
COMMENT ON TABLE basket is '��ٱ���';
COMMENT ON COLUMN basket.basketno is '��ٱ��� ��ȣ';
COMMENT ON COLUMN basket.memberno is 'ȸ�� ��ȣ';
COMMENT ON COLUMN basket.p_no is '��ǰ ��ȣ';
COMMENT ON COLUMN basket.p_name is '��ǰ�̸�';
COMMENT ON COLUMN basket.cnt is '��ǰ ����';
COMMENT ON COLUMN basket.p_price is '��ǰ ����';
COMMENT ON COLUMN basket.pay is '��ǰ �� ����';
COMMENT ON COLUMN basket.thumb1 is '��ǰ �����';
COMMENT ON COLUMN basket.p_quantity is '��ǰ ���';
COMMENT ON COLUMN basket.basket_date is '��ٱ��� ��� ����';

INSERT INTO basket(basketno, memberno, p_no, p_name, cnt, p_price, pay, thumb1, p_quantity, basket_date)
VALUES(basket_seq.nextval, 1, 1, '���¿��� ����', 3, 15000, 45000, 'tear.jpg', sysdate);

INSERT INTO basket(basketno, memberno, p_no, p_name, cnt, p_price, pay, thumb1, p_quantity, basket_date)
VALUES(basket_seq.nextval, 1, 2, '���¿��� ��ġ', 2, 6800, 13600, 'nunchi.jpg', sysdate);

INSERT INTO basket(basketno, memberno, p_no, p_name, cnt, p_price, pay, thumb1, p_quantity, basket_date)
VALUES(basket_seq.nextval, 1, 3, '���¿��� ����', 5, 4600, 23000, 'smile.jpg', sysdate);
commit;


SELECT * FROM basket;

DELETE FROM basket
WHERE memberno = 1;


/**********************************/
/* Table Name: ���� */
/**********************************/
DROP TABLE orders CASCADE CONSTRAINTS;

CREATE TABLE orders(
    ordersno               NUMBER(10)            NOT NULL  PRIMARY KEY,
    memberno             NUMBER(10)            NOT NULL,
    p_no                     VARCHAR(100)         NOT NULL,
    total_cost               NUMBER(10)           NOT NULL,
    pay_how                 VARCHAR2(20)        NOT NULL,
    coupon_name        VARCHAR2(100)         NULL,
    coupon_cost          NUMBER(10)             NULL,
    point_use               NUMBER(10)            NULL,
    deli_cost               NUMBER(10)             NULL,
    total_pay               NUMBER(10)            NOT NULL,
    point_acc               NUMBER(10)            NULL,
    name_post              VARCHAR2(10)          NOT NULL ,
    phon_post               VARCHAR2(15)         NOT NULL,
    zipcode                  VARCHAR(5)            NOT NULL, -- �����ȣ, 12345
    address1                VARCHAR(80)            NOT NULL, -- �ּ�
    address2                 VARCHAR(80)           NOT NULL, -- �� �ּ�
    name_get               VARCHAR2(10)           NOT NULL,
    phon_get                VARCHAR2(15)          NOT NULL ,
    request                  VARCHAR2(100)         NOT NULL,
    pay_date                 DATE                      NOT NULL,
    FOREIGN KEY (memberno) REFERENCES members (memberno)
);

DROP SEQUENCE orders_seq;

commit;
CREATE SEQUENCE orders_seq
    START WITH 1                -- ���۹�ȣ
    INCREMENT BY 1            -- ������
    MAXVALUE 999999999     -- �ִ밪
    CACHE 2                         -- 2���� �޸𸮿����� ���
    NOCYCLE;                       -- �ٽ� 1���� �����Ǵ°��� ����


COMMENT ON TABLE orders is '�ֹ� ����';
COMMENT ON COLUMN orders.ordersno is '������ȣ';
COMMENT ON COLUMN orders.memberno is 'ȸ����ȣ';
COMMENT ON COLUMN orders.p_no is '��ǰ��ȣ';
COMMENT ON COLUMN orders.total_cost is '�� �ݾ�';
COMMENT ON COLUMN orders.pay_how is '���� ����';
COMMENT ON COLUMN orders.coupon_name is '���� �̸�';
COMMENT ON COLUMN orders.coupon_cost is '���� ����';
COMMENT ON COLUMN orders.point_use is '����Ʈ ���';
COMMENT ON COLUMN orders.deli_cost is '��ۺ�';
COMMENT ON COLUMN orders.total_pay is '���� ���� �ݾ�';
COMMENT ON COLUMN orders.point_acc is '����Ʈ ����';
COMMENT ON COLUMN orders.name_post is '����� �̸�';
COMMENT ON COLUMN orders.phon_post is '����� ��ȣ';
COMMENT ON COLUMN orders.zipcode is '�����ȣ';
COMMENT ON COLUMN orders.address1 is '�ּ�';
COMMENT ON COLUMN orders.address2 is '�� �ּ�';
COMMENT ON COLUMN orders.name_get is '������ �̸�';
COMMENT ON COLUMN orders.phon_get is '������ ��ȣ';
COMMENT ON COLUMN orders.request is '��۽� ��û ����';
COMMENT ON COLUMN orders.pay_date is '������';



SELECT * FROM orders;
DELETE FROM orders;
commit;

/**********************************/
/* Table Name: �������� */
/**********************************/
DROP TABLE orders_detail;

CREATE TABLE orders_detail(
    orders_detailno         NUMBER(10)    NOT NULL  PRIMARY KEY,
    ordersno                 NUMBER(10)    NOT NULL,
    memberno              NUMBER(10)     NOT NULL,
    p_no                      NUMBER(10)      NOT NULL,
    p_name                  VARCHAR2(100)   NOT NULL,
    cnt                        NUMBER(10)       NOT NULL,
    p_price               NUMBER(10)       NOT NULL,
    pay                       NUMBER(10)       NOT NULL,
    thumb1                VARCHAR2(100)    NOT NULL,
    pay_date                DATE                 NOT NULL,
    FOREIGN KEY (ordersno) REFERENCES orders (ordersno),
    FOREIGN KEY (p_no) REFERENCES product (p_no),
    FOREIGN KEY (memberno) REFERENCES members (memberno)
);

COMMENT ON TABLE orders_detail is '��������';
COMMENT ON COLUMN orders_detail.orders_detailno is '�������ι�ȣ';
COMMENT ON COLUMN orders_detail.ordersno is '���� ��ȣ';
COMMENT ON COLUMN orders_detail.memberno is 'ȸ�� ��ȣ';
COMMENT ON COLUMN orders_detail.p_no is '��ǰ ��ȣ';
COMMENT ON COLUMN orders_detail.p_name is '��ǰ �̸�';
COMMENT ON COLUMN orders_detail.cnt is '����';
COMMENT ON COLUMN orders_detail.p_price is '�ݾ�';
COMMENT ON COLUMN orders_detail.pay is '�����ݾ�';
COMMENT ON COLUMN orders_detail.thumb1 is '�����';
COMMENT ON COLUMN orders_detail.pay_date is '������';

DROP SEQUENCE orders_detail_seq;

CREATE SEQUENCE orders_detail_seq
    START WITH 1                -- ���۹�ȣ
    INCREMENT BY 1            -- ������
    MAXVALUE 999999999     -- �ִ밪
    CACHE 2                         -- 2���� �޸𸮿����� ���
    NOCYCLE;                       -- �ٽ� 1���� �����Ǵ°��� ����
    
DELETE FROM orders_detail;
SELECT * FROM orders_detail;
commit;
/**********************************/
/* Table Name: ����Ʈ ����/��� */
/**********************************/
DROP TABLE points;

CREATE TABLE points(
    pointsno              NUMBER(10)  NOT NULL  PRIMARY KEY,
    memberno            NUMBER(10) NOT NULL,
    ordersno              NUMBER(10) NOT NULL,
    contents              VARCHAR(50) NOT NULL,
    point_change         NUMBER(10)  NOT NULL,
    points_date            DATE           NOT NULL,
    FOREIGN KEY (memberno) REFERENCES members (memberno),
    FOREIGN KEY (ordersno) REFERENCES orders (ordersno)
);

INSERT INTO points(pointsno, memberno, ordersno, contents, point_change, points_date)
VALUES(points_seq.nextval, 1, 1, '���¿��� ����', 2300, sysdate);

DROP SEQUENCE points_seq;

CREATE SEQUENCE points_seq
    START WITH 1                -- ���۹�ȣ
    INCREMENT BY 1            -- ������
    MAXVALUE 999999999     -- �ִ밪
    CACHE 2                         -- 2���� �޸𸮿����� ���
    NOCYCLE;                       -- �ٽ� 1���� �����Ǵ°��� ����


SELECT points_date FROM points;

SELECT pointsno, memberno, ordersno, contents, point_change, points_date, r
    FROM (
        SELECT pointsno, memberno, ordersno, contents, point_change, points_date, rownum as r
        FROM points)
    WHERE r >0 AND r <= 2;

COMMENT ON TABLE points is '����Ʈ';
COMMENT ON COLUMN points.poinstno is '����Ʈ ��ȣ';
COMMENT ON COLUMN points.memberno is 'ȸ����ȣ';
COMMENT ON COLUMN points.ordersno is '������ȣ';
COMMENT ON COLUMN points.contents is '����';
COMMENT ON COLUMN points.point_change is '����Ʈ �����ݾ�';
COMMENT ON COLUMN points.points_date is '����Ʈ ������';

commit;