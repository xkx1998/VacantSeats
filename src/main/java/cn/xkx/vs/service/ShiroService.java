package cn.xkx.vs.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;

import java.util.Date;

public class ShiroService {

    @RequiresRoles({"admin"})
    public void testMethod() {
        System.out.println("testMethod,Time:" + new Date());

        Session session = SecurityUtils.getSubject().getSession();
        Object val = session.getAttribute("key");
        System.out.println("Service SessionVal :"+val);
    }
}
