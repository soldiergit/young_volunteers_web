package com.youngvolunteer.action.activity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.youngvolunteer.QR_code.MatrixToImageWriter;
import com.youngvolunteer.common.PageBean;
import com.youngvolunteer.model.VolunteerActivityEntity;
import com.youngvolunteer.service.activity.ActivityService;
import com.youngvolunteer.util.DateUtil;
import com.youngvolunteer.vo.R;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


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
     * sign up
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
     * no sign up
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
     * sign in
     * @return
     */
    public String findAllVolunteerSigninActivity(){

        PageBean allVolunteerActivity = activityService.findAllVolunteerJoinActivity(key, new PageBean<VolunteerActivityEntity>().setCurrPage(page).setPageSize(limit), userId);

        r = R.ok().put("data",allVolunteerActivity.getRows());

        logger.info("$$$$$$$$$$$$$$$"+userId+limit);

        logger.info("查询列表："+r);

        return SUCCESS;
    }

    /**
     * no sign in
     * @return
     */
    public String findAllVolunteerNoSigninActivity(){

        PageBean allVolunteerActivity = activityService.findAllVolunteerNojoinActivity(key, new PageBean<VolunteerActivityEntity>().setCurrPage(page).setPageSize(limit), userId);

        r = R.ok().put("data",allVolunteerActivity.getRows());

        logger.info("$$$$$$$$$$$$$"+userId+limit);

        logger.info("查询列表："+r);

        return SUCCESS;
    }

    /**
     * scoring
     * @return
     */
    public String findAllAdminScoreActivity(){

        PageBean allVolunteerActivity = activityService.findAllAdminScoreActivity(key, new PageBean<VolunteerActivityEntity>().setCurrPage(page).setPageSize(limit));

        r = R.ok().put("data",allVolunteerActivity.getRows());

        logger.info("查询已评分列表："+r);

        return SUCCESS;
    }

    /**
     * no scoring
     * @return
     */
    public String findAllAdminNOScoreActivity(){

        PageBean allVolunteerActivity = activityService.findAllAdminNOScoreActivity(key, new PageBean<VolunteerActivityEntity>().setCurrPage(page).setPageSize(limit));

        r = R.ok().put("data",allVolunteerActivity.getRows());

        logger.info("查询列表："+r);

        return SUCCESS;
    }

    /**
     * 生成二维码
     * @return
     */
    public String createActivityQRCode(){

        String path = "/home/soldier/SOLDIER/idea_project/young_volunteers_web/src/main/webapp/images/QRCode";
        String content = volunteerActivityEntity.getActivityId()+".jpg";
        try {

            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 400, 400, hints);
            //直接用活动编号作为二维码名称
            File imgPath = new File(path, content);
            MatrixToImageWriter.writeToFile(bitMatrix, "jpg", imgPath);

            logger.info("二维码地址："+imgPath);

            /**
             * 存在数据库里面的照片路径是在项目里的相对路径
             */
            String imgPath_datebase = ServletActionContext.getRequest().getContextPath() + "/images/QRCode/" + content;
            VolunteerActivityEntity volunteerActivityEntity_result = activityService.findOneVolunteery(volunteerActivityEntity);
            volunteerActivityEntity_result.setCodePath(imgPath_datebase);
            activityService.updateVolunteerActivity(volunteerActivityEntity_result);
            r = R.ok();

        } catch (WriterException e) {
            e.printStackTrace();
            r = R.error();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
