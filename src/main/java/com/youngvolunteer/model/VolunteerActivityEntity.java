package com.youngvolunteer.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * @Program: young_volunteers_web
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-02 15:14
 * @Describe：
 **/
@Entity
@Table(name = "volunteer_activity", schema = "young_volunteer", catalog = "")
public class VolunteerActivityEntity {
    private int activityId;
    private String activityCode;
    private String activityTitle;
    private String activityContent;
    private Integer activityPeopleNum;
    private String activityLeader;
    private Date activityStartTime;
    private Date activityEndTime;
    private Date activitySignStartTime;
    private Date activitySignEndTime;
    private String codePath;

    @Id
    @Column(name = "activity_id", nullable = false)
    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    @Basic
    @Column(name = "activity_code", nullable = true, length = 255)
    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    @Basic
    @Column(name = "activity_title", nullable = true, length = 255)
    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    @Basic
    @Column(name = "activity_content", nullable = true, length = 5000)
    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }

    @Basic
    @Column(name = "activity_people_num", nullable = true)
    public Integer getActivityPeopleNum() {
        return activityPeopleNum;
    }

    public void setActivityPeopleNum(Integer activityPeopleNum) {
        this.activityPeopleNum = activityPeopleNum;
    }

    @Basic
    @Column(name = "activity_leader", nullable = true, length = 255)
    public String getActivityLeader() {
        return activityLeader;
    }

    public void setActivityLeader(String activityLeader) {
        this.activityLeader = activityLeader;
    }

    @Basic
    @Column(name = "activity_start_time", nullable = true)
    public Date getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    @Basic
    @Column(name = "activity_end_time", nullable = true)
    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    @Basic
    @Column(name = "activity_sign_start_time", nullable = true)
    public Date getActivitySignStartTime() {
        return activitySignStartTime;
    }

    public void setActivitySignStartTime(Date activitySignStartTime) {
        this.activitySignStartTime = activitySignStartTime;
    }

    @Basic
    @Column(name = "activity_sign_end_time", nullable = true)
    public Date getActivitySignEndTime() {
        return activitySignEndTime;
    }

    public void setActivitySignEndTime(Date activitySignEndTime) {
        this.activitySignEndTime = activitySignEndTime;
    }

    @Basic
    @Column(name = "code_path", nullable = true)
    public String getCodePath() {
        return codePath;
    }

    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VolunteerActivityEntity that = (VolunteerActivityEntity) o;

        if (activityId != that.activityId) return false;
        if (activityCode != null ? !activityCode.equals(that.activityCode) : that.activityCode != null) return false;
        if (activityTitle != null ? !activityTitle.equals(that.activityTitle) : that.activityTitle != null)
            return false;
        if (activityContent != null ? !activityContent.equals(that.activityContent) : that.activityContent != null)
            return false;
        if (activityPeopleNum != null ? !activityPeopleNum.equals(that.activityPeopleNum) : that.activityPeopleNum != null)
            return false;
        if (activityLeader != null ? !activityLeader.equals(that.activityLeader) : that.activityLeader != null)
            return false;
        if (activityStartTime != null ? !activityStartTime.equals(that.activityStartTime) : that.activityStartTime != null)
            return false;
        if (activityEndTime != null ? !activityEndTime.equals(that.activityEndTime) : that.activityEndTime != null)
            return false;
        if (activitySignStartTime != null ? !activitySignStartTime.equals(that.activitySignStartTime) : that.activitySignStartTime != null)
            return false;
        if (activitySignEndTime != null ? !activitySignEndTime.equals(that.activitySignEndTime) : that.activitySignEndTime != null)
            return false;
        if (codePath != null ? !codePath.equals(that.codePath) : that.codePath != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = activityId;
        result = 31 * result + (activityCode != null ? activityCode.hashCode() : 0);
        result = 31 * result + (activityTitle != null ? activityTitle.hashCode() : 0);
        result = 31 * result + (activityContent != null ? activityContent.hashCode() : 0);
        result = 31 * result + (activityPeopleNum != null ? activityPeopleNum.hashCode() : 0);
        result = 31 * result + (activityLeader != null ? activityLeader.hashCode() : 0);
        result = 31 * result + (activityStartTime != null ? activityStartTime.hashCode() : 0);
        result = 31 * result + (activityEndTime != null ? activityEndTime.hashCode() : 0);
        result = 31 * result + (activitySignStartTime != null ? activitySignStartTime.hashCode() : 0);
        result = 31 * result + (activitySignEndTime != null ? activitySignEndTime.hashCode() : 0);
        result = 31 * result + (codePath != null ? codePath.hashCode() : 0);
        return result;
    }
}
