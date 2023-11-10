package com.chungvv3.controller;

import com.chungvv3.entities.Image;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/images/api/v1")
public class ImageController {
    private List<Image> images = new ArrayList(Arrays.asList(
            new Image(1, "image 1", "image 1"),
            new Image(2, "image 2", "image 2"),
            new Image(3, "image 3", "image 3")
    ));

    @GetMapping("/{id}")
    public Image getImageById(@PathVariable("id") int imageId) {
        System.out.println("getImageById called");
        return images.get(imageId);
    }

    @GetMapping
    public List<Image> getImages(@RequestParam(value = "size", defaultValue = "2") int size) {
        System.out.println("GetImages called");
        return images.subList(0, Math.min(size, images.size()));
    }

    @PostMapping("/{id}")
    public Image addNewImage(@PathVariable("id") int pathId, @RequestParam("pr1") String pr1,
                             @RequestParam("pr2") int pr2, @RequestBody Image image) {
        int id = images.size();
        image.setId(id);
        image.setTitle(image.getTitle() + "_" + pathId +"_" + pr1 + "_" + pr2);
        images.add(image);
        return image;
    }
}
