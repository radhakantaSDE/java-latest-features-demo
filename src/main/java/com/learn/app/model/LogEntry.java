package com.learn.app.model;

import java.time.Instant;
import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LogEntry {

  private Instant timestamp;
  private String message;
  private String logType;
}
