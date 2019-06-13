package com.youngvolunteer.dao.volunteer.impl;

import com.youngvolunteer.common.PageBean;
import com.youngvolunteer.dao.volunteer.VolunteerDao;
import com.youngvolunteer.model.SysVolunteerEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: youngvolunteer
 * @Author: soldier
 * @Email： 583403411@qq.com
 * @Create: 2019-06-03 23:37
 * @Describe：
 **/
@Component
public class VolunteerDaoImpl implements VolunteerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void saveSysVolunteer(SysVolunteerEntity sysVolunteerEntity) {
        hibernateTemplate.save(sysVolunteerEntity);
    }

    @Override
    public void deleteSysVolunteer(SysVolunteerEntity sysVolunteerEntity) {
        hibernateTemplate.delete(sysVolunteerEntity);
    }

    @Override
    public void updateSysVolunteer(SysVolunteerEntity sysVolunteerEntity) {
        hibernateTemplate.update(sysVolunteerEntity);
    }

    @Override
    public SysVolunteerEntity findOneSysVolunteery(SysVolunteerEntity sysVolunteerEntity) {

        Session currentSession = sessionFactory.openSession();

        Criteria criteria = currentSession.createCriteria(SysVolunteerEntity.class);

        List<SysVolunteerEntity> list = criteria.add(Restrictions.eq("volunteerId", sysVolunteerEntity.getVolunteerId())).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        currentSession.close();

        return list.size()>0&&list!=null?list.get(0):null;
    }

    @Override
    public PageBean findAllSysVolunteer(String key, PageBean<SysVolunteerEntity> pageBean) {

        Session session = sessionFactory.openSession();

        System.out.println(pageBean.toString());

        Criteria criteria = session.createCriteria(SysVolunteerEntity.class);

        if (key != null && !key.equals("")) {
            //搜索
            List list = criteria.add(
                    Restrictions.or(
                            Restrictions.or(Restrictions.like("volunteerCode", key, MatchMode.ANYWHERE)),
                            Restrictions.or(Restrictions.like("volunteerCollege", key, MatchMode.ANYWHERE)),
                            Restrictions.or(Restrictions.like("volunteerEmail", key, MatchMode.ANYWHERE)),
                            Restrictions.or(Restrictions.like("volunteerName", key, MatchMode.ANYWHERE)),
                            Restrictions.or(Restrictions.like("volunteerPhone", key, MatchMode.ANYWHERE)),
                            Restrictions.or(Restrictions.like("volunteerClass", key, MatchMode.ANYWHERE))))
                    .setFirstResult((pageBean.getCurrPage() - 1) * pageBean.getPageSize() )
                    .setMaxResults((pageBean.getCurrPage() - 1) * pageBean.getPageSize() + pageBean.getPageSize())
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();

            pageBean.setRows(list);

        } else {
            List list = criteria.setFirstResult((pageBean.getCurrPage() - 1) * pageBean.getPageSize())
                    .setMaxResults((pageBean.getCurrPage() - 1) * pageBean.getPageSize() + pageBean.getPageSize()).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            pageBean.setRows(list);
            session.close();
        }
        return pageBean;
    }

    @Override
    public void deleteAllSysVolunteer(String[] Ids) {
        List<SysVolunteerEntity> list = new ArrayList<>();

        for (String id : Ids) {

            SysVolunteerEntity sysVolunteerEntity = new SysVolunteerEntity();
            sysVolunteerEntity.setVolunteerId(Integer.parseInt(id));

            list.add(sysVolunteerEntity);
        }
        hibernateTemplate.deleteAll(list);
    }
}
