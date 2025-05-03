package com.mycompany.cinema.controller;

import com.mycompany.cinema.entity.TicketPurchase;
import com.mycompany.cinema.service.TicketPurchaseService;

import java.util.List;

public class TicketPurchaseController {
    private TicketPurchaseController() {
    }

    private static final TicketPurchaseController TICKET_PURCHASE_CONTROLLER = new TicketPurchaseController();

    public static TicketPurchaseController getInstance() {
        return TICKET_PURCHASE_CONTROLLER;
    }

    public List<TicketPurchase> getAll() {
        return TicketPurchaseService.getInstance().getAll();
    }
}
