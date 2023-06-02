package os.memorandum.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import os.memorandum.repositories.TestRepository;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository repository;

}
