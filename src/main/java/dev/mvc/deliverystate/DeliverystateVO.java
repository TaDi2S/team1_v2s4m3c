package dev.mvc.deliverystate;

public class DeliverystateVO {

  //  CREATE TABLE deliverystate(
  //  stateno                              NUMBER(20)        NOT NULL  PRIMARY KEY,
  //  state                                 VARCHAR2(50)     NOT NULL
  //      
  //);
  //
  //COMMENT ON TABLE deliverystate is '��� ����';
  //COMMENT ON COLUMN deliverystate.stateno is '��� ���� ��ȣ';
  //COMMENT ON COLUMN deliverystate.state is '��� ����';

  private int stateno;
  private String state;
  public int getStateno() {
    return stateno;
  }
  public void setStateno(int stateno) {
    this.stateno = stateno;
  }
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }


}