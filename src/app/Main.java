package app;

import model.entities.Reservation;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-In date (DD/MM/YYYY): ");
        LocalDate checkIn = LocalDate.parse(sc.next(), dtf);
        System.out.print("Check-Out date (DD/MM/YYYY): ");
        LocalDate checkOut = LocalDate.parse(sc.next(), dtf);

        if (!checkOut.isAfter(checkIn)) {
            System.out.println("Error in reservation: check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("\nEnter data to update the reservation:");
            System.out.print("Check-In date (DD/MM/YYYY): ");
            checkIn = LocalDate.parse(sc.next(), dtf);
            System.out.print("Check-Out date (DD/MM/YYYY): ");
            checkOut = LocalDate.parse(sc.next(), dtf);

            LocalDate.now();
            if (checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            } else if (!checkOut.isAfter(checkIn)) {
                System.out.println("Error in reservation: check-out date must be after check-in date");
            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
        }
    }
}
