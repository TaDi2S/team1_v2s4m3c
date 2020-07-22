package dev.mvc.viewfile;

import java.util.List;

public interface ViewfileDAOInter {
  /**
   * ���� ���  
   * @param viewfileVO
   * @return
   */
  public int create(ViewfileVO viewfileVO);
  
  /**
   * ��ü �̹��� ���
   * @return
   */
  public List<ViewfileVO> list();  
  
  /**
   * ��ȸ
   * @param viewfileno
   * @return
   */
  public ViewfileVO read(int viewfileno);
  
  /**
   * ����
   * @param viewfileno
   * @return
   */
  public int delete(int viewfileno);
  
  /**
   * p_no�� ���� ���� ���
   * @param p_no
   * @return
   */
  public List<ViewfileVO> list_by_p_no(int p_no);
}
