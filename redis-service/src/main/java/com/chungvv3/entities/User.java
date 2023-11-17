package com.chungvv3.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {
    private static final long versionSerialID = 1l;
    private String name;
    private int age;
}
