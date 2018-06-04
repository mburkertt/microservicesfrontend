package ch.erni.frontend.controller;

import ch.erni.frontend.model.Ernian;
import ch.erni.frontend.service.FileWriterReaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ErnianFormController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErnianFormController.class);
    private FileWriterReaderService fileWriterReaderService;
    @Autowired
    public ErnianFormController(FileWriterReaderService fileWriterReaderService) {
        this.fileWriterReaderService = fileWriterReaderService;
    }
    @GetMapping("/ernian")
    public String ernianForm(Model model) {
        model.addAttribute("ernian", new Ernian());
        LOGGER.info("Form was called");
        return "ernian";
    }
    @PostMapping("/ernian")
    public String ernianSubmit(@ModelAttribute Ernian ernian) {
        fileWriterReaderService.writeErnians(ernian);
        LOGGER.info("Ernian was put into filespace {}", ernian);
        return "result";
    }
}