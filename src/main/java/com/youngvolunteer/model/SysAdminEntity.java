package com.youngvolunteer.model;

import javax.persistence.*;

/**
 * @Program: young_volunteers_web
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-02 15:14
 * @Describe：
 **/
@Entity
@Table(name = "sys_admin", schema = "young_volunteer", catalog = "")
public class SysAdminEntity {
    private int adminId;
    private String loginName;
    private String adminCode;
    private String adminEmail;
    private String adminName;
    private String adminPhone;
    private Integer adminSex;
    private String loginPassword;
    private SysUserEntity user;

    @Id
    @Column(name = "admin_id", nullable = false)
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "login_name", nullable = false, length = 255)
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Basic
    @Column(name = "admin_code", nullable = true, length = 255)
    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    @Basic
    @Column(name = "admin_email", nullable = true, length = 255)
    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    @Basic
    @Column(name = "admin_name", nullable = true, length = 255)
    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Basic
    @Column(name = "admin_phone", nullable = true, length = 255)
    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    @Basic
    @Column(name = "admin_sex", nullable = true)
    public Integer getAdminSex() {
        return adminSex;
    }

    public void setAdminSex(Integer adminSex) {
        this.adminSex = adminSex;
    }

    @Basic
    @Column(name = "login_password", nullable = true, length = 255)
    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysAdminEntity that = (SysAdminEntity) o;

        if (adminId != that.adminId) return false;
        if (loginName != null ? !loginName.equals(that.loginName) : that.loginName != null) return false;
        if (adminCode != null ? !adminCode.equals(that.adminCode) : that.adminCode != null) return false;
        if (adminEmail != null ? !adminEmail.equals(that.adminEmail) : that.adminEmail != null) return false;
        if (adminName != null ? !adminName.equals(that.adminName) : that.adminName != null) return false;
        if (adminPhone != null ? !adminPhone.equals(that.adminPhone) : that.adminPhone != null) return false;
        if (adminSex != null ? !adminSex.equals(that.adminSex) : that.adminSex != null) return false;
        if (loginPassword != null ? !loginPassword.equals(that.loginPassword) : that.loginPassword != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adminId;
        result = 31 * result + (loginName != null ? loginName.hashCode() : 0);
        result = 31 * result + (adminCode != null ? adminCode.hashCode() : 0);
        result = 31 * result + (adminEmail != null ? adminEmail.hashCode() : 0);
        result = 31 * result + (adminName != null ? adminName.hashCode() : 0);
        result = 31 * result + (adminPhone != null ? adminPhone.hashCode() : 0);
        result = 31 * result + (adminSex != null ? adminSex.hashCode() : 0);
        result = 31 * result + (loginPassword != null ? loginPassword.hashCode() : 0);
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
        return "SysAdminEntity{" +
                "adminId=" + adminId +
                ", loginName='" + loginName + '\'' +
                ", adminCode='" + adminCode + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminPhone='" + adminPhone + '\'' +
                ", adminSex=" + adminSex +
                ", loginPassword='" + loginPassword + '\'' +
                ", user=" + user +
                '}';
    }
}
