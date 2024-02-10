package com.example.demo.controllers.test;

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

    @GetMapping("/redirectWithRedirectView")
    public RedirectView redirectWithUsingRedirectView(RedirectAttributes attributes) {
        attributes.addFlashAttribute("flashAttributeVCN", "redirectWithRedirectViewVCN");
        attributes.addAttribute("attributeVCN", "redirectWithRedirectViewVCN");
        return new RedirectView("register");
    }

    @GetMapping({ "/redirectWithRedirectPrefix", "prefixRedirect" })
    public ModelAndView redirectWithUsingRedirectPrefix(ModelMap model) {
        model.addAttribute("attributeVCN", "redirectWithRedirectPrefixVCN");
        return new ModelAndView("redirect:/register", model);
    }
}
