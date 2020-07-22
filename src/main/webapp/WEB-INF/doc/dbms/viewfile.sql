/**********************************/
/* Table Name: ÷������ */
/**********************************/
DROP TABLE viewfile;
CREATE TABLE viewfile(
        viewfileno                  NUMBER(10)         NOT NULL         PRIMARY KEY,
        p_no                        NUMBER(10)         NULL ,
        vname                      VARCHAR2(100)         NOT NULL,
        vupname                  VARCHAR2(100)         NOT NULL,
        thumb                      VARCHAR2(100)         NULL ,
        vsize                        NUMBER(10)         DEFAULT 0         NOT NULL,
        vdate                       DATE     NOT NULL,
  FOREIGN KEY (p_no) REFERENCES product (p_no)
);

COMMENT ON TABLE viewfile is '÷������';
COMMENT ON COLUMN viewfile.viewfileno is '÷�����Ϲ�ȣ';
COMMENT ON COLUMN viewfile.p_no is '��ǰ��ȣ';
COMMENT ON COLUMN viewfile.vname is '���� ���ϸ�';
COMMENT ON COLUMN viewfile.vupname is '���ε� ���ϸ�';
COMMENT ON COLUMN viewfile.thumb is 'Thumb ���ϸ�';
COMMENT ON COLUMN viewfile.vsize is '���� ������';
COMMENT ON COLUMN viewfile.vdate is '�����';

DROP SEQUENCE viewfile_seq;
CREATE SEQUENCE viewfile_seq
  START WITH 1              -- ���� ��ȣ
  INCREMENT BY 1          -- ������
  MAXVALUE 9999999999 -- �ִ밪: 9999999 --> NUMBER(7) ����
  CACHE 2                       -- 2���� �޸𸮿����� ���
  NOCYCLE;                     -- �ٽ� 1���� �����Ǵ� ���� ����
  
-- 1) ���
INSERT INTO viewfile(viewfileno, p_no, vname, vupname, thumb, vsize, vdate)
VALUES(attachfile_seq.nextval, 1, 'bin1.jpg', 'bin_1.jpg', 'bin_t.jpg', 1000, sysdate);

INSERT INTO viewfile(viewfileno, p_no, vname, vupname, thumb, vsize, vdate)
VALUES(attachfile_seq.nextval, 1, 'bin2.jpg', 'bin2_1.jpg', 'bin2_t.jpg', 2000, sysdate);

COMMIT;
             
-- 2) ���( contentsno ���� ���� ����, attachfileno ���� ��������)
SELECT viewfileno, p_no, vname, vupname, thumb, vsize, vdate
FROM viewfile
ORDER BY p_no DESC,  p_no ASC;

SELECT viewfileno, vname, vupname, thumb
FROM viewfile
ORDER BY p_no DESC,  p_no ASC;            

-- 3) �ۺ� ���� ���(contentsno ���� ���� ����, attachfileno ���� ��������)
SELECT viewfileno, p_no, vname, vupname, thumb, vsize, vdate
FROM viewfile
WHERE p_no = 1
ORDER BY vname ASC;

 ATTACHFILENO CONTENTSNO FNAME        FUPNAME      THUMB          FSIZE  RDATE
 ------------ ---------- ------------ ------------ -------------- ------ ---------------------
            1          1 car1.jpg     car1_0.jpg   car1_0_t.jpg    12099 2019-12-04 15:01:20.0
            2          1 car2.jpg     car2_0.jpg   car2_0_t.jpg    10553 2019-12-04 15:01:20.0
            3          1 car3.jpg     car3.jpg     car3_t.jpg       9208 2019-12-04 15:01:20.0
            4          1 car4.jpg     car4.jpg     car4_t.jpg      11819 2019-12-04 15:01:20.0
            5          1 car5.jpg     car5.jpg     car5_t.jpg       9976 2019-12-04 15:01:20.0
            9          1 moon.zip     moon.zip     NULL           292777 2019-12-05 10:14:12.0
            6          1 spring18.jpg spring18.jpg spring18_t.jpg 444455 2019-12-05 09:55:07.0
            7          1 spring19.jpg spring19.jpg spring19_t.jpg 126983 2019-12-05 09:55:07.0
            8          1 spring20.jpg spring20.jpg spring20_t.jpg 345322 2019-12-05 09:55:07.0

-- 4) �ϳ��� ���� ����
-- ��� ����
DELETE FROM viewfile;
COMMIT;

DELETE FROM viewfile
WHERE viewfileno = 4;


-- 5) FK contentsno �θ�Ű �� ��ȸ
SELECT attachfileno, contentsno, fname, fupname, thumb, fsize, rdate
FROM attachfile
WHERE contentsno=1;

ATTACHFILENO CONTENTSNO FNAME        FUPNAME      THUMB          FSIZE  RDATE
 ------------ ---------- ------------ ------------ -------------- ------ ---------------------
            1          1 car3.jpg     car3.jpg     car3_t.jpg       9208 2019-12-04 15:01:20.0
            2          1 car4.jpg     car4.jpg     car4_t.jpg      11819 2019-12-04 15:01:20.0
            3          1 car5.jpg     car5.jpg     car5_t.jpg       9976 2019-12-04 15:01:20.0

-- �θ�Ű�� ���� ����
SELECT COUNT(*) as cnt
FROM attachfile
WHERE contentsno=1;

 CNT
 ---
   3             
             
-- 6) FK �θ� ���̺� ���ڵ� ����
-- ��� ����
DELETE FROM attachfile;
COMMIT;

DELETE FROM attachfile
WHERE contentsno=1;

COMMIT;

  
-- 7) Contents, Attachfile join
    SELECT c.title, 
               a.attachfileno, a.contentsno, a.fname, a.fupname, a.thumb, a.fsize, a.rdate
    FROM contents c, attachfile a
    WHERE c.contentsno = a.contentsno
    ORDER BY c.contentsno DESC,  a.attachfileno ASC;
   
 TITLE     ATTACHFILENO CONTENTSNO FNAME        FUPNAME        THUMB            FSIZE  RDATE
 --------- ------------ ---------- ------------ -------------- ---------------- ------ ---------------------
 ũ��������            4          2 winter14.jpg winter14.jpg   winter14_t.jpg   160966 2019-12-17 12:43:24.0
 ũ��������            5          2 winter15.jpg winter15.jpg   winter15_t.jpg   180887 2019-12-17 12:43:24.0
 ũ��������            6          2 winter16.jpg winter16.jpg   winter16_t.jpg    53359 2019-12-17 12:43:24.0
 �ܿ� ����              1          1 winter01.jpg winter01_0.jpg winter01_0_t.jpg 171853 2019-12-17 12:42:46.0
 �ܿ� ����              2          1 winter02.jpg winter02_0.jpg winter02_0_t.jpg 176114 2019-12-17 12:42:47.0
 �ܿ� ����              3          1 winter03.jpg winter03_0.jpg winter03_0_t.jpg 192743 2019-12-17 12:42:47.0

-- 8) ��ȸ
SELECT viewfileno, p_no, vname, vupname, thumb, vsize, vdate
FROM viewfile
WHERE viewfileno=6;

commit;
