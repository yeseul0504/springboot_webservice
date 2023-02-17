package com.yeseul.book.springboot.domain.posts;

import com.yeseul.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor  //기본생성자자동추가
@Entity
public class Posts extends BaseTimeEntity {

    @Id   //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment됨
    private Long id;
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    //기본적으론 생성자를 통해 최종값을 채운후 insert / 변경은 해당 이벤트에 맞는 public 메소드를 호출
    //이 책에선 builder 클래스를 사용 (생성시점에 값을 채워주는것은 같다) but 생성자는 지금채워야 할 필드를
    //정확하게 지정할수 없다.
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
