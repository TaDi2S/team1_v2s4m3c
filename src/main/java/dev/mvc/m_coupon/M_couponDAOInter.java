package dev.mvc.m_coupon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


//MyBATIS�� <mapper namespace="dev.mvc.Contents.ContentsDAOInter">�� ���� 
public interface M_couponDAOInter {
//���ۿ� ���� �޼ҵ���� MyBATIS�� XML ���Ͼ��� id�� �����ؾ��մϴ�.

  /**
   * ȸ�� ���� ���
   * <xmp>
   * <insert id="create" parameterType="M_couponVO"> 
   * </xmp>
   * @param m_couponVO
   * @return ��ϵ� ���ڵ� ����
   */
  public int create (M_couponVO m_couponVO);
  
  /**
   * ȸ���� ���� ���� ��ȸ
   * <xmp>
   * <select id="read" resultType="M_couponVO" parameterType="int">]
   * </xmp>
   * @param memberno
   * @return
   */
  public List<M_couponVO> read_member_coupon(int memberno);
  
  /**
   * ����  �� ó��
   * <xmp>
   * <update id="update" parameterType="M_couponVO"> 
   * </xmp>
   * @param m_couponVO
   * @return ó���� ���ڵ� ����
   */
  public M_couponVO update(int m_couponno); // ���� ��
  
  public int update(M_couponVO m_couponVO); // ���� ó��
  
  /**
   * ���� ó��
   * <xmp>
   * <delete id="delete" parameterType="int">
   * </xmp>
   * @param m_couponno
   * @return ó���� ���ڵ� ����
   */
  public int delete(M_couponVO m_couponVO);
  
}
