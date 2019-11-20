package com.codecool.eszterszluka.series.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Series {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private LocalDate firstReleaseDate;

    @Singular
    @OneToMany (mappedBy = "series", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private Set<Season> seasons;
}
