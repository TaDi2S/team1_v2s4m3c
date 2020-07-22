package dev.mvc.cate_gory;

/*
 CREATE TABLE cate_gory(
    goryno                             NUMBER(10)    NOT NULL    PRIMARY KEY,
    name                                   VARCHAR2(100)     NOT NULL,
    seqno                                NUMBER(10)    DEFAULT 1     NOT NULL,
    printout                             CHAR(1)     DEFAULT 'Y'     NOT NULL,
    rdate                                  DATE    NOT NULL,
    cnt                                    NUMBER(10)    DEFAULT 0     NOT NULL
);
 */

public class Cate_goryVO {
  /** ī�װ� ��ȣ */
  private int goryno;  
  /**  ī�װ� �̸� */
  private String name;
  /** ��� ���� */
  private int seqno;
  /** ��� ��� */
  private String printout;
  /** ����� */
  private String rdate;
  /** ��ϵ� �� �� */
  private int cnt;
  
  public Cate_goryVO() {
    
  }
  
  public Cate_goryVO(int goryno, String name, int seqno, String printout, String rdate, int cnt) {
    this.goryno = goryno;
    this.name = name;
    this.seqno = seqno;
    this.printout = printout;
    this.rdate = rdate;
    this.cnt = cnt;
  }

  public int getGoryno() {
    return goryno;
  }

  public void setGoryno(int goryno) {
    this.goryno = goryno;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getSeqno() {
    return seqno;
  }

  public void setSeqno(int seqno) {
    this.seqno = seqno;
  }

  public String getPrintout() {
    return printout;
  }

  public void setPrintout(String printout) {
    this.printout = printout;
  }

  public String getRdate() {
    return rdate;
  }

  public void setRdate(String rdate) {
    this.rdate = rdate;
  }

  public int getCnt() {
    return cnt;
  }

  public void setCnt(int cnt) {
    this.cnt = cnt;
  }
  
  
}
