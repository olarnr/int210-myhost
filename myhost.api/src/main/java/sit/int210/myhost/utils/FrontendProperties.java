package sit.int210.myhost.utils;

import java.security.PublicKey;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix="frontend")
public class FrontendProperties {
    private String url;
    private int port;
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }
}
