package com.codecool.eszterszluka.series;

import com.codecool.eszterszluka.series.entities.Season;
import com.codecool.eszterszluka.series.entities.Series;
import com.codecool.eszterszluka.series.repositories.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@SpringBootApplication
public class SeriesApplication {

    @Autowired
    SeriesRepository seriesRepository;

    public static void main(String[] args) {
        SpringApplication.run(SeriesApplication.class, args); }

    @Bean
    @Profile("production")
    public CommandLineRunner init(){

        return args -> {
            Season season1 = Season.builder()
                    .name("TOS01")
                    .releaseDate(LocalDate.of(1972, 01, 01))
                    .build();

            Season season2 = Season.builder()
                    .name("TOS02")
                    .releaseDate(LocalDate.of(1973, 1, 1))
                    .build();

            Season season3 = Season.builder()
                    .name("TOS03")
                    .releaseDate(LocalDate.of(1974, 1, 1))
                    .build();

            Season season4 = Season.builder()
                    .name("TOS04")
                    .releaseDate(LocalDate.of(1975, 1, 1))
                    .build();

            Series starTrek = Series.builder()
                    .name("Star Trek")
                    .firstReleaseDate(LocalDate.of(1972, 1, 1))
                    .season(season1)
                    .season(season2)
                    .season(season3)
                    .season(season4)
                    .build();

            season1.setSeries(starTrek);
            season2.setSeries(starTrek);
            season3.setSeries(starTrek);
            season4.setSeries(starTrek);

            seriesRepository.save(starTrek);


        };

    }

}
