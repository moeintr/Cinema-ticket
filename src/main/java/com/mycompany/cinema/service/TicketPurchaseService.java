package com.mycompany.cinema.service;

import com.mycompany.cinema.entity.TicketPurchase;
import com.mycompany.cinema.repository.TicketPurchaseFileRepository;

import java.util.List;

public class TicketPurchaseService implements Service<TicketPurchase>{
    private TicketPurchaseService() {
    }
    private static final TicketPurchaseService TICKET_PURCHASE_SERVICE = new TicketPurchaseService();

    public static TicketPurchaseService getInstance() {
        return TICKET_PURCHASE_SERVICE;
    }

    @Override
    public List<TicketPurchase> getAll() {
        return TicketPurchaseFileRepository.getInstance().findAll();
    }

    @Override
    public void saveAll(List<TicketPurchase> ticketPurchaseServices) {
        TicketPurchaseFileRepository.getInstance().saveAll(ticketPurchaseServices);
    }
}
