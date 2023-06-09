package os.memorandum.repositories;

import os.memorandum.models.TestEntity;
import os.memorandum.repositories.base.BaseJpaRepository;

public interface TestRepository extends BaseJpaRepository<TestEntity> {


    TestEntity findTestEntityById(Long id);

}
