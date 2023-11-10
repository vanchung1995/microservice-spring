package com.chungvv3.controller;

import com.chungvv3.entities.Image;
import com.chungvv3.service.GaleryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/galery/api/v1")
public class GaleryController {

    private final GaleryService galeryService;

    public GaleryController(GaleryService galeryService) {
        this.galeryService = galeryService;
    }

    @GetMapping("/{id}")
    public Image getImageByIdUseRestTemplate(@PathVariable("id") int imageId) {
        return galeryService.getImageUseFeignClient(imageId);
    }

    @GetMapping
    public List<Image> getImagesUseFeignClient(@RequestParam(value = "size", defaultValue = "2") int size) {
        return galeryService.getImageListUseFeignClient(size);
    }

    @PostMapping("/{id}")
    public Image addNewImage(@PathVariable("id") int pathId, @RequestParam("pr1") String pr1,
                             @RequestParam("pr2") int pr2, @RequestBody Image image) {
        return galeryService.createNewImage(pathId, pr1, pr2, image);
    }
}
