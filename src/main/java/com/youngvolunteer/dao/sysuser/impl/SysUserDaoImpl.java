package com.youngvolunteer.dao.sysuser.impl;

import com.youngvolunteer.common.PageBean;
import com.youngvolunteer.dao.sysuser.SysUserDao;
import com.youngvolunteer.model.SysUserEntity;
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
public class SysUserDaoImpl implements SysUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     * 添加用户
     * @param sysUserEntity
     */
    @Override
    public void saveUser(SysUserEntity sysUserEntity) {
        hibernateTemplate.save(sysUserEntity);
    }

    /**
     * 删除用户
     * @param sysUserEntity
     */
    @Override
    public void deleteUser(SysUserEntity sysUserEntity) {
        hibernateTemplate.delete(sysUserEntity);
    }

    /**
     * 更新用户
     * @param sysUserEntity
     */
    @Override
    public void updateUser(SysUserEntity sysUserEntity) {
        hibernateTemplate.update(sysUserEntity);
    }

    /**
     * 选择一个
     * @param sysUserEntity
     * @return
     */
    @Override
    public SysUserEntity findOneUser(SysUserEntity sysUserEntity) {

        Session currentSession = sessionFactory.openSession();

        Criteria criteria = currentSession.createCriteria(SysUserEntity.class);

        List<SysUserEntity> list = criteria.add(Restrictions.eq("userId", sysUserEntity.getUserId())).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        currentSession.close();

        return list.size()>0&&list!=null?list.get(0):null;
    }

    /**
     * 分页查询
     * @param key
     * @param pageBean
     * @return
     */
    @Override
    public PageBean findAllUser(String key, PageBean<SysUserEntity> pageBean) {

        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(SysUserEntity.class);

        if (key != null && !key.equals("")) {
            //搜索
            List list = criteria.add(
                    Restrictions.or(Restrictions.like("userId", key, MatchMode.ANYWHERE),
                            Restrictions.or(Restrictions.like("loginAccount", key, MatchMode.ANYWHERE)),
                            Restrictions.or(Restrictions.like("userName", key, MatchMode.ANYWHERE))))
                    .setFirstResult((pageBean.getCurrPage() - 1) * pageBean.getPageSize() )
                    .setMaxResults((pageBean.getCurrPage() - 1) * pageBean.getPageSize() + pageBean.getPageSize()).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

            System.out.println(pageBean+"\n"+list);
            pageBean.setRows(list);


        } else {
            List list = criteria.setFirstResult((pageBean.getCurrPage() - 1) * pageBean.getPageSize())
                    .setMaxResults((pageBean.getCurrPage() - 1) * pageBean.getPageSize() + pageBean.getPageSize()).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            System.out.println(pageBean+"\n"+list);
            pageBean.setRows(list);
        }
        return pageBean;

    }

    /**
     * 批量删除
     * @param userIds
     */
    @Override
    public void deleteAllUser(String[] userIds) {
        List<SysUserEntity> list = new ArrayList<>();

        System.out.println(userIds);

        for (String id : userIds) {
            SysUserEntity sysUserEntity = new SysUserEntity();
            sysUserEntity.setUserId(Integer.parseInt(id));
            list.add(sysUserEntity);
        }
        hibernateTemplate.deleteAll(list);
    }

}
