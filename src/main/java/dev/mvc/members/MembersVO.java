package dev.mvc.members;

public class MembersVO {
/*  
  memberno NUMBER(6)     NOT NULL, -- ȸ�� ��ȣ, ���ڵ带 �����ϴ� �÷�
  gradeno  NUMBER(7)     DEFAULT 1 NOT NULL, -- ��� ��ȣ
  id       VARCHAR(20)   NOT NULL UNIQUE, -- ���̵�, �ߺ� �ȵ�, ���ڵ带 ���� 
  passwd   VARCHAR(60)   NOT NULL, -- �н�����, ������ ����
  mname    VARCHAR(20)   NOT NULL, -- ����, �ѱ� 10�� ���� ����
  nickname VARCHAR(20)   NOT NULL UNIQUE, -- �г���
  email    VARCHAR(60)   NOT NULL UNIQUE, -- �̸��� �ּ�, �ߺ� �Ұ�
  tel      VARCHAR(14)   NOT NULL, -- ��ȭ��ȣ
  zipcode  VARCHAR(5)        NULL, -- �����ȣ, 12345
  address1 VARCHAR(80)       NULL, -- �ּ� 1
  address2 VARCHAR(50)       NULL, -- �ּ� 2
  birth    VARCHAR(14)       NULL, -- �������
  points   NUMBER(7)     DEFAULT 0 NOT NULL, -- ������
  mdate    DATE          NOT NULL, -- ������    
  PRIMARY KEY (memberno),                     -- �ѹ� ��ϵ� ��
  FOREIGN KEY (gradeno) REFERENCES grade (gradeno)
  */
  
  /** ȸ�� ��ȣ */
  private int memberno;
  /** ��� ��ȣ */
  private int gradeno;
  /** ���̵� */
  private String id;
  /** ��й�ȣ */
  private String passwd;
  /** �̸� */
  private String mname;
  /** �г��� */
  private String nickname;
  /** �̸��� */
  private String email;
  /** ��ȭ��ȣ */
  private String tel;
  /** �����ȣ */
  private String zipcode;
  /** �ּ� */
  private String address1;
  /** �� �ּ�*/
  private String address2;
  /** ������� */
  private String birth;
  /** ����Ʈ */
  private int points;
  /** ������*/
  private String mdate;
  
  public int getMemberno() {
    return memberno;
  }
  public void setMemberno(int memberno) {
    this.memberno = memberno;
  }
  public int getGradeno() {
    return gradeno;
  }
  public void setGradeno(int gradeno) {
    this.gradeno = gradeno;
  }
  public String getNickname() {
    return nickname;
  }
  public void setNickname(String nickname) {
    this.nickname = nickname;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getBirth() {
    return birth;
  }
  public void setBirth(String birth) {
    this.birth = birth;
  }
  public int getPoints() {
    return points;
  }
  public void setPoints(int points) {
    this.points = points;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getPasswd() {
    return passwd;
  }
  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }
  public String getMname() {
    return mname;
  }
  public void setMname(String mname) {
    this.mname = mname;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
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
  public String getMdate() {
    return mdate;
  }
  public void setMdate(String mdate) {
    this.mdate = mdate;
  }
  
}
