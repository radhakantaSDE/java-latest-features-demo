package com.learn.app.model;

import lombok.*;

import java.time.Instant;

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
