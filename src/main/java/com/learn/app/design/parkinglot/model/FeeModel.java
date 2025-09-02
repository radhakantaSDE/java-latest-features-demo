package com.learn.app.design.parkinglot.model;

import java.time.Duration;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FeeModel {
  double baseRate;
  double hourlyRate;

  double calculateFee(Duration duration) {
    long hours = duration.toHours();
    return baseRate + (hours * hourlyRate);
  }
}
