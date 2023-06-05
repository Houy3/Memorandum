package os.memorandum.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import os.memorandum.dto.test.NewTestDto;
import os.memorandum.dto.test.TestDto;
import os.memorandum.repositories.TestRepository;
import os.memorandum.services.TestService;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository repository;


    @Override
    public TestDto add(NewTestDto dto) {
        return null;
    }
}
