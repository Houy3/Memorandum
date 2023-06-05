package os.memorandum.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import os.memorandum.models.base.LongIdEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)

@Entity
@Table(name = "tests")
public class TestEntity extends LongIdEntity {


    @Column(unique = true)
    private String testField;

    private LocalDateTime time;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "links",
            joinColumns= @JoinColumn(name="test_id"),
            inverseJoinColumns= @JoinColumn(name="test2_id")
    )
    @ToString.Exclude
    private Set<Test2Entity> testEntities;

}


