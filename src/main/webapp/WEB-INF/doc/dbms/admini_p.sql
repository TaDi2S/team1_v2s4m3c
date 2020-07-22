/**********************************/
/* Table Name: ������ */
/**********************************/
DROP TABLE admini;
CREATE TABLE admini(
adminno                        NUMBER(10)  NOT NULL  PRIMARY KEY,
name                           VARCHAR2(16)  NOT NULL,
identify                             VARCHAR2(20)  NOT NULL,
passwd                         VARCHAR2(20)  NOT NULL,
nickname                       VARCHAR2(32)  NOT NULL,
acclevel                          NUMBER(1)  NOT NULL,
phone                          VARCHAR2(13)  NOT NULL,
email                          VARCHAR2(30) NULL,
picture                         VARCHAR2(1000) NULL,
signupdate                    DATE NOT NULL,
othersdetail                    VARCHAR2(1000) NULL
);

COMMENT ON TABLE admini is '������';
COMMENT ON COLUMN admini.adminno is '�����ڹ�ȣ';
COMMENT ON COLUMN admini.name is '�̸�';
COMMENT ON COLUMN admini.identify is 'ID';
COMMENT ON COLUMN admini.passwd is '��й�ȣ';
COMMENT ON COLUMN admini.nickname is '�г���';
COMMENT ON COLUMN admini.acclevel is '���� ����';
COMMENT ON COLUMN admini.phone is '����ó';
COMMENT ON COLUMN admini.email is '�̸���';
COMMENT ON COLUMN admini.picture is '����';
COMMENT ON COLUMN admini.signupdate is '������';
COMMENT ON COLUMN admini.othersdetail is '���';

DROP SEQUENCE admini_seq;
CREATE SEQUENCE admini_seq
    START WITH 1            -- ���۹�ȣ
    INCREMENT BY 1        --������
    MAXVALUE 9999999    --�ִ밪: 9999999 --> NUMBER(7)
    CACHE 2                     --2���� �޸𸮿����� ���
    NOCYCLE;                   --�ٽ� 1���� �����Ǵ� ���� ����

-- ���
INSERT INTO admini(adminno, name, identify, passwd, nickname, acclevel, phone, email, signupdate)
VALUES(admini_seq.nextval, '�ֽÿ�', 'cso0001', '1234', 'CSO', '1', '010-5678-9012', 'cso0001@example.net', sysdate);

INSERT INTO admini(adminno, name, identify, passwd, nickname, acclevel, phone, email, signupdate)
VALUES(admini_seq.nextval, '�Ⱥ���', 'abl0001', '1234', 'AD_ABL', '1', '010-1234-5678', 'abl0001@example.net', sysdate);

INSERT INTO admini(adminno, name, identify, passwd, nickname, acclevel, phone, signupdate)
VALUES(admini_seq.nextval, '�赵��', 'kdy0001', '1234', 'AD_KDY', '1', '010-3456-7890', sysdate);

-- ���
SELECT adminno, name, identify, passwd, nickname, acclevel, phone
FROM admini
ORDER BY adminno;

-- 1�� ��ȸ
SELECT adminno, name, identify, passwd, nickname, acclevel, phone, email, picture, signupdate
FROM admini
WHERE adminno = 1;

-- adminno �ִ밪 ����
SELECT MAX(adminno) as MAXNO
FROM admini

-- ����
UPDATE admini
SET acclevel=2
WHERE adminno = 1;

-- ����
DELETE FROM admini
WHERE adminno = 1;

UPDATE admini
  SET acclevel=acclevel-1
  WHERE adminno = 16

commit;