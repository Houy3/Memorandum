package os.memorandum.services;

import os.memorandum.dto.test.NewTestDto;
import os.memorandum.dto.test.TestDto;

public interface TestService {

    TestDto add(NewTestDto dto);
}
