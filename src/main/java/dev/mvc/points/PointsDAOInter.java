package dev.mvc.points;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dev.mvc.coupon.CouponVO;
import dev.mvc.orders_detail.Orders_detailVO;


//MyBATIS�� <mapper namespace="dev.mvc.Contents.ContentsDAOInter">�� ���� 
public interface PointsDAOInter {
//���ۿ� ���� �޼ҵ���� MyBATIS�� XML ���Ͼ��� id�� �����ؾ��մϴ�.

  /**
   * ī�װ� �׷� ���
   * <xmp>
   * <insert id="create" parameterType="Point_useVO"> 
   * </xmp>
   * @param pointsVO
   * @return ��ϵ� ���ڵ� ����
   */
  public int create_acc(PointsVO pointsVO);
  
  public int create_use(PointsVO pointsVO);
  
  /**
   * ���
   * <xmp>
   * <select id="list_pointsno_asc" resultType="Point_useVO">
   * </xmp>
   * @return ���ڵ� ���
   */
  public List<PointsVO> list_all();
  
  /**
   * ��ȸ
   * <xmp>
   * <select id="read" resultType="Point_useVO" parameterType="int">]
   * </xmp>
   * @param memberno
   * @return
   */
  public List<PointsVO> read_memberno(int memberno);
  
  /**
   * ����  �� ó��
   * <xmp>
   * <update id="update" parameterType="Point_useVO"> 
   * </xmp>
   * @param pointsVO
   * @return ó���� ���ڵ� ����
   */
  public PointsVO update(int pointsno); // ���� ��
  
  /**
   * <!-- �н����� �˻�  -->
   * <select id="passwd_check" parameterType="HashMap" resultType="int">
   * @param hashMap
   * @return
   */
  public int passwd_check(HashMap hashMap);

  /**
   * ���� ó��
   * <xmp>
   * <delete id="delete" parameterType="int">
   * </xmp>
   * @param pointsno
   * @return ó���� ���ڵ� ����
   */
  public int delete(int pointsno);
  
  /**
   * ȸ����ȣ�� ���� ó��, �ֹ��󼼷� �ѱ�� ����
   * <xmp>
   * <delete id="delete_memberno" parameterType="int">
   * </xmp>
   * @param memberno
   * @return ó���� ���ڵ� ����
   */
  public int delete_memberno(int memberno);
  
  /**
   * ������ ��ư
   * @param map
   * @return
   */
  public List<PointsVO> list_add_view(HashMap<String, Object> map);
  
  
}
