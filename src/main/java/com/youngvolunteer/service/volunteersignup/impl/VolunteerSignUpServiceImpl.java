package com.youngvolunteer.service.volunteersignup.impl;

import com.youngvolunteer.common.PageBean;
import com.youngvolunteer.dao.volunteersignup.VolunteerSignUpDao;
import com.youngvolunteer.model.VolunteerSignUpEntity;
import com.youngvolunteer.service.volunteersignup.VolunteerSignUpService;
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
public class VolunteerSignUpServiceImpl implements VolunteerSignUpService {

    @Autowired
    private VolunteerSignUpDao volunteerSignUpDao;
    /**
     * 添加
     * @param volunteerSignUpEntity
     */
    @Override
    public void saveVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity){
        volunteerSignUpDao.saveVolunteerSignUp(volunteerSignUpEntity);
    }

    /**
     * 删除
     * @param volunteerSignUpEntity
     */
    @Override
    public void deleteVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity){
        volunteerSignUpDao.deleteVolunteerSignUp(volunteerSignUpEntity);
    }

    /**
     * 修改
     * @param volunteerSignUpEntity
     */
    @Override
    public void updateVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity){
        volunteerSignUpDao.updateVolunteerSignUp(volunteerSignUpEntity);
    }

    /**
     * 查询
     * @param volunteerSignUpEntity
     * @return
     */
    @Override
    public VolunteerSignUpEntity findOneVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity){
        return volunteerSignUpDao.findOneVolunteerSignUp(volunteerSignUpEntity);
    }

    /**
     * 查询
     * @param key
     * @param pageBean
     * @return
     */
    @Override
    public PageBean findAllVolunteerSignUp(String key, PageBean<VolunteerSignUpEntity> pageBean){
        return volunteerSignUpDao.findAllVolunteerSignUp(key,pageBean);
    }
    /**
     * 批量删除
     * @param Ids
     */
    @Override
    public void deleteAllVolunteerSignUp(String[] Ids){
        volunteerSignUpDao.deleteAllVolunteerSignUp(Ids);
    }

}
