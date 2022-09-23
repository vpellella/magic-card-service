package com.example.demo;

import com.infy.magiccard.MagicCardApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest(classes = MagicCardApplication.class)
@ActiveProfiles(profiles = "local")
class MagicCardApplicationTests {

    @Test
    void contextLoads() {

    }

}
