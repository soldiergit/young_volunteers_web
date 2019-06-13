package com.youngvolunteer.dao.volunteersignup;

import com.youngvolunteer.common.PageBean;
import com.youngvolunteer.model.VolunteerSignUpEntity;

/**
 * @Program: youngvolunteer
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-03 23:46
 * @Describe：
 **/
public interface VolunteerSignUpDao {

    /**
     * 添加
     * @param volunteerSignUpEntity
     */
    public void saveVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity);

    /**
     * 删除
     * @param volunteerSignUpEntity
     */
    public void deleteVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity);

    /**
     * 修改
     * @param volunteerSignUpEntity
     */
    public void updateVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity);

    /**
     * 查询
     * @param volunteerSignUpEntity
     * @return
     */
    public VolunteerSignUpEntity findOneVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity);

    /**
     * 查询
     * @param key
     * @param pageBean
     * @return
     */
    public PageBean findAllVolunteerSignUp(String key, PageBean<VolunteerSignUpEntity> pageBean);
    /**
     * 批量删除
     * @param userIds
     */
    public void deleteAllVolunteerSignUp(String[] userIds);

}
