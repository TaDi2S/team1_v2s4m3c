package dev.mvc.delivery;

public class DeliveryVO {

//  /**********************************/
//  /* Table Name: ��������� */
//  /**********************************/
//  DROP TABLE delivery; 
//  CREATE TABLE delivery(
//      deliveryno                        NUMBER(20)        NOT NULL       PRIMARY KEY,
//          stateno                              NUMBER(20)          DEFAULT 1       NOT NULL,
//      receiver                            VARCHAR2(50)       NOT NULL,
//          contact                           VARCHAR2(50)       NOT NULL,
//          contact2                          VARCHAR2(50)     NULL,
//      zipcode                           VARCHAR2(50)       NOT NULL,
//          address1                          VARCHAR2(100)      NOT NULL,
//          address2                          VARCHAR2(50)       NOT NULL,
//          FOREIGN KEY (stateno) REFERENCES deliverystate (stateno)
//  );
//
//  COMMENT ON TABLE delivery is '���';
//  COMMENT ON COLUMN delivery.deliveryno is '��۹�ȣ';
//  COMMENT ON COLUMN delivery.stateno is '��� ���� ��ȣ';
//  COMMENT ON COLUMN delivery.receiver is '������';
//  COMMENT ON COLUMN delivery.contact is '����ó';
//  COMMENT ON COLUMN delivery.contact2 is '����ó2';
//  COMMENT ON COLUMN delivery.zipcode is '���� ��ȣ';
//  COMMENT ON COLUMN delivery.address1 is '�ּ�';
//  COMMENT ON COLUMN delivery.address2 is '�� �ּ�';
  
  private int deliveryno;
  private int stateno;
  private String receiver;
  private String contact;
  private String contact2;
  private String zipcode;
  private String address1;
  private String address2;
  public int getDeliveryno() {
    return deliveryno;
  }
  public void setDeliveryno(int deliveryno) {
    this.deliveryno = deliveryno;
  }
  public int getStateno() {
    return stateno;
  }
  public void setStateno(int stateno) {
    this.stateno = stateno;
  }
  public String getReceiver() {
    return receiver;
  }
  public void setReceiver(String receiver) {
    this.receiver = receiver;
  }
  public String getContact() {
    return contact;
  }
  public void setContact(String contact) {
    this.contact = contact;
  }
  public String getContact2() {
    return contact2;
  }
  public void setContact2(String contact2) {
    this.contact2 = contact2;
  }
  public String getZipcode() {
    return zipcode;
  }
  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }
  public String getAddress1() {
    return address1;
  }
  public void setAddress1(String address1) {
    this.address1 = address1;
  }
  public String getAddress2() {
    return address2;
  }
  public void setAddress2(String address2) {
    this.address2 = address2;
  }
  
  
 
  
}