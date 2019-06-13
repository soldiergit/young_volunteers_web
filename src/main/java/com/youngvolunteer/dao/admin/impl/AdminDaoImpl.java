package com.youngvolunteer.dao.admin.impl;

import com.youngvolunteer.dao.admin.AdminDao;
import com.youngvolunteer.model.SysAdminEntity;
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
 * @Create: 2019-06-04 00:10
 * @Describe：
 **/
@Component
public class AdminDaoImpl implements AdminDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void saveAdmin(SysAdminEntity sysAdminEntity) {
        hibernateTemplate.save(sysAdminEntity);
    }

    @Override
    public void updateAdmin(SysAdminEntity sysAdminEntity) {
        hibernateTemplate.update(sysAdminEntity);
    }

    @Override
    public void deleteAdmin(SysAdminEntity sysAdminEntity) {
        hibernateTemplate.delete(sysAdminEntity);
    }

    /**
     * 通过id查询
     * @param sysAdminEntity
     * @return
     */
    @Override
    public SysAdminEntity findOneAdmin(SysAdminEntity sysAdminEntity) {

        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(SysAdminEntity.class);

        List<SysAdminEntity> list = criteria.add(Restrictions.eq("adminId", sysAdminEntity.getAdminId())).list();

        session.close();

        return list.size()>0&&list!=null?list.get(0):null;
    }

    @Override
    public List<SysAdminEntity> findAllAdmin(SysAdminEntity sysAdminEntity) {
        return (List<SysAdminEntity>) hibernateTemplate.find("from com.youngvolunteer.model.SysAdminEntity");
    }


}
