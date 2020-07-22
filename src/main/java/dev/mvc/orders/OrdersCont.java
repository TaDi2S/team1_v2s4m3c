package dev.mvc.orders;

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

import dev.mvc.basket.BasketProcInter;
import dev.mvc.basket.BasketVO;
import dev.mvc.coupon.CouponProcInter;
import dev.mvc.coupon.CouponVO;
import dev.mvc.grade.GradeProcInter;
import dev.mvc.grade.GradeVO;
import dev.mvc.m_coupon.M_couponProcInter;
import dev.mvc.m_coupon.M_couponVO;
import dev.mvc.members.MembersProcInter;
import dev.mvc.members.MembersVO;
import dev.mvc.orders.OrdersProcInter;
import dev.mvc.orders.OrdersVO;
import dev.mvc.orders_detail.Orders_detailProcInter;
import dev.mvc.orders_detail.Orders_detailVO;
import dev.mvc.points.PointsProcInter;
import dev.mvc.points.PointsVO;


@Controller
//Dependency Injection(DI) ����� ���� �ڵ����� ��ü ������ �ʿ��� Class���� ���� ���� 
public class OrdersCont {
  @Autowired
  @Qualifier("dev.mvc.basket.BasketProc") // BasketProc�� @Component ȣ���ؼ� ���
  private BasketProcInter basketProc;
  @Autowired
  @Qualifier("dev.mvc.orders.OrdersProc") // OrdersProc�� @Component ȣ���ؼ� ���
  private OrdersProcInter ordersProc;
  
  @Autowired
  @Qualifier("dev.mvc.orders_detail.Orders_detailProc") // Orders_detailProc�� @Component ȣ���ؼ� ���
  private Orders_detailProcInter orders_detailProc;
  
  @Autowired
  @Qualifier("dev.mvc.m_coupon.M_couponProc") // M_couponProc�� @Component ȣ���ؼ� ���
  private M_couponProcInter m_couponProc;
  
  @Autowired
  @Qualifier("dev.mvc.coupon.CouponProc") // CouponProc�� @Component ȣ���ؼ� ���
  private CouponProcInter couponProc;
  
  @Autowired
  @Qualifier("dev.mvc.points.PointsProc") // PointsProc�� @Component ȣ���ؼ� ���
  private PointsProcInter pointsProc;
  
  @Autowired
  @Qualifier("dev.mvc.members.MembersProc")
  private MembersProcInter membersProc;
  
  @Autowired
  @Qualifier("dev.mvc.grade.GradeProc")
  private GradeProcInter gradeProc;
  
  public OrdersCont() {
    System.out.println("--> OrdersCont created.");
  }
  
  /**
   * �����
   */
  // http://localhost:9090/project/orders/create.do
  @RequestMapping(value="/orders/create.do", method=RequestMethod.GET)
  public ModelAndView create(HttpSession session) {
    ModelAndView mav = new ModelAndView();
    
    int memberno = (int)session.getAttribute("memberno");
    
    List<BasketVO> list = this.basketProc.read_memberno(memberno);
    
    MembersVO membersVO = this.membersProc.read(memberno);
    
    GradeVO gradeVO = this.gradeProc.read(membersVO.getGradeno());
    List<M_couponVO> list_coupon = this.m_couponProc.read_member_coupon(memberno);
    mav.addObject("list", list);
    mav.addObject("list_coupon", list_coupon);
    String p_no = "";
    // ������ %�� �����ֱ�
    String accum = Double.toString(gradeVO.getAccum() * 100) + "%";
    
    // ��ǰ��ȣ ���ļ� ����
    for (int i = 0; i<list.size(); i++) {
      p_no = p_no  + list.get(i).getP_no() + ",";
    }
    p_no = p_no.substring(0, p_no.length()-1);
        
    mav.addObject("accum", accum);
    mav.addObject("p_no", p_no);
    mav.addObject("membersVO", membersVO);
    mav.addObject("gradeVO", gradeVO);
    
    mav.setViewName("/orders/create"); // webapp/orders/create.jsp
    return mav;
  }
  
