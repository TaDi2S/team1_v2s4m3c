/**********************************/
/* Table Name: �ݼ� */
/**********************************/
DROP TABLE resend;
CREATE TABLE resend(
		resendno                      		NUMBER(20)		 NOT NULL,
	    ordersno                                NUMBER(20)     NOT NULL,
		state                         		    VARCHAR2(50)		 NOT NULL,
		process                       		VARCHAR2(50)		 DEFAULT 'F'		 NOT NULL,
		rdate                         		    DATE		 NOT NULL 
);

COMMENT ON TABLE resend is '�ݼ�';
COMMENT ON COLUMN resend.resendno is '�ݼ۹�ȣ';
COMMENT ON COLUMN resend.ordersno is '������ȣ';
COMMENT ON COLUMN resend.state is '����';
COMMENT ON COLUMN resend.process is 'ó�� ����';
COMMENT ON COLUMN resend.rdate is '�����';


DROP SEQUENCE resend_seq;

CREATE SEQUENCE resend_seq
  START WITH 1              -- ���� ��ȣ
  INCREMENT BY 1          -- ������
  MAXVALUE 9999999999 -- �ִ밪: 9999999999 --> NUMBER(10) ����
  CACHE 2                       -- 2���� �޸𸮿����� ���
  NOCYCLE;                     -- �ٽ� 1���� �����Ǵ� ���� ����

--  1. ���

INSERT INTO resend(resendno, ordersno, state, process, rdate)
VALUES(resend_seq.nextval,  1, '�ݼ� ó�� ��', 'Y', sysdate);

INSERT INTO resend(resendno, ordersno, state, process, rdate)
VALUES(resend_seq.nextval,  2, '�ݼ� ó�� �Ϸ�', 'Y', sysdate);

INSERT INTO resend(resendno, ordersno, state, process, rdate)
VALUES(resend_seq.nextval,  3, '�ݼ� �Ұ�', 'F', sysdate);

-- 2. ���

SELECT resendno, ordersno, state, process, rdate
FROM resend
ORDER BY resendno DESC;

-- 3. ��ȸ

SELECT resendno, ordersno, state, process, rdate
FROM resend
WHERE resendno = 1;

-- 4. ����

UPDATE resend
SET state ='ó�� �� ���� �߻�', process='F'
WHERE resendno = 1;

SELECT resendno, ordersno, state, process, rdate
FROM resend
ORDER BY resendno ASC;

-- 5. ����

-- ��� ����

DELETE FROM resend;

 -- Ư�� ��� ����
 
DELETE FROM resend
WHERE resendno=1;


commit;