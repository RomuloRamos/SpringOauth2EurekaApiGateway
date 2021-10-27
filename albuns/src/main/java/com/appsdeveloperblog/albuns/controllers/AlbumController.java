package com.appsdeveloperblog.albuns.controllers;

import java.util.Arrays;
import java.util.List;

import com.appsdeveloperblog.albuns.response.AlbunsRest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/albuns")
public class AlbumController {
    
    @GetMapping
    public List<AlbunsRest> getAlbuns() {
        
        AlbunsRest album1 = new AlbunsRest();
        album1.setUserId("1");
        album1.setAlbumId("1");
        album1.setAlbumTitle("album 1 Title");
        album1.setAlbumDescription("album 1 Description");
        album1.setAlbumUrl("album 1 Url");

        AlbunsRest album2 = new AlbunsRest();
        album2.setUserId("1");
        album2.setAlbumId("2");
        album2.setAlbumTitle("album 2 Title");
        album2.setAlbumDescription("album 2 Description");
        album2.setAlbumUrl("album 2 Url");

        return Arrays.asList(album1, album2);
    }

}
