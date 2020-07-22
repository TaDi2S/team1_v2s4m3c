/**********************************/
/* Table Name: ��ȯ �� ȯ�� ���� */
/**********************************/
DROP TABLE change;
CREATE TABLE change(
		changeno                      		NUMBER(20)		 NOT NULL,
		ordersno                         		NUMBER(20)		 NOT NULL,
		memberno                      		NUMBER(20)		 NOT NULL,
        producename                      VARCHAR2(100)         NOT NULL,
		pricecode                     		VARCHAR2(100)		 NOT NULL,
		changecnt                           NUMBER(20)		 NOT NULL,
		process                       		VARCHAR2(100)		 DEFAULT 'F'		 NOT NULL,
		rdate                         		DATE		 NOT NULL
);

COMMENT ON TABLE change is '��ȯ �� ȯ�� ����';
COMMENT ON COLUMN change.changeno is '������ȣ';
COMMENT ON COLUMN change.ordersno is '������ȣ';
COMMENT ON COLUMN change.memberno is 'ȸ����ȣ';
COMMENT ON COLUMN change.producename is '��ǰ �̸�';
COMMENT ON COLUMN change.pricecode is '��ǰ �ֹ� �ڵ�';
COMMENT ON COLUMN change.changecnt is '��ȯ �� ȯ�� ����';
COMMENT ON COLUMN change.process is 'ó�� ����';
COMMENT ON COLUMN change.rdate is '�����';



DROP SEQUENCE change_seq;

CREATE SEQUENCE change_seq
  START WITH 1              -- ���� ��ȣ
  INCREMENT BY 1          -- ������
  MAXVALUE 9999999999 -- �ִ밪: 9999999999 --> NUMBER(10) ����
  CACHE 2                       -- 2���� �޸𸮿����� ���
  NOCYCLE;                     -- �ٽ� 1���� �����Ǵ� ���� ����
  
 
-- 1. ���
INSERT INTO change(changeno, ordersno, memberno, producename, pricecode, changecnt, process, rdate)
VALUES(change_seq.nextval, 1, 327,  '��ټ�', '2FTX-3F1', 6, 'Y', sysdate);

INSERT INTO change(changeno, ordersno, memberno, producename, pricecode, changecnt, process, rdate)
VALUES(change_seq.nextval, 2, 129,  '��ī�ݶ�', '2FF3X-3F1', 1, 'F', sysdate);

INSERT INTO change(changeno, ordersno, memberno, producename, pricecode, changecnt, process, rdate)
VALUES(change_seq.nextval, 3, 132,  '����', '2F324DX-3F1', 2, 'F', sysdate);

-- 2. ���

SELECT changeno, ordersno, memberno, producename, pricecode, changecnt, process, rdate
FROM change
ORDER BY changeno DESC;



-- 3. ��ȸ

SELECT changeno, ordersno, memberno, producename, pricecode, changecnt, process, rdate
FROM change
WHERE changeno = 1;

-- 4. ���� 

UPDATE change
SET changecnt =3 , PROCESS ='Y'
WHERE changeno = 1;

-- 5. ����

-- ��� ����

DELETE FROM change;

 -- Ư�� ��� ����
 
DELETE FROM change
WHERE changeno=1; 

commit;