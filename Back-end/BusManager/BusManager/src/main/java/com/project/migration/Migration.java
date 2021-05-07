/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.migration;

import java.util.EnumSet;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

/**
 *
 * @author DELL
 */
//public class Migration {
//    public static void dropDataBase(SchemaExport export, Metadata metadata){
//        EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.DATABASE);
//        export.drop(targetTypes, metadata);
//        System.out.println("Drop Ok");
//    }
//
//    public static void createDataBase(SchemaExport export, Metadata metadata){
//        EnumSet<TargetType> targetTypes = EnumSet.of(TargetType.DATABASE);
//        SchemaExport.Action action = SchemaExport.Action.CREATE;
//        export.execute(targetTypes, action, metadata);
//        System.out.println("Export Ok");
//    }
//
//    public static void main(String[] args) {
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .configure("hibernate-mysql.cfg.xml")
//                .build();
//        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
//        SchemaExport export = new SchemaExport();
//        System.out.println("Drop Database...");
//        // Drop Database
//        dropDataBase(export, metadata);
//
//        System.out.println("Create Database...");
//
//        // Tạo lại hệ thống bảng
//        createDataBase(export, metadata);
//    }
//}
