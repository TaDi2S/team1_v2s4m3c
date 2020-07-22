package dev.mvc.delivery;

import java.util.List;

public interface DeliveryProcInter {

  /**
   * ��� ó��
   * <insert id="create" parameterType="DeliveryVO">
   * @param deliveryVO
   * @return
   */
  public int create(DeliveryVO deliveryVO);

  /**
   * ��ü ��� 
   * <select id="list" resultType="DeliveryVO">
   * @return
   */
  public List<DeliveryVO> list();

  /**
   * ��ȸ
   * <select id="read" resultType="DeliveryVO" parameterType="int">
   * @param deliveryno
   * @return
   */
  public DeliveryVO read(int deliveryno);
  

  /**
   * ���� ó��
   * <update id="update" parameterType="DeliveryVO">
   * @param deliveryVO
   * @return
   */
  public int update(DeliveryVO deliveryVO);

  /**
   * ����
   * <delete id="delete" parameterType="int">
   * @param deliveryno
   * @return
   */
  public int delete(int deliveryno);

}
