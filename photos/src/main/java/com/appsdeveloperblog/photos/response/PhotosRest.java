package com.appsdeveloperblog.photos.response;

public class PhotosRest {
    
    private String albumId;
    private String photoId;
    private String userId;
    private String photoTitle;
    private String photoDescription;
    private String photoUrl;


    public PhotosRest() {
    }


    public String getAlbumId() {
        return albumId;
    }


    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }


    public String getPhotoId() {
        return photoId;
    }


    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getPhotoTitle() {
        return photoTitle;
    }


    public void setPhotoTitle(String photoTitle) {
        this.photoTitle = photoTitle;
    }


    public String getPhotoDescription() {
        return photoDescription;
    }


    public void setPhotoDescription(String photoDescription) {
        this.photoDescription = photoDescription;
    }


    public String getPhotoUrl() {
        return photoUrl;
    }


    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    

}
