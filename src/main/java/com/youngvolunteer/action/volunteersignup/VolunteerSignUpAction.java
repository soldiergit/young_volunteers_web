package com.youngvolunteer.action.volunteersignup;

import com.youngvolunteer.common.PageBean;
import com.youngvolunteer.model.VolunteerActivityEntity;
import com.youngvolunteer.model.VolunteerSignUpEntity;
import com.youngvolunteer.service.activity.ActivityService;
import com.youngvolunteer.service.volunteer.VolunteerService;
import com.youngvolunteer.service.volunteersignup.VolunteerSignUpService;
import com.youngvolunteer.vo.R;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Program: youngvolunteer
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-05 12:23
 * @Describe：
 **/
public class VolunteerSignUpAction extends ActionSupport implements ModelDriven<VolunteerSignUpEntity> {

    @Autowired
    private VolunteerSignUpService volunteerSignUpService;
    @Autowired
    private VolunteerService volunteerService;
    @Autowired
    private ActivityService activityService;
    //日志
    private static Logger logger = Logger.getLogger(VolunteerSignUpEntity.class);
    //模型驱动
    private VolunteerSignUpEntity volunteerSignUpEntity = new VolunteerSignUpEntity();
    //
    private PageBean<VolunteerSignUpEntity> pageBean = new PageBean<>();
    //返回集
    private R r = new R();
    //搜索值
    private String key;
    //当前页
    private Integer page;
    //大小
    private Integer limit;
    //批量删除id
    private String ids;
    //用户id
    private String userId;
    //用户姓名
    private String userName;
    //活动
    private VolunteerActivityEntity volunteerActivityEntity;


    //////////////////////////////////////////////////////
    /**
     * 添加  -- 报名活动
     */
    public String saveVolunteerSignUp(){

        //查询志愿者id
        volunteerSignUpEntity.setVolunteerId(userId);
        //查询志愿者姓名
        volunteerSignUpEntity.setVolunteerName(userName);

        logger.info("报名："+volunteerSignUpEntity);

        volunteerSignUpService.saveVolunteerSignUp(volunteerSignUpEntity);

        r = R.ok();

        return SUCCESS;
    }

    /**
     * 删除 -- 退出活动
     */
    public String deleteVolunteerSignUp(){

        //查询志愿者id
        volunteerSignUpEntity.setVolunteerId(userId);

        //查询出该活动
        volunteerActivityEntity.setActivityId(Integer.parseInt(volunteerSignUpEntity.getActivityId()));
        VolunteerActivityEntity volunteerActivityEntity_result = activityService.findOneVolunteery(volunteerActivityEntity);
        if (volunteerActivityEntity_result.getActivityStartTime().getTime() < new Date().getTime() ||
                volunteerActivityEntity_result.getActivityStartTime().getTime() == new Date().getTime()) {
            r = R.error("活动已经开始，不能退出！");
            return SUCCESS;
        }

        volunteerSignUpService.deleteVolunteerSignUp(volunteerSignUpEntity);

        r = R.ok();

        return SUCCESS;
    }

    /**
     * 签到
     */
    public String volunteerSignIn(){

        //查询志愿者id
        volunteerSignUpEntity.setVolunteerId(userId);

        volunteerSignUpEntity = volunteerSignUpService.findOneVolunteerSignUp(volunteerSignUpEntity);
        volunteerSignUpEntity.setSignIn(1);

        volunteerSignUpService.updateVolunteerSignUp(volunteerSignUpEntity);

        r = R.ok();

        return SUCCESS;
    }

    /**
     * 修改
     */
    public String updateVolunteerSignUp(){

        volunteerSignUpService.updateVolunteerSignUp(volunteerSignUpEntity);

        r = R.ok();

        return SUCCESS;
    }

    /**
     * 查询
     * @return
     */
    public String findOneVolunteerSignUp(){

        VolunteerSignUpEntity oneVolunteerSignUp = volunteerSignUpService.findOneVolunteerSignUp(volunteerSignUpEntity);

        r = R.ok().put("data",oneVolunteerSignUp);

        return SUCCESS;
    }

    /**
     * 查询
     */
    public String findAllVolunteerSignUp(){

        PageBean allUser = volunteerSignUpService.findAllVolunteerSignUp(key, new PageBean<VolunteerSignUpEntity>().setCurrPage(page).setPageSize(limit));

        r = R.ok().put("data",allUser.getRows());

        return SUCCESS;
    }
    /**
     * 批量删除
     */
    public String deleteAllVolunteerSignUp(){


        String[] id = ids.split(",");

        volunteerSignUpService.deleteAllVolunteerSignUp(id);

        r = R.ok();

        return SUCCESS;
    }
    //////////////////////////////////////////////////////

    @Override
    public VolunteerSignUpEntity getModel() {

        return volunteerSignUpEntity;

    }

    public VolunteerSignUpEntity getVolunteerSignUpEntity() {
        return volunteerSignUpEntity;
    }

    public void setVolunteerSignUpEntity(VolunteerSignUpEntity volunteerSignUpEntity) {
        this.volunteerSignUpEntity = volunteerSignUpEntity;
    }

    public PageBean<VolunteerSignUpEntity> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<VolunteerSignUpEntity> pageBean) {
        this.pageBean = pageBean;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public VolunteerActivityEntity getVolunteerActivityEntity() {
        return volunteerActivityEntity;
    }

    public void setVolunteerActivityEntity(VolunteerActivityEntity volunteerActivityEntity) {
        this.volunteerActivityEntity = volunteerActivityEntity;
    }
}
