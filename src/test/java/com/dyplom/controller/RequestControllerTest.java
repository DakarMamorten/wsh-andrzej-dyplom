package com.dyplom.controller;

import com.dyplom.domain.Status;
import com.dyplom.domain.dto.RequestDTO;
import com.dyplom.service.RequestService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RequestController.class)
class RequestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private RequestService requestService;

    @Before()
    public void setup() {
        //Init MockMvc Object and build
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @WithMockUser("admin")
    void whenGetRequestListShouldAllowAccessForAdminUser() throws Exception {
        this.mockMvc
                .perform(get("/request/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("request/list"))
                .andExpect(model().attributeExists("requests"))
                .andExpect(model().attributeExists("user_requests"))
                .andExpect(model().attributeExists("carNumbers"));
    }

    @Test
    @WithMockUser("admin")
    void whenFindByIdThenReturnRequest() throws Exception {
        var request = new RequestDTO();
        request.setId(2L);
        request.setIdentifier("R00000002");
        request.setCarModel("WIND");
        request.setCarBrand("TOYOTA");
        request.setRegistrationNumber("AE");
        request.setCountryRegion("Ukraine");
        request.setVinNumber("123123WEf2123f");
        request.setStatus(Status.APPROVED);
        when(requestService.findById(2L)).thenReturn(request);

        this.mockMvc
                .perform(get("/request").param("id", "2"))
                .andExpect(status().isOk())
                .andExpect(view().name("request/request_info"))
                .andExpect(model().attributeExists("request"));
    }

    @Test
    @WithMockUser(value = "admin", roles = {"USER", "ADMINISTRATOR"})
    void whenAddRequestShouldAllowAccessForAdminUser() throws Exception {
        var body = """
                {
                    "carModel": "CL",
                    "carBrand": "ACURA",
                    "registrationNumber": "123123",
                    "countryRegion": "A",
                    "yearOfProduction": 2020,
                    "vinNumber": "R823123WEf2123f"
                }
                """;
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/request/add").with(csrf())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(body))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(value = "admin", roles = {"USER", "ADMINISTRATOR"})
    void whenApprovedRequestShouldAllowAccessForAdminUser() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/request/approve").with(csrf())
                                .param("requestId","2")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().is3xxRedirection());
    }

    @Test
    @WithMockUser(value = "admin", roles = {"USER", "ADMINISTRATOR"})
    void whenRejectRequestShouldAllowAccessForAdminUser() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/request/reject").with(csrf())
                                .param("requestId","2")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().is3xxRedirection());
    }


}
