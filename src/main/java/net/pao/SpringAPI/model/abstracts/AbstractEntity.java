package net.pao.SpringAPI.model.abstracts;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class AbstractEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private LocalDate creationDate = LocalDate.now();

    private LocalDate updatedDate = LocalDate.now();

    //private LocalDate deletedDate
}
