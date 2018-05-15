package ch.erni.frontend.controller;

import ch.erni.frontend.model.Ernian;
import ch.erni.frontend.service.FileWriterReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ErnianFormController {

    private FileWriterReaderService fileWriterReaderService;

    @Autowired
    public ErnianFormController(FileWriterReaderService fileWriterReaderService) {
        this.fileWriterReaderService = fileWriterReaderService;
    }

    @GetMapping("/ernian")
    public String ernianForm(Model model) {
        model.addAttribute("ernian", new Ernian());
        return "ernian";
    }

    @PostMapping("/ernian")
    public String ernianSubmit(@ModelAttribute Ernian ernian) {
        fileWriterReaderService.writeErnians(ernian);
        return "result";
    }
}


