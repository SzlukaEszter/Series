package com.codecool.eszterszluka.series.repositories;

import com.codecool.eszterszluka.series.entities.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
