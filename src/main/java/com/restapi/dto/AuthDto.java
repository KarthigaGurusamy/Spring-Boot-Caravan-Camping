package com.restapi.dto;

import com.restapi.model.AppUser;
import com.restapi.request.RegisterRequest;
import com.restapi.response.AuthResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthDto {

    public AppUser mapToAppUser(RegisterRequest user) {
        AppUser appUser = new AppUser();
        appUser.setUsername(user.getUsername());
        appUser.setName(user.getName());
        appUser.setPassword(user.getPassword());
        appUser.setEmail(user.getEmail());
        return appUser;
    }


    public AuthResponse mapToAuthResponse(AppUser appUser) {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setId(appUser.getId());
        authResponse.setName(appUser.getName());
        authResponse.setUsername(appUser.getUsername());
        authResponse.setRole(appUser.getRoles().getName());
        authResponse.setEmail(appUser.getEmail());

        return authResponse;
    }

    public List<AuthResponse> mapToAllUsersAuthResponse(List<AppUser> all) {
        List<AuthResponse> authResponses = new ArrayList<>();
        for(AppUser appUser:all)
        {
            AuthResponse authResponse = new AuthResponse();
            authResponse.setId(appUser.getId());
            authResponse.setName(appUser.getName());
            authResponse.setUsername(appUser.getUsername());
            authResponse.setRole(appUser.getRoles().getName());
            authResponse.setEmail(appUser.getEmail());
            authResponses.add(authResponse);
        }
        return authResponses;
    }
}
