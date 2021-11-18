package br.com.amadeus.order.bdd;


import br.com.amadeus.order.dto.request.OrderRequest;
import com.google.gson.Gson;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@CucumberContextConfiguration
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"},
        features = {"classpath:bdd"},
        glue = {"br.com.amadeus.order.bdd"})
public class RunCucumberTest {

    protected OrderRequest getOrderRequest() {
        return OrderRequest.builder()
                .orderCode(1L)
                .controlNumber(3L)
                .registrationDate(new Date())
                .name("PIZZA")
                .valor(23.5D)
                .quantity(5)
                .clientCode(10L)
                .build();
    }

    protected String getOrderRequestInJson() {
        Gson gson = new Gson();
        return gson.toJson(getOrderRequest());
    }
}
