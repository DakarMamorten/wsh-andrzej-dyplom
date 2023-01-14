//package com.dyplom.controller;
//
//import com.dyplom.wsh.AbstractIntegrationTest;
//import org.assertj.core.api.Assertions;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
//
//@ContextConfiguration
//class RequestRestControllerTest extends AbstractIntegrationTest {
//
//    @Autowired
//    RequestRestController requestRestController;
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate = new TestRestTemplate("admin","gt64");
//
//    @Autowired
//    private WebApplicationContext context;
//    private MockMvc mvc;
//
//    @Before
//    public void setup() {
//        mvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .apply(springSecurity())
//                .build();
//    }
//
//    @Test
//    void index() {
//        // we test that our controller is not null
//        Assertions.assertThat(requestRestController).isNotNull();
//    }
//    @Test
//    @WithMockUser("admin")
//    void list() {
//        Assertions.assertThat(restTemplate
//                .getForObject("http://localhost:" + port + "/api/v1/request/list/all", String.class))
//                .contains("APPROVED");
//    }
//
////    @Test
////    void findById() {
////    }
////
////    @Test
////    void approve() {
////    }
////
////    @Test
////    void reject() {
////    }
////
////    @Test
////    void add() {
////    }
//}