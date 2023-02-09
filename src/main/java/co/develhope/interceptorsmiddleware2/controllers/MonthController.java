package co.develhope.interceptorsmiddleware2.controllers;

import co.develhope.interceptorsmiddleware2.entities.Month;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/months")
public class MonthController {

    @GetMapping("/get")
    public Month getMonth (@RequestAttribute("month") Month month){
        return month;
    }
}
