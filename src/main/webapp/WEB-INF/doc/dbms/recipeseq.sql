/**********************************/
/* Table Name: �����Ǽ��� */
/**********************************/
DROP TABLE recipeseq;
CREATE TABLE recipeseq(
		recipeseqno                   		NUMBER(10)		 NOT NULL		 PRIMARY KEY,
		recipeno                      		NUMBER(10)		 NULL ,
		memberno                      		NUMBER(10)		 NULL ,
        contents                            VARCHAR2(1000)      NULL,
		file_seq                		VARCHAR2(100)		 NULL,
		thumb_seq               		VARCHAR2(100)		 NULL,
		size_seq                		NUMBER(10)		 NULL,
        step                           NUMBER(10)       DEFAULT 1     NULL,
		recipeseqseqno                		NUMBER(10)		 DEFAULT 1		 NOT NULL,
  FOREIGN KEY (recipeno) REFERENCES recipe (recipeno),
  FOREIGN KEY (memberno) REFERENCES members (memberno)
);

COMMENT ON TABLE recipeseq is '�����Ǽ���';
COMMENT ON COLUMN recipeseq.recipeseqno is '�����Ǽ�����ȣ';
COMMENT ON COLUMN recipeseq.recipeno is '�����ǹ�ȣ';
COMMENT ON COLUMN recipeseq.memberno is 'ȸ����ȣ';
COMMENT ON COLUMN recipeseq.contents is '����';
COMMENT ON COLUMN recipeseq.file_seq is '�����Ǽ������ϸ�';
COMMENT ON COLUMN recipeseq.thumb_seq is '�����Ǽ������Ͻ����';
COMMENT ON COLUMN recipeseq.size_seq is '�����Ǽ�������ũ��';
COMMENT ON COLUMN recipeseq.step is '�����ǽ��ܹ�ȣ';
COMMENT ON COLUMN recipeseq.recipeseqseqno is '�����Ǽ������Ĺ�ȣ';

DROP SEQUENCE recipeseq_seq;
CREATE SEQUENCE recipeseq_seq
  START WITH 1              -- ���� ��ȣ
  INCREMENT BY 1          -- ������
  MAXVALUE 9999999999 -- �ִ밪: 9999999 --> NUMBER(7) ����
  CACHE 2                       -- 2���� �޸𸮿����� ���
  NOCYCLE;                     -- �ٽ� 1���� �����Ǵ� ���� ����

SELECT * FROM recipe;
SELECT * FROM member;
SELECT * FROM recipeseq;

INSERT INTO recipeseq(recipeseqno, recipeno, memberno, contents, file3, thumb3, size3, recipeseqseqno)
VALUES(recipeseq_seq.nextval, 1, 1, '����1', '1.jpg', '1_t.jpg', 10, 1);

SELECT recipeseqno, recipeno, memberno, contents, file_seq, thumb_seq, size_seq, step, recipeseqseqno
FROM recipeseq
WHERE recipeno = 1;

commit;