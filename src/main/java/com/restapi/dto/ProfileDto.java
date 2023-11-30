package com.restapi.dto;

import com.restapi.model.Profile;
import com.restapi.request.ProfileRequest;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

@Component
public class ProfileDto {
    public Profile mapToProfileResponse(ProfileRequest profileRequest) {
        Profile profile = new Profile();
        if(profileRequest.getId()!=null)
        {
            profile.setId(profileRequest.getId());
        }
        profile.setGender(profileRequest.getGender());
        profile.setPhoneNumber(profileRequest.getPhoneNumber());
        profile.setDateOfBirth(profileRequest.getDateOfBirth());
        return profile;
    }

    public Profile mapToProfile(Profile optionalProfile) {
        Profile profile = new Profile();
        profile.setGender(optionalProfile.getGender());
        profile.setPhoneNumber(optionalProfile.getPhoneNumber());
        profile.setDateOfBirth(optionalProfile.getDateOfBirth());
        profile.setId(optionalProfile.getId());
        return profile;
    }
}
