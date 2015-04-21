package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.russ4stall.critter.core.User;
import com.russ4stall.critter.db.DbiFactory;
import com.russ4stall.critter.db.UserDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * @author Russ Forstall
 */
@Result(location = "/landing-page", type = "redirect")
public class ChangePasswordAction extends ActionSupport implements SessionAware {
    private static final int MINIMUM_PASSWORD_LENGTH = 6;
    private String password;
    private String newPassword;
    private String confirmNewPassword;
    private Map<String, Object> session;

    @Override
    public String input() throws Exception {
        return INPUT;
    }

    @Override
    public void validate() {
        if (isEmpty(password)) {
            addFieldError("password", "Please try again");
            return;
        }
        if (isEmpty(newPassword)) {
            addFieldError("newPassword", "Please try again");
            return;
        }
        if (isEmpty(confirmNewPassword)) {
            addFieldError("confirmNewPassword", "Please try again");
            return;
        }
        if (!StringUtils.equals(newPassword, confirmNewPassword)) {
            addFieldError("newPassword", "Passwords don't match.");
            return;
        }
        if (newPassword.length() < MINIMUM_PASSWORD_LENGTH) {
            addFieldError("password", "Password must be at least " + MINIMUM_PASSWORD_LENGTH + " characters long.");
            return;
        }
        User user = (User) session.get("user");
        try (UserDao userDao = new DbiFactory().getDbi().open(UserDao.class)) {
            if (user == null || !BCrypt.checkpw(password, user.getPassword())) {
                addFieldError("password", "Please try again");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String execute() throws Exception {
        String hashPass = BCrypt.hashpw(newPassword, BCrypt.gensalt());

        User user = (User) session.get("user");

        User newUser;

        try (UserDao userDao = new DbiFactory().getDbi().open(UserDao.class)) {
            userDao.changePassword(user.getId(), hashPass);
            newUser = userDao.getUserById(user.getId());
        }

        session.put("user", newUser);

        return SUCCESS;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
