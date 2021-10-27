package com.appsdeveloperblog.resourceserver.response;

public class UserRest {
    
    private String userFirstName;
    private String userId;
    private String userLastName;


    public UserRest(String userFirstName, String userId, String userLastName) {
        this.userFirstName = userFirstName;
        this.userId = userId;
        this.userLastName = userLastName;
    }
    public String getUserFirstName() {
        return userFirstName;
    }
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserLastName() {
        return userLastName;
    }
    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

}
