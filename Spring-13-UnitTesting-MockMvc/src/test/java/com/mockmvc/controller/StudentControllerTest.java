package com.mockmvc.controller;

import com.mockmvc.entity.Student;
import com.mockmvc.service.StudentService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    void getStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "\"id\": null,\n" +
                        "\"firstName\": \"mike\",\n" +
                        "\"lastName\": \"smith\",\n" +
                        "\"age\": 20\n" +
                        "}"))
                .andReturn();
    }

    @Test
    void jsonAssert() throws JSONException {
        String actual = "{\n" +
                "\"id\": null,\n" +
                "\"firstName\": \"mike\",\n" +
                "\"lastName\": \"smith\",\n" +
                "\"age\": 20\n" +
                "}";
        String expected = "{\n" +
                "\"id\": null,\n" +
                "\"firstName\": \"mike\",\n" +
                "\"lastName\": \"smith\",\n" +
                "\"age\": 20\n" +
                "}";
        JSONAssert.assertEquals(expected, actual, false);
    }

    @Test
    void jsonAssert_withoutEscapeCharacters() throws JSONException {
        String actual = "{id: 0, firstName: mike, lastName: smith, age: 20}";
        String expected = "{id: 0, firstName: mike, lastName: smith}";
        JSONAssert.assertEquals(expected, actual, false);
    }

    @Test
    void getStudent_data() throws Exception {
        when(studentService.getStudentData()).thenReturn(Arrays.asList(
                new Student("tom","hanks",50),
                new Student("bill", "Sanders", 20)
        ));
        mockMvc.perform(MockMvcRequestBuilders.get("/studentData").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":null,\"firstName\":\"tom\",\"lastName\":\"hanks\",\"age\":50},{\"id\":null,\"firstName\":\"bill\",\"lastName\":\"Sanders\",\"age\":20}]"))
                .andReturn();
    }
}