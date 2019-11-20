package com.codecool.eszterszluka.series.repositories;

import com.codecool.eszterszluka.series.entities.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Long> {
}
