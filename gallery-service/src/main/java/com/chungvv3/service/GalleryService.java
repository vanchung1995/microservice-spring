package com.chungvv3.service;

import com.chungvv3.entities.Image;
import com.chungvv3.service.subservice.FeignImageService;
import com.chungvv3.service.subservice.RestTemplateImageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryService {
    private final FeignImageService feignImageService;
    private final RestTemplateImageService restTemplateImageService;

    public GalleryService(FeignImageService feignImageService, RestTemplateImageService restTemplateImageService) {
        this.feignImageService = feignImageService;
        this.restTemplateImageService = restTemplateImageService;
    }

    public List<Image> getImageListUseFeignClient(int size) {
        return feignImageService.getListImage(size);
    }

    public List<Image> getImageListUseRestTemplate(int size) {
        return restTemplateImageService.getListImageLoadBalancer(size);
    }

    public Image getImageUseFeignClient(int imageId) {
        return feignImageService.getImage(imageId);
    }

    public Image createNewImage(int pathId, String param1, int param2, Image image) {
        return feignImageService.addNewImage(pathId, param1, param2, image);
    }

    public Image getImageUseRestTemple(int imageId) {
        return null;
    }
}
