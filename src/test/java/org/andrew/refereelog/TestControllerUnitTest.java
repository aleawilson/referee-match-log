// 1. Pure unit test for TestController using JUnit 5 and Mockito
package org.andrew.refereelog;

import org.andrew.refereelog.model.MatchLog;
import org.andrew.refereelog.repository.MatchLogRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class TestControllerUnitTest {
    @Mock
    private MatchLogRepository repository;

    @InjectMocks
    private TestController controller;

    @Test
    void submitForm_savesMatchLog_andReturnsMessage() {
        // Arrange
        MatchLog matchLog = new MatchLog();
        matchLog.setReferee("John");
        matchLog.setAssistantReferee1("Alice");
        matchLog.setAssistantReferee2("Bob");
        matchLog.setHomeTeamName("TeamA");
        matchLog.setAwayTeamName("TeamB");
        matchLog.setHomeTeamScore(1);
        matchLog.setAwayTeamScore(2);

        // Act
        String response = controller.submitForm(matchLog);

        // Assert
        verify(repository).save(matchLog);
        assertThat(response).isEqualTo("Match saved for Referee: John");
    }
}