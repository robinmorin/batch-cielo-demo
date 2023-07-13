package com.example.batchcielodemo.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TABLE_INFO_PROCESS_BATCH")
public class InfoProcess {

    @Id
    @Column(name = "ID", nullable = false)
    @JsonAlias("idRecord")
    private Integer id;

    @Column(name = "NAME", nullable = false)
    @JsonAlias("nameInfo")
    private String name;

    @Column(name = "ADDRESS", nullable = false)
    @JsonAlias("addressInfo")
    private String address;

    @Column(name = "PHONE", nullable = false)
    @JsonAlias("phoneInfo")
    private String phone;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        InfoProcess that = (InfoProcess) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }
}
