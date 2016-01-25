package net.xiayule.itweet.db.entity;

import javax.persistence.*;


/**
 * Created by zhiyou on 16-1-25.
 */
@Entity
@Table(name = "publish")
public class Publish {
    @Id
    @Column(name = "P_id",updatable=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "P_content")
    @Basic(optional = false)
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Publish(String content) {
        this.content = content;
    }

    public Publish() {
        super();
    }
}
