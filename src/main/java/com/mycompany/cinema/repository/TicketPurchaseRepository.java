package com.mycompany.cinema.repository;

import com.mycompany.cinema.entity.TicketPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketPurchaseRepository extends JpaRepository<TicketPurchase, Long> {
}
