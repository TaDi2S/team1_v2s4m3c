package dev.mvc.question;

import java.util.HashMap;
import java.util.List;

public interface QuestionProcInter {
  /**
   * ���� ���
   * @param questionVO
   * @return
   */
  public int create(QuestionVO questionVO);
  
  /**
   * ��ü ���� ���
   * @return
   */
  public List<HashMap<Object, Object>> list_all();
  
  /**
   * questionno ��� ���ϱ�
   * @return
   */
  public List<Integer> getNOs();
  
  /**
   * ȸ���� ���� ���
   * @param memberno
   * @return
   */
  public List<QuestionVO> list_by_memberno(int memberno);
  
  /**
   * ȸ���� ���� ���� ��ȸ
   * @param memberno
   * @return
   */
  public QuestionVO read(int questionno);
  
  /**
   * questionno ��� ���ϱ�
   * @return
   */
  public List<Integer> getNOs_member(int memberno);
  
  /**
   * ���� ����
   * @param questionno
   * @param state
   * @return
   */
  public int answer_regist(HashMap<Object, Object> map);
  
  /**
   * ���� & �亯 ����
   * @param questionno
   * @return
   */
  public int delete(int questionno);
}
