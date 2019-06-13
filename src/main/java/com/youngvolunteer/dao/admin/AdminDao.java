package com.youngvolunteer.dao.admin;

import com.youngvolunteer.model.SysAdminEntity;

import java.util.List;

/**
 * @Program: youngvolunteer
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-04 00:10
 * @Describe：
 **/
public interface AdminDao {
    void saveAdmin(SysAdminEntity sysAdminEntity);

    void updateAdmin(SysAdminEntity sysAdminEntity);

    void deleteAdmin(SysAdminEntity sysAdminEntity);

    SysAdminEntity findOneAdmin(SysAdminEntity sysAdminEntity);

    List<SysAdminEntity> findAllAdmin(SysAdminEntity sysAdminEntity);
}
