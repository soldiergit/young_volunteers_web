package com.youngvolunteer.dao.volunteer;

import com.youngvolunteer.common.PageBean;
import com.youngvolunteer.model.SysVolunteerEntity;

/**
 * @Program: youngvolunteer
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-03 23:36
 * @Describe：
 **/
public interface VolunteerDao {

    /**
     * 添加
     * @param sysVolunteerEntity
     */
    public void saveSysVolunteer(SysVolunteerEntity sysVolunteerEntity);

    /**
     * 删除
     * @param sysVolunteerEntity
     */
    public void deleteSysVolunteer(SysVolunteerEntity sysVolunteerEntity);

    /**
     * 修改
     * @param sysVolunteerEntity
     */
    public void updateSysVolunteer(SysVolunteerEntity sysVolunteerEntity);

    /**
     * 查询
     * @param sysVolunteerEntity
     * @return
     */
    public SysVolunteerEntity findOneSysVolunteery(SysVolunteerEntity sysVolunteerEntity);

    /**
     * 查询
     * @return
     */
    public PageBean findAllSysVolunteer(String key, PageBean<SysVolunteerEntity> pageBean);
    /**
     * 批量删除
     * @param Ids
     */
    public void deleteAllSysVolunteer(String[] Ids);

}
