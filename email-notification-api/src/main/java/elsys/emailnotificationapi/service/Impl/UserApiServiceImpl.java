package elsys.emailnotificationapi.service.Impl;

import elsys.emailnotificationapi.api.user_api.UserApiEndpoints;
import elsys.emailnotificationapi.service.UserApiService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserApiServiceImpl implements UserApiService {
    private final WebClient webClient;

    public UserApiServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @Override
    public String getUserEmail(String userUuid) {
        String endpoint = UserApiEndpoints.getUserEmail(userUuid);

        return webClient
            .get()
            .uri(endpoint)
            .retrieve()
            .bodyToMono(String.class)
            .block();
    }
}