  /**
   * ���ó��
   * @param ordersVO
   * @return
   */
    // http://localhost:9090/project/orders/create.do
  @RequestMapping(value="/orders/create.do", method=RequestMethod.POST)
  public ModelAndView create(OrdersVO ordersVO) {
    ModelAndView mav = new ModelAndView();
    // �ֹ� ���
    int cnt = this.ordersProc.create(ordersVO);
    
    
    // ����� ���� ����
    if(ordersVO.getCoupon_cost() > 0) {
      CouponVO couponVO = this.couponProc.read_by_coupon_name(ordersVO.getCoupon_name());
      M_couponVO m_couponVO = new M_couponVO();
      m_couponVO.setCouponno(couponVO.getCouponno());
      m_couponVO.setMemberno(ordersVO.getMemberno());
      this.m_couponProc.delete(m_couponVO);
    }
    // �ֹ� �� ���
    Orders_detailVO orders_detailVO = new Orders_detailVO();
    int cnt2 = 0;
    List<Orders_detailVO> list = this.basketProc.read_memberno_to_detail(ordersVO.getMemberno());
    for(int i = 0; i<list.size(); i++) {
      orders_detailVO = list.get(i);
      orders_detailVO.setOrdersno(ordersVO.getOrdersno());
      
      cnt2 = this.orders_detailProc.create(orders_detailVO);
    }
    // ��ٱ��� ����
   // int cnt3 = this.basketProc.delete_memberno(ordersVO.getMemberno());
    
    // ����Ʈ ����/��� ���� ���
    MembersVO membersVO = this.membersProc.read(ordersVO.getMemberno());
    GradeVO gradeVO = this.gradeProc.read(membersVO.getGradeno());
    double accum = (gradeVO.getAccum() * 100);
    int points = membersVO.getPoints() + ordersVO.getPoint_acc() - ordersVO.getPoint_use();
    membersVO.setPoints(points);
    this.membersProc.update_points(membersVO);
    
    String str_acc = "[��������] �ֹ�(" + ordersVO.getOrdersno() + ") " + accum + "% ����";
    PointsVO pointsVO = new PointsVO();
    pointsVO.setMemberno(ordersVO.getMemberno());
    pointsVO.setOrdersno(ordersVO.getOrdersno());
    pointsVO.setContents(str_acc);
    pointsVO.setPoint_change(ordersVO.getPoint_acc());
    int cnt4 = this.pointsProc.create_acc(pointsVO);
    if (ordersVO.getPoint_use() != 0) {
      String str_use = "[���] �ֹ�(" + ordersVO.getOrdersno() + ") ���� �� ���";
      pointsVO.setContents(str_use);
      pointsVO.setPoint_change(ordersVO.getPoint_use());
      int cnt5 = this.pointsProc.create_use(pointsVO);
      mav.addObject("cnt5", cnt5);
    }
    
    mav.addObject("memberno", ordersVO.getMemberno());
    mav.addObject("cnt", cnt);
    mav.addObject("cnt2", cnt2);
    //mav.addObject("cnt3", cnt3);
    mav.addObject("cnt4", cnt4);
    
    mav.addObject("size", list.size());
    mav.setViewName("redirect:/orders/create_msg.jsp");
    return mav; // forward
  }
  
  
  /**
   * ��ü���
   * @return
   */
  // http://localhost:9090/project/orders/list.do
  @RequestMapping(value="/orders/list.do", method=RequestMethod.GET)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView();
    
    // List<OrdersVO> list = this.ordersProc.list();
    List<OrdersVO> list = this.ordersProc.list_all();
    mav.addObject("list", list); // requet.setAttribute("list", list);
    
