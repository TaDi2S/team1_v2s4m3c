/**********************************/
/* Table Name: ��� */
/**********************************/
DROP TABLE delivery; 
CREATE TABLE delivery(
		deliveryno                    		NUMBER(20)		    NOT NULL       PRIMARY KEY,
        stateno                              NUMBER(20)          DEFAULT 1       NOT NULL,
		receiver                         		VARCHAR2(50)	     NOT NULL,
        contact                        		VARCHAR2(50)	     NOT NULL,
        contact2                      		VARCHAR2(50)		 NULL,
		zipcode                       		VARCHAR2(50)	     NOT NULL,
        address1                       		VARCHAR2(100)	     NOT NULL,
        address2                       		VARCHAR2(50)	     NOT NULL,
        FOREIGN KEY (stateno) REFERENCES deliverystate (stateno)
);

COMMENT ON TABLE delivery is '���';
COMMENT ON COLUMN delivery.deliveryno is '��۹�ȣ';
COMMENT ON COLUMN delivery.stateno is '��� ���� ��ȣ';
COMMENT ON COLUMN delivery.receiver is '������';
COMMENT ON COLUMN delivery.contact is '����ó';
COMMENT ON COLUMN delivery.contact2 is '����ó2';
COMMENT ON COLUMN delivery.zipcode is '���� ��ȣ';
COMMENT ON COLUMN delivery.address1 is '�ּ�';
COMMENT ON COLUMN delivery.address2 is '�� �ּ�';

DROP SEQUENCE delivery_seq;

CREATE SEQUENCE delivery_seq
  START WITH 1              
  INCREMENT BY 1          
  MAXVALUE 9999999999 
  CACHE 2                       
  NOCYCLE;                     
  
-- 1. ���
INSERT INTO delivery(deliveryno, stateno, receiver, contact, zipcode, address1, address2)
VALUES(delivery_seq.nextval,  1, 'a', '010-1111-1111', '02-451',  'a', 'a');


-- 2. ���

SELECT deliveryno, stateno, receiver, contact, zipcode, address1, address2
FROM delivery
ORDER BY deliveryno DESC;

-- 3. ��ȸ

SELECT deliveryno, stateno, receiver, contact, zipcode, address1, address2
FROM delivery
WHERE deliveryno = 1;

-- 4. ����

UPDATE delivery
SET stateno=2, receiver='b', contact ='010-1234-5678', zipcode='031-123', address1='b', address2='c'
WHERE deliveryno = 1;

-- 5. ����

-- ��ü ����

DELETE FROM delivery;

 -- Ư�� �κ� ����
 
DELETE FROM delivery
WHERE deliveryno=1;


commit;
