package springinaction.ch04.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import springinaction.ch04.Spitter;
import springinaction.ch04.data.SpitterController;
import springinaction.ch04.data.SpitterRepository;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

public class SpittlerControllerTest {


    @Test
    public void spitterRegTest() throws Exception {
        MockMvc mockMvc = standaloneSetup(new SpitterController()).build();
        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterController spitterController = new SpitterController();
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        Spitter unsaved = new Spitter();
        unsaved.setFirstName("Jack");
        unsaved.setLastName("Ma");
        unsaved.setUsername("fuck");
        unsaved.setPassword("xxxxx");

        Spitter saved = ((Spitter) unsaved.clone());
        saved.setId(24L);
        when(mockRepository.save(unsaved)).thenReturn(saved);

        MockMvc mockMvc = standaloneSetup(spitterController).build();
        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Ma")
                .param("username", "fuck")
                .param("password", "xxxxx")).andExpect(redirectedUrl("/spitter/jbauer"));

        verify(mockRepository, atLeastOnce()).save(unsaved);
    }
}
