package org.example.store;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class StoreApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

    private final AmazonS3 s3;

    @Override
    public void run(String... args) throws Exception {
        String newBucket = "b123321";

    //  s3.createBucket("newBucket");

        String key =  "test.txt";
        File file = new File("src/main/resources/test.txt");
        s3.putObject(new PutObjectRequest(newBucket, key, file));
    }
}
