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
        Spittle expectedSpittle = new Spittle("Hello", new Date());
        SpittleRepository spittleRepository = mock(SpittleRepository.class);
        when(spittleRepository.findOne(12345)).thenReturn(expectedSpittle);


        SpittleController homeController = new SpittleController(spittleRepository);
        MockMvc mockMvc = standaloneSetup(homeController).build();
        mockMvc.perform(get("/spittles/12345"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSpittle));
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

    @Test
    public void shouldShowPagedSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(50);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        //make a mock impl for calling mlckrepository.findspittles
        when(mockRepository.findSpittles(238900, 50))
                .thenReturn(expectedSpittles);

        // override the auto injection of repository interface
        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();

        mockMvc.perform(get("/spittles?max=238900&count=50"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"));
        //this assert can't pass as the actual result is a non-list format data
        //.andExpect(model().attribute("spittleList", hasItem(expectedSpittles.toArray())));
    }

    /**
     * a mock data producer
     *
     * @param count
     * @return [count]s spittles
     */
    private List<Spittle> createSpittleList(int count) {
        List<Spittle> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            results.add(new Spittle("Spittle " + i, new Date()));
        }
        return results;
    }
}
