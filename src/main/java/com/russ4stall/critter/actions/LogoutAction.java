package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.utils.LoginNotRequired;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@LoginNotRequired
@Result(location = "/login", type = "redirect")
public class LogoutAction extends ActionSupport implements SessionAware, ServletResponseAware {
    private Map<String, Object> session;
    @SuppressWarnings("UnusedDeclaration")
    private HttpServletResponse response;

    public String input() {
        session.remove("user");
        //Cookie cookie = new Cookie("remember-me", "");
        //cookie.setMaxAge(0);
        //response.addCookie(cookie);
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}
