package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;

import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.UserDao;
import com.russ4stall.critter.utils.LoginNotRequired;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * Date: 10/15/14
 * Time: 2:35 PM
 *
 * @author Russ Forstall
 */

@LoginNotRequired
@Result(location = "/landing-page", type = "redirect")
public class LoginAction extends ActionSupport implements SessionAware {
    private String email;
    private String password;

    private Map<String, Object> session;

    private UserDao userDao;

    public String input() {
        //if user is already logged in, redirect to landing page
        if (session.containsKey("user")) {
            return SUCCESS;
        }
        return INPUT;
    }

    @Override
    public void validate() {
        if(isEmpty(email)) {
            addFieldError("email", "Email is a required field");
            return;
        }
        if(isEmpty(password)) {
            addFieldError("password", "Password is a required field");
            return;
        }
        UserDao userDao = new DbiFactory().getDbi().open(UserDao.class);
        User user = userDao.getUserByEmail(email);
        if (user == null || !BCrypt.checkpw(password, user.getPassword())) {
            addFieldError("email", "Incorrect email and password combination");
        }

        userDao.close();
    }

    @Override
    public String execute() throws Exception {
        UserDao userDao = new DbiFactory().getDbi().open(UserDao.class);
        User user = userDao.getUserByEmail(email);

        session.put("user", user);

        userDao.close();
        return SUCCESS;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
