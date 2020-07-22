package dev.mvc.coupon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import dev.mvc.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.coupon.CouponProc")
//Dependency Injection(DI) ����� ���� �ڵ����� ��ü ������ �ʿ��� Class���� ���� ���� 
public class CouponProc implements CouponProcInter {
  @Autowired // DI, Spring framework�� �ڵ� ������ DAO�� �ڵ� �Ҵ��.
  private CouponDAOInter couponDAO;
 // private ContentsgrpDAOInter coupongrpDAO; = new ContentsgrpDAO(); �� Spring�� �ڵ����� �����
  
  @Override
  public int create(CouponVO couponVO) {
    int cnt = this.couponDAO.create(couponVO);
    return cnt;
  }
  
  @Override
  public List<CouponVO> list(){
    List<CouponVO> list = this.couponDAO.list();
    return list;
  }

  @Override
  public CouponVO read_by_coupon_name(String coupon_name) {
    CouponVO coupon_cost = this.couponDAO.read_by_coupon_name(coupon_name);
    return coupon_cost;
  }
  
  @Override
  public CouponVO read_update(int couponno) {
    CouponVO couponVO = this.couponDAO.read_update(couponno);
    return couponVO;
  }
  
  @Override
  public int update(CouponVO couponVO) {
    int cnt = this.couponDAO.update(couponVO);
    return cnt;
  }
  
  @Override
  public int delete(int couponno) {
    int cnt = this.couponDAO.delete(couponno);
    return cnt;
  }

  @Override
  public List<CouponVO> list_add_view(HashMap<String, Object> map) {
    int record_per_page = 2; // ���������� 2��
    
    // couponPage�� 1���� ����
    int beginOfPage = ((Integer)map.get("couponPage") - 1) * record_per_page; // ���������� 2��

    int startNum = beginOfPage + 1; 
    int endNum = beginOfPage + record_per_page;  // ���������� 2��
    /*
    1 ������: WHERE r >= 1 AND r <= 2
    2 ������: WHERE r >= 3 AND r <= 4
    3 ������: WHERE r >= 5 AND r <= 6
    */
    map.put("startNum", startNum);
    map.put("endNum", endNum);
    
    List<CouponVO> list = couponDAO.list_add_view(map);
    String coupon_name = "";
    
    // Ư�� ���� ����
    for (CouponVO couponVO:list) {
      coupon_name = couponVO.getCoupon_name();
      coupon_name = Tool.convertChar(coupon_name);
      couponVO.setCoupon_name(coupon_name);
    }
    return list;
  }
}
