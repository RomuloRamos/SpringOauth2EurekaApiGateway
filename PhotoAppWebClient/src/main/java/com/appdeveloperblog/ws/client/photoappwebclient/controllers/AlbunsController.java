package com.appdeveloperblog.ws.client.photoappwebclient.controllers;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.appdeveloperblog.ws.client.photoappwebclient.response.AlbunsRest;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class AlbunsController {
    
    @Autowired
    OAuth2AuthorizedClientService oauth2ClientService;
    // @Autowired
    // RestTemplate restTemplate;

    @Autowired
    WebClient webClient;

    @GetMapping("/albuns")
    public String getAlbuns(Model model, @AuthenticationPrincipal OidcUser principal) {

        // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;

        // OAuth2AuthorizedClient oauth2Client = oauth2ClientService.loadAuthorizedClient(oauthToken.getAuthorizedClientRegistrationId(), 
        // oauthToken.getName());

        // String jwtAccessToken = oauth2Client.getAccessToken().getTokenValue();
        // System.out.println("AccessToken: "+jwtAccessToken);

        // System.out.println("Principal: "+principal);
        // OidcIdToken idToken = principal.getIdToken();
        // String strIdToken = idToken.getTokenValue();
        // System.out.println("idTokenValue = "+strIdToken);

        String url = "http://localhost:8082/albuns"; //Route from Api Gateway
        // HttpHeaders headers = new HttpHeaders();
        // headers.add("Authorization", "Bearer "+jwtAccessToken);

        // HttpEntity<List<AlbunsRest>> entity = new HttpEntity<>(headers);

        // ResponseEntity<List<AlbunsRest>> responseEntity =  restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<AlbunsRest>>() {});
        // List<AlbunsRest> albuns = responseEntity.getBody();
        List<AlbunsRest> albuns = webClient.get()
            .uri(url)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<List<AlbunsRest>>(){})
            .block();
        model.addAttribute("albuns", albuns);

        return "albuns";//Name of html file that should be called
    }
}
