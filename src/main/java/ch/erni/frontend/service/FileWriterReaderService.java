package ch.erni.frontend.service;

import ch.erni.frontend.model.Ernian;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

public interface FileWriterReaderService {


    Map<UUID, Ernian> readErnians();

    void writeErnians(Ernian ernian);
}
