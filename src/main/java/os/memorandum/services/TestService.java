package os.memorandum.services;

import jakarta.validation.Valid;
import os.memorandum.dto.test.NewTestDto;
import os.memorandum.dto.test.TestDto;

public interface TestService {

    TestDto add(@Valid NewTestDto dto);
}
