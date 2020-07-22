package dev.mvc.blacklist;

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

@Controller
public class BlacklistCont {

   public BlacklistCont() {
     System.out.println("--> BlacklistCont ������;");
   }
   
   @Autowired
   @Qualifier("dev.mvc.blacklist.BlacklistProc")
   private BlacklistProcInter blacklistProc;
   
   /**
    * ������Ʈ ��� ��
    * @return
    */
   // http://localhost:9090/team1/blacklist/create.do
   @RequestMapping(value="/blacklist/create.do", method=RequestMethod.GET)
   public ModelAndView create(HttpSession session) {
     ModelAndView mav = new ModelAndView();
     if(session.getAttribute("adminno") != null) {
       mav.setViewName("/blacklist/create");
     } else {
       mav.addObject("needlogin", 1);
       mav.setViewName("redirect:/admini/login.do");
     }
     
     return mav;
   }
   
   /**
    * ID�� �����ϴ��� üũ
    * @return
    */
   // http://localhost:9090/team1/blacklist/create.do
   @ResponseBody
   @RequestMapping(value="/blacklist/getmemberinfo.do", method=RequestMethod.GET,
                            produces="text/plain;charset=UTF-8")
   public String getmemberinfo(String identify) {
     
     JSONObject json = new JSONObject();
     if(this.blacklistProc.checkID(identify) == 1) {
       HashMap<Object, Object> map = new HashMap<Object, Object>();
       map = this.blacklistProc.getByID(identify);
       json.put("rs", 1);
       json.put("memberno", map.get("MEMBERNO").toString());
       json.put("mname", (String)map.get("MNAME"));
       json.put("mnickname", (String)map.get("NICKNAME"));
       json.put("gradeno", map.get("GRADENO").toString());
       json.put("mdate", map.get("MDATE").toString());
     } else {
       json.put("rs", 0);
     }
     return json.toString();
   }
   
   /**
    * �̹� ����� ID���� üũ
    * @return
    */
   // http://localhost:9090/team1/blacklist/create.do
   @ResponseBody
   @RequestMapping(value="/blacklist/isexists.do", method=RequestMethod.GET,
                            produces="text/plain;charset=UTF-8")
   public String isexists(int memberno) {
     
//     System.out.println("memberno:" + memberno);
     JSONObject json = new JSONObject();
     int exists = this.blacklistProc.isexists(memberno);
//     System.out.println(exists);
     json.put("exists", exists);
     return json.toString();
   }
   
   /**
    * ������Ʈ ��� ó��
    * @return
    */
   // http://localhost:9090/team1/blacklist/create.do
   @RequestMapping(value="/blacklist/create.do", method=RequestMethod.POST)
   public ModelAndView create(BlacklistVO blacklistVO) {
     ModelAndView mav = new ModelAndView();
     if(blacklistVO.getReason() == null) {
       blacklistVO.setReason("none");
     }
     int cnt = this.blacklistProc.create(blacklistVO);
     mav.addObject("cnt", cnt);
     mav.addObject("url", "create_msg");
     mav.setViewName("redirect:/blacklist/msg.do");
     return mav;
   }
   
   /**
    * ������Ʈ
    * @return
    */
   // http://localhost:9090/team1/blacklist/create.do
   @RequestMapping(value="/blacklist/list.do", method=RequestMethod.GET)
   public ModelAndView list(HttpSession session) {
     ModelAndView mav = new ModelAndView();
     if(session.getAttribute("adminno") != null) {
       List<HashMap<Object, Object>> list = this.blacklistProc.list();
       System.out.println(list);
       mav.addObject("list", list);
       mav.setViewName("/blacklist/list");
     } else {
       mav.addObject("needlogin", 1);
       mav.setViewName("redirect:/admini/login.do");
     }
     return mav;
   }
   
   /**
    * ���� �߰�
    * @return
    */
   // http://localhost:9090/team1/blacklist/create.do
   @ResponseBody
   @RequestMapping(value="/blacklist/update_todate.do", method=RequestMethod.POST,
                            produces="text/plain;charset=UTF-8")
   public String update_todate(int blacklistno, int plusdate) {
     
//     System.out.println("memberno:" + memberno);
     JSONObject json = new JSONObject();
     System.out.println("blacklistno: " + blacklistno + ", plusdate: " + plusdate);
     int cnt = this.blacklistProc.update_todate(blacklistno, plusdate);
//     System.out.println(exists);
     json.put("cnt", cnt);
     return json.toString();
   }
   
   /**
    * ����
    * @return
    */
   // http://localhost:9090/team1/blacklist/delete.do
   @ResponseBody
   @RequestMapping(value="/blacklist/delete.do", method=RequestMethod.POST,
                            produces="text/plain;charset=UTF-8")
   public String delete(int blacklistno) {
     
//     System.out.println("memberno:" + memberno);
     JSONObject json = new JSONObject();
     System.out.println("����, blacklistno: " + blacklistno);
     int cnt = this.blacklistProc.delete(blacklistno);
//     System.out.println(exists);
     json.put("cnt", cnt);
     return json.toString();
   }
   
   /**
    * �޽���
    * @param url
    * @return
    */
   @RequestMapping(value="/blacklist/msg.do", method=RequestMethod.GET )
   public ModelAndView msg(String url) {
     ModelAndView mav = new ModelAndView();
     // ��� ó�� �޽���: /admini/create_msg.jsp
     // ���� ó�� �޽���: /admini/update_msg.jsp
     // ���� ó�� �޽���: /admini/delete_msg.jsp
     mav.setViewName("/blacklist/" + url); 
     return mav;
   }
}
