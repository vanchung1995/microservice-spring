package com.chungvv3.service.subservice;

import com.chungvv3.entities.Image;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Component
public class RestTemplateImageService {
    private static final String IMAGE_PATH = "/images/api/v1";
    private static final String IMAGE_SERVICE = "image-service";
    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplateBalanced;
    private final RestTemplate restTemplate;

    public RestTemplateImageService(DiscoveryClient discoveryClient, RestTemplate restTemplateBalanced) {
        this.discoveryClient = discoveryClient;
        this.restTemplateBalanced = restTemplateBalanced;
        this.restTemplate = new RestTemplate();
    }

    private String getImageUrl() {
        URI uri = discoveryClient.getInstances(IMAGE_SERVICE).get(0).getUri();
        return uri.toString();
    }

    public List<Image> getListImage(int size) {
        String imageUrl = getImageUrl();
        String endPoint = imageUrl + IMAGE_PATH;
        List<Image> imageList = restTemplate
                .getForObject(endPoint, List.class);
        return imageList;
    }

    public List<Image> getListImageLoadBalancer(int size) {
        String endPoint = "http://" + IMAGE_SERVICE +"/" + IMAGE_PATH;
        List<Image> imageList = restTemplateBalanced
                .getForObject(endPoint, List.class);
        return imageList;
    }
}
