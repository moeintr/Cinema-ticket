package com.mycompany.cinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class TicketPurchase implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketPurchaseId;
    @ManyToOne
    private Film film;
    @ManyToOne
    private User user;
    private Integer totalNumber;
    private Long totalCost;
}
