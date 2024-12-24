package com.example.Commandes_service.repo;


import com.example.Commandes_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Order, Long> {}
