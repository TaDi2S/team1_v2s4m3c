DROP TABLE blacklist;
CREATE TABLE blacklist(
		blacklistno NUMERIC(10) NOT NULL PRIMARY KEY,
		reason VARCHAR2(1000) DEFAULT 'none' NOT NULL,
		memberno NUMERIC(10) UNIQUE NOT NULL,
		adminno NUMERIC(10) NOT NULL,
		fromdate DATE NOT NULL,
		todate DATE NOT NULL,
  FOREIGN KEY (adminno) REFERENCES admini (adminno),
  FOREIGN KEY (memberno) REFERENCES members (memberno)
);

COMMENT ON TABLE blacklist is '������Ʈ';
COMMENT ON COLUMN blacklist.blacklistno is '������Ʈ��ȣ';
COMMENT ON COLUMN blacklist.reason is '����';
COMMENT ON COLUMN blacklist.memberno is 'ȸ����ȣ';
COMMENT ON COLUMN blacklist.adminno is '�����ڹ�ȣ';
COMMENT ON COLUMN blacklist.fromdate is '���糯¥';
COMMENT ON COLUMN blacklist.todate is '�������';

INSERT INTO blacklist(blacklistno, adminno, memberno, reason, fromdate, todate)
VALUES((SELECT NVL(MAX(blacklistno), 0)+1 as blacklistno FROM blacklist), 1, 1, '��ħ', sysdate, sysdate+3);

SELECT blacklistno, adminno, memberno, reason, fromdate, todate
FROM blacklist
ORDER BY fromdate DESC;

SELECT b.blacklistno, b.reason, b.fromdate, b.todate, b.memberno, b.adminno,
              m.memberno, m.id, m.mname, m.nickname, m.mdate, m.gradeno, 
              a.adminno, a.nickname as anickname
FROM blacklist b, admini a, members m 
WHERE b.memberno = m.memberno AND b.adminno = a.adminno
ORDER BY fromdate DESC;
    
UPDATE blacklist 
SET todate=todate+12
WHERE blacklistno = 3; 

DELETE FROM blacklist
WHERE blacklistno=3