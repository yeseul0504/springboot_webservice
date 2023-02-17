package com.yeseul.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        //별도 외부의 WAS를 두지 않고 애플리케이션을 실행할때 내부에서 WAS를 실행
        //항상 서버에 톰캣을 설치할 필요가 없고 JAR파일로 실행하면된다.
        //언제 어디서나 같은 환경에서 스프링부트를 배포할수 있기 때문에 내장WAS사용을 권장

    }
}
