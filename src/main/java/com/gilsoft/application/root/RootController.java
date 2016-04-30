package com.gilsoft.application.root;

import com.gilsoft.service.CallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
    @Autowired
    private CallerService callerService;

    @RequestMapping("/")
    public Integer index(@RequestParam("query") String query) {
        return callerService.moreSophisticatedExecute(query);
    }
}
