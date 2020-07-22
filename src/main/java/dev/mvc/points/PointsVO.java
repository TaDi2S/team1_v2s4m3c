package dev.mvc.points;

/*
CREATE TABLE points(
poinstno              NUMBER(10)  NOT NULL  PRIMARY KEY,
memberno            NUMBER(10) NOT NULL,
ordersno              NUMBER(10) NOT NULL,
contents              VARCHAR(50) NOT NULL,
point_change         NUMBER(10)  NOT NULL,
points_date            DATE           NOT NULL,
FOREIGN KEY (memberno) REFERENCES members (memberno),
FOREIGN KEY (ordersno) REFERENCES orders (ordersno)
);
 */
public class PointsVO {
  /** ����Ʈ ��� ��ȣ **/
  private int pointsno;
  /** ȸ�� ��ȣ **/
  private int memberno;
  /** �ֹ� ��ȣ **/
  private int ordersno;
  /** ���� **/
  private String contents;
  /** ����Ʈ ���� �ݾ� **/
  private int point_change;
  /** ����Ʈ ��� ��¥ **/
  private String points_date;
  
  public int getPointsno() {
    return pointsno;
  }
  public void setPointsno(int pointsno) {
    this.pointsno = pointsno;
  }
  public int getMemberno() {
    return memberno;
  }
  public void setMemberno(int memberno) {
    this.memberno = memberno;
  }
  public int getOrdersno() {
    return ordersno;
  }
  public void setOrdersno(int ordersno) {
    this.ordersno = ordersno;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
  public int getPoint_change() {
    return point_change;
  }
  public void setPoint_change(int point_change) {
    this.point_change = point_change;
  }
  public String getPoints_date() {
    return points_date;
  }
  public void setPoints_date(String points_date) {
    this.points_date = points_date;
  }
  
  
  
}