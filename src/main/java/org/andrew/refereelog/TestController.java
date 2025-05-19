package org.andrew.refereelog;

import org.andrew.refereelog.model.MatchLog;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.andrew.refereelog.repository.MatchLogRepository;

@RestController
public class TestController {
    @Autowired
    private MatchLogRepository matchLogRepository;

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute MatchLog matchLog) {
        matchLogRepository.save(matchLog);
        return "Match saved for Referee: " + matchLog.getReferee();
    }
}
