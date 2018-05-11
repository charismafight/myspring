package springinaction.ch04.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import springinaction.ch04.Spittle;
import springinaction.ch04.data.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception {
        HomeController homeController = new HomeController();
        MockMvc mockMvc = standaloneSetup(homeController).build();
        //Assert.assertEquals("home", homeController.home());
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }

    @Test
    public void testSpittles() throws Exception {
        HomeController homeController = new HomeController();
        MockMvc mockMvc = standaloneSetup(homeController).build();
        mockMvc.perform(get("/list")).andExpect(view().name("spittles"));
    }

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);

        SpittleController spittleController = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(spittleController).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();

        mockMvc.perform(get("/spittles")).andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            results.add(new Spittle("Spittle " + i, new Date()));
        }
        return results;
    }
}
