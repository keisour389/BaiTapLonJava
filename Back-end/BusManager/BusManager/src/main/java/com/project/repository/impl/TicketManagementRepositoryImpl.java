/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.repository.impl;

import com.project.model.TicketManagement;
import com.project.repository.TicketManagementRepository;
import com.project.response.TicketManagementResponse;
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
public class TicketManagementRepositoryImpl implements TicketManagementRepository{
    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    @Transactional
    public List getAllTicketManagement() {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder(); 
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<TicketManagement> root = query.from(TicketManagement.class);
        query.select(criteriaBuilder.construct(
                TicketManagementResponse.class,
                root.get("ticketId"),
                root.get("seatId"),
                root.get("price").as(String.class),
                root.get("status").as(String.class),
                root.get("payment").as(String.class),
                root.get("paymentDate").as(String.class),
                root.get("bookingDate").as(String.class),
                root.get("note"),
                root.get("tripId").as(String.class),
                root.get("cusId").as(String.class)
        ));
        return session.createQuery(query).getResultList();
    }

    @Override
    @Transactional
    public TicketManagement getTicketManagementById(String id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<TicketManagement> query = criteriaBuilder.createQuery(TicketManagement.class);
        Root<TicketManagement> root = query.from(TicketManagement.class);
        query.select(root);
        Predicate p = criteriaBuilder.equal(root.get("ticketId"), id);
        
        query.where(p);
        
        return session.createQuery(query).uniqueResult();
    }

    @Override
    @Transactional
    public TicketManagement createTicketManagement(TicketManagement ticketManagement) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        if(ticketManagement != null){
            session.save(ticketManagement);
            return ticketManagement;
        }
        else{
            return null;
        }
    }

    @Override
    @Transactional
    public void updateTicketManagementById(String id, TicketManagement ticketManagement) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<TicketManagement> query = criteriaBuilder.createCriteriaUpdate(TicketManagement.class);
        Root<TicketManagement> root = query.from(TicketManagement.class);
        query.set("seatId", ticketManagement.getSeatId());
        query.set("price", ticketManagement.getPrice());
        query.set("status", ticketManagement.getStatus());
        query.set("payment", ticketManagement.getPayment());
        query.set("paymentDate", ticketManagement.getPaymentDate());
        query.set("bookingDate", ticketManagement.getBookingDate());
        query.set("note", ticketManagement.getNote());
        query.set("tripId", ticketManagement.getTripId());
        query.set("cusId", ticketManagement.getCusId());
        
        Predicate p = criteriaBuilder.equal(root.get("ticketId"), id);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }

    @Override
    @Transactional
    public void deleteTicketManagementById(String id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<TicketManagement> query = criteriaBuilder.createCriteriaDelete(TicketManagement.class);
        Root<TicketManagement> root = query.from(TicketManagement.class);
        
        Predicate p = criteriaBuilder.equal(root.get("ticketId"), id);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }
}
