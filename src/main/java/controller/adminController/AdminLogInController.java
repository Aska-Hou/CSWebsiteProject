package controller.adminController;

import domain.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AdminService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping(value = "/admin")
public class AdminLogInController {

    @Autowired
    public AdminService adminService;

    @RequestMapping(value = "/logIn")
    public void logIn(Manager manager, String checkCode, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        HttpSession session = httpServletRequest.getSession();
        String correctCheckCode = (String) session.getAttribute("CHECKCODE_SERVER");

        boolean logInResult = adminService.logIn(manager);
        httpServletResponse.setContentType("application/json; charset=utf-8");
        PrintWriter writer = httpServletResponse.getWriter();

        //        验证码不对
        if (!correctCheckCode.equalsIgnoreCase(checkCode)) {
            writer.write("{\"result\":\"false\"}");
        } else {
            //            账号密码对
            if (logInResult) {
                session = httpServletRequest.getSession();
                session.setAttribute("manager", manager);
                Cookie cookie = new Cookie("manager", String.valueOf(manager.getManager_id()));
                cookie.setPath("/");
                httpServletResponse.addCookie(cookie);
                writer.write("{\"result\":\"true\"}");
            } else {
            //            账号密码不对
                writer.write("{\"result\":\"false\"}");
            }
        }
    }

    @RequestMapping(value = "/logOut")
    public void logOut(Manager manager, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("manager");
        Cookie cookie = new Cookie("manager", null);
        cookie.setPath("/");
        response.addCookie(cookie);
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("{\"logOutResult\":\"true\"}");
    }

    @RequestMapping(value = "/getAdminInfo")
    @ResponseBody
    public Manager getAdminInfo(HttpServletRequest request){
        HttpSession session = request.getSession();
        Manager manager = (Manager) session.getAttribute("manager");
        return manager;
    }

    @RequestMapping(value = "/changePassword")
    public void changePassword(Manager manager, String newPassword, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Manager sessionManager = (Manager)session.getAttribute("manager");
        manager.setManager_id(sessionManager.getManager_id());
        boolean result = adminService.changePassword(manager, newPassword);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (result){
            logOut(manager, request, response);
        }
        else
            writer.write("{\"updateResult\":\"false\"}");
    }

    @RequestMapping(value = "/addNewAccount")
    public void addNewAccount(Manager manager, HttpServletResponse response) throws IOException {
        boolean findResult = adminService.findIDValid(manager);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (!findResult){
            writer.write("{\"addResult\":\"idInvalid\"}");
            return;
        }
        boolean addResult = adminService.addNewManager(manager);
        if (addResult){
            writer.write("{\"addResult\":\"true\"}");
        }
        else {
            writer.write("{\"addResult\":\"false\"}");
        }
    }
}
