package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.UserDao;
import com.russ4stall.critter.utils.LoginNotRequired;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Map;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * @author Russ Forstall
 */
@LoginNotRequired
@Result(location = "/landing-page", type = "redirect")
public class RegisterAction extends ActionSupport implements SessionAware {
    private static final int MINIMUM_PASSWORD_LENGTH = 6;

    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private Map<String, Object> session;

    public String input() {
        //if user is already logged in, redirect to landing page
        if (session.containsKey("user")) {
            return SUCCESS;
        }
        return INPUT;
    }

    @Override
    public String execute() throws Exception {
        UserDao userDao = new DbiFactory().getDbi().open(UserDao.class);
        String hashPass = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User(
                UUID.randomUUID().toString(),
                name,
                email,
                hashPass
        );
        userDao.createUser(user.getId(), name, email, hashPass);
        session.put("user", user);

        userDao.close();
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (isEmpty(name)) {
            addFieldError("name", "Name is a required field.");
            return;
        }
        if (isEmpty(email)) {
            addFieldError("email", "Email is a required field.");
            return;
        }
        if (!EmailValidator.getInstance().isValid(email)) {
            addFieldError("email", "A valid email is required.");
            return;
        }
        if (isEmpty(password)) {
            addFieldError("password", "Password is a required field.");
            return;
        }
        if (!StringUtils.equals(password, confirmPassword)) {
            addFieldError("password", "Passwords don't match.");
            return;
        }
        if (password.length() < MINIMUM_PASSWORD_LENGTH) {
            addFieldError("password", "Password must be at least " + MINIMUM_PASSWORD_LENGTH + " characters long.");
            return;
        }
        UserDao userDao = new DbiFactory().getDbi().open(UserDao.class);
        if (userDao.getUserByEmail(email) != null) {
            addFieldError("email", "This email is taken.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setSession(Map<String, Object> stringObjectMap) {
        session = stringObjectMap;
    }
}
