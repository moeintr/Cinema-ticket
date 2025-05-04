package com.mycompany.cinema.controller;

import com.mycompany.cinema.dtos.TicketPurchaseRequest;
import com.mycompany.cinema.entity.TicketPurchase;
import com.mycompany.cinema.service.TicketPurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public TicketPurchase buyTicket(@RequestBody TicketPurchaseRequest ticketPurchaseRequest) {
        return ticketPurchaseService.buyTicket(ticketPurchaseRequest.getUser(), ticketPurchaseRequest.getTitle(), ticketPurchaseRequest.getTotalNumber());
    }
}
