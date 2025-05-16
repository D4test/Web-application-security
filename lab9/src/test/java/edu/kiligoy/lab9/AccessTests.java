package edu.kiligoy.lab9;

/*
@author   Dtest
@project   lab7
@class  AccessTests
@version  1.0.0
@since 30.04.2025 - 23.32
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class AccessTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void beforeAll() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    // Anonymous user tests
    @Test
    @WithAnonymousUser
    public void whenAnonymThenStatusUnauthorized() throws Exception {
        mockMvc.perform(get("/api/v1/items"))
                .andExpect(status().isUnauthorized());
    }
    

    @Test
    @WithAnonymousUser
    public void whenAnonymAccessProtectedEndpointsThenUnauthorized() throws Exception {
        mockMvc.perform(get("/api/v1/items/hello/user"))
                .andExpect(status().isUnauthorized());

        mockMvc.perform(get("/api/v1/items/hello/admin"))
                .andExpect(status().isUnauthorized());

        mockMvc.perform(get("/api/v1/items/hello/unknown"))
                .andExpect(status().isUnauthorized());

        mockMvc.perform(get("/api/v1/items/hello/superadmin"))
                .andExpect(status().isUnauthorized());
    }

    // Admin user tests
    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAdminAccessAdminEndpointThenOk() throws Exception {
        mockMvc.perform(get("/api/v1/items/hello/admin"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAdminAccessUserEndpointThenForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/items/hello/user"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAdminAccessUnknownEndpointThenOk() throws Exception {
        mockMvc.perform(get("/api/v1/items/hello/unknown"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAdminAccessSuperAdminEndpointThenForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/items/hello/superadmin"))
                .andExpect(status().isForbidden());
    }

    // User role tests
    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void whenUserAccessUserEndpointThenOk() throws Exception {
        mockMvc.perform(get("/api/v1/items/hello/user"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void whenUserAccessAdminEndpointThenForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/items/hello/admin"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void whenUserAccessUnknownEndpointThenOk() throws Exception {
        mockMvc.perform(get("/api/v1/items/hello/unknown"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void whenUserAccessSuperAdminEndpointThenForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/items/hello/superadmin"))
                .andExpect(status().isForbidden());
    }

    // SuperAdmin role tests
    @Test
    @WithMockUser(username = "superadmin", password = "superadmin", roles = {"SUPERADMIN"})
    void whenSuperAdminAccessAllEndpointsThenOk() throws Exception {
        mockMvc.perform(get("/api/v1/items/hello/user"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/v1/items/hello/admin"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/v1/items/hello/unknown"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/v1/items/hello/superadmin"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAdminAccessCrudEndpointsThenOk() throws Exception {
        // Note: These might need to be adjusted based on your actual security configuration
        // Currently, the controller doesn't show security annotations for CRUD methods
        mockMvc.perform(get("/api/v1/items"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/v1/items/1"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "superadmin", password = "superadmin", roles = {"SUPERADMIN"})
    void whenSuperAdminAccessCrudEndpointsThenOk() throws Exception {
        mockMvc.perform(get("/api/v1/items"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/v1/items/1"))
                .andExpect(status().isOk());
    }
}