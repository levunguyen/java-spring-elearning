package elearning.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Component
public class FileSupport {

    @Value("${videos.location}")
    String videosSavePath;

    public InputStream getFileStream(String filePath) throws FileNotFoundException {
        return new FileInputStream(filePath);
    }

}
