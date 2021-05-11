/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.repository.impl;

import com.project.model.CancelHistory;
import com.project.repository.CancelHistoryRepository;
import com.project.response.CancelHistoryResponse;
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
public class CancelHistoryRepositoryImpl implements CancelHistoryRepository{
    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    @Transactional
    public List getAllCancelHistory() {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder(); 
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<CancelHistory> root = query.from(CancelHistory.class);
        query.select(criteriaBuilder.construct(
                CancelHistoryResponse.class,
                root.get("cancelId"),
                root.get("reason"),
                root.get("note"),
                root.get("cusId").as(String.class),
                root.get("empId").as(String.class),
                root.get("ticketId").as(String.class)
        ));
        return session.createQuery(query).getResultList();
    }

    @Override
    @Transactional
    public CancelHistory getCancelHistoryById(String id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CancelHistory> query = criteriaBuilder.createQuery(CancelHistory.class);
        Root<CancelHistory> root = query.from(CancelHistory.class);
        query.select(root);
        Predicate p = criteriaBuilder.equal(root.get("cancelId"), id);
        
        query.where(p);
        
        return session.createQuery(query).uniqueResult();
    }

    @Override
    @Transactional
    public CancelHistory createCancelHistory(CancelHistory cancelHistory) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        if(cancelHistory != null){
            session.save(cancelHistory);
            return cancelHistory;
        }
        else{
            return null;
        }
    }

    @Override
    @Transactional
    public void updateCancelHistoryById(CancelHistory cancelHistory) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<CancelHistory> query = criteriaBuilder.createCriteriaUpdate(CancelHistory.class);
        Root<CancelHistory> root = query.from(CancelHistory.class);
        query.set("reason", cancelHistory.getReason());
        query.set("note", cancelHistory.getNote());
        query.set("cusId", cancelHistory.getCusId());
        query.set("empId", cancelHistory.getEmpId());
        query.set("ticketId", cancelHistory.getTicketId());
        
        Predicate p = criteriaBuilder.equal(root.get("cancelId"), cancelHistory.getCancelId());
        query.where(p);
        session.createQuery(query).executeUpdate();
    }

    @Override
    @Transactional
    public void deleteCancelHistoryById(String id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<CancelHistory> query = criteriaBuilder.createCriteriaDelete(CancelHistory.class);
        Root<CancelHistory> root = query.from(CancelHistory.class);
        
        Predicate p = criteriaBuilder.equal(root.get("cancelId"), id);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }
}
