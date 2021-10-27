package com.appsdeveloperblog.photos.controllers;

import java.util.Arrays;
import java.util.List;

import com.appsdeveloperblog.photos.response.PhotosRest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/photos")
public class PhotosController {
    
    @GetMapping
    public List<PhotosRest> getPhotos() {
        
        PhotosRest photo1 = new PhotosRest();
        photo1.setPhotoTitle("photo 1 Title");
        photo1.setPhotoDescription("photo 1 Description");
        photo1.setPhotoUrl("photo 1 Url");
        photo1.setUserId("1");
        photo1.setPhotoId("1");
        photo1.setAlbumId("albumIdHere");

        PhotosRest photo2 = new PhotosRest();
        photo2.setPhotoTitle("photo 2 Title");
        photo2.setPhotoDescription("photo 2 Description");
        photo2.setPhotoUrl("photo 2 Url");
        photo2.setUserId("1");
        photo2.setPhotoId("2");
        photo2.setAlbumId("albumIdHere");

        return Arrays.asList(photo1, photo2);
    }
}
