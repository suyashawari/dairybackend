package com.onlinedairy.dto;//package com.onlinedairy.dto;
//
//import com.onlinedairy.model.AppUser;
//import lombok.Data;
//
//@Data class LoginResponse {
//    private boolean success;
//    private String message;
//    private AppUser user;
//
//    public static LoginResponse success(AppUser user) {
//        LoginResponse response = new LoginResponse();
//        response.setSuccess(true);
//        response.setMessage("Login successful");
//        response.setUser(user);
//        return response;
//    }
//
//    public static LoginResponse failure(String message) {
//        LoginResponse response = new LoginResponse();
//        response.setSuccess(false);
//        response.setMessage(message);
//        return response;
//    }
//}