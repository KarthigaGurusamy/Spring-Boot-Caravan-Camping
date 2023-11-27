package com.restapi.response;


import com.restapi.request.UserDetailsRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDetailsResponse {

    List<UserDetailsRequest> userDetailsRequestList = new ArrayList<>();
}
