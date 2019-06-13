package com.youngvolunteer.service.activity;

import com.youngvolunteer.common.PageBean;
import com.youngvolunteer.model.VolunteerActivityEntity;

/**
 * @Program: youngvolunteer
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-04 00:09
 * @Describe：
 **/
public interface ActivityService {
    /**
     * 添加
     * @param volunteerActivityEntity
     */
    public void saveVolunteerActivity(VolunteerActivityEntity volunteerActivityEntity);

    /**
     * 删除
     * @param volunteerActivityEntity
     */
    public void deleteVolunteerActivity(VolunteerActivityEntity volunteerActivityEntity);

    /**
     * 修改
     * @param volunteerActivityEntity
     */
    public void updateVolunteerActivity(VolunteerActivityEntity volunteerActivityEntity);

    /**
     * 查询
     * @param volunteerActivityEntity
     * @return
     */
    public VolunteerActivityEntity findOneVolunteery(VolunteerActivityEntity volunteerActivityEntity);

    /**
     * 查询
     * @param key
     * @param pageBean
     * @return
     */
    public PageBean findAllVolunteerActivity(String key, PageBean<VolunteerActivityEntity> pageBean);

    /**
     * 批量删除
     * @param Ids
     */
    public void deleteAllVolunteerActivity(String[] Ids);

    /**
     * 查询参加了的活动
     * @param key
     * @param setPageSize
     * @param userId
     * @return
     */
    PageBean findAllVolunteerJoinActivity(String key, PageBean<VolunteerActivityEntity> setPageSize, String userId);

    /**
     * 查询未参加的活动
     * @param key
     * @param setPageSize
     * @param userId
     * @return
     */
    PageBean findAllVolunteerNojoinActivity(String key, PageBean<VolunteerActivityEntity> setPageSize, String userId);
}
