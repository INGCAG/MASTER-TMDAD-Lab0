package es.unizar.tmdad.lab0.controller;

import es.unizar.tmdad.lab0.service.TwitterLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.social.UncategorizedApiException;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class SearchControllerRest {
    @Autowired
    TwitterLookupService twitter;

    @RequestMapping("/")
    public String greeting() {
        return "index";
    }

    @RequestMapping("/searchRest")
    public SearchResults searchRest(@RequestParam("q") String q) {
        return twitter.search(q);
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UncategorizedApiException.class)
    public String handleUncategorizedApiException(Model m) {
        m.addAttribute("res", twitter.emptyAnswer());
        return "search :: content";
    }
}
