package com.learn.app.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

  private String id;
  private String line1;
  private String line2;
  private String pin;
  private String contact;
}
