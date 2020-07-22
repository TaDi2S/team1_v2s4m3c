DROP TABLE pay;
CREATE TABLE pay(
		payno                           NUMBER(10)		        NOT NULL		 PRIMARY KEY,
		memberno                     NUMBER(10)		        NOT NULL,
        productno                     NUMBER(10)		        NOT NULL,
		totalcost                       NUMBER(10)		        NOT NULL,
        quantity                       NUMBER(10)		        NOT NULL,
        rdate                           DATE                        NOT NULL,
        FOREIGN KEY (memberno) REFERENCES member (memberno),
        FOREIGN KEY (productno) REFERENCES product (p_no)
);

COMMENT ON TABLE pay is '����';
COMMENT ON COLUMN pay.payno is '������ȣ';
COMMENT ON COLUMN pay.memberno is 'ī�װ� �׷� ��ȣ';
COMMENT ON COLUMN pay.productno is '��ǰ��ȣ';
COMMENT ON COLUMN pay.totalcost is '�ݾ�';
COMMENT ON COLUMN pay.quantity is '����';
COMMENT ON COLUMN pay.rdate is '������';

commit;