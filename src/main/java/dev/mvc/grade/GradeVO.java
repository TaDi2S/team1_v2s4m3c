package dev.mvc.grade;

public class GradeVO {
/*
  gradeno  NUMBER(7)     NOT NULL,   -- ��� ��ȣ
  gname    VARCHAR(20)   NOT NULL,   -- ��� �̸�
  accum    NUMBER(3,2)   NOT NULL,   -- ������
  PRIMARY KEY (gradeno)
 */
  
  /** ��� ��ȣ */
  private int gradeno;
  /** ��� �̸� */
  private String gname = "";
  /** ������ */
  private float accum;
  
  public int getGradeno() {
    return gradeno;
  }
  public void setGradeno(int gradeno) {
    this.gradeno = gradeno;
  }
  public String getGname() {
    return gname;
  }
  public void setGname(String gname) {
    this.gname = gname;
  }
  public float getAccum() {
    return accum;
  }
  public void setAccum(float accum) {
    this.accum = accum;
  }
  
  
}
