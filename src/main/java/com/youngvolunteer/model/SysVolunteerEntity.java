package com.youngvolunteer.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * @Program: youngvolunteer_Gen
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-02 15:14
 * @Describe：
 **/
@Entity
@Table(name = "sys_volunteer", schema = "young_volunteer", catalog = "")
public class SysVolunteerEntity {
    private int volunteerId;
    private String volunteerCode;
    private String volunteerClass;
    private String volunteerCollege;
    private Date volunteerJoinTime;
    private String volunteerEmail;
    private String volunteerName;
    private String volunteerPhone;
    private Integer volunteerSex;
    private SysUserEntity user;

    @Id
    @Column(name = "volunteer_id", nullable = false)
    public int getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(int volunteerId) {
        this.volunteerId = volunteerId;
    }

    @Basic
    @Column(name = "volunteer_code", nullable = true, length = 255)
    public String getVolunteerCode() {
        return volunteerCode;
    }

    public void setVolunteerCode(String volunteerCode) {
        this.volunteerCode = volunteerCode;
    }

    @Basic
    @Column(name = "volunteer_class", nullable = true, length = 255)
    public String getVolunteerClass() {
        return volunteerClass;
    }

    public void setVolunteerClass(String volunteerClass) {
        this.volunteerClass = volunteerClass;
    }

    @Basic
    @Column(name = "volunteer_college", nullable = true, length = 255)
    public String getVolunteerCollege() {
        return volunteerCollege;
    }

    public void setVolunteerCollege(String volunteerCollege) {
        this.volunteerCollege = volunteerCollege;
    }

    @Basic
    @Column(name = "volunteer_join_time", nullable = true)
    public Date getVolunteerJoinTime() {
        return volunteerJoinTime;
    }

    public void setVolunteerJoinTime(Date volunteerJoinTime) {
        this.volunteerJoinTime = volunteerJoinTime;
    }

    @Basic
    @Column(name = "volunteer_email", nullable = true, length = 255)
    public String getVolunteerEmail() {
        return volunteerEmail;
    }

    public void setVolunteerEmail(String volunteerEmail) {
        this.volunteerEmail = volunteerEmail;
    }

    @Basic
    @Column(name = "volunteer_name", nullable = true, length = 255)
    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    @Basic
    @Column(name = "volunteer_phone", nullable = true, length = 255)
    public String getVolunteerPhone() {
        return volunteerPhone;
    }

    public void setVolunteerPhone(String volunteerPhone) {
        this.volunteerPhone = volunteerPhone;
    }

    @Basic
    @Column(name = "volunteer_sex", nullable = true)
    public Integer getVolunteerSex() {
        return volunteerSex;
    }

    public void setVolunteerSex(Integer volunteerSex) {
        this.volunteerSex = volunteerSex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysVolunteerEntity that = (SysVolunteerEntity) o;

        if (volunteerId != that.volunteerId) return false;
        if (volunteerCode != null ? !volunteerCode.equals(that.volunteerCode) : that.volunteerCode != null)
            return false;
        if (volunteerClass != null ? !volunteerClass.equals(that.volunteerClass) : that.volunteerClass != null)
            return false;
        if (volunteerCollege != null ? !volunteerCollege.equals(that.volunteerCollege) : that.volunteerCollege != null)
            return false;
        if (volunteerJoinTime != null ? !volunteerJoinTime.equals(that.volunteerJoinTime) : that.volunteerJoinTime != null)
            return false;
        if (volunteerEmail != null ? !volunteerEmail.equals(that.volunteerEmail) : that.volunteerEmail != null)
            return false;
        if (volunteerName != null ? !volunteerName.equals(that.volunteerName) : that.volunteerName != null)
            return false;
        if (volunteerPhone != null ? !volunteerPhone.equals(that.volunteerPhone) : that.volunteerPhone != null)
            return false;
        if (volunteerSex != null ? !volunteerSex.equals(that.volunteerSex) : that.volunteerSex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = volunteerId;
        result = 31 * result + (volunteerCode != null ? volunteerCode.hashCode() : 0);
        result = 31 * result + (volunteerClass != null ? volunteerClass.hashCode() : 0);
        result = 31 * result + (volunteerCollege != null ? volunteerCollege.hashCode() : 0);
        result = 31 * result + (volunteerJoinTime != null ? volunteerJoinTime.hashCode() : 0);
        result = 31 * result + (volunteerEmail != null ? volunteerEmail.hashCode() : 0);
        result = 31 * result + (volunteerName != null ? volunteerName.hashCode() : 0);
        result = 31 * result + (volunteerPhone != null ? volunteerPhone.hashCode() : 0);
        result = 31 * result + (volunteerSex != null ? volunteerSex.hashCode() : 0);
        return result;
    }

    @OneToOne
    public SysUserEntity getUser() {
        return user;
    }

    public void setUser(SysUserEntity user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "SysVolunteerEntity{" +
                "volunteerId=" + volunteerId +
                ", volunteerCode='" + volunteerCode + '\'' +
                ", volunteerClass='" + volunteerClass + '\'' +
                ", volunteerCollege='" + volunteerCollege + '\'' +
                ", volunteerJoinTime=" + volunteerJoinTime +
                ", volunteerEmail='" + volunteerEmail + '\'' +
                ", volunteerName='" + volunteerName + '\'' +
                ", volunteerPhone='" + volunteerPhone + '\'' +
                ", volunteerSex=" + volunteerSex +
                ", user=" + user +
                '}';
    }
}
