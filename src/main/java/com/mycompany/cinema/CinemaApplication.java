package com.mycompany.cinema;

import com.mycompany.cinema.controller.FilmController;
import com.mycompany.cinema.controller.TicketPurchaseController;
import com.mycompany.cinema.entity.Film;
import com.mycompany.cinema.entity.TicketPurchase;
import com.mycompany.cinema.service.FilmService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CinemaApplication {
    private static Scanner scanner;
    private static List<Film> initialFilms() {
        return new ArrayList<>(List.of(
                new Film(1,"The Shawshank Redemption", 100, 1_000L),
                new Film(2, "Shutter Island", 100, 900L),
                new Film(3, "Spider Man", 100, 850L),
                new Film(4, "The Dark Knight Rises", 100, 950L),
                new Film(5, "In Time", 100, 700L)
                ));
    }

    public static void main(String[] args) {
        Integer option = 0;
        System.out.println("welcome to my cinema");
        while (option != 9) {
            try {
                System.out.println("plz choose an option:");
                System.out.println("1-initial films");
                System.out.println("2-show list of films and remaining tickets");
                System.out.println("3-buy ticket and calculate price");
                System.out.println("4-show all ticket purchases");
                System.out.println("9-exit");
                scanner = new Scanner(System.in);
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        List<Film> initialFilms = initialFilms();
                        FilmController filmController = new FilmController(FilmService.getInstance());
                        filmController.saveAll(initialFilms);
                        System.out.println(initialFilms);
                        break;
                    case 2:
                        FilmController filmController1 = new FilmController(FilmService.getInstance());
                        List<Film> films = filmController1.getAll();
                        System.out.println(films);
                        break;
                    case 3:
                        System.out.println("plz enter title of film");
                        scanner = new Scanner(System.in);
                        String title = scanner.nextLine();

                        System.out.println("plz enter your number of tickets");
                        scanner = new Scanner(System.in);
                        Integer totalNumber = scanner.nextInt();

                        FilmController filmController2 = new FilmController(FilmService.getInstance());
                        TicketPurchase ticketPurchase = filmController2.buyTicket(title, totalNumber);
                        System.out.println(ticketPurchase);
                        System.out.println("success.....");
                        break;
                    case 4:
                        List<TicketPurchase> ticketPurchases = TicketPurchaseController.getInstance().getAll();
                        System.out.println(ticketPurchases);
                        break;
                    default:
                        throw new RuntimeException("wrong input");
                }
            } catch (Exception e) {
                option = 0;
                System.err.println(e.getMessage());
            }
        }
    }
}