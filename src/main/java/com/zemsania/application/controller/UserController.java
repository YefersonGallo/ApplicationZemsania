package com.zemsania.application.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    private ArrayList<User> getUsers(){
        JsonParser parser = new JsonParser();
        String file = "";
        ArrayList<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/zemsania/application/persistence/users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                file += line;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        JsonArray usersJSON = parser.parse(file).getAsJsonArray();
        for (JsonElement obj : usersJSON) {
            JsonObject gsonObj = obj.getAsJsonObject();
            String user = gsonObj.get("user").getAsString();
            String password = gsonObj.get("password").getAsString();
            users.add(new User(user, password));
        }

        return users;
    }

    @PostMapping("user")
    public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
        User user = new User();
        for (User aux: getUsers()) {
            if(aux.getUser().equals(username) && aux.getPwd().equals(pwd)){
                String token = getJWTToken(username);
                user.setUser(username);
                user.setToken(token);
                logger.debug(username + " Logueo exitoso");
            }
        }
        if(user.getToken() == null){logger.info(username + " Datos incorrectos en el logueo");}
        return user;
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.
                commaSeparatedStringToAuthorityList("ROLE_USER");
        String token = Jwts
                .builder()
                .setId("zemsaniaTest")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}