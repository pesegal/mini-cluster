package mini.cluster.frontend.service;

import mini.cluster.frontend.config.ServiceDependencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CountService {

    // Endpoint representation
    private static String COUNT = "/count";

    // Access to configuration properties host and port
    private String counterServiceUrl;
    private RestTemplate restTemplate = new RestTemplate();


    @Autowired
    public CountService(ServiceDependencies serviceDependencies) {
        this.counterServiceUrl = serviceDependencies.getCount().getHost() + ":"
                + serviceDependencies.getCount().getPort();
    }

    /**
     * Queries the count service for the current count.
     *
     * @return Integer of the current count.
     */
    public Integer getCount() {
        var responseEntity = restTemplate.getForEntity(counterServiceUrl + COUNT, Integer.class);
        return responseEntity.getBody();
    }

    /**
     * PUTs a new number as the current value of the count service.
     *
     * @return
     */
    public void setCount(int value) {
        var uriBuilder = UriComponentsBuilder.fromUriString(counterServiceUrl + COUNT)
                .queryParam("setCount", value);
        restTemplate.put(uriBuilder.toUriString(), null);
    }

}
