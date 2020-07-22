
/**********************************/
/* Table Name: ������ī�װ� */
/**********************************/
DROP TABLE recipecate;
CREATE TABLE recipecate(
		recipecateno                  		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		recipecategrpno               		NUMBER(10)		 NULL ,
		name                          		VARCHAR2(100)		 NOT NULL,
		seqno                         		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		visible                       		CHAR(1)		 DEFAULT 'Y'		 NOT NULL,
        cnt                                NUMBER(10)            DEFAULT 0      NOT NULL,
		rdate                         		DATE		 NOT NULL,
  FOREIGN KEY (recipecategrpno) REFERENCES recipecategrp (recipecategrpno)
);

COMMENT ON TABLE recipecate is '������ī�װ�';
COMMENT ON COLUMN recipecate.recipecateno is '������ī�װ���ȣ';
COMMENT ON COLUMN recipecate.recipecategrpno is '������ī�װ��׷��ȣ';
COMMENT ON COLUMN recipecate.name is '�̸�';
COMMENT ON COLUMN recipecate.seqno is '��¼���';
COMMENT ON COLUMN recipecate.visible is '��¼���';
COMMENT ON COLUMN recipecate.rdate is '�����';

DROP SEQUENCE recipecate_seq;
CREATE SEQUENCE recipecate_seq
  START WITH 1              -- ���� ��ȣ
  INCREMENT BY 1          -- ������
  MAXVALUE 9999999999 -- �ִ밪: 9999999 --> NUMBER(7) ����
  CACHE 2                       -- 2���� �޸𸮿����� ���
  NOCYCLE;                     -- �ٽ� 1���� �����Ǵ� ���� ����

INSERT INTO recipecate(recipecateno, recipecategrpno, name, seqno, visible, cnt, rdate)
VALUES(recipecate_seq.nextval, 1, '������ī�װ�', 1, 'Y', 0, sysdate);

commit;
  
SELECT * FROM recipecate;
  