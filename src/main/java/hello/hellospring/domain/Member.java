package hello.hellospring.domain;

import javax.persistence.*;

@Entity
//-->jpa가 관리하는 entity가 됨
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    디비에 값을 넣으면 디비가 아이디를 자동으로 생성해줌 -> identity 전략
    private Long id;
    // 데이터를 구분하기 위해서 시스템이 정하는 이름. 고객이 정하지 않음
    private String name;

    //getter and setter 단축기 alt+insert
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}