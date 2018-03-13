package es.unizar.tmdad.lab0.controller;

import es.unizar.tmdad.lab0.service.TwitterLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.social.UncategorizedApiException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class SearchController {

    @Autowired
    TwitterLookupService twitter;

    @RequestMapping("/")
    public String greeting() {
        return "index-old";
    }

    @RequestMapping("/search")
    public String search(@RequestParam("q") String q, Model m) {
        m.addAttribute("res", twitter.search(q));
        return "search :: content";
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UncategorizedApiException.class)
    public String handleUncategorizedApiException(Model m) {
        m.addAttribute("res", twitter.emptyAnswer());
        return "search :: content";
    }
}