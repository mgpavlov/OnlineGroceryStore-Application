package org.softuni.onlinegrocery.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccessController extends BaseController {

    @GetMapping("/unauthorized")
    public ModelAndView renderUnauthorizedPage() {
        return super.view("/unauthorized");
    }
}
