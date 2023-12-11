package com.chungvv3.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CustomErrorResponse {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime timestamp = LocalDateTime.now();

    private final String message;
}
