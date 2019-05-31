package com.neo;

import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisXmlApplicationTests {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void contextLoads() {
        System.out.println("hello world");
    }

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void test() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/test")).andReturn();
        int status = result.getResponse().getStatus();
        String contentAsString = result.getResponse().getContentAsString();
        JSONObject jsonobject = JSONObject.fromObject(contentAsString);
        PageInfo user = (PageInfo) JSONObject.toBean(jsonobject, PageInfo.class);
    }


}
