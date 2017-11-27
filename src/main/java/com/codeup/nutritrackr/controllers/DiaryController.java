package com.codeup.nutritrackr.controllers;

import com.codeup.nutritrackr.models.Meal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DiaryController {

    //private final Diaries diaries;

    //public DiaryController(Diaries diaries) {
    //   this.diaries = diaries;
    //}

    @GetMapping("/diary")
    public String showDiaryPage(Model model) {
        model.addAttribute("meal", new Meal());
        return "users/diary";
    }

    @PostMapping("/diary")
    public String saveDiaryEntries(@ModelAttribute Meal meal) {
        Meal.save(meal);
        return "redirect:/diary";
    }

    @GetMapping("/diary/create")
    public String createDiaryPost(){
       return "users/diary";
    }



}
