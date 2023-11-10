package com.chungvv3.service;

import com.chungvv3.entities.Image;
import com.chungvv3.service.subservice.FeignImageService;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GaleryService {
    private final DiscoveryClient discoveryClient;
    private final FeignImageService feignImageService;

    public GaleryService(DiscoveryClient discoveryClient, FeignImageService feignImageService) {
        this.discoveryClient = discoveryClient;
        this.feignImageService = feignImageService;
    }

    public List<Image> getImageListUseFeignClient(int size) {
        return feignImageService.getListImage(size);
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
