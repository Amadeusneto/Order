package br.com.amadeus.order.bdd.services;

import br.com.amadeus.order.bdd.RunCucumberTest;
import br.com.amadeus.order.dto.request.OrderRequest;
import br.com.amadeus.order.dto.request.ProductRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CreateOrderSteps extends RunCucumberTest {
    @Autowired
    private MockMvc mvc;

    private OrderRequest orderRequest;
    private ProductRequest productRequest;
    ResultActions result;

    @Given("I have a valid order")
    public void prepareOrder() throws Exception {
        orderRequest = getOrderRequest();
        productRequest = getProductRequest();
    }

    @When("I call service to save the new order")
    public void sendInformationOrder() throws Exception {
        result = mvc.perform(post("/v1/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(getOrderRequestInJson()));
    }

    @Then("I receive the code 201")
    public void receivedResponse() throws Exception {
        result.andDo(print())
                .andExpect(status().isCreated());
    }


}
