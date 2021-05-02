/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.repository.impl;

import com.project.model.AccountInfo;
import com.project.repository.AccountInfoRepository;
import com.project.response.AccountInfoResponse;
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

/**
 *
 * @author DELL
 */
public class AccountInfoRepositoryImpl implements AccountInfoRepository{
    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    @Transactional
    public List getAllAccountInfo() {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder(); 
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<AccountInfo> root = query.from(AccountInfo.class);
        query.select(criteriaBuilder.construct(
                AccountInfoResponse.class,
                root.get("userId"),
                root.get("password"),
                root.get("type"),
                root.get("status"),
                root.get("createdOn").as(String.class),
                root.get("updatedOn").as(String.class),
                root.get("note")
        ));
        return session.createQuery(query).getResultList();
    }
    
    @Override
    @Transactional
    public AccountInfo getAccountInfoById(String id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<AccountInfo> query = criteriaBuilder.createQuery(AccountInfo.class);
        Root<AccountInfo> root = query.from(AccountInfo.class);
        query.select(root);
        Predicate p = criteriaBuilder.equal(root.get("userId"), id);
        
        query.where(p);
        
        return session.createQuery(query).uniqueResult();
    }

    @Override
    @Transactional
    public AccountInfo getAccountInfoByUserIdPassword(String userId, String password) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<AccountInfo> query = criteriaBuilder.createQuery(AccountInfo.class);
        Root<AccountInfo> root = query.from(AccountInfo.class);
        query.select(root);
        
        Predicate p1 = criteriaBuilder.like(root.get("userId").as(String.class), userId);
        Predicate p2 = criteriaBuilder.equal(root.get("password").as(String.class), password);
        query.where(criteriaBuilder.and(p1,p2));
        
        return session.createQuery(query).uniqueResult();
    }
    
    @Override
    @Transactional
    public AccountInfo createAccountInfo(AccountInfo accountInfo) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        if(accountInfo != null){
            session.save(accountInfo);
            return accountInfo;
        }
        else{
            return null;
        }
    }

    @Override
    @Transactional
    public void updateAccountInfoById(String id, AccountInfo accountInfo) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<AccountInfo> query = criteriaBuilder.createCriteriaUpdate(AccountInfo.class);
        Root<AccountInfo> root = query.from(AccountInfo.class);
        query.set("password", accountInfo.getPassword());
        query.set("type", accountInfo.getType());
        query.set("status", accountInfo.getStatus());
        query.set("createdOn", accountInfo.getCreatedOn());
        query.set("updatedOn", accountInfo.getUpdatedOn());
        query.set("note", accountInfo.getNote());
        
        Predicate p = criteriaBuilder.equal(root.get("userId"), id);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }

    @Override
    @Transactional
    public void deleteAccountInfoById(String id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<AccountInfo> query = criteriaBuilder.createCriteriaDelete(AccountInfo.class);
        Root<AccountInfo> root = query.from(AccountInfo.class);
        
        Predicate p = criteriaBuilder.equal(root.get("userId"), id);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }
}
