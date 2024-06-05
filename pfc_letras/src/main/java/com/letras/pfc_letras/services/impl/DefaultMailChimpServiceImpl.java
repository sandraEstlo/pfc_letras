package com.letras.pfc_letras.services.impl;

import com.letras.pfc_letras.services.MailChimpService;
import org.springframework.stereotype.Service;

@Service
public class DefaultMailChimpServiceImpl implements MailChimpService {

    private static final String API_KEY = "943b28e09c76817315b8d97977b0398-us22";
    private static final String TEMPLATE_ID = "3440";
    private static final String LIST_ID = "3c4565dcdf";

    @Override
    public void registerListClient(String email) {

    }

    @Override
    public void sendWelcomeMail(String email) {

    }
}
