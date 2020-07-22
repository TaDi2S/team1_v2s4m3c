/**********************************/
/* Table Name: �������� */
/**********************************/
CREATE TABLE announce(
		announceno NUMERIC(10) NOT NULL PRIMARY KEY,
		adminno NUMERIC(10) NOT NULL,
		atitle VARCHAR2(200) NOT NULL,
		acontent CLOB NOT NULL,
		mp3 VARCHAR2(1000),
		mp4 VARCHAR2(1000),
		isview VARCHAR2(1) DEFAULT 'Y' NOT NULL,
		keyword VARCHAR2(1000),
		adate DATE NOT NULL,
  FOREIGN KEY (adminno) REFERENCES admini (adminno)
);

COMMENT ON TABLE announce is '��������';
COMMENT ON COLUMN announce.announceno is '�������׹�ȣ';
COMMENT ON COLUMN announce.adminno is '�����ڹ�ȣ';
COMMENT ON COLUMN announce.atitle is '����';
COMMENT ON COLUMN announce.acontent is '����';
COMMENT ON COLUMN announce.mp3 is 'mp3';
COMMENT ON COLUMN announce.mp4 is 'mp4';
COMMENT ON COLUMN announce.isview is '���';
COMMENT ON COLUMN announce.keyword is 'Ű����';
COMMENT ON COLUMN announce.adate is '�ۼ���¥';

-- ���
INSERT INTO announce(announceno, adminno, atitle, acontent, mp3, mp4, isview, keyword, adate)
VALUES((SELECT NVL(MAX(announceno), 0)+1 as announceno FROM announce),
             1, '��ް���', '������', '', '', 'Y', '', sysdate);
             
INSERT INTO announce(announceno, adminno, atitle, acontent, mp3, mp4, isview, keyword, adate)
VALUES((SELECT NVL(MAX(announceno), 0)+1 as announceno FROM announce),
             1, '�ް�����', '������', '', '', 'Y', '', sysdate);
             
INSERT INTO announce(announceno, adminno, atitle, acontent, mp3, mp4, isview, keyword, adate)
VALUES((SELECT NVL(MAX(announceno), 0)+1 as announceno FROM announce),
             1, '��������', '����', '', '', 'Y', '', sysdate);
             
-- ���
SELECT announceno, adminno, acontent, isview, keyword, adate
FROM announce
ORDER BY announceno;

-- ��ȸ
SELECT announceno, adminno, atitle, acontent, mp3, mp4, isview, keyword, adate
FROM announce
WHERE announceno = 1;

-- ����
UPDATE announce
SET atitle='��������', acontent='����ô', mp3='none', mp4='none', isview='N', keyword='����'
WHERE announceno = 1;

-- ����
DELETE FROM announce
WHERE announceno = 1;

SELECT announceno, atitle, rn
FROM(
         SELECT announceno, atitle, rownum as rn
         FROM (
                   SELECT announceno, atitle 
                   FROM announce
                   ORDER BY announceno DESC
         )  
)
WHERE r>=1 AND r <=3;