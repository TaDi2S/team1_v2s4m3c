/**********************************/
/* Table Name: ȸ�� */
/**********************************/
DROP TABLE members;
CREATE TABLE members (
  memberno NUMBER(7)     NOT NULL, -- ȸ����ȣ, ���ڵ带 �����ϴ� �÷�
  gradeno  NUMBER(7)     NOT NULL, -- ��� ��ȣ
  id       VARCHAR(20)   NOT NULL UNIQUE, -- ���̵�, 4�� �̻�, �ߺ� �Ұ�
  passwd   VARCHAR(60)   NOT NULL, -- ��й�ȣ, ����/���� ����, �ߺ� �Ұ�, 6�� �̻�
  mname    VARCHAR(20)   NOT NULL, -- ȸ�� �̸�, �ѱ� 10�� ���� ����
  nickname VARCHAR(20)   NOT NULL UNIQUE, -- �г���
  email    VARCHAR(60)   NOT NULL UNIQUE, -- �̸��� �ּ�, �ߺ� �Ұ�
  tel      VARCHAR(14)   NOT NULL, -- ��ȭ��ȣ, �ߺ� �Ұ�
  zipcode  VARCHAR(5)    NULL, -- �����ȣ, 12345
  address1 VARCHAR(80)   NULL, -- �ּ�
  address2 VARCHAR(80)   NULL, -- �� �ּ�
  birth    VARCHAR(14)   NULL, -- �������
  points   NUMBER(7)     NOT NULL, -- ������
  mdate    DATE          NOT NULL, -- ������
  PRIMARY KEY (memberno),
  FOREIGN KEY (gradeno) REFERENCES grade (gradeno)
);

COMMENT ON TABLE members is 'ȸ��';
COMMENT ON COLUMN members.memberno is 'ȸ�� ��ȣ';
COMMENT ON COLUMN members.id is '���̵�';
COMMENT ON COLUMN members.passwd is '��� ��ȣ';
COMMENT ON COLUMN members.mname is 'ȸ�� �̸�';
COMMENT ON COLUMN members.nickname is '�г���';
COMMENT ON COLUMN members.email is '�̸���';
COMMENT ON COLUMN members.tel is '��ȭ ��ȣ';
COMMENT ON COLUMN members.zipcode is '���� ��ȣ';
COMMENT ON COLUMN members.address1 is '�ּ�';
COMMENT ON COLUMN members.address2 is '�� �ּ�';
COMMENT ON COLUMN members.birth is '�������';
COMMENT ON COLUMN members.gradeno is 'ȸ�� ���';
COMMENT ON COLUMN members.points is '������';
COMMENT ON COLUMN members.mdate is '������';

DROP SEQUENCE members_seq;
CREATE SEQUENCE members_seq
    START WITH 1                -- ���۹�ȣ
    INCREMENT BY 1            -- ������
    MAXVALUE 999999999     -- �ִ밪
    CACHE 2                         -- 2���� �޸𸮿����� ���
    NOCYCLE;                       -- �ٽ� 1���� �����Ǵ°��� ����
 
 -- �ߺ� Ȯ��
 1) id �ߺ� Ȯ��
SELECT COUNT(id) as cnt
FROM members
WHERE id='user1';
 
2) e-mail �ߺ� Ȯ��
SELECT COUNT(id) as cnt
FROM members
WHERE email='user1';

-- ���
INSERT INTO members(memberno, gradeno, id, passwd, mname, nickname, email, tel, zipcode, address1, address2, birth, points, mdate)
VALUES (members_seq.nextval, 1, 'user1', '1234', '����', '�Ϻ�', 'aaa@email.com', '000-0000-0000', '12345', '��⵵ �����ν�', '101��', '1995-01-01', 0, sysdate);

INSERT INTO members(memberno, gradeno, id, passwd, mname, nickname, email, tel, zipcode, address1, address2, birth, points, mdate)
VALUES (members_seq.nextval, 2, 'user2', '1234', '������', '�̺�', 'bbb@email.com', '000-0000-0001', '12345', '��⵵ ������', '102��', '2000-01-01', 0, sysdate);

INSERT INTO members(memberno, gradeno, id, passwd, mname, nickname, email, tel, zipcode, address1, address2, birth, points, mdate)
VALUES (members_seq.nextval, 3, 'user3', '1234', '�ڹڹ�', '���', 'ccc@email.com', '000-0000-0002', '12345', '��⵵ ��⵵', '103��', '2005-01-01', 0, sysdate);

-- ��ȸ
SELECT memberno, gradeno, id, passwd, mname, nickname, email, tel, zipcode, address1, address2, birth, points, mdate
FROM members
ORDER BY memberno ASC;

-- ����
UPDATE members
SET passwd='0000', email='111@email.com', tel='111-1111-1111', zipcode='22222', address1='�����ν�', address2='������'
WHERE memberno = 1;

-- �н����� �˻�
SELECT COUNT(*) as passwd_cnt
FROM members
WHERE memberno = 1 AND passwd = '1234';

-- ����
DELETE FROM members
WHERE memberno = 1;

-- ��� ���ڵ� ����
SELECT COUNT(*) as count
FROM members;

commit;
