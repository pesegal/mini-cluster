package mini.cluster.countservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CountApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountApplication.class, args);
	}

}
