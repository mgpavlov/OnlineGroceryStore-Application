package org.softuni.onlinegrocery.configuration;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

import static org.softuni.onlinegrocery.util.constants.AppConstants.*;

@Configuration
public class ApplicationCloudConfiguration {

    @Value("${cloudinary.cloud-name}")
    private String cloudApiName;
    @Value("${cloudinary.api-key}")
    private String cloudApiKey;
    @Value("${cloudinary.api-secret}")
    private String cloudApiSecret;

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(new HashMap<String, Object>(){{
            put(CLOUD_NAME, cloudApiName);
            put(API_KEY, cloudApiKey);
            put(API_SECRET, cloudApiSecret);
        }});
    }
}
