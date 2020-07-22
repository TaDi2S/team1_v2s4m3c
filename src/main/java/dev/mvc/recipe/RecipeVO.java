package dev.mvc.recipe;

import org.springframework.web.multipart.MultipartFile;

public class RecipeVO {
//  recipeno                          NUMBER(10)     NOT NULL    PRIMARY KEY,
//  memberno                          NUMBER(10)     NULL ,
//  recipecateno                      NUMBER(10)     NULL ,
//  title                             VARCHAR2(100)    NOT NULL,
//  introdfood                        VARCHAR2(1000)     NOT NULL,
//  category                          VARCHAR2(100)    NOT NULL,
//  infofood                          VARCHAR2(100)    NOT NULL,
//  ingredfood                        VARCHAR2(10)     NOT NULL,
//  seqfood                           VARCHAR2(1000)     NOT NULL,
//  recom                             NUMBER(7)    DEFAULT 0     NOT NULL,
//  hits                              NUMBER(10)     DEFAULT 0     NOT NULL,
//  replycnt                          NUMBER(7)    DEFAULT 0     NOT NULL,
//  youtube                           VARCHAR2(100)    NULL ,
//  visible                           CHAR(1)    DEFAULT 'Y'     NOT NULL,
//  ip                                VARCHAR2(15)     NOT NULL,
//  indent                            NUMBER(2)    DEFAULT 0     NOT NULL,
//  word                              VARCHAR2(300)    NOT NULL,
//  rdate                             DATE     NOT NULL,
//  file1                                   VARCHAR(100)          NULL,
//  thumb1                              VARCHAR(100)          NULL,
//  size1                                 NUMBER(10)      DEFAULT 0 NULL,  
  /** ������ ��ȣ */
  private int recipeno;
  /** ȸ�� ��ȣ */
  private int memberno;
  /** ī�װ� ��ȣ*/
  private int recipecateno;
  /** ���� */
  private String title;
  /** �丮�Ұ� */
  private String introdfood;
  /** ī�װ� */
  private String category;
  /** �丮���� */
  private String infofood;
  /** �丮��� */
  private String ingredfood;
  /** �丮���� */
  private String seqfood;
  /** ��õ */
  private int recom;
  /** ��ȸ�� */
  private int hits;
  /** ��ۼ� */
  private int replycnt;
  /** ������ */
  private String youtube;
  /** ��¸�� */
  private String visible;
  /** ������ */
  private String ip;
  /** ��۵鿩���� */
  private int indent;
  /** �丮��*/
  private String tip;
  /** �˻��� */
  private String word;
  /** ����� */
  private String rdate;
  /** ���� �̹��� */
  private String file1;
  /** ���� �̹��� Preview*/
  private String thumb1;
  /** ���� �̹��� ũ��*/
  private long size1;

  /** �̹��� MultipartFile */
  private MultipartFile file1MF;
  
  /** ���� */
  private double rating;
  /** ���� ī��Ʈ*/
  private int rating_cnt;
  /** ���� ����*/
  private double rating_sum;
  
  
  public double getRating() {
    return rating;
  }
  public void setRating(double rating) {
    this.rating = rating;
  }
  public int getRating_cnt() {
    return rating_cnt;
  }
  public void setRating_cnt(int rating_cnt) {
    this.rating_cnt = rating_cnt;
  }
  public double getRating_sum() {
    return rating_sum;
  }
  public void setRating_sum(double rating_sum) {
    this.rating_sum = rating_sum;
  }
  public int getRecipeno() {
    return recipeno;
  }
  public void setRecipeno(int recipeno) {
    this.recipeno = recipeno;
  }
  public int getMemberno() {
    return memberno;
  }
  public void setMemberno(int memberno) {
    this.memberno = memberno;
  }
  public int getRecipecateno() {
    return recipecateno;
  }
  public void setRecipecateno(int recipecateno) {
    this.recipecateno = recipecateno;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getIntrodfood() {
    return introdfood;
  }
  public void setIntrodfood(String introdfood) {
    this.introdfood = introdfood;
  }
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }
  public String getInfofood() {
    return infofood;
  }
  public void setInfofood(String infofood) {
    this.infofood = infofood;
  }
  public String getIngredfood() {
    return ingredfood;
  }
  public void setIngredfood(String ingredfood) {
    this.ingredfood = ingredfood;
  }
  public String getSeqfood() {
    return seqfood;
  }
  public void setSeqfood(String seqfood) {
    this.seqfood = seqfood;
  }
  public int getRecom() {
    return recom;
  }
  public void setRecom(int recom) {
    this.recom = recom;
  }
  public int getHits() {
    return hits;
  }
  public void setHits(int hits) {
    this.hits = hits;
  }
  public int getReplycnt() {
    return replycnt;
  }
  public void setReplycnt(int replycnt) {
    this.replycnt = replycnt;
  }
  public String getYoutube() {
    return youtube;
  }
  public void setYoutube(String youtube) {
    this.youtube = youtube;
  }
  public String getVisible() {
    return visible;
  }
  public void setVisible(String visible) {
    this.visible = visible;
  }
  public String getIp() {
    return ip;
  }
  public void setIp(String ip) {
    this.ip = ip;
  }
  public int getIndent() {
    return indent;
  }
  public void setIndent(int indent) {
    this.indent = indent;
  }
  public String getWord() {
    return word;
  }
  public void setWord(String word) {
    this.word = word;
  }
  public String getRdate() {
    return rdate;
  }
  public void setRdate(String rdate) {
    this.rdate = rdate;
  }
  public String getFile1() {
    return file1;
  }
  public void setFile1(String file1) {
    this.file1 = file1;
  }
  public String getThumb1() {
    return thumb1;
  }
  public void setThumb1(String thumb1) {
    this.thumb1 = thumb1;
  }
  public long getSize1() {
    return size1;
  }
  public void setSize1(long size1) {
    this.size1 = size1;
  }

  public MultipartFile getFile1MF() {
    return file1MF;
  }
  public void setFile1MF(MultipartFile file1mf) {
    file1MF = file1mf;
  }
  public String getTip() {
    return tip;
  }
  public void setTip(String tip) {
    this.tip = tip;
  }

  
}
