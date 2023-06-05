package os.memorandum.repositories;

import os.memorandum.models.Test3Entity;
import os.memorandum.repositories.base.LongIdEntityJpaRepository;

public interface Test3Repository extends LongIdEntityJpaRepository<Test3Entity> {


    Test3Entity findTestEntityById(Long id);
}
