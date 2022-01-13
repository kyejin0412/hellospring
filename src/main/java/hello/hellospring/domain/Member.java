package hello.hellospring.domain;

public class Member {

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
