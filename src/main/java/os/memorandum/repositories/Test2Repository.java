package os.memorandum.repositories;

import os.memorandum.models.Test2Entity;
import os.memorandum.repositories.base.LongIdEntityJpaRepository;

public interface Test2Repository extends LongIdEntityJpaRepository<Test2Entity> {


    Test2Entity findTestEntityById(Long id);
}
