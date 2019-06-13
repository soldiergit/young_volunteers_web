package com.youngvolunteer.action.admin;

import com.youngvolunteer.model.SysAdminEntity;
import com.youngvolunteer.service.admin.AdminService;
import com.youngvolunteer.vo.R;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Program: youngvolunteer
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-04-28 23:53
 * @Describe：
 **/
public class AdminAction extends ActionSupport implements ModelDriven<SysAdminEntity> {

    private static Logger logger = Logger.getLogger(SysAdminEntity.class);

    @Autowired
    private AdminService adminService;

    private SysAdminEntity sysAdminEntity = new SysAdminEntity();

    private String oldPassword;

    private R result = new R();

    @Override
    public SysAdminEntity getModel() {
        return this.sysAdminEntity;
    }

    public String addAdmin(){

        System.out.println("添加管理员");

        adminService.saveAdmin(sysAdminEntity);

        return SUCCESS;
    }
    /**
     * 单个查询
     * @return
     */
    public String selectOneAdmin(){

        SysAdminEntity sysAdminEntity1 = adminService.findOneAdmin(sysAdminEntity);

        System.out.println(sysAdminEntity1);

        return SUCCESS;
    }

    public SysAdminEntity getSysAdminEntity() {
        return sysAdminEntity;
    }

    public void setSysAdminEntity(SysAdminEntity sysAdminEntity) {
        this.sysAdminEntity = sysAdminEntity;
    }

    public R getResult() {
        return result;
    }

    public void setResult(R result) {
        this.result = result;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
