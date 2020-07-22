package dev.mvc.deliverystate;

import java.util.List;

public interface DeliverystateDAOInter {
  
  /**
   * ��� ó��
   * <insert id="create" parameterType="DeliverystateVO">
   * @param deliverystateVO
   * @return
   */
  public int create(DeliverystateVO deliverystateVO);

  /**
   * ��ü ��� 
   * <select id="list" resultType="DeliverystateVO">
   * @return
   */
  public List<DeliverystateVO> list();

  /**
   * ��ȸ
   * <select id="read" resultType="DeliverystateVO" parameterType="int">
   * @param stateno
   * @return
   */
  public DeliverystateVO read(int stateno);
  

  /**
   * ���� ó��
   * <update id="update" parameterType="DeliverystateVO">
   * @param deliverystateVO
   * @return
   */
  public int update(DeliverystateVO deliverystateVO);

  /**
   * ����
   * <delete id="delete" parameterType="int">
   * @param stateno
   * @return
   */
  public int delete(int stateno);
  
}
