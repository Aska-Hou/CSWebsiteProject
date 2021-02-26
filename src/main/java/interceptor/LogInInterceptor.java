package interceptor;

import domain.Manager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogInInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getRequestURI().contains("checkCode") || request.getRequestURI().contains("adminLogin.html") || request.getRequestURI().contains("logIn")){
            return true;
        }
        else {
            Cookie[] cookies = request.getCookies();
            HttpSession session = request.getSession();
            Manager manager = (Manager) session.getAttribute("manager");
            if (manager == null) {
                response.sendRedirect("/CSWebsiteProject_war_exploded/admin/adminLogin.html?hintMessage=true");
                return false;
            }
            for (Cookie cookie : cookies) {
                if ("manager".equals(cookie.getName())) {
                    if (manager.getManager_id() == Integer.parseInt(cookie.getValue()))
                        return true;
                }
            }
            response.sendRedirect("/admin/adminLogin.html?hintMessage=true");
            return false;
        }
    }

}
