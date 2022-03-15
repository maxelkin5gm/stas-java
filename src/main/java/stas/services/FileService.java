package stas.services;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;


@Service
public class FileService {

    public String readFile(String pathInResource) {
        try {
            var path = new ClassPathResource(pathInResource).getFile().toPath();
            return Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
