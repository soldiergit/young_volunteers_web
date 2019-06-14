package com.youngvolunteer.dao.activity;

import com.youngvolunteer.common.PageBean;
import com.youngvolunteer.model.VolunteerActivityEntity;

/**
 * @Program: youngvolunteer
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-04 00:09
 * @Describe：
 **/
public interface ActivityDao {
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

    /**
     * 查询已签到的活动
     * @param key
     * @param setPageSize
     * @param userId
     * @return
     */
    PageBean findAllVolunteerSigninActivity(String key, PageBean<VolunteerActivityEntity> setPageSize, String userId);

    /**
     * 查询未签到的活动
     * @param key
     * @param setPageSize
     * @param userId
     * @return
     */
    PageBean findAllVolunteerNoSigninActivity(String key, PageBean<VolunteerActivityEntity> setPageSize, String userId);

    /**
     * 查询已评分的活动
     * @param key
     * @param setPageSize
     * @return
     */
    PageBean findAllAdminScoreActivity(String key, PageBean<VolunteerActivityEntity> setPageSize);

    /**
     * 查询未评分的活动
     * @param key
     * @param setPageSize
     * @return
     */
    PageBean findAllAdminNOScoreActivity(String key, PageBean<VolunteerActivityEntity> setPageSize);
}
