package org.canureal.goldennews.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "defaultNewsModel")
@Getter @Setter
public class NormalNewsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsId;

    @CreationTimestamp
    private LocalDateTime releaseDate;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false)
    @Lob
    private String contents;
}
