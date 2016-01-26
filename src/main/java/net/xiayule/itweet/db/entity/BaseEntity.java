package net.xiayule.itweet.db.entity;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by tan on 16-1-21.
 *
 * 所有的实体类类都要以 Entity 结尾，并且继承 BaseEntity
 *
 * 继承该类，使得持久化时，会自动填写创建人、创建时间等信息
 *
 * @see net.xiayule.itweet.db.entity.GreetingEntity
 */
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public class BaseEntity implements Auditable<String, Long> {

    @Id
    @Column(name = "F_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "F_CREATED_BY")
    @CreatedBy
    private String createdBy;

    @Column(name = "F_CREATED_AT")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "F_LAST_MODIFIED_BY")
    @LastModifiedBy
    private String lastModifiedBy;

    @Column(name = "F_LAST_MODIFIED_AT")
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Version
    @Column(name = "F_VERSION")
    private Long version;

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(String s) {
        this.createdBy = s;
    }

    @Override
    public DateTime getCreatedDate() {
        return null == createdDate ? null : new DateTime(createdDate);
    }

    @Override
    public void setCreatedDate(DateTime dateTime) {
        this.createdDate = null == dateTime ? null : dateTime.toDate();
    }

    @Override
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    @Override
    public void setLastModifiedBy(String s) {
        this.lastModifiedBy = s;
    }

    @Override
    public DateTime getLastModifiedDate() {
        return null == lastModifiedDate ? null : new DateTime(lastModifiedDate);
    }

    @Override
    public void setLastModifiedDate(DateTime dateTime) {
        this.lastModifiedDate = null == dateTime ? null : dateTime.toDate();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return null == getId();
    }
}
