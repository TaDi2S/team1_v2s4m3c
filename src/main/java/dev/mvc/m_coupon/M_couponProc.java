package dev.mvc.m_coupon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import dev.mvc.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.m_coupon.M_couponProc")
//Dependency Injection(DI) ����� ���� �ڵ����� ��ü ������ �ʿ��� Class���� ���� ���� 
public class M_couponProc implements M_couponProcInter {
  @Autowired // DI, Spring framework�� �ڵ� ������ DAO�� �ڵ� �Ҵ��.
  private M_couponDAOInter m_couponDAO;
 // private ContentsgrpDAOInter m_coupongrpDAO; = new ContentsgrpDAO(); �� Spring�� �ڵ����� �����
  
  @Override
  public int create (M_couponVO m_couponVO) {
    int cnt = this.m_couponDAO.create(m_couponVO);
    return cnt;
  }
  
  @Override
  public List<M_couponVO> read_member_coupon(int memberno) {
    List<M_couponVO> list = null;
    list = this.m_couponDAO.read_member_coupon(memberno);
    return list;
  }

  @Override
  public int update(M_couponVO m_couponVO) {
    int cnt = this.m_couponDAO.update(m_couponVO);
    return cnt;
  }

  @Override
  public int delete(M_couponVO m_couponVO) {
    int cnt = this.m_couponDAO.delete(m_couponVO);
    return cnt;
  }

  @Override
  public M_couponVO update(int m_couponno) {
    // TODO Auto-generated method stub
    return null;
  }

  
}
