package openidproject.openiddemo.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserDataService {

    public Map<String, Object> getUserData() {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) SecurityContextHolder
                .getContext()
                .getAuthentication();

        return token
                .getPrincipal()
                .getAttributes();
    }
}
