package com.restapi.service;

import com.restapi.dto.ProfileDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.AppUser;
import com.restapi.model.Location;
import com.restapi.model.Profile;
import com.restapi.model.Staff;
import com.restapi.repository.ProfileRepository;
import com.restapi.repository.UserRepository;
import com.restapi.request.ProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileDto profileDto;

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public Profile updateUserProfile(ProfileRequest profileRequest) {

        Profile profile = profileDto.mapToProfileResponse(profileRequest);
        AppUser appUser = userRepository.findById(profileRequest.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("UserId",
                        "UserId", profileRequest.getUserId()));
        profile.setAppUser(appUser);
        profileRepository.save(profile);
        return getUserProfile(profileRequest.getUserId());

    }

    public Profile getUserProfile(Long id) {
        Profile profile = profileRepository.findByUserId(id);
        return profileDto.mapToProfile(profile);
    }

    public Profile createUserProfile(ProfileRequest profileRequest) {
        Profile profile = profileDto.mapToProfileResponse(profileRequest);
        AppUser appUser = userRepository.findById(profileRequest.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("UserId",
                        "UserId", profileRequest.getUserId()));
        profile.setAppUser(appUser);

        Profile isProfile = profileRepository.findByUserId(profileRequest.getUserId());

        if(isProfile==null)
        {
            profileRepository.save(profile);

        }
        return getUserProfile(appUser.getId());
    }
}
