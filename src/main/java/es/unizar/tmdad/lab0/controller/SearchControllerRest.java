package es.unizar.tmdad.lab0.controller;

import es.unizar.tmdad.lab0.service.TwitterLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchControllerRest {
    @Autowired
    TwitterLookupService twitter;

    @RequestMapping("/searchRest")
    public String search(@RequestParam("q") String q, Model m) {
        m.addAttribute("res", twitter.search(q));
        return "search :: content";
    }
}
