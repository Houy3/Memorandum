package os.memorandum.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import os.memorandum.models.base.LongIdEntity;


@SuperBuilder
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor

@Entity
@Table
public class TestEntity extends LongIdEntity {


    private String testField;

}


