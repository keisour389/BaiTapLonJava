/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.repository.impl;

import com.project.model.EmpInfo;
import com.project.repository.EmpInfoRepository;
import com.project.response.EmpInfoResponse;
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
public class EmpInfoRepositoryImpl implements EmpInfoRepository{
    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    @Transactional
    public List getAllEmpInfo() {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder(); 
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<EmpInfo> root = query.from(EmpInfo.class);
        query.select(criteriaBuilder.construct(
                EmpInfoResponse.class,
                root.get("userId"),
                root.get("firstName"),
                root.get("lastName"),
                root.get("displayName"),
                root.get("phoneNumber"),
                root.get("birthday").as(String.class),
                root.get("address"),
                root.get("id"),
                root.get("gender"),
                root.get("type"),
                root.get("createdOn").as(String.class),
                root.get("updatedOn").as(String.class),
                root.get("note")
        ));
        return session.createQuery(query).getResultList();
    }

    @Override
    @Transactional
    public EmpInfo getEmpInfoById(String id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<EmpInfo> query = criteriaBuilder.createQuery(EmpInfo.class);
        Root<EmpInfo> root = query.from(EmpInfo.class);
        query.select(root);
        Predicate p = criteriaBuilder.equal(root.get("userId"), id);
        
        query.where(p);
        
        return session.createQuery(query).uniqueResult();
    }

    @Override
    @Transactional
    public EmpInfo createEmpInfo(EmpInfo empInfo) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        if(empInfo != null){
            session.save(empInfo);
            return empInfo;
        }
        else{
            return null;
        }
    }

    @Override
    @Transactional
    public void updateEmpInfoById(String id, EmpInfo empInfo) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<EmpInfo> query = criteriaBuilder.createCriteriaUpdate(EmpInfo.class);
        Root<EmpInfo> root = query.from(EmpInfo.class);
        query.set("firstName", empInfo.getFirstName());
        query.set("lastName", empInfo.getLastName());
        query.set("displayName", empInfo.getDisplayName());
        query.set("phoneNumber", empInfo.getPhoneNumber());
        query.set("birthday", empInfo.getBirthday());
        query.set("address", empInfo.getAddress());
        query.set("id", empInfo.getId());
        query.set("gender", empInfo.getGender());
        query.set("type", empInfo.getType());
        query.set("createdOn", empInfo.getCreatedOn());
        query.set("updatedOn", empInfo.getUpdatedOn());
        query.set("note", empInfo.getNote());
        
        Predicate p = criteriaBuilder.equal(root.get("userId"), id);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }

    @Override
    @Transactional
    public void deleteEmpInfoById(String id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<EmpInfo> query = criteriaBuilder.createCriteriaDelete(EmpInfo.class);
        Root<EmpInfo> root = query.from(EmpInfo.class);
        
        Predicate p = criteriaBuilder.equal(root.get("userId"), id);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }
    
}
