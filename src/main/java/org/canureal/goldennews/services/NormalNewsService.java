package org.canureal.goldennews.services;

import lombok.RequiredArgsConstructor;
import org.canureal.goldennews.dtos.NewsDto;
import org.canureal.goldennews.models.NormalNewsModel;
import org.canureal.goldennews.repositorys.NormalNewsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NormalNewsService {
    private final NormalNewsRepository newsRepository;

    public NewsDto.Response createNewNews(NewsDto.Create dto) {
        NormalNewsModel news = new NormalNewsModel();
        news.setContents(dto.contents());
        news.setTitle(dto.title());

        NormalNewsModel saved = newsRepository.save(news);

        return new NewsDto.Response(
                saved.getNewsId(),
                saved.getTitle(),
                saved.getContents(),
                saved.getReleaseDate()
        );
    }

    public NewsDto.Response updateNews(Long newsId,NewsDto.Update dto) {
        NormalNewsModel news = newsRepository.findById(newsId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "no news in id " + newsId));

        if (dto.title() != null) {
            news.setTitle(dto.title());
        }
        if (dto.contents() != null) {
            news.setContents(dto.contents());
        }

        NormalNewsModel saved = newsRepository.save(news);

        return new NewsDto.Response(
                saved.getNewsId(),
                saved.getTitle(),
                saved.getContents(),
                saved.getReleaseDate()
        );
    }
     
    public List<NewsDto.Response> getLatestNews() {
      return newsRepository.findAllByOrderByReleaseDateDesc()
        .stream()
        .map(news -> new NewsDto.Response(
              news.getNewsId(),
              news.getTitle(),
              news.getContents(),
              news.getReleaseDate()
        )).toList();
    }

    public List<NewsDto.Response> getAllNews() {
        return newsRepository.findAll()
                .stream()
                .map(news -> new NewsDto.Response(
                        news.getNewsId(),
                        news.getTitle(),
                        news.getContents(),
                        news.getReleaseDate()
                )).toList();
    }
}
