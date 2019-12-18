package mini.cluster.frontend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "service")
public class ServiceDependencies {

    private CountServiceConfig count;

    public CountServiceConfig getCount() {
        return count;
    }

    public void setCount(CountServiceConfig count) {
        this.count = count;
    }

    public static class CountServiceConfig {
        private String host;
        private int port;

        public CountServiceConfig() {
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }
    }
}
