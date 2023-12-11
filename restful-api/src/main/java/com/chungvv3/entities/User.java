package com.chungvv3.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;

    @NotBlank
    @Size(min = 5, message = "Name must be greater or equals 5 characters")
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Birthday must be less than today")
    private LocalDate birthday;
}
