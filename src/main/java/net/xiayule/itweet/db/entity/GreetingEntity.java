package net.xiayule.itweet.db.entity;

import javax.persistence.*;

/**
 * Created by tan on 16-1-18.
 */
@Entity
public class GreetingEntity {

    @Id
    @Column(name = "F_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "F_NAME")
    private String name;


    public GreetingEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
