package os.memorandum.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import os.memorandum.models.base.LongIdEntity;


@SuperBuilder
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor

@Entity
@Table(name = "tests2")
public class Test2Entity extends LongIdEntity {


    private String test2Field;

}


