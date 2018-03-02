package ch.erni.frontend.controller;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import ch.erni.frontend.service.FileWriterReaderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "logging.level.org.springframework.web=DEBUG")
@AutoConfigureMockMvc
public class ErnianFormControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @Mock
    FileWriterReaderService fileWriterReaderService;
    @InjectMocks
    ErnianFormController ernianFormController = new ErnianFormController(fileWriterReaderService);


    @Test
    public void rendersForm() throws Exception {
        mockMvc.perform(get("/ernian"))
                .andExpect(content().string(containsString("Form")));
    }


    @Test
    public void submitsForm() throws Exception {
        mockMvc.perform(post("/ernian")
                .param("firstName", "Urs")
                .param("lastName", "Oberhaensli")
                .param("country", "CH")
                .param("town", "Basel")
                .param("zip", "5634")
                .param("street", "BernerStrasse 11"))
                .andExpect(content().string(containsString("Result")))
                .andExpect(content().string(containsString("firstName: Urs")))
                .andExpect(content().string(containsString("lastName: Oberhaensli")))
                .andExpect(content().string(containsString("country: ch")))
                .andExpect(content().string(containsString("town: Basel")))
                .andExpect(content().string(containsString("zip: 5634")))
                .andExpect(content().string(containsString("street: BernerStrasse 11")));
    }


}

