/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.repository.impl;

import com.project.model.AccountInfo;
import com.project.model.CusInfo;
import com.project.repository.CusInfoRepository;
import com.project.response.CusInfoResponse;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public class CusInfoRepositoryImpl implements CusInfoRepository{
    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    @Transactional
    public List getAllCusInfo() {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder(); 
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<CusInfo> root = query.from(CusInfo.class);
        query.select(criteriaBuilder.construct(
                CusInfoResponse.class,
                root.get("userId"),
                root.get("firstName"),
                root.get("lastName"),
                root.get("displayName"),
                root.get("phoneNumber"),
                root.get("birthday").as(String.class),
                root.get("gender"),
                root.get("createdOn").as(String.class),
                root.get("updatedOn").as(String.class),
                root.get("note"),
                root.get("username").as(String.class)
        ));
        return session.createQuery(query).getResultList();
    }

    @Override
    @Transactional
    public CusInfo getCusInfoById(String id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CusInfo> query = criteriaBuilder.createQuery(CusInfo.class);
        Root<CusInfo> root = query.from(CusInfo.class);
        query.select(root);
        Predicate p = criteriaBuilder.equal(root.get("userId"), id);
        
        query.where(p);
        
        return session.createQuery(query).uniqueResult();
    }

    @Override
    @Transactional
    public CusInfo createCusInfo(CusInfo cusInfo) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        if(cusInfo != null){
            session.save(cusInfo);
            return cusInfo;
        }
        else{
            return null;
        }
    }

    @Override
    @Transactional
    public void updateCusInfoById(String id, CusInfo cusInfo) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<CusInfo> query = criteriaBuilder.createCriteriaUpdate(CusInfo.class);
        Root<CusInfo> root = query.from(CusInfo.class);
        query.set("firstName", cusInfo.getFirstName());
        query.set("lastName", cusInfo.getLastName());
        query.set("displayName", cusInfo.getDisplayName());
        query.set("phoneNumber", cusInfo.getPhoneNumber());
        query.set("birthday", cusInfo.getBirthday());
        query.set("gender", cusInfo.getGender());
        query.set("createdOn", cusInfo.getCreatedOn());
        query.set("updatedOn", cusInfo.getUpdatedOn());
        query.set("note", cusInfo.getNote());
        query.set("username", cusInfo.getUsername());
        
        Predicate p = criteriaBuilder.equal(root.get("userId"), id);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }

    @Override
    @Transactional
    public void deleteCusInfoById(String id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<CusInfo> query = criteriaBuilder.createCriteriaDelete(CusInfo.class);
        Root<CusInfo> root = query.from(CusInfo.class);
        
        Predicate p = criteriaBuilder.equal(root.get("userId"), id);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }
}
