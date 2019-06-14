package com.youngvolunteer.service.activity.impl;

import com.youngvolunteer.common.PageBean;
import com.youngvolunteer.dao.activity.ActivityDao;
import com.youngvolunteer.model.VolunteerActivityEntity;
import com.youngvolunteer.service.activity.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Program: youngvolunteer
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-04 00:32
 * @Describe：
 **/
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityDao activityDao;
    /**
     * 添加
     * @param volunteerActivityEntity
     */
    @Override
    public void saveVolunteerActivity(VolunteerActivityEntity volunteerActivityEntity){
        activityDao.saveVolunteerActivity(volunteerActivityEntity);
    }

    /**
     * 删除
     * @param volunteerActivityEntity
     */
    @Override
    public void deleteVolunteerActivity(VolunteerActivityEntity volunteerActivityEntity){
        activityDao.deleteVolunteerActivity(volunteerActivityEntity);
    }

    /**
     * 修改
     * @param volunteerActivityEntity
     */
    @Override
    public void updateVolunteerActivity(VolunteerActivityEntity volunteerActivityEntity){
        activityDao.updateVolunteerActivity(volunteerActivityEntity);
    }

    /**
     * 查询
     * @param volunteerActivityEntity
     * @return
     */
    @Override
    public VolunteerActivityEntity findOneVolunteery(VolunteerActivityEntity volunteerActivityEntity){
        return activityDao.findOneVolunteery(volunteerActivityEntity);
    }

    /**
     * 查询
     * @param key
     * @param pageBean
     * @return
     */
    @Override
    public PageBean findAllVolunteerActivity(String key, PageBean<VolunteerActivityEntity> pageBean){
        return activityDao.findAllVolunteerActivity(key,pageBean);
    }
    /**
     * 批量删除
     * @param Ids
     */
    @Override
    public void deleteAllVolunteerActivity(String[] Ids){
        activityDao.deleteAllVolunteerActivity(Ids);
    }

    /**
     * 查询已加入的活动
     * @param key
     * @param setPageSize
     * @return
     */
    @Override
    public PageBean findAllVolunteerJoinActivity(String key, PageBean<VolunteerActivityEntity> setPageSize, String userId) {
        return activityDao.findAllVolunteerJoinActivity(key, setPageSize, userId);
    }

    /**
     * 查询未加入的活动
     * @param key
     * @param setPageSize
     * @return
     */
    @Override
    public PageBean findAllVolunteerNojoinActivity(String key, PageBean<VolunteerActivityEntity> setPageSize, String userId) {
        return activityDao.findAllVolunteerNojoinActivity(key,setPageSize, userId);
    }

    /**
     * 查询已签到的活动
     * @param key
     * @param setPageSize
     * @return
     */
    @Override
    public PageBean findAllVolunteerSigninActivity(String key, PageBean<VolunteerActivityEntity> setPageSize, String userId) {
        return activityDao.findAllVolunteerSigninActivity(key, setPageSize, userId);
    }

    /**
     * 查询未签到的活动
     * @param key
     * @param setPageSize
     * @return
     */
    @Override
    public PageBean findAllVolunteerNoSigninActivity(String key, PageBean<VolunteerActivityEntity> setPageSize, String userId) {
        return activityDao.findAllVolunteerNoSigninActivity(key, setPageSize, userId);
    }

    /**
     * 查询已评分的活动
     * @param key
     * @param setPageSize
     * @return
     */
    @Override
    public PageBean findAllAdminScoreActivity(String key, PageBean<VolunteerActivityEntity> setPageSize) {
        return activityDao.findAllAdminScoreActivity(key, setPageSize);
    }

    /**
     * 查询未评分的活动
     * @param key
     * @param setPageSize
     * @return
     */
    @Override
    public PageBean findAllAdminNOScoreActivity(String key, PageBean<VolunteerActivityEntity> setPageSize) {
        return activityDao.findAllAdminNOScoreActivity(key, setPageSize);
    }
}
