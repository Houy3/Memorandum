package os.memorandum.repositories;

import os.memorandum.models.TestEntity;
import os.memorandum.repositories.base.LongIdEntityJpaRepository;

public interface TestRepository extends LongIdEntityJpaRepository<TestEntity> {


    TestEntity findTestEntityById(Long id);

}
