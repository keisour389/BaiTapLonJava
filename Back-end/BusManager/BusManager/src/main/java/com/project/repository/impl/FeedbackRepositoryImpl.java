/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.repository.impl;

import com.project.model.Feedback;
import com.project.repository.FeedbackRepository;
import com.project.response.FeedbackResponse;
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
public class FeedbackRepositoryImpl implements FeedbackRepository{
    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    @Transactional
    public List getAllFeedback() {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder(); 
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<Feedback> root = query.from(Feedback.class);
        query.select(criteriaBuilder.construct(
                FeedbackResponse.class,
                root.get("feedbackId"),
                root.get("content"),
                root.get("status"),
                root.get("note"),
                root.get("cusId").as(String.class),
                root.get("empId").as(String.class)
        ));
        return session.createQuery(query).getResultList();
    }

    @Override
    @Transactional
    public Feedback getFeedbackById(String id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Feedback> query = criteriaBuilder.createQuery(Feedback.class);
        Root<Feedback> root = query.from(Feedback.class);
        query.select(root);
        Predicate p = criteriaBuilder.equal(root.get("feedbackId"), id);
        
        query.where(p);
        
        return session.createQuery(query).uniqueResult();
    }

    @Override
    @Transactional
    public Feedback createFeedback(Feedback feedback) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        if(feedback != null){
            session.save(feedback);
            return feedback;
        }
        else{
            return null;
        }
    }

    @Override
    @Transactional
    public void updateFeedbackById(String id, Feedback feedback) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<Feedback> query = criteriaBuilder.createCriteriaUpdate(Feedback.class);
        Root<Feedback> root = query.from(Feedback.class);
        query.set("content", feedback.getContent());
        query.set("status", feedback.getStatus());
        query.set("note", feedback.getNote());
        query.set("cusId", feedback.getCusId());
        query.set("empId", feedback.getEmpId());
        
        Predicate p = criteriaBuilder.equal(root.get("feedbackId"), id);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }

    @Override
    @Transactional
    public void deleteFeedbackById(String id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<Feedback> query = criteriaBuilder.createCriteriaDelete(Feedback.class);
        Root<Feedback> root = query.from(Feedback.class);
        
        Predicate p = criteriaBuilder.equal(root.get("feedbackId"), id);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }
}
