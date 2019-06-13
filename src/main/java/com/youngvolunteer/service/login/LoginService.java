package com.youngvolunteer.service.login;

import com.youngvolunteer.model.SysUserEntity;
import com.youngvolunteer.vo.R;

/**
 * @Program: youngvolunteer
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-01 23:13
 * @Describe：
 **/
public interface LoginService {
    /**
     * 用户登入
     * @param sysUserEntity
     * @return
     */
    public R userLogin(SysUserEntity sysUserEntity);

    /**
     * 修改密码
     * @param sysUserEntity
     * @param newPassword
     * @return
     */
    R updatePassword(SysUserEntity sysUserEntity,String newPassword);
}
