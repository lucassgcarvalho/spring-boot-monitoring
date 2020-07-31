package br.com.forum.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EncryptUtils {

    private PasswordEncoder passwordEncoder;

    public EncryptUtils(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = (passwordEncoder == null) ? new BCryptPasswordEncoder() : passwordEncoder;
    }

    public String encryptPassword(String password) {
        return this.passwordEncoder.encode(password);
    }
}

