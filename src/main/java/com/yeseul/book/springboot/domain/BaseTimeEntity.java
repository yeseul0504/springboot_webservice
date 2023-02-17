package com.yeseul.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA 엔티티 클래스들이 baseTimeEntity를 상속하면 필드들도 칼럼으로 인식하게 한다.
@EntityListeners(AuditingEntityListener.class) //baseTimeEntity클래스에 Ayditing클래스 기능 포함
public abstract class BaseTimeEntity {
    /*모든 엔티티의 상위 클래스 아래 필드들을 관리  */
    @CreatedDate //entity가 생성되어 저장될때 시간을 자동저장
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
