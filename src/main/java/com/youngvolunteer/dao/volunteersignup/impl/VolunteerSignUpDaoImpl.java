package com.youngvolunteer.dao.volunteersignup.impl;

import com.youngvolunteer.common.PageBean;
import com.youngvolunteer.dao.volunteersignup.VolunteerSignUpDao;
import com.youngvolunteer.model.VolunteerSignUpEntity;
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
 * @Create: 2019-06-04 00:31
 * @Describe：
 **/
@Component
public class VolunteerSignUpDaoImpl implements VolunteerSignUpDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     * 添加
     * @param volunteerSignUpEntity
     */
    @Override
    public void saveVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity){
        hibernateTemplate.save(volunteerSignUpEntity);
    }

    /**
     * 删除
     * @param volunteerSignUpEntity
     */
    @Override
    public void deleteVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity){
        hibernateTemplate.delete(volunteerSignUpEntity);
    }

    /**
     * 修改
     * @param volunteerSignUpEntity
     */
    @Override
    public void updateVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity){
        hibernateTemplate.update(volunteerSignUpEntity);
    }

    /**
     * 查询
     * @param volunteerSignUpEntity
     * @return
     */
    @Override
    public VolunteerSignUpEntity findOneVolunteerSignUp(VolunteerSignUpEntity volunteerSignUpEntity){

        Session currentSession = sessionFactory.openSession();

        Criteria criteria = currentSession.createCriteria(VolunteerSignUpEntity.class);

        //志愿者签到，需要把活动id和个人id传过来
        if (volunteerSignUpEntity.getActivityId() != null && volunteerSignUpEntity.getVolunteerId() != null) {
            criteria.add(Restrictions.eq("activityId", volunteerSignUpEntity.getActivityId()));
            criteria.add(Restrictions.eq("volunteerId", volunteerSignUpEntity.getVolunteerId()));
        } else {
            criteria.add(Restrictions.eq("userId", volunteerSignUpEntity.getSignUpId()));
        }

        List<VolunteerSignUpEntity> list = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        currentSession.close();

        return list.size()>0&&list!=null?list.get(0):null;
    }

    /**
     * 查询
     * @param key
     * @param pageBean
     * @return
     */
    @Override
    public PageBean findAllVolunteerSignUp(String key, PageBean<VolunteerSignUpEntity> pageBean){

        List list = null;

        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(VolunteerSignUpEntity.class);

        if (key != null && !key.equals("")) {
            //搜索
            list = criteria.add(
                    Restrictions.or(Restrictions.like("signUpId", key, MatchMode.ANYWHERE),
                            Restrictions.or(Restrictions.like("signIn", key, MatchMode.ANYWHERE)),
                            Restrictions.or(Restrictions.like("volunteerId", key, MatchMode.ANYWHERE)),
                            Restrictions.or(Restrictions.like("activityId", key, MatchMode.ANYWHERE)),
                            Restrictions.or(Restrictions.like("volunteerScore", key, MatchMode.ANYWHERE))))
                    .setFirstResult((pageBean.getCurrPage() - 1) * pageBean.getPageSize() )
                    .setMaxResults((pageBean.getCurrPage() - 1) * pageBean.getPageSize() + pageBean.getPageSize()).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            pageBean.setRows(list);
        } else {
            list = criteria.setFirstResult((pageBean.getCurrPage() - 1) * pageBean.getPageSize())
                    .setMaxResults((pageBean.getCurrPage() - 1) * pageBean.getPageSize() + pageBean.getPageSize()).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            pageBean.setRows(list);
        }
        session.close();
        return pageBean;
    }
    /**
     * 批量删除
     * @param Ids
     */
    @Override
    public void deleteAllVolunteerSignUp(String[] Ids){

        List<VolunteerSignUpEntity> list = new ArrayList<>();

        for (String id : Ids) {
            VolunteerSignUpEntity volunteerSignUpEntity = new VolunteerSignUpEntity();
            volunteerSignUpEntity.setSignUpId(Integer.parseInt(id));
            list.add(volunteerSignUpEntity);
        }
        hibernateTemplate.deleteAll(list);
    }

}
