package dev.mvc.coupon;


/*
 *CREATE TABLE coupon(
      couponno                    NUMBER(10)       NOT NULL       PRIMARY KEY,
      coupon_name               VARCHAR2(100)    NOT NULL,           
      coupon_cost                 NUMBER(10)        NOT NULL                             
);
 */
public class CouponVO {
  /** ���� ��ȣ **/
  private int couponno;
  /** ���� �̸� */
  private String coupon_name;
  /** ���� ���� **/
  private int coupon_cost;
  
  public int getCouponno() {
    return couponno;
  }
  public void setCouponno(int couponno) {
    this.couponno = couponno;
  }
  public String getCoupon_name() {
    return coupon_name;
  }
  public void setCoupon_name(String coupon_name) {
    this.coupon_name = coupon_name;
  }
  public int getCoupon_cost() {
    return coupon_cost;
  }
  public void setCoupon_cost(int coupon_cost) {
    this.coupon_cost = coupon_cost;
  }
  
}