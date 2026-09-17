package org.canureal.goldennews.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class NewsDto {
   public record Create(
           @NotBlank(message = "title cannot be empty")
           @Size(max = 255, message = "title cannot have more than 255 chars")
           String title,
           @NotBlank(message = "content cannot be empty")
           String contents
   ) {}

   public record Update(
           @Size(max = 255,message = "title cannot have more than 255 chars")
           String title,
           String contents
   ) {}

   public record Response(
           Long newsId,
           String title,
           String contents,
           LocalDateTime releaseDate
   ) {}
}
