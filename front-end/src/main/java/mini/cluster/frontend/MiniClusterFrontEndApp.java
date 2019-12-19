package mini.cluster.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MiniClusterFrontEndApp {
	public static void main(String[] args) {
		SpringApplication.run(MiniClusterFrontEndApp.class, args);
	}

}
