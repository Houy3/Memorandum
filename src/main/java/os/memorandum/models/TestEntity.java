package os.memorandum.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import os.memorandum.models.base.BaseEntity;

import java.time.LocalDateTime;


@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)

@Entity
@Table(name = "tests")
public class TestEntity extends BaseEntity {


    @Column(unique = true)
    private String testField;

    @Column(nullable = false)
    private String testField2;

    private LocalDateTime time;
    
}


