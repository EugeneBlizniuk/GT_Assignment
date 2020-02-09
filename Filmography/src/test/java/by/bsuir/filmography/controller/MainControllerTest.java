package by.bsuir.filmography.controller;

import by.bsuir.filmography.config.WebConfig;
import by.bsuir.filmography.conroller.MainController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
public class MainControllerTest {
    @Autowired
    private MainController mainController;
    @Autowired
    protected WebApplicationContext context;
    private MockMvc mockMvc;
    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.context);
        this.mockMvc = builder.build();
    }
    @Test
    public void welcomePageRequestShouldReturnOk() throws Exception{
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/");
        this.mockMvc.perform(builder).andExpect(ok);
    }
    @Test
    public void showAllInformationShouldBeOk() throws Exception{
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/show-all-tables");
        this.mockMvc.perform(builder).andExpect(ok);
    }
    @Test
    public void searchingPageShouldBeOk() throws Exception{
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/searching");
        this.mockMvc.perform(builder).andExpect(ok);
    }
    @Test
    public void mainControllerShouldNotBeNull() {
        Assert.assertNotNull(mainController);
    }
}
