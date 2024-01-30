package com.example.demo.controllers;

import com.example.demo.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping
    public ResponseEntity<String> getMethodName() {
        return testService.todo();
    }

    @GetMapping("/redirectWithRedirectView")
    public RedirectView redirectWithUsingRedirectView(RedirectAttributes attributes) {
        attributes.addFlashAttribute("flashAttributeVCN", "redirectWithRedirectViewVCN");
        attributes.addAttribute("attributeVCN", "redirectWithRedirectViewVCN");
        return new RedirectView("hood");
    }

    @GetMapping("/redirectWithRedirectPrefix")
    public ModelAndView redirectWithUsingRedirectPrefix(ModelMap model) {
        model.addAttribute("attributeVCN", "redirectWithRedirectPrefixVCN");
        return new ModelAndView("redirect:/hood", model);
    } 
}
