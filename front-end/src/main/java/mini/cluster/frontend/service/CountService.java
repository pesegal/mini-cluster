package mini.cluster.frontend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.naming.ServiceUnavailableException;
import java.net.URI;
import java.util.Optional;

@Service
public class CountService {

    Logger logger = LoggerFactory.getLogger(CountService.class);

    // Service Representation
    private static String COUNT_SERVICE_ID = "count-service";
    // Endpoint representation
    private static String COUNT = "/count";

    // Access to configuration properties host and port
    private RestTemplate restTemplate = new RestTemplate();
    private DiscoveryClient discoveryClient;


    @Autowired
    public CountService(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }


    public Optional<URI> serviceURL() {
        return discoveryClient.getInstances(COUNT_SERVICE_ID)
                .stream()
                .map(ServiceInstance::getUri)
                .findFirst();
    }

    /**
     * Queries the count service for the current count.
     *
     * @return Integer of the current count.
     */
    public Integer getCount() throws RestClientException, ServiceUnavailableException {
        var service = serviceURL().map(s -> s.resolve(COUNT)).orElseThrow(() -> generateException("GET", COUNT));
        logger.debug(service.toString());
        var responseEntity = restTemplate.getForEntity(service, Integer.class);
        return responseEntity.getBody();
    }

    /**
     * PUTs a new number as the current value of the count service.
     */
    public void setCount(int value) throws RestClientException, ServiceUnavailableException {
        var service = serviceURL().map(s -> s.resolve(COUNT)).orElseThrow(() -> generateException("GET", COUNT));
        var uriBuilder = UriComponentsBuilder.fromUri(service)
                .queryParam("setCount", value);
        logger.debug(service.toString());
        restTemplate.put(uriBuilder.toUriString(), null);
    }

    private ServiceUnavailableException generateException(String method, String path) {
        return new ServiceUnavailableException("Unable to resolve " + method + " " + COUNT_SERVICE_ID + path);
    }

}
