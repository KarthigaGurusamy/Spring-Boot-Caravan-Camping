package com.restapi.dto;

import com.restapi.model.Profile;
import com.restapi.request.ProfileRequest;
import org.springframework.stereotype.Component;

@Component
public class ProfileDto {
    public Profile mapToStaffLocation(ProfileRequest profileRequest) {
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
}
