package com.yeseul.book.springboot.web;
import com.yeseul.book.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //SpringRunner라는 실행자와 Junit 사이의 연결자 역할
@WebMvcTest(controllers =  HelloController.class)
@MockBean(JpaMetamodelMappingContext.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;  //web Api 를 테스트할때 사용

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    //테스트통과 x
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                .param("name", name) //API 테스트할때 사용될 요청 파라미터를 설정.단, 스트링만 허용
                                .param("amount", String.valueOf(amount)))//그래서 숫자,날짜 등을 등록할 때는 문자열로 변경해야만 가능
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))  //JSON 응답값을 필드별로 검증할수 있는 메소드
                .andExpect(jsonPath("$.amount", is(amount))); //$를 기준으로 필드명 명시
    }
}