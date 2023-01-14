package com.dyplom.wsh;

import com.dyplom.WshAndrzejDyplomApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = WshAndrzejDyplomApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = { "spring.datasource.url=jdbc:tc:postgresql:11-alpine:///sdk",
                "spring.datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver"

        }
)
public abstract class AbstractIntegrationTest {
}
