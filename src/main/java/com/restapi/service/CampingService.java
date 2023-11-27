package com.restapi.service;

import com.restapi.dto.CampingDto;
import com.restapi.model.Camping;
import com.restapi.repository.CampingRepository;
import com.restapi.request.CampingRequest;
import com.restapi.response.CampingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CampingService {

    @Autowired
    private CampingRepository campingRepository;

    @Autowired
    private CampingDto campingDto;
    public CampingResponse findAll() {
        List<Camping> campingList = campingRepository.findAll();
        return campingDto.mapToCampingResponse(campingList);
    }


    @Transactional
    public CampingResponse createCamping(CampingRequest campingRequest) {
        Camping camping = campingDto.mapToCamping(campingRequest);
        campingRepository.save(camping);
        return findAll();
    }

    @Transactional
    public CampingResponse updateCamping(CampingRequest campingRequest) {
        Camping camping = campingDto.mapToCamping(campingRequest);
        campingRepository.save(camping);
        return findAll();
    }

    public CampingResponse deleteCamping(Long id) {
        campingRepository.deleteById(id);
        return findAll();

    }

    public Camping findCampingById(Long id) {
        Optional<Camping> campingOptional = campingRepository.findById(id);
        return campingDto.mapToCampingOptional(campingOptional);
    }
}
