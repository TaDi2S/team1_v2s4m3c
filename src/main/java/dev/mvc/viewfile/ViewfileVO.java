package dev.mvc.viewfile;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ViewfileVO {
/*
 CREATE TABLE viewfile(
        viewfileno                  NUMBER(10)         NOT NULL         PRIMARY KEY,
        p_no                        NUMBER(10)         NULL ,
        vname                      VARCHAR2(100)         NOT NULL,
        vupname                  VARCHAR2(100)         NOT NULL,
        thumb                      VARCHAR2(100)         NULL ,
        vsize                        NUMBER(10)         DEFAULT 0         NOT NULL,
        vdate                       DATE     NOT NULL,
  FOREIGN KEY (p_no) REFERENCES product (p_no));
 */
  /** ÷�����Ϲ�ȣ*/
  private int viewfileno;
  /** ��ǰ ��ȣ(FK)*/
  private int p_no;
  /** ���� ���ϸ�*/
  private String vname;
  /** ���ε� ���ϸ�*/
  private String vupname;
  /** Thumb ���ϸ�*/
  private String thumb;
  /** ���� ������*/
  private long vsize;
  /** �����*/
  private String vdate;
  /** Form�� ������ MultipartFile�� ��ȯ�Ͽ� List�� ����  */
  private List<MultipartFile> vnamesMF;
  /** ���� ���� ��� */
  private String vlabel;
  
  public int getViewfileno() {
    return viewfileno;
  }
  public void setViewfileno(int viewfileno) {
    this.viewfileno = viewfileno;
  }
  public int getP_no() {
    return p_no;
  }
  public void setP_no(int p_no) {
    this.p_no = p_no;
  }
  public String getVname() {
    return vname;
  }
  public void setVname(String vname) {
    this.vname = vname;
  }
  public String getVupname() {
    return vupname;
  }
  public void setVupname(String vupname) {
    this.vupname = vupname;
  }
  public String getThumb() {
    return thumb;
  }
  public void setThumb(String thumb) {
    this.thumb = thumb;
  }
  public long getVsize() {
    return vsize;
  }
  public void setVsize(long vsize) {
    this.vsize = vsize;
  }
  public List<MultipartFile> getVnamesMF() {
    return vnamesMF;
  }
  public void setVnamesMF(List<MultipartFile> vnamesMF) {
    this.vnamesMF = vnamesMF;
  }
  public String getVlabel() {
    return vlabel;
  }
  public void setVlabel(String vlabel) {
    this.vlabel = vlabel;
  }
  public String getVdate() {
    return vdate;
  }
  public void setVdate(String vdate) {
    this.vdate = vdate;
  }
  
}
