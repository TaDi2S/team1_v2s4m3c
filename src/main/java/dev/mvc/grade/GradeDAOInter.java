package dev.mvc.grade;

import java.util.List;

public interface GradeDAOInter {
  /** 
   * ���
   * @param gradeVO
   * @return
   */
  public int create(GradeVO gradeVO);
  
  /**
   * ���
   * @return
   */
  public List<GradeVO> list();
  
  /**
   * ��ȸ, ������
   */
  public GradeVO read(int gradeno);
  
  /**
   * ���� ó��
   */
  public int update(GradeVO gradeVO);
  
  /**
   * ����ó��
   */
  public int delete(int gradeno);
  
  
}
