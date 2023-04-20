package dev.paintilya.quebectaxcalculator.API;

import dev.paintilya.quebectaxcalculator.BLL.Control.QuebecTaxController;
import dev.paintilya.quebectaxcalculator.DAL.AlwaysDataSqlConnector;
import dev.paintilya.quebectaxcalculator.DAL.AlwaysDataSqlDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class QuebecTaxCalculatorApplication {

    @Bean
    @LoadBalanced
    public WebClient.Builder getWebClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() { return new RestTemplate(); }

    @Bean
    QuebecTaxController getQuebecTaxController() {
        return new QuebecTaxController(new AlwaysDataSqlDAO(new AlwaysDataSqlConnector()));
    }

    public static void main(String[] args) {
        SpringApplication.run(QuebecTaxCalculatorApplication.class, args);
    }

}