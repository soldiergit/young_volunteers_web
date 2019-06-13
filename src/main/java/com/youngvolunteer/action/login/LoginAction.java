package com.youngvolunteer.action.login;

import com.youngvolunteer.model.SysUserEntity;
import com.youngvolunteer.service.login.LoginService;
import com.youngvolunteer.vo.R;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Program: youngvolunteer
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-01 23:11
 * @Describe：
 **/
public class LoginAction extends ActionSupport implements ModelDriven<SysUserEntity> {

    private static Logger logger = Logger.getLogger(SysUserEntity.class);

    @Autowired
    private LoginService loginService;

    private SysUserEntity sysUserEntity = new SysUserEntity();

    private String newPassword;

    private R result = new R();

    /**
     * 用户登入
     * @return
     */
    public String userLogin(){

        logger.info("message:用户登入:"+sysUserEntity);

        result = loginService.userLogin(sysUserEntity);

        System.out.println(result);

        return SUCCESS;
    }

    /**
     * 修改密码
     * @return
     */
    public String updatePassword(){

        logger.info("修改密码："+sysUserEntity+"\t"+newPassword);

        result = loginService.updatePassword(sysUserEntity,newPassword);

        return SUCCESS;
    }

    /**
     * 退出登入
     * @return
     */
    public String logout(){

        System.out.println("用户退出");

        return SUCCESS;
    }



    public SysUserEntity getSysUserEntity() {
        return sysUserEntity;
    }

    public void setSysUserEntity(SysUserEntity sysUserEntity) {
        this.sysUserEntity = sysUserEntity;
    }

    public R getResult() {
        return result;
    }

    public void setResult(R result) {
        this.result = result;
    }

    @Override
    public SysUserEntity getModel() {
        return sysUserEntity;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
