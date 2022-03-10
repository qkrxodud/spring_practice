package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {

    @Id //PK를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 된다.
    Long id;
    String name;

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
