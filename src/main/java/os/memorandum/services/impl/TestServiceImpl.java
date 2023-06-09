package os.memorandum.services.impl;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import os.memorandum.dto.test.NewTestDto;
import os.memorandum.dto.test.TestDto;
import os.memorandum.models.TestEntity;
import os.memorandum.repositories.TestRepository;
import os.memorandum.services.TestService;
import os.memorandum.services.check.UniqueCheck;
import os.memorandum.services.check.core.Check;
import os.memorandum.services.check.core.CheckService;

import java.util.List;

@Service
public class TestServiceImpl extends CheckService<TestEntity, TestRepository> implements TestService {


    protected TestServiceImpl(TestRepository repository, ConversionService conversionService) {
        super(repository, conversionService);
    }



    @Override
    public TestDto add(NewTestDto dto) {
        TestEntity testEntity = converter.convert(dto, TestEntity.class);
        save(testEntity);
        return converter.convert(testEntity, TestDto.class);
    }

    @Override
    protected List<Check<TestEntity>> registerChecks(List<Check<TestEntity>> checks) {
        checks.add(new UniqueCheck<>(repository, "testField"));
        return checks;
    }


}
