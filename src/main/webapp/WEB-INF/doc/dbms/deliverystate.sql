/**********************************/
/* Table Name: ��� ���� */
/**********************************/
DROP TABLE deliverystate CASCADE CONSTRAINTS;
CREATE TABLE deliverystate(
        stateno                              NUMBER(20)           NOT NULL  PRIMARY KEY,
		state                                 VARCHAR2(50)		 NOT NULL
        
);

COMMENT ON TABLE deliverystate is '��� ����';
COMMENT ON COLUMN deliverystate.stateno is '��� ���� ��ȣ';
COMMENT ON COLUMN deliverystate.state is '��� ����';



DROP SEQUENCE deliverystate_seq;

CREATE SEQUENCE deliverystate_seq
  START WITH 1              -- ���� ��ȣ
  INCREMENT BY 1          -- ������
  MAXVALUE 9999999999 -- �ִ밪: 9999999999 --> NUMBER(10) ����
  CACHE 2                       -- 2���� �޸𸮿����� ���
  NOCYCLE;                     -- �ٽ� 1���� �����Ǵ� ���� ����
  
  
-- ���  
INSERT INTO deliverystate(stateno, state)
VALUES(deliverystate_seq.nextval,  '���� �Ϸ�');

INSERT INTO deliverystate(stateno, state)
VALUES(deliverystate_seq.nextval,  '��� �غ� ��');

INSERT INTO deliverystate(stateno, state)
VALUES(deliverystate_seq.nextval,  '��� ��');

INSERT INTO deliverystate(stateno, state)
VALUES(deliverystate_seq.nextval,  '��� �Ϸ�');

INSERT INTO deliverystate(stateno, state)
VALUES(deliverystate_seq.nextval,  '���� �Ϸ�');

-- ���
SELECT stateno, state
FROM deliverystate
ORDER BY stateno DESC;

-- ��ȸ

SELECT stateno, state
FROM deliverystate
WHERE stateno = 1;

-- ����

UPDATE deliverystate
SET state = '��� ��'
WHERE stateno = 1;

SELECT stateno, state
FROM deliverystate
ORDER BY stateno ASC;

commit;
--���� 

-- ��� ����

DELETE FROM deliverystate;

 -- Ư�� ��� �� ��� ����
 
DELETE FROM deliverystate
WHERE stateno=3;

commit;