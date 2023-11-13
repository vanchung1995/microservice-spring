package com.chungvv3.controller;

import com.chungvv3.entities.Image;
import com.chungvv3.service.GalleryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gallery/api/v1")
public class GalleryController {

    private final GalleryService galleryService;

    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping("/{id}")
    public Image getImageByIdUseRestTemplate(@PathVariable("id") int imageId) {
        return galleryService.getImageUseFeignClient(imageId);
    }

    @GetMapping
    public List<Image> getImagesUseFeignClient(@RequestParam(value = "size", defaultValue = "2") int size) {
//        return galleryService.getImageListUseFeignClient(size);
        return galleryService.getImageListUseRestTemplate(size);
    }

    @PostMapping("/{id}")
    public Image addNewImage(@PathVariable("id") int pathId, @RequestParam("pr1") String pr1,
                             @RequestParam("pr2") int pr2, @RequestBody Image image) {
        return galleryService.createNewImage(pathId, pr1, pr2, image);
    }
}
