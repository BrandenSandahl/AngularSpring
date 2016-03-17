package com.theironyard;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.theironyard.entities.User;
import com.theironyard.services.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AngularSpringApplication.class)
@WebAppConfiguration
public class AngularSpringApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	WebApplicationContext wap;

	MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wap).build();
    }

    @Test
    public void addUser() throws Exception {
        User user = new User();
        user.setUsername("Alice");
        user.setEmail("alice@alice.com");
        user.setAddress("420 E");

        //this if for creating JSON strings
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/user")
                .content(json)
                .contentType("application/json")
        );


        Assert.assertTrue(userRepository.count() == 1);
    }

    @Test
    public void deleteUser() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/user/1")
        );

        Assert.assertTrue(userRepository.count() == 0);
    }


}
