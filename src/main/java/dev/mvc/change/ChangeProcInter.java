package dev.mvc.change;

import java.util.List;

public interface ChangeProcInter {

  
  /**
   * ��� ó��
   * <insert id="create" parameterType="ChangeVO">
   * @param changeVO
   * @return
   */
  public int create(ChangeVO changeVO);

  /**
   * ��ü ��� 
   * <select id="list" resultType="ChangeVO">
   * @return
   */
  public List<ChangeVO> list();

  /**
   * ��ȸ
   * <select id="read" resultType="ChangeVO" parameterType="int">
   * @param changeno
   * @return
   */
  public ChangeVO read(int changeno);
  

  /**
   * ���� ó��
   * <update id="update" parameterType="ChangeVO">
   * @param changeVO
   * @return
   */
  public int update(ChangeVO changeVO);

  /**
   * ����
   * <delete id="delete" parameterType="int">
   * @param changeno
   * @return
   */
  public int delete(int changeno);

}
