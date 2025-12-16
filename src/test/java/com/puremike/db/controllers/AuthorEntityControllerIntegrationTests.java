package com.puremike.db.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.puremike.db.TestDataJPAUtils;
import com.puremike.db.domain.AuthorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class AuthorEntityControllerIntegrationTests {

        private final MockMvc mockMvc;
        private final ObjectMapper objectMapper;

        @Autowired
        public AuthorEntityControllerIntegrationTests(MockMvc mockMvc, ObjectMapper objectMapper) {
                this.mockMvc = mockMvc;
                this.objectMapper = objectMapper;
        }

        @Test
        public void testThatCreateAuthorReturnsTheCorrectStatusCode() throws Exception {
                AuthorEntity testAuthor = TestDataJPAUtils.createTestAuthor();
                testAuthor.setId(null);
                String authorJson = objectMapper.writeValueAsString(testAuthor);

                mockMvc.perform(
                                MockMvcRequestBuilders.post("/authors")
                                                .content(authorJson)
                                                .contentType(MediaType.APPLICATION_JSON))
                                .andExpect(
                                                MockMvcResultMatchers.status().isCreated());
        }

        @Test
        public void testThatCreateAuthorReturnsTheSavedAuthor() throws Exception {
                AuthorEntity testAuthorA = TestDataJPAUtils.createTestAuthorA();
                testAuthorA.setId(null);

                String authorJson = objectMapper.writeValueAsString(testAuthorA);

                mockMvc.perform(
                                MockMvcRequestBuilders.post("/authors")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content(authorJson))
                                .andExpect(
                                                MockMvcResultMatchers.jsonPath("$.id").isNumber())
                                .andExpect(
                                                MockMvcResultMatchers.jsonPath("$.name").value("Don E."))
                                .andExpect(
                                                MockMvcResultMatchers.jsonPath("$.age").value(30));
        }
}
