package com.youngvolunteer.action.volunteer;

import com.youngvolunteer.common.PageBean;
import com.youngvolunteer.model.SysUserEntity;
import com.youngvolunteer.model.SysVolunteerEntity;
import com.youngvolunteer.service.sysuser.SysUserService;
import com.youngvolunteer.service.volunteer.VolunteerService;
import com.youngvolunteer.util.DateUtil;
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
 * @Create: 2019-06-05 12:12
 * @Describe：
 **/
public class VolunteerAction extends ActionSupport implements ModelDriven<SysVolunteerEntity> {

    @Autowired
    private VolunteerService volunteerService;
    @Autowired
    private SysUserService sysUserService;
    //日志
    private static Logger logger = Logger.getLogger(VolunteerService.class);
    //模型驱动
    private SysVolunteerEntity sysVolunteerEntity = new SysVolunteerEntity();
    //
    private PageBean<SysVolunteerEntity> pageBean = new PageBean<>();
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
    //date
    private String volunteerJoinTimes;

    /////////////////////////////////////////

    /**
     * 添加
     */
    public String saveVolunteer(){

        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setUserId((int) System.currentTimeMillis());
        sysUserEntity.setLoginAccount(sysVolunteerEntity.getVolunteerEmail());
        sysUserEntity.setLoginPassword("123456");
        sysUserEntity.setRoleType(1);
        sysUserEntity.setUserName(sysVolunteerEntity.getVolunteerName());
        sysUserEntity.setUserAvailable(1);
        sysUserService.saveUser(sysUserEntity);


        logger.info("日期："+volunteerJoinTimes);
        Date date = DateUtil.string2Date(volunteerJoinTimes,"yyyy-MM-dd");
        sysVolunteerEntity.setVolunteerId(sysUserEntity.getUserId());
        sysVolunteerEntity.setVolunteerJoinTime(new java.sql.Date(date.getTime()));
        volunteerService.saveSysVolunteer(sysVolunteerEntity);

        r = R.ok();

        return SUCCESS;
    }

    /**
     * 删除
     */
    public String deleteVolunteer(){

        logger.info("删除志愿者："+sysVolunteerEntity);

        volunteerService.deleteSysVolunteer(sysVolunteerEntity);

        r = R.ok();

        return SUCCESS;
    }

    /**
     * 修改
     */
    public String updateVolunteer(){

        volunteerService.updateSysVolunteer(sysVolunteerEntity);

        r = R.ok();

        return SUCCESS;
    }

    /**
     * 查询
     * @return
     */
    public String findOneVolunteer(){

        SysVolunteerEntity oneSysVolunteery = volunteerService.findOneSysVolunteery(sysVolunteerEntity);

        r = R.ok().put("data",oneSysVolunteery);

        return SUCCESS;
    }

    /**
     * 查询
     */
    public String findAllVolunteer(){

        logger.info("搜索："+key);

        PageBean allVolunteer = volunteerService.findAllSysVolunteer(key, new PageBean<SysVolunteerEntity>().setCurrPage(page).setPageSize(limit));

        r = R.ok().put("data",allVolunteer.getRows());

        logger.info("查询列表："+r);

        return SUCCESS;
    }
    /**
     * 批量删除
     */
    public String deleteAllVolunteer(){


        String[] id = ids.split(",");

        volunteerService.deleteAllSysVolunteer(id);

        r = R.ok();

        return SUCCESS;
    }

///////////////////////////////////////////////////////////

    @Override
    public SysVolunteerEntity getModel() {

        return sysVolunteerEntity;
    }

    public SysVolunteerEntity getSysVolunteerEntity() {
        return sysVolunteerEntity;
    }

    public void setSysVolunteerEntity(SysVolunteerEntity sysVolunteerEntity) {
        this.sysVolunteerEntity = sysVolunteerEntity;
    }

    public PageBean<SysVolunteerEntity> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<SysVolunteerEntity> pageBean) {
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

    public String getVolunteerJoinTimes() {
        return volunteerJoinTimes;
    }

    public void setVolunteerJoinTimes(String volunteerJoinTimes) {
        this.volunteerJoinTimes = volunteerJoinTimes;
    }
}
