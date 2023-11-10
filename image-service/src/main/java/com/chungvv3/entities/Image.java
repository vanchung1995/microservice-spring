package com.chungvv3.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Image {
    private Integer id;
    private String title;
    private String url;
}
