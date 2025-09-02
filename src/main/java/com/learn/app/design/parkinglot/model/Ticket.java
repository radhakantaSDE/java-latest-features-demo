package com.learn.app.design.parkinglot.model;

import java.time.LocalDateTime;

public class Ticket {

  String ticketId;
  Vehicle vehicle;
  LocalDateTime entryTime;
  ParkingSpot spot;
}
