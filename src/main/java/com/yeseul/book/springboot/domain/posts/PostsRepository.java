package com.yeseul.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    //Dao 라 불리는 DB Layer 접근자 이다.
    //JPA 에서는 Repository 라고 부르며 인터페이스로 생성한다.
    //JpaRepository<Entity 클라스, PK타입> 으로 상속하면 기본 CRUD메소드가 자동으로 생성된다.
    //Entity클래스와 기본 Entity Repository 는 함께 위치해야 한다.
    // (나중에 도메인이 많아지면 domain 패키지안에 함께 관리
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
