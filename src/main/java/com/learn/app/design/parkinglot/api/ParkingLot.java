package com.learn.app.design.parkinglot.api;

import com.learn.app.design.parkinglot.model.FeeModel;
import com.learn.app.design.parkinglot.model.Floor;
import com.learn.app.design.parkinglot.model.VehicleType;
import com.learn.app.design.parkinglot.service.SpotManager;
import com.learn.app.design.parkinglot.service.TicketManager;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParkingLot {

  List<Floor> floors;
  Map<VehicleType, FeeModel> feeModels;
  TicketManager ticketManager;
  SpotManager spotManager;
}
