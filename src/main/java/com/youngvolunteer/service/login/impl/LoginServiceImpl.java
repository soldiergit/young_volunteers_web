package com.youngvolunteer.service.login.impl;

import com.youngvolunteer.dao.login.LoginDao;
import com.youngvolunteer.model.SysUserEntity;
import com.youngvolunteer.service.login.LoginService;
import com.youngvolunteer.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Program: youngvolunteer
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-05-01 20:54
 * @Describe：
 **/
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    /**
     * 用户登入
     * @param sysUserEntity
     * @return
     */
    @Override
    public R userLogin(SysUserEntity sysUserEntity) {

        return loginDao.userLogin(sysUserEntity);
    }

    /**
     * 修改密码
     * @param sysUserEntity
     * @param newPassword
     * @return
     */
    @Override
    public R updatePassword(SysUserEntity sysUserEntity,String newPassword) {

        return loginDao.updatePassword(sysUserEntity,newPassword);
    }
}
