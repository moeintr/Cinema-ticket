package com.mycompany.cinema.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.cinema.entity.TicketPurchase;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicketPurchaseFileRepository implements FileRepository<TicketPurchase> {
    private TicketPurchaseFileRepository() {
    }
    private static final TicketPurchaseFileRepository TICKET_PURCHASE_FILE_REPOSITORY = new TicketPurchaseFileRepository();

    public static TicketPurchaseFileRepository getInstance() {
        return TICKET_PURCHASE_FILE_REPOSITORY;
    }

    private final File file = new File("ticketPurchases.json");
    private final String CHARSET_NAME = "utf-8";
    private final Gson gson = new Gson();

    @Override
    public void saveAll(List<TicketPurchase> ticketPurchases) {
        try {
            String json = gson.toJson(ticketPurchases);
            FileUtils.writeStringToFile(file, json, CHARSET_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TicketPurchase> findAll() {
        try {
            if (!file.exists()) return new ArrayList<>(List.of());
            String content = FileUtils.readFileToString(file, CHARSET_NAME);
            List<TicketPurchase> ticketPurchases = gson.fromJson(content, new TypeToken<List<TicketPurchase>>(){}.getType());
            return ticketPurchases;
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
