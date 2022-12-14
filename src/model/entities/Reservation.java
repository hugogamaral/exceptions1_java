package model.entities;


import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {

    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation() {
    }

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException {
        if (!checkOut.isAfter(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public long duration() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);

    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {

        LocalDate.now();
        if (checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())) {
            throw new DomainException("Reservation dates for update must be future dates");
        }
        if (!checkOut.isAfter(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

        public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        public String toString() {
            return "Room " + roomNumber +
                    ", check-In: " + getCheckIn().format(dtf) +
                    ", check-Out: " + getCheckOut().format(dtf) +
                    ", " + duration() + " nights";

        }
    }

