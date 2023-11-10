package com.chungvv3.service.subservice;

import com.chungvv3.entities.Image;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "image-service", path = "/images/api/v1")
public interface FeignImageService {
    @GetMapping
    public List<Image> getListImage(@RequestParam("size") int size);

    @GetMapping("/{id}")
    public Image getImage(@PathVariable("id") int imageId);

    @PostMapping("/{id}")
    public Image addNewImage(@PathVariable("id") int idd, @RequestParam("pr1") String pr1,
                             @RequestParam("pr2") int pr2, @RequestBody Image image);
}
