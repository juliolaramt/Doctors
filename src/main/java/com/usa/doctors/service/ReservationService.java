package com.usa.doctors.service;

import com.usa.doctors.Repository.ReservationRepository;
//import com.usa.doctors.controller.ClientReport;
import com.usa.doctors.model.ClientReport;
import com.usa.doctors.model.Reservation;
import com.usa.doctors.model.ReservationReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getById(Integer id) {
        return reservationRepository.getById(id);
    }

    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> optionalReservation = reservationRepository.getById(reservation.getIdReservation());
            if (optionalReservation.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> optionalReservation = reservationRepository.getById(reservation.getIdReservation());
            if (!optionalReservation.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    optionalReservation.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    optionalReservation.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    optionalReservation.get().setStatus(reservation.getStatus());
                }
                if (reservation.getScore() != null) {
                    optionalReservation.get().setScore(reservation.getScore());
                }
                reservationRepository.save(optionalReservation.get());
                return optionalReservation.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    public boolean delete(Integer id) {
        Boolean variaBoolean = getById(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return variaBoolean;
    }

    public ReservationReport getReservationStatusReport(){
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");
        return new ReservationReport(completed.size(), cancelled.size());
    }
    public List<Reservation> getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date aDate= new Date();
        Date bDate= new Date();
        try {
            aDate = parser.parse(dateA);
            bDate = parser.parse(dateB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }
        if(aDate.before(bDate)){
            return reservationRepository.getReservationPeriod(aDate, bDate);
        }else{
            return new ArrayList<>();
        }
    }
      public  List<ClientReport> getTopClients(){
        return reservationRepository.getTopClients();
      }
}