package os.memorandum.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import os.memorandum.models.base.BaseEntity;


@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)

@Entity
@Table(name = "m2o_tests")
public class M2OEntity extends BaseEntity {


    private String testField;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TestEntity testEntity;

}


