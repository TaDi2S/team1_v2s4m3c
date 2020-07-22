package dev.mvc.delivery;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.deliverystate.DeliverystateProcInter;





@Controller
public class DeliveryCont {
  @Autowired
  @Qualifier("dev.mvc.delivery.DeliveryProc")
  private DeliveryProcInter deliveryProc;
  
  @Autowired
  @Qualifier("dev.mvc.deliverystate.DeliverystateProc")
  private DeliverystateProcInter deliverystateProc;

  public DeliveryCont() {

  }

  // http://localhost:9090/team1/delivery/create.do
  /**
   * ��� ��
   * @return
   */
  @RequestMapping(value="/delivery/create.do", method=RequestMethod.GET )
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    
    mav.setViewName("/delivery/create");

    return mav; // forward
  }

  /**
   * ��� ó��
   * @param 
   * @return
   */
  @RequestMapping(value="/delivery/create.do", method=RequestMethod.POST)
  public ModelAndView create(DeliveryVO deliveryVO){
    ModelAndView mav = new ModelAndView();

    // System.out.println("id: " + memberVO.getId());

    int cnt= deliveryProc.create(deliveryVO);
    mav.addObject("cnt", cnt); 
    mav.addObject("deliveryno", deliveryVO.getDeliveryno());
    mav.addObject("url", "create_msg"); 

    mav.setViewName("redirect:/delivery/msg.do");

    return mav;
  }

  // http://localhost:9090/team1/delivery/list.do
  /**
   * ��ü ���
   * @return
   */
  @RequestMapping(value="/delivery/list.do", method=RequestMethod.GET )
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView();

    
    List<DeliveryVO> list = this.deliveryProc.list();
    mav.addObject("list", list); // request.setAttribute("list", list);
    

    mav.setViewName("/delivery/list"); 
    return mav;
  }

  // http://localhost:9090/team1/delivery/read.do
  /**
   *��ȸ + ���� 
   * @return
   */
  @RequestMapping(value="/delivery/read.do", method=RequestMethod.GET )
  public ModelAndView read(int deliveryno) {
    ModelAndView mav = new ModelAndView();

    DeliveryVO deliveryVO = this.deliveryProc.read(deliveryno);
    mav.addObject("deliveryVO", deliveryVO); 
    mav.addObject("deliveryno", deliveryVO.getDeliveryno());
    mav.setViewName("/delivery/read");

    return mav;
  }


  // http://localhost:9090/team1/delivery/update.do
  /**
   * ���� ó��
   * @param deliveryVO
   * @return
   */
  @RequestMapping(value="/delivery/update.do", method=RequestMethod.POST )
  public ModelAndView update(DeliveryVO deliveryVO) {
    ModelAndView mav = new ModelAndView();

    int cnt = this.deliveryProc.update(deliveryVO);
    mav.addObject("cnt", cnt); // request�� ����
    mav.addObject("deliveryno", deliveryVO.getDeliveryno());
    mav.addObject("url", "update_msg");

    mav.setViewName("redirect:/delivery/msg.do");

    return mav;
  }

  // http://localhost:9090/team1/delivery/delete.do

  /**
   * ���� ��
   * @return
   */
  @RequestMapping(value="/delivery/delete.do", method=RequestMethod.GET )
  public ModelAndView delete(int deliveryno) {
    ModelAndView mav = new ModelAndView();

    DeliveryVO deliveryVO = this.deliveryProc.read(deliveryno);
    mav.addObject("deliveryVO", deliveryVO);

    mav.setViewName("/delivery/delete");

    return mav;
  }

  // http://localhost:9090/team1/delivery/delete.do
  /**
   * ���� ó��
   * @param deliveryVO
   * @return
   */
  @RequestMapping(value="/delivery/delete.do", method=RequestMethod.POST )
  public ModelAndView delete_proc(int deliveryno) {
    ModelAndView mav = new ModelAndView();

    DeliveryVO deliveryVO = this.deliveryProc.read(deliveryno);
    int cnt = this.deliveryProc.delete(deliveryno);
    mav.addObject("cnt", cnt); // request�� ����
    mav.addObject("deliveryno", deliveryVO.getDeliveryno()); // redirect parameter ����
    mav.addObject("deliveryno", deliveryVO.getReceiver()); // redirect parameter ����
    mav.addObject("url", "delete_msg");

    mav.setViewName("redirect:/delivery/msg.do"); // spring ��ȣ��

    return mav;
  }

  /**
   * �޽���
   * @param deliveryno
   * @return
   */
  @RequestMapping(value="/delivery/msg.do", method=RequestMethod.GET)
  public ModelAndView msg(String url){
    ModelAndView mav = new ModelAndView();

    // ��� ó�� �޽���: create_msg --> /delivery/create_msg.jsp
    // ���� ó�� �޽���: update_msg --> /delivery/update_msg.jsp
    // ���� ó�� �޽���: delete_msg --> /delivery/delete_msg.jsp
    mav.setViewName("/delivery/" + url); // forward

    return mav; // forward
  }


}
