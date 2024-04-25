package elsys.emailnotificationapi.service.Impl;

import elsys.emailnotificationapi.api.property_api.PropertyApiEndpoints;
import elsys.emailnotificationapi.service.PropertyApiService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PropertyApiServiceImpl implements PropertyApiService {
    private final WebClient webClient;

    public PropertyApiServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public String getOwnerUuidByPropertyUuid(String propertyUuid) {
        String endpoint = PropertyApiEndpoints.getOwnerUuidByPropertyUuid(propertyUuid);

        return webClient.get()
                .uri(endpoint)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
