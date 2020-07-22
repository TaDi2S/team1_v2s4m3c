DROP TABLE product;
CREATE TABLE product(
		p_no              	    NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		goryno                  NUMBER(10)		 NOT NULL,
        adminno                NUMBER(10)       NOT NULL,
		p_name                 VARCHAR2(100)		 NOT NULL,
		p_printout              CHAR(1)		 DEFAULT 'Y'		 NULL,
		p_date                   DATE		 NULL,
        p_price                  NUMBER(10)		 DEFAULT 0		NOT NULL,
        p_unit                    NUMBER(10)		 NULL,
        p_capacity               VARCHAR2(100)		 NULL,
        p_delivery                VARCHAR2(50)		 NULL,
        p_allergy_info           clob                  NULL,
        p_expiration_date      VARCHAR2(100)		NULL,
        p_detailed               clob      NULL,
        p_quantity               NUMBER(10)		DEFAULT 1  NOT NULL,
        hits                        NUMBER(7)    DEFAULT 0     NULL,
        searchword                    VARCHAR2(300)  NULL,
        file1                                   VARCHAR(100)          NULL,
        thumb1                              VARCHAR(100)          NULL,
        size1                                 NUMBER(10)      DEFAULT 0 NULL, 
     FOREIGN KEY (adminno) REFERENCES admini (adminno),
     FOREIGN KEY (goryno) REFERENCES cate_gory (goryno)
);

COMMENT ON TABLE product is '��ǰ';
COMMENT ON COLUMN product.p_no is '��ǰ ��ȣ';
COMMENT ON COLUMN product.goryno is 'ī�װ� ��ȣ';
COMMENT ON COLUMN product.adminno is 'ī�װ� ��ȣ';
COMMENT ON COLUMN product.p_name is '��ǰ �̸�';
COMMENT ON COLUMN product.p_printout is '��� ���';
COMMENT ON COLUMN product.p_date is '�����';
COMMENT ON COLUMN product.p_price is '��ǰ ����';
COMMENT ON COLUMN product.p_unit is '��ǰ �Ǹ� ����';
COMMENT ON COLUMN product.p_capacity is '��ǰ �뷮/�߷�';
COMMENT ON COLUMN product.p_delivery  is '��ǰ ��� ����';
COMMENT ON COLUMN product.p_allergy_info is '��ǰ �˷����� ����';
COMMENT ON COLUMN product.p_expiration_date is '������� �� �ȳ�����';
COMMENT ON COLUMN product.p_detailed is '��ǰ �� ����';
COMMENT ON COLUMN product.p_quantity is '��ǰ ��� ����';
COMMENT ON COLUMN product.hits is '��ȸ��';
COMMENT ON COLUMN product.searchword is '�˻���';
COMMENT ON COLUMN product.file1 is '���� �̹���';
COMMENT ON COLUMN product.thumb1 is '������ �̹���';
COMMENT ON COLUMN product.size1 is '���� �̹��� ũ��';

DROP SEQUENCE p_seq;
CREATE SEQUENCE p_seq
  START WITH 1              -- ���� ��ȣ
  INCREMENT BY 1          -- ������
  MAXVALUE 9999999999 -- �ִ밪: 9999999 --> NUMBER(7) ����
  CACHE 2                       -- 2���� �޸𸮿����� ���
  NOCYCLE;                     -- �ٽ� 1���� �����Ǵ� ���� ����
 
 
 --��ǰ ��� 
INSERT INTO product(p_no,  goryno, adminno, p_name, p_printout, p_date, p_price, p_unit,
                    p_capacity, p_delivery, p_allergy_info, p_expiration_date, p_detailed, p_quantity,
                    searchword,file1, thumb1, size1)
VALUES(p_seq.nextval, 1, 1, '[�� �ǰ���]������ġ ��', 'Y', sysdate, 1980, 1,
                    '������� ONLY', '������174g/�ҽ�30g',
                    '*������ -���, ��, ����, �丶��, �߰�� ���� /*�ҽ� -���, �� ����',
                    '������ ���� 3�� �̻� ���� ��ǰ�� �����帳�ϴ�.',
                    '������ ���� �״�� ���� �佺�並 ����̸� � �����̵� ǳ�̰� ���� Ȯ ���', 1,
                    '��', 'product.jpg', 'product_t.jpg',23657);               

--��ü ���
SELECT p_no, goryno, p_name, p_printout, p_date, p_price, p_unit,
       p_capacity, p_delivery, p_allergy_info, p_expiration_date, p_detailed, p_quantity,searchword,file1, thumb1, size1
FROM product
ORDER BY p_no DESC;

-- ���� sequence�� Ȯ��
SELECT p_seq.nextval FROM dual;
SELECT p_seq.currval FROM dual;

-- ��ȸ
SELECT p_no, goryno, p_name, p_printout, p_date, p_price, p_unit,
       p_capacity, p_delivery, p_allergy_info, p_expiration_date, p_detailed, p_quantity
FROM product
WHERE p_no=1;

--ī�װ� �� ��ǰ ���
-- cate_gory �� product ���: cate_gory + product inner join,  1 : ��, ���� VO -->
SELECT c.goryno as c_goryno, c.name as c_name,
       p.p_no, p.p_name, p.p_date, p.p_printout
FROM cate_gory c, product p
WHERE c.goryno = p.goryno
ORDER BY c.goryno ASC, p.p_no ASC;

--��ǰ /  ���� ����
SELECT p.p_no as p_p_no, 
           r.reviewno as r_reviewno, r.title as r_title, 
           r.memberno as r__memberno, r.nickname as r_nickname, r.rdate as r_rdate
FROM product p, review r
WHERE p.p_no = r.p_no
ORDER BY r.reviewno DESC;
      



SELECT COUNT(*) as cnt
FROM product
WHERE goryno=1;



commit;
