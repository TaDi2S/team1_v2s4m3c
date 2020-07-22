package dev.mvc.deliverypay;

import java.util.List;

public interface DeliverypayDAOInter {

  /**
   * ��� ó��
   * <insert id="create" parameterType="DeliverypayVO">
   * @param DeliverypayVO
   * @return
   */
  public int create(DeliverypayVO deliverypayVO);

  /**
   * ��ü ��� 
   * <select id="list" resultType="DeliverypayVO">
   * @return
   */
  public List<DeliverypayVO> list();

  /**
   * ��ȸ
   * <select id="read" resultType="DeliverypayVO" parameterType="int">
   * @param Deliverypayno
   * @return
   */
  public DeliverypayVO read(int deliverypayno);
  

  /**
   * ���� ó��
   * <update id="update" parameterType="DeliverypayVO">
   * @param DeliverypayVO
   * @return
   */
  public int update(DeliverypayVO deliverypayVO);

  /**
   * ����
   * <delete id="delete" parameterType="int">
   * @param Deliverypayno
   * @return
   */
  public int delete(int deliverypayno);

  

}
