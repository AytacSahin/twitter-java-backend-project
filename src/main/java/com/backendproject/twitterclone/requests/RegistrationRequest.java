package com.backendproject.twitterclone.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {

    @NotNull
    @NotBlank
    @Size(min = 3, message = "İsim en az üç karakterden oluşmalı.")
    private String name;

    @NotNull
    @NotBlank
    private String phoneNumber;

    @NotNull
    @NotBlank
    @Email(message ="Lütfen geçerli bir mail adresi giriniz.")
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 3, message = "Nick en az üç karakterden oluşmalı.")
    private String nick;

    @NotNull
    @NotBlank
    @Size(min = 8, message = "Şifre en az 8 karakterli olmalı.")
    private String password;

}
