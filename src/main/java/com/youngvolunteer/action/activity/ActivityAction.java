package com.youngvolunteer.action.activity;

import com.youngvolunteer.common.PageBean;
import com.youngvolunteer.model.VolunteerActivityEntity;
import com.youngvolunteer.service.activity.ActivityService;
import com.youngvolunteer.util.DateUtil;
import com.youngvolunteer.vo.R;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Program: youngvolunteer
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-05 09:24
 * @Describe：
 **/
public class ActivityAction extends ActionSupport implements ModelDriven<VolunteerActivityEntity> {

    @Autowired
    private ActivityService activityService;
    //日志
    private static Logger logger = Logger.getLogger(VolunteerActivityEntity.class);
    //模型驱动
    private VolunteerActivityEntity volunteerActivityEntity = new VolunteerActivityEntity();
    //
    private PageBean<VolunteerActivityEntity> pageBean = new PageBean<>();
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
    //活动开始时间
    private String activityStartTimes;
    //活动结束时间
    private String activityEndTimes;
    //活动报名开始时间
    private String activitySignStartTimes;
    //活动报名结束时间
    private String activitySignEndTimes;
    //用户id
    private String userId;

    /////////////////////////////////////////

    /**
     * 添加
     */
    public String saveVolunteerActivity(){

        logger.info(activitySignStartTimes+"\n"+activityEndTimes+"\n"+activitySignStartTimes+"\n"+activitySignEndTimes);

        volunteerActivityEntity.setActivityStartTime(new java.sql.Date(DateUtil.string2Date(activityStartTimes,"yyyy-MM-dd").getTime()));
        volunteerActivityEntity.setActivityEndTime(new java.sql.Date(DateUtil.string2Date(activityEndTimes,"yyyy-MM-dd").getTime()));
        volunteerActivityEntity.setActivitySignStartTime(new java.sql.Date(DateUtil.string2Date(activitySignStartTimes,"yyyy-MM-dd").getTime()));
        volunteerActivityEntity.setActivitySignEndTime(new java.sql.Date( DateUtil.string2Date(activitySignEndTimes,"yyyy-MM-dd").getTime()));

        activityService.saveVolunteerActivity(volunteerActivityEntity);

        r = R.ok();

        return SUCCESS;
    }

    /**
     * 删除
     */
    public String deleteVolunteerActivity(){

        activityService.deleteVolunteerActivity(volunteerActivityEntity);

        r = R.ok();

        return SUCCESS;
    }

    /**
     * 修改
     */
    public String updateVolunteerActivity(){

        activityService.updateVolunteerActivity(volunteerActivityEntity);

        r = R.ok();

        return SUCCESS;
    }

    /**
     * 查询
     * @return
     */
    public String findOneVolunteer(){

        VolunteerActivityEntity oneVolunteery = activityService.findOneVolunteery(volunteerActivityEntity);

        r = R.ok().put("data",oneVolunteery);

        return SUCCESS;
    }

    /**
     * 查询
     */
    public String findAllVolunteerActivity(){

        PageBean allVolunteerActivity = activityService.findAllVolunteerActivity(key, new PageBean<VolunteerActivityEntity>().setCurrPage(page).setPageSize(limit));

        r = R.ok().put("data",allVolunteerActivity.getRows());

        logger.info("查询列表："+r);

        return SUCCESS;
    }

    /**
     * join
     * @return
     */
    public String findAllVolunteerJoinActivity(){

        PageBean allVolunteerActivity = activityService.findAllVolunteerJoinActivity(key, new PageBean<VolunteerActivityEntity>().setCurrPage(page).setPageSize(limit), userId);

        r = R.ok().put("data",allVolunteerActivity.getRows());

        logger.info("$$$$$$$$$$$$$$$"+userId+limit);

        logger.info("查询列表："+r);

        return SUCCESS;
    }

    /**
     * no join
     * @return
     */
    public String findAllVolunteerNojoinActivity(){

        PageBean allVolunteerActivity = activityService.findAllVolunteerNojoinActivity(key, new PageBean<VolunteerActivityEntity>().setCurrPage(page).setPageSize(limit), userId);

        r = R.ok().put("data",allVolunteerActivity.getRows());

        logger.info("$$$$$$$$$$$$$"+userId+limit);

        logger.info("查询列表："+r);

        return SUCCESS;
    }

    /**
     * 批量删除
     */
    public String deleteAllVolunteerActivity(){


        String[] id = ids.split(",");

        activityService.deleteAllVolunteerActivity(id);

        r = R.ok();

        return SUCCESS;
    }


    /////////////////////////////////////////

    @Override
    public VolunteerActivityEntity getModel() {

        return volunteerActivityEntity;
    }

    public VolunteerActivityEntity getVolunteerActivityEntity() {
        return volunteerActivityEntity;
    }

    public void setVolunteerActivityEntity(VolunteerActivityEntity volunteerActivityEntity) {
        this.volunteerActivityEntity = volunteerActivityEntity;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public PageBean<VolunteerActivityEntity> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<VolunteerActivityEntity> pageBean) {
        this.pageBean = pageBean;
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

    public String getActivityStartTimes() {
        return activityStartTimes;
    }

    public void setActivityStartTimes(String activityStartTimes) {
        this.activityStartTimes = activityStartTimes;
    }

    public String getActivityEndTimes() {
        return activityEndTimes;
    }

    public void setActivityEndTimes(String activityEndTimes) {
        this.activityEndTimes = activityEndTimes;
    }

    public String getActivitySignStartTimes() {
        return activitySignStartTimes;
    }

    public void setActivitySignStartTimes(String activitySignStartTimes) {
        this.activitySignStartTimes = activitySignStartTimes;
    }

    public String getActivitySignEndTimes() {
        return activitySignEndTimes;
    }

    public void setActivitySignEndTimes(String activitySignEndTimes) {
        this.activitySignEndTimes = activitySignEndTimes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
