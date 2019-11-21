package com.codecool.eszterszluka.series;

import com.codecool.eszterszluka.series.entities.Episode;
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
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
            //todo Episode.setSeason(Season) for all Episodes
            Set<Episode> episodes1 = IntStream.range(1, 9)
                    .boxed()
                    .map(integer -> Episode.builder()
                            .name("So1Episode" + integer)
                    .build())
                    .collect(Collectors.toSet());

            Set<Episode> episodes2 = IntStream.range(1, 9)
                    .boxed()
                    .map(integer -> Episode.builder()
                            .name("So2Episode" + integer)
                    .build())
                    .collect(Collectors.toSet());

            Set<Episode> episodes3 = IntStream.range(1, 9)
                    .boxed()
                    .map(integer -> Episode.builder()
                            .name("So3Episode" + integer)
                    .build())
                    .collect(Collectors.toSet());

            Set<Episode> episodes4 = IntStream.range(1, 9)
                    .boxed()
                    .map(integer -> Episode.builder()
                            .name("So4Episode" + integer)
                    .build())
                    .collect(Collectors.toSet());

            Season season1 = Season.builder()
                    .name("TOS01")
                    .releaseDate(LocalDate.of(1972, 01, 01))
                    .episodes(episodes1)
                    .build();

            setSeasonInAllEpisodes(season1);

            Season season2 = Season.builder()
                    .name("TOS02")
                    .releaseDate(LocalDate.of(1973, 1, 1))
                    .episodes(episodes2)
                    .build();

            setSeasonInAllEpisodes(season2);

            Season season3 = Season.builder()
                    .name("TOS03")
                    .releaseDate(LocalDate.of(1974, 1, 1))
                    .episodes(episodes3)
                    .build();

            setSeasonInAllEpisodes(season3);

            Season season4 = Season.builder()
                    .name("TOS04")
                    .releaseDate(LocalDate.of(1975, 1, 1))
                    .episodes(episodes4)
                    .build();

            setSeasonInAllEpisodes(season4);

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

    private void setSeasonInAllEpisodes(Season season){
        Set<Episode> episodes = season.getEpisodes();
        for (Episode episode: episodes
             ) {
            episode.setSeason(season);
        }

    }
}
