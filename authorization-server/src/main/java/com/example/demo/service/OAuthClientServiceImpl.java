package com.example.demo.service;

import com.example.demo.repository.OAuthClientRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OAuthClientServiceImpl {
    @Autowired
    private OAuthClientRepository oAuthClientRepository;

}
