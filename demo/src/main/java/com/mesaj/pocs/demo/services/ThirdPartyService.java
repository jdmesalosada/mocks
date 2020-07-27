package com.mesaj.pocs.demo.services;

import com.mesaj.pocs.demo.exceptions.UserNotFoundException;
import com.mesaj.pocs.demo.model.thirdparty.ThirdPartyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ThirdPartyService {

    @Value("${third.party.url}")
    private String url;

    @Autowired
    RestTemplate restTemplate;

    public ThirdPartyUser getThirdPartyUser(Long id) {
        ResponseEntity<ThirdPartyUser> resp = null;

        try {

            resp = restTemplate.getForEntity(url + "/users/" + id,
                    ThirdPartyUser.class);
        } catch (Exception ex) {

            throw new UserNotFoundException(id);
        }

        return resp.getStatusCode() == HttpStatus.OK ? resp.getBody() : null;
    }

}
