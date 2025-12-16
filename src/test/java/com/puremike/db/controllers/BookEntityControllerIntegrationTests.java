package com.puremike.db.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.puremike.db.TestDataJPAUtils;
import com.puremike.db.domain.AuthorEntity;
import com.puremike.db.repositories.AuthorRepository;

import java.util.Map;

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
public class BookEntityControllerIntegrationTests {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookEntityControllerIntegrationTests(MockMvc mockMvc, ObjectMapper objectMapper,
            AuthorRepository authorRepository) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
        this.authorRepository = authorRepository;
    }

    @Test
    public void testThatCreateBookReturnsCorrectStatusCode() throws Exception {

        // Create a persisted Author
        AuthorEntity testAuthor = authorRepository.save(TestDataJPAUtils.createTestAuthor());

        Map<String, Object> bookMap = TestDataJPAUtils.createMapTestBook(testAuthor);

        String bookJson = objectMapper.writeValueAsString(bookMap);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/books")
                        .content(bookJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        MockMvcResultMatchers.status().isCreated());

    }

    @Test
    public void testThatCreateBookReturnsTheSavedBook() throws Exception {

        // Create a persisted Author
        AuthorEntity testAuthor = authorRepository.save(TestDataJPAUtils.createTestAuthor());

        Map<String, Object> bookMap = TestDataJPAUtils.createMapTestBook(testAuthor);

        String bookJson = objectMapper.writeValueAsString(bookMap);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/books")
                        .content(bookJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.isbn").value("4425-5563"))
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.title").value("First Book"))
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.author_id").value(testAuthor.getId()));

    }
}
