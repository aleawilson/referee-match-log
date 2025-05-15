package org.andrew.refereelog;

import org.andrew.refereelog.model.MatchLog;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class TestController {
    //@GetMapping("/")
    //public String showForm() {
    //    return "index";
   // }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute MatchLog matchLog) {
        // Here, Spring automatically binds form data to MatchLog object

        // For now, just return a simple confirmation message:
        return "Match logged: Referee - " + matchLog.getReferee() + ", Home Team Score - " + matchLog.getHomeTeamScore();
    }
}
