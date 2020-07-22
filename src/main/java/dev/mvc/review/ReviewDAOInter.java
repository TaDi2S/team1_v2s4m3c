package dev.mvc.review;

import java.util.HashMap;
import java.util.List;

public interface ReviewDAOInter {
  /**
   * ��� ó��
   * @param reviewVO
   * @return
   */
  public int create(ReviewVO reviewVO);
  
  /**
   * ��ü ���
   * @return
   */
  public List<ReviewVO> list();
  
  /**
   * ��ǰ �� ����
   * @param p_no
   * @return
   */
  public List<ReviewProductVO> list_by_p_no_join(int p_no);
  
  /**
   * �� ���� ��ư
   * @param map
   * @return
   */
  public List<ReviewProductVO> list_by_p_no_join_add_view(HashMap<String, Object> map);

}
