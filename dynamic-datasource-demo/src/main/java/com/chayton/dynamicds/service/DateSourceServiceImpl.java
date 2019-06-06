package com.chayton.dynamicds.service;

import com.chayton.dynamic.datasource.DynamicDataSource;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @Author: ChaytonRiver
 * @Date: 2019-06-04 17:16
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DateSourceServiceImpl implements IDateSourceService {

    @PersistenceContext
    @Qualifier
    private EntityManager entityManager;


    @Override
    @DynamicDataSource()
    public List findMaster(){
        Session session = getSession();
        NativeQuery nativeQuery = session.createSQLQuery("select fd_name from sys_org_element");
        return nativeQuery.getResultList();
    }

    @Override
    @DynamicDataSource(name = "school")
    public List findSchool(){
        Session session = getSession();
        NativeQuery nativeQuery = session.createSQLQuery("select name from test");
        return nativeQuery.getResultList();
    }

    @Override
    @DynamicDataSource(name = "apt")
    public List findApt(){
       Session session = getSession();
        NativeQuery nativeQuery = session.createSQLQuery("SELECT fd_problem_describe from apt_audit_problem");
        return nativeQuery.getResultList();
    }

    public Session getSession(){
        return entityManager.unwrap(org.hibernate.Session.class);
    }
}
