package net.pao.SpringAPI.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import net.pao.SpringAPI.model.abstracts.AbstractEntity;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "clients")
public class Client extends AbstractEntity {


    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "birth_day")
    private LocalDate birthDay;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @OneToMany
    @JoinColumn(name = "account_id")
    private Set<Account> accountId;
}
