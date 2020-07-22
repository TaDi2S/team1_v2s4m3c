/**********************************/
/* Table Name: ī�װ� */
/**********************************/
drop table cate_gory;
CREATE TABLE cate_gory(
		goryno                        	   NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		name                          	       VARCHAR2(100)		 NOT NULL,
		seqno                         		   NUMBER(10)		 DEFAULT 1		 NOT NULL,
		printout                       		   CHAR(1)		 DEFAULT 'Y'		 NOT NULL,
		rdate                           		   DATE		 NOT NULL,
		cnt                           	       NUMBER(10)		 DEFAULT 0		 NOT NULL
);

COMMENT ON TABLE cate_gory is 'ī�װ�';
COMMENT ON COLUMN cate_gory.goryno is 'ī�װ� ��ȣ';
COMMENT ON COLUMN cate_gory.name is 'ī�װ� �̸�';
COMMENT ON COLUMN cate_gory.seqno is '��� ����';
COMMENT ON COLUMN cate_gory.printout is '��� ���';
COMMENT ON COLUMN cate_gory.rdate is '�����';
COMMENT ON COLUMN cate_gory.cnt is '��ϵ� �� ��';

DROP SEQUENCE gory_seq;
CREATE SEQUENCE gory_seq
  START WITH 1              -- ���� ��ȣ
  INCREMENT BY 1          -- ������
  MAXVALUE 9999999999 -- �ִ밪: 9999999 --> NUMBER(7) ����
  CACHE 2                       -- 2���� �޸𸮿����� ���
  NOCYCLE;                     -- �ٽ� 1���� �����Ǵ� ���� ����
  
--���
INSERT INTO cate_gory(goryno, name, seqno, printout, rdate, cnt)
VALUES(gory_seq.nextval, '�����塤���ö�', 1 , 'Y', sysdate, 0);

INSERT INTO cate_gory(goryno, name, seqno, printout, rdate, cnt)
VALUES(gory_seq.nextval, '����ġ��õ���ǰ', 1 , 'Y', sysdate, 0);

INSERT INTO cate_gory(goryno, name, seqno, printout, rdate, cnt)
VALUES(gory_seq.nextval, '��������ǰ���Ｎ��ǰ', 1 , 'Y', sysdate, 0);

INSERT INTO cate_gory(goryno, name, seqno, printout, rdate, cnt)
VALUES(gory_seq.nextval, '���ġ��ø��󡤱׷����', 1 , 'Y', sysdate, 0);

INSERT INTO cate_gory(goryno, name, seqno, printout, rdate, cnt)
VALUES(gory_seq.nextval, '���Ρ�Ƣ�衤������', 1 , 'Y', sysdate, 0);

INSERT INTO cate_gory(goryno, name, seqno, printout, rdate, cnt)
VALUES(gory_seq.nextval, '�ס�����', 1 , 'Y', sysdate, 0);

--���
SELECT goryno, name, seqno, printout, rdate, cnt
FROM cate_gory
ORDER BY goryno ASC;

-- ����
DELETE FROM cate_gory
WHERE goryno = 1;
commit;

-- ��ȸ
SELECT goryno, name, seqno, printout, rdate, cnt
FROM cate_gory
WHERE goryno=3;

-- ����
UPDATE cate_gory
SET name='������'
WHERE goryno = 3;

-- ����
DELETE FROM cate_gory
WHERE goryno = 7;

--�� �� ����
UPDATE cate_gory 
SET cnt = cnt + 1 
WHERE goryno=1;

commit;

