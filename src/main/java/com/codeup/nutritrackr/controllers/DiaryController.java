package com.codeup.nutritrackr.controllers;

import com.codeup.nutritrackr.models.Diary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import com.codeup.nutritrackr.services.Diaries;


@Controller
public class DiaryController {

    //private final Diaries diaries;

    //public DiaryController(Diaries diaries) {
    //   this.diaries = diaries;
    //}

    @GetMapping("/diary")
    public String showDiaryPage(Model model) {
        model.addAttribute("diary", new Diary());
        return "users/diary";
    }

    @PostMapping("/diary")
    public String saveDiaryEntries(@ModelAttribute Diary diary) {
        //diary.setfood(diary);
        diary.save(diary);
        return "redirect:/diary";
    }



}
