package dev.mvc.orders;


/*
 * CREATE TABLE orders(
    ordersno               NUMBER(10)            NOT NULL  PRIMARY KEY,
    memberno             NUMBER(10)            NOT NULL,
    p_no                     VARCHAR(100)         NOT NULL,
    total_cost               NUMBER(10)           NOT NULL,
    pay_how                 VARCHAR2(20)        NOT NULL,
    coupon_name        VARCHAR2(100)        NULL,
    coupon_cost          NUMBER(10)             NULL,
    point_use               NUMBER(10)            NULL,
    deli_cost               NUMBER(10)             NULL,
    total_pay               NUMBER(10)           NOT NULL,
    point_acc               NUMBER(10)            NULL,
    name_post              VARCHAR2(10)          NOT NULL ,
    phon_post               VARCHAR2(15)         NOT NULL,
    zipcode                  VARCHAR(5)            NOT NULL, 
    address1                VARCHAR(80)            NOT NULL, 
    address2                 VARCHAR(80)           NOT NULL,
    name_get               VARCHAR2(10)           NOT NULL,
    phon_get                VARCHAR2(15)          NOT NULL ,
    request                  VARCHAR2(100)         NOT NULL,
    pay_date                 DATE                      NOT NULL,
      FOREIGN KEY (memberno) REFERENCES members (memberno)
);
 */
public class OrdersVO {
  /** �ֹ� ��ȣ **/
  private int ordersno;
  /** ��� ��ȣ **/
  private int memberno;
  /** ��ǰ ��ȣ **/
  private String p_no;
  /** �� ��ǰ �ݾ� **/
  private int total_cost;
  /** ���� ��� **/
  private String pay_how;
  /** ���� ��� **/
  private String coupon_name;
  /** �� ���� �ݾ� **/
  private int coupon_cost;
  /** �� ����Ʈ ��� �ּ� **/
  private int point_use;
  /** ��ۺ� **/
  private int deli_cost;
  /**  �� ���� �ݾ� */
  private int total_pay;
  /** �� ����Ʈ ���� **/
  private int point_acc;
  /** ����� �̸� **/
  private String name_post;
  /** ����� ��ȣ */
  private String phon_post;
  /** �����ȣ **/
  private String zipcode;
  /** �ּ� **/
  private String address1;
  /** �� �ּ� **/
  private String address2;
  /** ������ �̸� */
  private String name_get;
  /** ������ ��ȣ **/
  private String phon_get;
  /** ��۽� ��û ���� **/
  private String request;
  /** �ֹ��� */
  private String pay_date;
  public int getOrdersno() {
    return ordersno;
  }
  public void setOrdersno(int ordersno) {
    this.ordersno = ordersno;
  }
  public int getMemberno() {
    return memberno;
  }
  public void setMemberno(int memberno) {
    this.memberno = memberno;
  }
  public String getP_no() {
    return p_no;
  }
  public void setP_no(String p_no) {
    this.p_no = p_no;
  }
  public int getTotal_cost() {
    return total_cost;
  }
  public void setTotal_cost(int total_cost) {
    this.total_cost = total_cost;
  }
  public String getPay_how() {
    return pay_how;
  }
  public void setPay_how(String pay_how) {
    this.pay_how = pay_how;
  }
  public String getCoupon_name() {
    return coupon_name;
  }
  public void setCoupon_name(String coupon_name) {
    this.coupon_name = coupon_name;
  }
  public int getTotal_pay() {
    return total_pay;
  }
  public void setTotal_pay(int total_pay) {
    this.total_pay = total_pay;
  }
  public String getName_post() {
    return name_post;
  }
  public void setName_post(String name_post) {
    this.name_post = name_post;
  }
  public String getPhon_post() {
    return phon_post;
  }
  public void setPhon_post(String phon_post) {
    this.phon_post = phon_post;
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
  public String getName_get() {
    return name_get;
  }
  public void setName_get(String name_get) {
    this.name_get = name_get;
  }
  public String getPhon_get() {
    return phon_get;
  }
  public void setPhon_get(String phon_get) {
    this.phon_get = phon_get;
  }
  public String getRequest() {
    return request;
  }
  public void setRequest(String request) {
    this.request = request;
  }

  public String getPay_date() {
    return pay_date;
  }
  public void setPay_date(String pay_date) {
    this.pay_date = pay_date;
  }
  public int getCoupon_cost() {
    return coupon_cost;
  }
  public void setCoupon_cost(int coupon_cost) {
    this.coupon_cost = coupon_cost;
  }
  public int getPoint_use() {
    return point_use;
  }
  public void setPoint_use(int point_use) {
    this.point_use = point_use;
  }
  public int getDeli_cost() {
    return deli_cost;
  }
  public void setDeli_cost(int deli_cost) {
    this.deli_cost = deli_cost;
  }
  public int getPoint_acc() {
    return point_acc;
  }
  public void setPoint_acc(int point_acc) {
    this.point_acc = point_acc;
  }
  
}