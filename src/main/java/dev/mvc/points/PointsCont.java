package dev.mvc.points;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.coupon.CouponVO;
import dev.mvc.points.PointsProcInter;
import dev.mvc.points.PointsVO;

@Controller
//Dependency Injection(DI) ����� ���� �ڵ����� ��ü ������ �ʿ��� Class���� ���� ���� 
public class PointsCont {
  @Autowired
  @Qualifier("dev.mvc.points.PointsProc") // PointsProc�� @Component ȣ���ؼ� ���
  private PointsProcInter pointsProc;
  
  public PointsCont() {
    System.out.println("--> PointsCont created.");
  }
  
  /**
   * �����
   */
  // http://localhost:9090/project/points/create.do
  @RequestMapping(value="/points/create.do", method=RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/points/update"); // webapp/points/create.jsp
    
    return mav;
  }
  
  /**
   * ���ó��
   * @param pointsVO
   * @return
   */
    // http://localhost:9090/project/points/create.do
@RequestMapping(value="/points/create.do", method=RequestMethod.POST)
  public ModelAndView create(PointsVO pointsVO) {
    // PointsVO pointsVO <FORM> �±��� ������ �ڵ� ������
    // request.setAttribute("pointsVO", pointsVO); �ڵ����� ������ ��
    
    ModelAndView mav = new ModelAndView();
    
    int cnt = this.pointsProc.create_acc(pointsVO);
    
    mav.addObject("cnt", cnt);
    
    mav.setViewName("redirect:/points/create_msg.jsp");
    
    return mav; // forward
  }

  /**
   * ��ü���
   * @return
   */
  // http://localhost:9090/project/points/list.do
  @RequestMapping(value="/points/list.do", method=RequestMethod.GET)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView();
    
    // List<PointsVO> list = this.pointsProc.list();
    List<PointsVO> list = this.pointsProc.list_all();
    mav.addObject("list", list); // requet.setAttribute("list", list);
    
    mav.setViewName("/points/list"); // webapp/points/create.jsp
    return mav;
  }
  
  /**
   * ��ȸ
   * @param memberno ��ȸ�� ��ٱ����� ��� ��ȣ
   * @return
   */
  // http://localhost:9090/project/points/read_update.do
  @RequestMapping(value="/points/read.do", method=RequestMethod.GET)
  public ModelAndView read_memberno(HttpSession session) {
    ModelAndView mav = new ModelAndView();
    
    int memberno = (int)session.getAttribute("memberno");
    
    List<PointsVO> list = this.pointsProc.read_memberno(memberno);
    
    mav.addObject("list", list);
    mav.addObject("memberno", memberno);
    mav.setViewName("/points/read_memberno"); // webapp/points/read.jsp
    return mav;
  }
  
  /**
   * ���� ó��
   * @param pointsno
   * @return
   */
  // http://localhost:9090/project/points/delete.do
  @ResponseBody
  @RequestMapping(value="/points/delete.do", method=RequestMethod.POST)
  public String delete(PointsVO pointsVO) {
        
    int cnt = this.pointsProc.delete(pointsVO.getPointsno());
    
    JSONObject json = new JSONObject();
    List<PointsVO> list = this.pointsProc.read_memberno(pointsVO.getMemberno());
    
    json.put("list", list);
    json.put("cnt", cnt); 
    
    return json.toString();
  }

  
    /**
     * �޽���
     * @param pointsno
     * @return
     */
    @RequestMapping(value="/points/msg.do", method=RequestMethod.GET)
    public ModelAndView msg(String url){
      ModelAndView mav = new ModelAndView();
      
      mav.setViewName("/points/" + url);
      //��� ó�� �޼��� : /points/create_msg.jsp
      //���� ó�� �޼��� : /points/update_msg.jsp
      //���� ó�� �޼��� : /points/delete_msg.jsp
      
      return mav; // forward
    }
    
    /**
     * ������ ��ư ����¡ ���
     * http://localhost:9090/project/points/list_add_view.do
     * @param couponPage ��� ������
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/points/list_add_view.do",
                                method = RequestMethod.GET,
                                produces = "text/plain;charset=UTF-8")
    public String list_add_view(int pointsPage) {
      
      System.out.println("pointsPage: " + pointsPage);
      
      HashMap<String, Object> map = new HashMap<String, Object>();
      map.put("pointsPage", pointsPage);
      
      List<PointsVO> list = pointsProc.list_add_view(map);
      
      for (int i = 0; i<list.size();i++) {
        System.out.println(list.get(i).getContents());
      }
      
      JSONObject obj = new JSONObject();
      obj.put("list", list);
   
      return obj.toString();     
    }
    
}
