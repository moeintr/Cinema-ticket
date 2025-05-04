package com.mycompany.cinema.controller;

import com.mycompany.cinema.entity.TicketPurchase;
import com.mycompany.cinema.entity.User;
import com.mycompany.cinema.service.TicketPurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket-purchase")
public class TicketPurchaseController {
    private final TicketPurchaseService ticketPurchaseService;

    @GetMapping("/getAll")
    public List<TicketPurchase> getAll() {
        return ticketPurchaseService.getAll();
    }
    @PostMapping("/buy")
    public TicketPurchase buyTicket(User user, String title, Integer totalNumber) {
        return ticketPurchaseService.buyTicket(user, title, totalNumber);
    }
}
