package os.memorandum.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import os.memorandum.models.base.BaseEntity;

import java.util.Set;


@SuperBuilder
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor

@Entity
@Table(name = "m2m_tests")
public class M2MEntity extends BaseEntity {


    private String someData;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "m2m",
            joinColumns= @JoinColumn(name="m2m_id"),
            inverseJoinColumns= @JoinColumn(name="test_id")
    )
    @ToString.Exclude
    private Set<TestEntity> testEntities;

}


