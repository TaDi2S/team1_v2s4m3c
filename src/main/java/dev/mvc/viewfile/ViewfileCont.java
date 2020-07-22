package dev.mvc.viewfile;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.tool.Tool;
import dev.mvc.tool.Upload;

@Controller
public class ViewfileCont {
  @Autowired
  @Qualifier("dev.mvc.viewfile.ViewfileProc")
  private ViewfileProcInter viewfileProc;

  // http://localhost:9090/team1/viewfile/create.do
  /**
   * ��� ��
   * @return
   */  
  @RequestMapping(value="/viewfile/create.do", method=RequestMethod.GET )
  public ModelAndView create(int p_no) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/viewfile/create");
    
    return mav;
  }
  /**
   * ���� ���
   * @param request
   * @param viewfileVO
   * @param goryno �Խ��� ī�װ� ��ȣ
   * @return
   */  
  @RequestMapping(value = "/viewfile/create.do", method = RequestMethod.POST)
  public ModelAndView create(HttpServletRequest request,
                                           ViewfileVO viewfileVO,
                                           int goryno) {
    
    ModelAndView mav = new ModelAndView();
    // -----------------------------------------------------
    // ���� ���� �ڵ� ����
    // -----------------------------------------------------
    int p_no = viewfileVO.getP_no(); // �θ�� ��ȣ
    String vname = ""; // ���� ���ϸ�
    String vupname = ""; // ���ε�� ���ϸ�
    long vsize = 0;  // ���� ������
    String thumb = ""; // Preview �̹���
    int upload_count = 0; // ����ó���� ���ڵ� ����
    
    String upDir = Tool.getRealPath(request, "/viewfile/storage"); // ���� ���
    // ���� ������ ��� fnamesMF ��ü�� ������.
    List<MultipartFile> vnamesMF = viewfileVO.getVnamesMF();  // ���� ���
    int count = vnamesMF.size(); // ���� ���� ����
    if (count > 0) { // ������ ������ �ִٸ�
      for (MultipartFile multipartFile:vnamesMF) { // ���� ����
        vsize = multipartFile.getSize(); // ���� ũ��
        if (vsize > 0) { // ���� ũ�� üũ
          vname = multipartFile.getOriginalFilename(); // ���� ���ϸ�, spring.jpg
          // ���� ���� �� ���ε�� ���ϸ��� ���ϵ�, spring.jsp, spring_1.jpg...
          vupname = Upload.saveFileSpring(multipartFile, upDir); 
          
          if (Tool.isImage(vname)) { // �̹������� �˻�
            // thumb �̹��� ������ ���ϸ� ���ϵ�, width: 120, height: 80
            thumb = Tool.preview(upDir, vupname, 120, 80); 
          }
        }
        ViewfileVO vo = new ViewfileVO();
        vo.setP_no(p_no);
        vo.setVname(vname);
        vo.setVupname(vupname);
        vo.setThumb(thumb);
        vo.setVsize(vsize);
        
        upload_count = upload_count + viewfileProc.create(vo); // ���� 1�� ��� ���� dbms ����
      }
    }    
    // -----------------------------------------------------
    // ���� ���� �ڵ� ����
    // -----------------------------------------------------    
    mav.addObject("upload_count", upload_count);

    mav.addObject("p_no", viewfileVO.getP_no());

    System.out.println(viewfileVO.getP_no());
    
    mav.setViewName("redirect:/viewfile/create_msg.jsp");
    return mav;
  }  
  
  /**
   * ���
   * http://localhost:9090/viewfile/list.do
   * 
   * @return
   */
  @RequestMapping(value = "/viewfile/list.do", method = RequestMethod.GET)
  public ModelAndView list() {
    ModelAndView mav = new ModelAndView();

    List<ViewfileVO> list = viewfileProc.list();
    mav.addObject("list", list);

    mav.setViewName("/viewfile/list");

    return mav;
  }  
  
  /**
   * ÷�� ���� 1�� ���� ó��
   * 
   * @return
   */
  @RequestMapping(value = "/viewfile/delete.do", 
                             method = RequestMethod.GET)
  public ModelAndView delete_proc(HttpServletRequest request,
                                                int viewfileno) {
    ModelAndView mav = new ModelAndView();

    // ������ ���� ������ �о��.
    ViewfileVO viewfileVO = viewfileProc.read(viewfileno);
    
    String upDir = Tool.getRealPath(request, "/viewfile/storage"); // ���� ���
    Tool.deleteFile(upDir, viewfileVO.getVupname()); // Folder���� 1���� ���� ����
    Tool.deleteFile(upDir, viewfileVO.getThumb()); // 1���� Thumb ���� ����
    
    // DBMS���� 1���� ���� ����
    viewfileProc.delete(viewfileno);
        
    List<ViewfileVO> list = viewfileProc.list();        
    mav.addObject("list", list);
    
    mav.setViewName("redirect:/viewfile/list.do"); 

    return mav;
  }  
  
  
}
