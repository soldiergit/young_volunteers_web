package com.youngvolunteer.dao.login.impl;

import com.youngvolunteer.dao.login.LoginDao;
import com.youngvolunteer.model.SysUserEntity;
import com.youngvolunteer.vo.R;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Program: youngvolunteer
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-05-01 20:56
 * @Describe：
 **/
@Component
public class LoginDaoImpl implements LoginDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private SessionFactory sessionFactory;
    /**
     * 用户登入
     * @param sysUserEntity
     * @return
     */
    @Override
    public R userLogin(SysUserEntity sysUserEntity) {

        System.out.println(sysUserEntity);

        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(SysUserEntity.class);

        List list = criteria.add(
                Restrictions.eq("loginAccount", sysUserEntity.getLoginAccount()))
                .add(Restrictions.eq("loginPassword", sysUserEntity.getLoginPassword())).list();

        if (list==null||list.size()<1){

            Criteria criteria2 = session.createCriteria(SysUserEntity.class);

            List loginAccount = criteria2.add(Restrictions.eq("loginAccount", sysUserEntity.getLoginAccount())).list();

            if (loginAccount==null||loginAccount.size()<1){
                return R.error(1,"用户不存在");
            }
            return R.error(2,"密码错误");
        }
        R data = R.ok().put("data", list.get(0));
        session.close();
        return data;
    }

    /**
     * 修改密码
     * @param sysUserEntity
     * @return
     */
    @Override
    public R updatePassword(SysUserEntity sysUserEntity, String newPassword) {

//        SysUserEntity sysUserEntity_from_db = userDao.selectOneUser(sysUserEntity);

//        if (sysUserEntity_from_db!=null&&sysUserEntity.getLoginPassword().equals(sysUserEntity_from_db.getLoginPassword())){
//            sysUserEntity_from_db.setLoginPassword(newPassword);
//            hibernateTemplate.update(sysUserEntity_from_db);
//            return R.ok("修改成功");
//        }

        return R.error(2,"原密码错误");

    }
}
