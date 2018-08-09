package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/")
    public String listCustomers(Model model){
        model.addAttribute("customers", customerRepository.findAll());
        return "home";
    }

    @RequestMapping("details/{customerid}")
    public String showCustomer(@PathVariable("customerid") long customerid, Model model){
        model.addAttribute("customer", customerRepository.findById(customerid).get());
        return "details";
    }
}
