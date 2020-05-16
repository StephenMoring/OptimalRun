package com.exercise.optimalRun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.Configuration;
import io.swagger.client.api.AthletesApi;
import io.swagger.client.auth.OAuth;
import io.swagger.client.model.ActivityStats;
@SpringBootApplication
@RestController
public class OptimalRunApplication {


	public static void main(String[] args) {
		SpringApplication.run(OptimalRunApplication.class, args);
		
	}
	
	@GetMapping("/getMyStats")
	public String getMyStats() {
		ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure OAuth2 access token for authorization: strava_oauth
        OAuth strava_oauth = (OAuth) defaultClient.getAuthentication("strava_oauth");
        strava_oauth.setAccessToken("526bf160722caf6cb9db09c46e629a447b3047dc");

        AthletesApi apiInstance = new AthletesApi();
        int id = 54526789;
        try {
            ActivityStats result = apiInstance.getStats(id);
            return result.toString();
        } catch (ApiException e) {
        	e.printStackTrace();
            return "Exception when calling ActivitiesApi#getActivityById";
        }
	}
}
