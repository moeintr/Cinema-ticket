package com.mycompany.cinema.dtos;

import com.mycompany.cinema.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class TicketPurchaseRequest {
    private User user;
    private String title;
    private Integer totalNumber;
}
