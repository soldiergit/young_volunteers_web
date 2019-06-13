package com.youngvolunteer.service.sysuser.impl;

import com.youngvolunteer.common.PageBean;
import com.youngvolunteer.dao.sysuser.SysUserDao;
import com.youngvolunteer.model.SysUserEntity;
import com.youngvolunteer.service.sysuser.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Program: youngvolunteer
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-04 00:31
 * @Describe：
 **/
@Service
public class SysUserServiceImpl implements SysUserService {


    @Autowired
    private SysUserDao sysUserDao;
    /**
     * 添加
     * @param sysUserEntity
     */
    @Override
    public void saveUser(SysUserEntity sysUserEntity){
        sysUserDao.saveUser(sysUserEntity);
    }

    /**
     * 删除
     * @param sysUserEntity
     */
    @Override
    public void deleteUser(SysUserEntity sysUserEntity){
        sysUserDao.deleteUser(sysUserEntity);
    }

    /**
     * 修改
     * @param sysUserEntity
     */
    @Override
    public void updateUser(SysUserEntity sysUserEntity){
        sysUserDao.updateUser(sysUserEntity);
    }

    /**
     * 查询
     * @param sysUserEntity
     * @return
     */
    @Override
    public SysUserEntity findOneUser(SysUserEntity sysUserEntity){
        return sysUserDao.findOneUser(sysUserEntity);
    }

    /**
     * 查询
     * @param key
     * @param pageBean
     * @return
     */
    @Override
    public PageBean findAllUser(String key, PageBean<SysUserEntity> pageBean){
        return sysUserDao.findAllUser(key,pageBean);
    }
    /**
     * 批量删除
     * @param Ids
     */
    @Override
    public void deleteAllUser(String[] Ids){
        sysUserDao.deleteAllUser(Ids);
    }

}
