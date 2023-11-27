package com.restapi.dto;

import com.restapi.model.Profile;
import com.restapi.request.ProfileRequest;
import org.springframework.stereotype.Component;

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

    public Profile mapToProfile(Optional<Profile> optionalProfile) {
        Profile profile = new Profile();
        profile.setGender(optionalProfile.get().getGender());
        profile.setPhoneNumber(optionalProfile.get().getPhoneNumber());
        profile.setDateOfBirth(optionalProfile.get().getDateOfBirth());
        profile.setId(optionalProfile.get().getId());
        return profile;
    }
}
