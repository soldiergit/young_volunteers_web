package com.youngvolunteer.dao.login;

import com.youngvolunteer.model.SysUserEntity;
import com.youngvolunteer.vo.R;

/**
 * @Program: youngvolunteer
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-05-01 20:55
 * @Describe：
 **/
public interface LoginDao {

    /**
     * 用户登入
     * @param sysUserEntity
     * @return
     */
    R userLogin(SysUserEntity sysUserEntity);

    /**
     * 修改密码
     * @param sysUserEntity
     * @return
     */
    R updatePassword(SysUserEntity sysUserEntity, String newPassword);

}
