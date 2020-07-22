package dev.mvc.points;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.mvc.coupon.CouponVO;
import dev.mvc.tool.Tool;

@Component("dev.mvc.points.PointsProc")
//Dependency Injection(DI) ����� ���� �ڵ����� ��ü ������ �ʿ��� Class���� ���� ���� 
public class PointsProc implements PointsProcInter {
  @Autowired // DI, Spring framework�� �ڵ� ������ DAO�� �ڵ� �Ҵ��.
  private PointsDAOInter pointsDAO;
 // private ContentsgrpDAOInter pointsgrpDAO; = new ContentsgrpDAO(); �� Spring�� �ڵ����� �����
  
  @Override
  public int create_acc(PointsVO pointsVO) {
    int cnt = this.pointsDAO.create_acc(pointsVO);
    return cnt;
  }
  
  @Override
  public int create_use(PointsVO pointsVO) {
    int cnt = this.pointsDAO.create_use(pointsVO);
    return cnt;
  }
  
  @Override
  public List<PointsVO> list_all(){
    List<PointsVO> list = this.pointsDAO.list_all();
    return list;
  }

  @Override
  public List<PointsVO> read_memberno(int memberno) {
    List<PointsVO> list = null;
    list = this.pointsDAO.read_memberno(memberno);
    return list;
  }
  
 
  @Override
  public int delete(int pointsno) {
    int cnt = this.pointsDAO.delete(pointsno);
    return cnt;
  }
  
  @Override
  public int delete_memberno(int memberno) {
    int cnt = this.pointsDAO.delete_memberno(memberno);
    return cnt;
  }
  
  @Override
  public List<PointsVO> list_add_view(HashMap<String, Object> map){
int record_per_page = 2; // ���������� 2��
    
    // couponPage�� 1���� ����
    int beginOfPage = ((Integer)map.get("pointsPage") - 1) * record_per_page; // ���������� 2��

    int startNum = beginOfPage + 1; 
    int endNum = beginOfPage + record_per_page;  // ���������� 2��
    /*
    1 ������: WHERE r >= 1 AND r <= 2
    2 ������: WHERE r >= 3 AND r <= 4
    3 ������: WHERE r >= 5 AND r <= 6
    */
    map.put("startNum", startNum);
    map.put("endNum", endNum);
    List<PointsVO> list = pointsDAO.list_add_view(map);
    String contents = "";
    
    // Ư�� ���� ����
    for (PointsVO pointsVO:list) {
      contents = pointsVO.getContents();
      contents = Tool.convertChar(contents);
      pointsVO.setContents(contents);
    }
    return list;
  }  
}
