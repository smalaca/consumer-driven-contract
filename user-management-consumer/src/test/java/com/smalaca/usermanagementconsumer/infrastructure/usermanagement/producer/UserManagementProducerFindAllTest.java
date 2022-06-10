package com.smalaca.usermanagementconsumer.infrastructure.usermanagement.producer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureStubRunner(
        ids = {"com.smalaca:user-management:+:stubs:8100"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class UserManagementProducerFindAllTest {
    @Autowired
    private UserManagementProducer producer;

    @Test
    void shouldReturnUsersForGivenGroup() {
        List<UserDto> actual = producer.findAllForGroup("Avengers");

        assertThat(actual)
                .hasSize(3)
                .anySatisfy(dto -> assertThat(dto).isEqualTo(new UserDto(1L, "Captain America", UUID.randomUUID().toString(), "Avengers")))
                .anySatisfy(dto -> assertThat(dto).isEqualTo(new UserDto(2L, "Tony Stark", UUID.randomUUID().toString(), "Avengers")))
                .anySatisfy(dto -> assertThat(dto).isEqualTo(new UserDto(3L, "Odinson", UUID.randomUUID().toString(), "Avengers")));
    }

    @Test
    void shouldReturnNoUserForNotExistingGroup() {
        List<UserDto> actual = producer.findAllForGroup("Defenders");

        assertThat(actual).isEmpty();
    }
}