    mav.setViewName("/orders/list"); // webapp/orders/create.jsp
    return mav;
  }
  
  /**
   * ȸ�� �ֹ� ���
   * @return
   */
  @RequestMapping(value="/orders/list_memberno.do", method=RequestMethod.GET)
  public ModelAndView list(HttpSession session) {
    ModelAndView mav = new ModelAndView();
    
    int memberno = (int)session.getAttribute("memberno");
    
    // List<OrdersVO> list = this.ordersProc.list();
    List<OrdersVO> list = this.ordersProc.list_memberno(memberno);
    mav.addObject("list", list); // requet.setAttribute("list", list);
    
    mav.setViewName("/orders/list"); // webapp/orders/create.jsp
    return mav;
  }
  
  /**
   * ��ȸ
   * @param ordersno ��ȸ�� ī�װ� ��ȣ
   * @return
   */
  // http://localhost:9090/project/orders/read_update.do
  @RequestMapping(value="/orders/read.do", method=RequestMethod.GET)
  public ModelAndView read(int ordersno) {
    // request.setAttribute("ordersno", int ordersno) �۵� �ȵ�.
    ModelAndView mav = new ModelAndView();
    
    List<Orders_detailVO> list = this.orders_detailProc.list_ordersno(ordersno);
    OrdersVO ordersVO = this.ordersProc.read(ordersno);
    
    mav.addObject("list", list);
    mav.addObject("ordersVO", ordersVO);
    
    mav.setViewName("/orders/read"); // webapp/orders/create.jsp
    return mav; 
  }
  
  /**
   * ���� ��
   * @return
   */
  // http://localhost:9090/project/orders/update.do
  @RequestMapping(value="/orders/update.do", method=RequestMethod.GET)
  public ModelAndView update(int ordersno) {
    ModelAndView mav = new ModelAndView();

    OrdersVO ordersVO = this.ordersProc.update(ordersno);
    mav.addObject("ordersVO", ordersVO);

    mav.setViewName("/orders/update");
    return mav; 
  }
  
  /**
   * ���� ó��
   * @param ordersVO
   * @return
   */
  // http://localhost:9090/project/orders/update.do
  @RequestMapping(value="/orders/update.do", method=RequestMethod.POST)
  public ModelAndView update(OrdersVO ordersVO) {
    ModelAndView mav = new ModelAndView();
    
    mav.addObject("ordersno", ordersVO.getOrdersno());
    
    int cnt = 0; // ������ ���ڵ� ����
    
    cnt = this.ordersProc.update(ordersVO);
    
    mav.addObject("cnt", cnt);
    
    mav.addObject("url", "update_msg");
    
    mav.setViewName("redirect:/orders/msg.do");
    
    return mav;      
  }

  /**
  /* ���� ���� ó��
  /* @param coupon_name
  /* @return
  /* 
   */
  // http://localhost:9090/project/basket/update.do
  @ResponseBody
  @RequestMapping(value="/orders/read_coupon_cost.do", method=RequestMethod.POST, produces = "text/plain;charset=UTF-8")
  public String update_coupon(String coupon_name) {
    int coupon_cost = 0;
  
    if(coupon_name.equals("���þ���")) {
      coupon_cost = 0;
    }else {
     CouponVO couponVO = this.couponProc.read_by_coupon_name(coupon_name);
     coupon_cost = couponVO.getCoupon_cost();
    }
   System.out.println(coupon_name);
   JSONObject json = new JSONObject();
   json.put("coupon_name", coupon_name); 
   json.put("coupon_cost", coupon_cost); 
   
   return json.toString();
  }
 

/**
     * ���� ��
     * @return
     */
    // http://localhost:9090/project/orders/delete.do
    @RequestMapping(value="/orders/read_delete.do", method=RequestMethod.GET)
    public ModelAndView read_delete(int ordersno) {
      ModelAndView mav = new ModelAndView();

      OrdersVO ordersVO = this.ordersProc.read(ordersno);
      mav.addObject("ordersVO", ordersVO);

      mav.setViewName("/orders/read_delete");
      return mav; 
    }
    
    /**
     * ���� ó��
     * @param ordersno
     * @return
     */
    @RequestMapping(value="/orders/delete.do", method=RequestMethod.POST)
    public ModelAndView delete(int ordersno) {
      ModelAndView mav = new ModelAndView();
      
      int cnt = 0; // ������ ���ڵ� ����
      
      
      OrdersVO ordersVO = this.ordersProc.read(ordersno);
      mav.addObject("ordersno", ordersVO.getOrdersno());
      
      cnt = this.ordersProc.delete(ordersno);
     
      mav.addObject("cnt", cnt);
      mav.setViewName("redirect:/orders/list.do"); // spring ��ȣ��
      
      return mav;      
    }

    /**
     * �޽���
     * @param ordersno
     * @return
     */
    @RequestMapping(value="/orders/msg.do", method=RequestMethod.GET)
    public ModelAndView msg(String url){
      ModelAndView mav = new ModelAndView();
      
      mav.setViewName("/orders/" + url);
      //��� ó�� �޼��� : /orders/create_msg.jsp
      //���� ó�� �޼��� : /orders/update_msg.jsp
      //���� ó�� �޼��� : /orders/delete_msg.jsp
      
      return mav; // forward
    }
    
    /**
     * ������ ��ư ����¡ ���
     * http://localhost:9090/project/orders/list_add_view.do
     * @param couponPage ��� ������
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/orders/list_add_view.do",
                                method = RequestMethod.GET,
                                produces = "text/plain;charset=UTF-8")
    public String list_add_view(int ordersPage) {
      
      System.out.println("ordersPage: " + ordersPage);
      
      HashMap<String, Object> map = new HashMap<String, Object>();
      map.put("ordersPage", ordersPage);
      
      List<OrdersVO> list = ordersProc.list_add_view(map);
      
      JSONObject obj = new JSONObject();
      obj.put("list", list);
   
      return obj.toString();     
    }
}
