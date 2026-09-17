package org.canureal.goldennews.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.canureal.goldennews.dtos.NewsDto;
import org.canureal.goldennews.services.NormalNewsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {
    private final NormalNewsService newsService;

    @PostMapping("/create")
    public NewsDto.Response createNews(@Valid @RequestBody NewsDto.Create dto) {
        return newsService.createNewNews(dto);
    }

    @PatchMapping("/update/{newsId}")
    public NewsDto.Response updateNews(@Valid @RequestBody NewsDto.Update dto, @PathVariable @RequestParam Long newsId) {
        return newsService.updateNews(newsId, dto);
    }

    @GetMapping("/getallnews")
    public List<NewsDto.Response> getAllNews() {
        return newsService.getAllNews();
    }
}
