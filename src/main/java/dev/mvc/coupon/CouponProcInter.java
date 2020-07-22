package dev.mvc.coupon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface CouponProcInter {
  
  /**
   * ī�װ� �׷� ���
   * <xmp>
   * <insert id="create" parameterType="CouponVO"> 
   * </xmp>
   * @param couponVO
   * @return ��ϵ� ���ڵ� ����
   */
  public int create (CouponVO couponVO);
  
  /**
   * ���
   * <xmp>
   * <select id="list" resultType="CouponVO">
   * </xmp>
   * @return ���ڵ� ���
   */
  public List<CouponVO> list();
  
  /**
   * �����̸����� ��ȸ
   * <xmp>
   * <select id="read_by_coupon_name" resultType="CouponVO" parameterType="String">
   * </xmp>
   * @param coupon_name
   * @return CouponVO
   */
  public CouponVO read_by_coupon_name(String coupon_name);
  
  /**
   * ���� ��ȸ
   * <xmp>
   * <select id="read_update"  resultType="CouponVO" parameterType="int">
   * </xmp>
   * @param couponno
   * @return CouponVO
   */
  public CouponVO read_update(int couponno);
  
  public int update(CouponVO couponVO); // ���� ó��
  
  /**
   * ���� ó��
   * <xmp>
   * <delete id="delete" parameterType="int">
   * </xmp>
   * @param couponno
   * @return ó���� ���ڵ� ����
   */
  public int delete(int couponno);
  
  /**
   * ������ ��ư
   * @param map
   * @return
   */
  public List<CouponVO> list_add_view(HashMap<String, Object> map);
  
}
