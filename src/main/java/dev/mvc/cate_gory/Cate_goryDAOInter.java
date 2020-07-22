package dev.mvc.cate_gory;

import java.util.List;

public interface Cate_goryDAOInter {
  
  /**
   * ���
   * @param cate_goryVO
   */  
  public int create(Cate_goryVO cate_goryVO);

  /**
   * ��ü ��� 
   */
  public List<Cate_goryVO> list();
  
  /**
   * ��ȸ, ������
   */
  public Cate_goryVO read(int goryno);  
  
  /**
   * ����ó��
   */
  public int update(Cate_goryVO cate_goryVO);
  
  /**
   * ���� ó��
   */
  public int delete(int goryno);
  
  /**
   * �� �� ����
   * @param goryno
   * @return
   */
  public int increaseCnt(int goryno);
  
  /**
   * �� �� ����
   * @param goryno
   * @return
   */
  public int decreaseCnt(int goryno);
  
}
