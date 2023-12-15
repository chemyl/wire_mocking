package integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@WireMockTest(httpPort = 8080)
public class MockTest {

    // create Body Json by String block
    String bodyBlock = """ 
            {
            id: "123",
            username:"James",
            currency:"USD",
            company: "IBM"
            }""";

    // create Body Json by jackson ObjectMapper
    private static final ObjectMapper om = new ObjectMapper();

    // First mock service
    @RegisterExtension
    WireMockExtension userDataMock = new WireMockExtension.Builder()
            .options(WireMockConfiguration.options()
                    .port(8080))
            .build();

    // Second mock service
    @RegisterExtension
    WireMockExtension standDataMock = new WireMockExtension.Builder()
            .options(WireMockConfiguration.options()
                    .port(8085))
            .build();

    // Set Mock service into each test context
    @BeforeEach
    void setUp() {
        userDataMock.stubFor(
                get(urlPathEqualTo("/client"))      //ендпоинт
                        .withQueryParam("username", matching(".*"))  // параметр username с любом стринговым значением
                        .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-type", "application/json")
                                .withBody(bodyBlock)
                        ));
    }


    @Test
    @DisplayName("Sample 1")
    @Tag("tag")
    public void mockingTest() {
        // Test use api service from special ports and endpoint

    }

    @Test
    @DisplayName("Sample 2")
    @Tag("tag")
    public void mockingTest2() {
        // Test use api service from special ports and endpoint

    }
}
