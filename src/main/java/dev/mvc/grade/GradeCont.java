package dev.mvc.grade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GradeCont {
  @Autowired
  @Qualifier("dev.mvc.grade.GradeProc")
  private GradeProcInter gradeProc;
  
  public GradeCont() {
    System.out.println("--> GradeCont created.");
  }
  
  //http://localhost:9090/team1/grade/create.do
  /**
  * ��� ��
  * @return
  */
  @RequestMapping(value="/grade/create.do", method=RequestMethod.GET)
  public ModelAndView create() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/grade/create"); // webapp/grade/create.jsp
   
    return mav;
  }
  
  // http://localhost:9090/team1/grade/create.do
  /**
   * ��� ó��
   * @param gradeVO
   * @return
   */
  @RequestMapping(value="/grade/create.do", method=RequestMethod.POST )
  public ModelAndView create(GradeVO gradeVO) {
    // CategrpVO categrpVO <FORM> �±��� ������ �ڵ� ������.
    // request.setAttribute("categrpVO", categrpVO); �ڵ� ����
    
    ModelAndView mav = new ModelAndView();
    
    int cnt = this.gradeProc.create(gradeVO); // ��� ó��
    mav.addObject("cnt", cnt); // request�� ����, request.setAttribute("cnt", cnt)
    
    mav.setViewName("/grade/create_msg"); // webapp/grade/create_msg.jsp

    return mav; // forward
  }
  
  //localhost:9090/team1/grade/list.do
  /**
   * ��ü ���
   * @return
   */
  @RequestMapping(value="/grade/list.do", method=RequestMethod.GET)
  public ModelAndView list(){
    ModelAndView mav = new ModelAndView();
    
    List<GradeVO> list = this.gradeProc.list();
    mav.addObject("list", list);
    
    mav.setViewName("/grade/list"); // webapp/grade/list.jsp
    
    return mav;
  }
  
  // http://localhost:9090/team1/grade/read_update.do
  /**
   * ��ȸ + ������
   * @param gradeno ��ȸ�� ī�װ� ��ȣ
   * @return
   */
  @RequestMapping(value="/grade/read_update.do", method=RequestMethod.GET )
  public ModelAndView read_update(int gradeno) {
    ModelAndView mav = new ModelAndView();
    
    GradeVO gradeVO = this.gradeProc.read(gradeno);
    mav.addObject("gradeVO", gradeVO);
    
    List<GradeVO> list = this.gradeProc.list();
    mav.addObject("list", list); 

    mav.setViewName("/grade/read_update"); // webapp/grade/read_update.jsp
    return mav;
  }
  
  // http://localhost:9090/team1/grade/update.do
  /**
   * ���� ó��
   * @param gradeVO
   * @return
   */
  @RequestMapping(value="/grade/update.do", method=RequestMethod.POST )
  public ModelAndView update(GradeVO gradeVO) {
    ModelAndView mav = new ModelAndView();
    
    int cnt = this.gradeProc.update(gradeVO);
    mav.addObject("cnt", cnt); // request�� ����
    
    mav.setViewName("/grade/update_msg"); // webapp/grade/update_msg.jsp
    
    return mav;
  }
  
  // http://localhost:9090/team1/grade/read_delete.do
  /**
   * ��ȸ + ������
   * @param gradeno ��ȸ�� ī�װ� ��ȣ
   * @return
   */
  @RequestMapping(value="/grade/read_delete.do", method=RequestMethod.GET )
  public ModelAndView read_delete(int gradeno) {
    ModelAndView mav = new ModelAndView();
    
    GradeVO gradeVO = this.gradeProc.read(gradeno); // ������ �ڷ� �б�
    mav.addObject("gradeVO", gradeVO);  // request ��ü�� ����
    
    List<GradeVO> list = this.gradeProc.list(); // ���
    mav.addObject("list", list);  // request ��ü�� ����

    mav.setViewName("/grade/read_delete"); // webapp/grade/read_delete.jsp
    return mav;
  }

  // http://localhost:9090/team1/grade/delete.do
  /**
   * ����
   * @param categrpno ��ȸ�� ī�װ� ��ȣ
   * @return
   */
  @RequestMapping(value="/grade/delete.do", method=RequestMethod.POST )
  public ModelAndView delete(int gradeno) {
    ModelAndView mav = new ModelAndView();
    
    GradeVO gradeVO = this.gradeProc.read(gradeno); 
    mav.addObject("gradeVO", gradeVO);
    
    int cnt = this.gradeProc.delete(gradeno);
    mav.addObject("cnt", cnt); 
    
    mav.setViewName("/grade/delete_msg"); // webapp/grade/delete_msg.jsp

    return mav;
  }
  
  
  
}
