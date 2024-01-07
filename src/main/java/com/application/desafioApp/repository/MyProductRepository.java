package com.application.desafioApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.desafioApp.entities.MyProductList;

@Repository
public interface MyProductRepository extends JpaRepository<MyProductList,Integer>{
}
