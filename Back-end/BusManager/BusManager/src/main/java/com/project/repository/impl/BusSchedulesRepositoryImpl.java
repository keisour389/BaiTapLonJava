/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.repository.impl;

import com.project.model.BusSchedules;
import com.project.repository.BusSchedulesRepository;
import com.project.response.BusSchedulesResponse;
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
public class BusSchedulesRepositoryImpl implements BusSchedulesRepository{
    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    @Transactional
    public List<Object> getAllBusSchedules() {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder(); 
        CriteriaQuery<Object> query = criteriaBuilder.createQuery(Object.class);
        Root<BusSchedules> root = query.from(BusSchedules.class);
        query.select(criteriaBuilder.construct(
                BusSchedulesResponse.class,
                root.get("tripId"),
                root.get("licensePlates"),
                root.get("mainDriver").as(String.class),
                root.get("subDriver").as(String.class),
                root.get("from"),
                root.get("to"),
                root.get("departureDay").as(String.class),
                root.get("totalTime").as(String.class),
                root.get("status").as(String.class),
                root.get("vehicalType"),
                root.get("totalSeats").as(String.class),
                root.get("createdOn").as(String.class),
                root.get("updatedOn").as(String.class),
                root.get("note"),
                root.get("manager").as(String.class)
        ));
        return session.createQuery(query).getResultList();
    }

    @Override
    @Transactional
    public BusSchedules getBusSchedulesById(String id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<BusSchedules> query = criteriaBuilder.createQuery(BusSchedules.class);
        Root<BusSchedules> root = query.from(BusSchedules.class);
        query.select(root);
        Predicate p = criteriaBuilder.equal(root.get("tripId"), id);
        
        query.where(p);
        
        return session.createQuery(query).uniqueResult();
    }

    @Override
    @Transactional
    public BusSchedules createBusSchedules(BusSchedules busSchedules) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        if(busSchedules != null){
            session.save(busSchedules);
            return busSchedules;
        }
        else{
            return null;
        }
    }

    @Override
    @Transactional
    public void updateBusSchedulesById(String id, BusSchedules busSchedules) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<BusSchedules> query = criteriaBuilder.createCriteriaUpdate(BusSchedules.class);
        Root<BusSchedules> root = query.from(BusSchedules.class);
        query.set("licensePlates", busSchedules.getLicensePlates());
        query.set("mainDriver", busSchedules.getMainDriver());
        query.set("subDriver", busSchedules.getStatus());
        query.set("from", busSchedules.getFrom());
        query.set("to", busSchedules.getTo());
        query.set("departureDay", busSchedules.getDepartureDay());
        query.set("totalTime", busSchedules.getTotalTime());
        query.set("status", busSchedules.getStatus());
        query.set("vehicalType", busSchedules.getVehicalType());
        query.set("totalSeats", busSchedules.getTotalSeats());
        query.set("createdOn", busSchedules.getCreatedOn());
        query.set("updatedOn", busSchedules.getUpdatedOn());
        query.set("note", busSchedules.getNote());
        query.set("manager", busSchedules.getManager());
        
        Predicate p = criteriaBuilder.equal(root.get("tripId"), id);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }

    @Override
    @Transactional
    public void deleteBusSchedulesById(String id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaDelete<BusSchedules> query = criteriaBuilder.createCriteriaDelete(BusSchedules.class);
        Root<BusSchedules> root = query.from(BusSchedules.class);
        
        Predicate p = criteriaBuilder.equal(root.get("tripId"), id);
        query.where(p);
        session.createQuery(query).executeUpdate();
    }
}
