package dev.mvc.recipecate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.recipecategrp.RecipecategrpProcInter;
import dev.mvc.recipecategrp.RecipecategrpVO;


@Controller
public class RecipecateCont {
  @Autowired
  @Qualifier("dev.mvc.recipecategrp.RecipecategrpProc")
  private RecipecategrpProcInter recipecategrpProc;

  @Autowired
  @Qualifier("dev.mvc.recipecate.RecipecateProc")
  private RecipecateProcInter recipecateProc;
  
  public RecipecateCont() {
    System.out.println("--> RecipecateCont created.");
  }
  
  
  
  // http://localhost:9090/team1/recipecate/create.do
  /**
   * ��� ��
   * @return
   */
  @RequestMapping(value="/recipecate/create.do", method=RequestMethod.GET )
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/recipecate/create"); // webapp/recipecate/create.jsp
    
    return mav;
  }
  
  // http://localhost:9090/team1/recipecate/create.do
  /**
   * ��� ó��
   * @param recipecateVO
   * @return
   */
  @RequestMapping(value="/recipecate/create.do", method=RequestMethod.POST )
  public ModelAndView create(RecipecateVO recipecateVO) {
    ModelAndView mav = new ModelAndView();
    
    RecipecategrpVO recipecategrpVO = this.recipecategrpProc.read(recipecateVO.getRecipecategrpno());
    mav.addObject("recipecategrpVO", recipecategrpVO);
     
    int cnt = this.recipecateProc.create(recipecateVO);
    mav.addObject("cnt", cnt); // request�� ����
    
    if (cnt == 1) {
      mav.setViewName("/recipecate/create_msg"); // webapp/recipecate/create_msg.jsp
      // mav.setViewName("redirect:/cate/list.do"); // spring ��ȣ��
    } else { 
      mav.setViewName("/recipecate/create_msg"); // webapp/recipecate/create_msg.jsp
    }
    
    return mav;
  }
  
  // http://localhost:9090/team1/recipecate/list.do
  /**
   * ��ü ���
   * @return
   */
  @RequestMapping(value="/recipecate/list.do", method=RequestMethod.GET )
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView();
    
    List<RecipecateVO> list = this.recipecateProc.list_seqno_asc();
    mav.addObject("list", list); // request.setAttribute("list", list);

    mav.setViewName("/recipecate/list"); // webapp/cate/list.jsp
    return mav;
  }
  
  // http://localhost:9090/team1/recipecate/read_update.do
  /**
   * ��ȸ + ������
   * @param recipecateno ��ȸ�� ī�װ� ��ȣ
   * @return
   */
  @RequestMapping(value="/recipecate/read_update.do", method=RequestMethod.GET )
  public ModelAndView read_update(int recipecateno) {
    
    ModelAndView mav = new ModelAndView();
    
    RecipecateVO recipecateVO = this.recipecateProc.read(recipecateno);
    mav.addObject("recipecateVO", recipecateVO);  // request ��ü�� ����
    
    List<RecipecateVO> list = this.recipecateProc.list_seqno_asc();
    mav.addObject("list", list);  // request ��ü�� ����

    mav.setViewName("/recipecate/read_update"); 
    return mav; // forward
  }
  
  // http://localhost:9090/team1/recipecate/update.do
  /**
   * ���� ó��
   * @param recipecateVO
   * @return
   */
  @RequestMapping(value="/recipecate/update.do", method=RequestMethod.POST )
  public ModelAndView update(RecipecateVO recipecateVO) {
    ModelAndView mav = new ModelAndView();
    
    int cnt = this.recipecateProc.update(recipecateVO);
    mav.addObject("cnt", cnt); // request�� ����
    
    if (cnt == 1) {
      // mav.setViewName("/cate/update_msg"); // webapp/cate/update_msg.jsp
      mav.setViewName("redirect:/recipecate/list.do"); // spring ��ȣ��
    } else { 
      mav.setViewName("/recipecate/update_msg"); // webapp/cate/update_msg.jsp
    }
    
    return mav;
  }
  
  // http://localhost:9090/team1/recipecate/read_delete.do
  /**
   * ��ȸ + ������
   * @param recipecateno ������ ī�װ� ��ȣ
   * @return
   */
  @RequestMapping(value="/recipecate/read_delete.do", method=RequestMethod.GET )
  public ModelAndView read_delete(int recipecateno) {
    // request.setAttribute("cateno", int cateno) �۵� �ȵ�.
    
    ModelAndView mav = new ModelAndView();
    
    RecipecateVO recipecateVO = this.recipecateProc.read(recipecateno);
    mav.addObject("recipecateVO", recipecateVO);  // request ��ü�� ����
    
    List<RecipecateVO> list = this.recipecateProc.list_seqno_asc();
    mav.addObject("list", list);  // request ��ü�� ����

    mav.setViewName("/recipecate/read_delete"); // webapp/cate/read_delete.jsp
    return mav; // forward
  }
  
  // http://localhost:9090/team1/recipecate/delete.do
  /**
   * ���� ó��
   * @param recipecateVO
   * @return
   */
  @RequestMapping(value="/recipecate/delete.do", method=RequestMethod.POST )
  public ModelAndView delete(int recipecateno) {
    ModelAndView mav = new ModelAndView();
    
    int cnt = this.recipecateProc.delete(recipecateno);
    mav.addObject("cnt", cnt); // request�� ����
    
    if (cnt == 1) {
      // mav.setViewName("/cate/delete_msg"); // webapp/cate/delete_msg.jsp
      mav.setViewName("redirect:/recipecate/list.do"); // spring ��ȣ��
    } else { 
      mav.setViewName("/recipecate/delete_msg"); // webapp/cate/delete_msg.jsp
    }
    
    return mav;
  }
  
}
