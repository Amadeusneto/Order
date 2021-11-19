package br.com.amadeus.order.bdd;


import br.com.amadeus.order.dto.request.OrderRequest;
import br.com.amadeus.order.dto.request.ProductRequest;
import com.google.gson.Gson;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

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
                .controlNumber(87L)
                .registrationDate(LocalDate.now())
                .quantity(5)
                .clientCode(10L)
                .build();
    }

    protected ProductRequest getProductRequest() {
        return ProductRequest.builder()
                .name("PIZZA")
                .value(23.5D)
                .build();
    }

    protected String getOrderRequestInJson() {
        Gson gson = new Gson();
        return gson.toJson(getOrderRequest());
    }
}
