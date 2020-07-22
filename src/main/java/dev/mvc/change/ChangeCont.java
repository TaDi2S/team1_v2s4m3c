package dev.mvc.change;


import java.util.List;

import javax.mail.internet.ParameterList;

import org.apache.commons.fileupload.ParameterParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ChangeCont {
  @Autowired
  @Qualifier("dev.mvc.change.ChangeProc")
  private ChangeProcInter changeProc;
  
  public ChangeCont() {
    
  }
  
  // http://localhost:9090/team1/change/create.do
  /**
   * ��� ��
   * @return
   */
  @RequestMapping(value="/change/create.do", method=RequestMethod.GET )
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/change/create");

    return mav; // forward
  }

  /**
   * ��� ó��
   * @param changeVO
   * @return
   */
  @RequestMapping(value="/change/create.do", method=RequestMethod.POST)
  public ModelAndView create(ChangeVO changeVO){
    ModelAndView mav = new ModelAndView();

    // System.out.println("id: " + memberVO.getId());
    

    int cnt= changeProc.create(changeVO);
    mav.addObject("cnt", cnt); 
    mav.addObject("changeno", changeVO.getChangeno());
    mav.addObject("url", "create_msg"); 

    mav.setViewName("redirect:/change/msg.do");

    return mav;
  }

  // http://localhost:9090/team1/change/list.do
  /**
   * ��ü ���
   * @return
   */
  @RequestMapping(value="/change/list.do", method=RequestMethod.GET )
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView();

    List<ChangeVO> list = this.changeProc.list();
    mav.addObject("list", list); 

    mav.setViewName("/change/list"); 
    return mav;
  }

  // http://localhost:9090/team1/change/read.do
  /**
   * ��ȸ + ���� 
   * @return
   */
  @RequestMapping(value="/change/read.do", method=RequestMethod.GET )
  public ModelAndView read(int changeno) {
    ModelAndView mav = new ModelAndView();

    ChangeVO changeVO = this.changeProc.read(changeno);
    mav.addObject("changeVO", changeVO); 
    mav.addObject("changeno", changeVO.getChangeno());
    mav.setViewName("/change/read");

    return mav;
  }


  // http://localhost:9090/team1/change/update.do
  /**
   * ���� ó��
   * @param changeVO
   * @return
   */
  @RequestMapping(value="/change/update.do", method=RequestMethod.POST )
  public ModelAndView update(ChangeVO changeVO) {
    ModelAndView mav = new ModelAndView();

    int cnt = this.changeProc.update(changeVO);
    mav.addObject("cnt", cnt); // request�� ����
    mav.addObject("changeno", changeVO.getChangeno());
    mav.addObject("url", "update_msg");

    mav.setViewName("redirect:/change/msg.do");

    return mav;
  }

  // http://localhost:9090/team1/change/delete.do

  /**
   * ���� ��
   * @return
   */
  @RequestMapping(value="/change/delete.do", method=RequestMethod.GET )
  public ModelAndView delete(int changeno) {
    ModelAndView mav = new ModelAndView();

    ChangeVO changeVO = this.changeProc.read(changeno);
    mav.addObject("changeVO", changeVO);

    mav.setViewName("/change/delete");

    return mav;
  }

  // http://localhost:9090/team1/change/delete.do
  /**
   * ���� ó��
   * @param changeVO
   * @return
   */
  @RequestMapping(value="/change/delete.do", method=RequestMethod.POST )
  public ModelAndView delete_proc(int changeno) {
    ModelAndView mav = new ModelAndView();

    ChangeVO changeVO = this.changeProc.read(changeno);
    int cnt = this.changeProc.delete(changeno);
    mav.addObject("cnt", cnt); // request�� ����
    mav.addObject("changeno", changeVO.getChangeno());
    mav.addObject("payno", changeVO.getOrdersno()); // redirect parameter ����
    mav.addObject("url", "delete_msg");

    mav.setViewName("redirect:/change/msg.do"); // spring ��ȣ��

    return mav;
  }

  /**
   * �޽���
   * @param changeno
   * @return
   */
  @RequestMapping(value="/change/msg.do", method=RequestMethod.GET)
  public ModelAndView msg(String url){
    ModelAndView mav = new ModelAndView();

    // ��� ó�� �޽���: create_msg --> /change/create_msg.jsp
    // ���� ó�� �޽���: update_msg --> /change/update_msg.jsp
    // ���� ó�� �޽���: delete_msg --> /change/delete_msg.jsp
    mav.setViewName("/change/" + url); // forward

    return mav; // forward
  }
}
