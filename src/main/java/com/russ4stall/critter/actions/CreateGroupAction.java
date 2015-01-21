package com.russ4stall.critter.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by russ on 1/15/15.
 */
public class CreateGroupAction extends ActionSupport implements SessionAware {


    private Map<String, Object> session;

    @Override
    public String input() throws Exception {
        return super.input();
    }

    @Override
    public void validate() {
        super.validate();
    }

    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
