package com.letras.pfc_letras.services;

public interface MailChimpService {

    void registerListClient(String email);

    void sendWelcomeMail(String email);
}
