package com.smalaca.usermanagementconsumer.infrastructure.usermanagement.producer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureStubRunner(
        ids = {"com.smalaca:user-management:+:stubs:8100"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class UserManagementProducerCreateTest {
    private static final String GROUP = "Spider Verse";
    @Autowired
    private UserManagementProducer producer;

    @Test
    void shouldCreateUser() {
        Optional<Long> actual = producer.create(new UserDto("gwenstacy", "password", GROUP));
//        Optional<Long> actual = producer.create(new UserDto("smalaca", "xyz", "Group One"));

        assertThat(actual)
                .isPresent()
                .containsInstanceOf(Long.class);
    }

    @Test
    void shouldNotCreateUserWhenItAlreadyExists() {
//        producer.create(new UserDto("maryjane", UUID.randomUUID().toString(), GROUP));

        Optional<Long> actual = producer.create(new UserDto("Odinson", "xyz", "Avengers"));
//        Optional<Long> actual = producer.create(new UserDto("maryjane", UUID.randomUUID().toString(), GROUP));

        assertThat(actual).isEmpty();
    }
}