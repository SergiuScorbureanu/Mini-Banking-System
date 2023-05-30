package net.pao.SpringAPI.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import net.pao.SpringAPI.model.abstracts.AbstractEntity;
import net.pao.SpringAPI.model.enums.AccountType;

import javax.validation.constraints.Size;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "accounts")
public class Account extends AbstractEntity {

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "alias")
    private String alias;

    @Column(name = "account-type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "account_number")
    @Size(min = 16, max = 16, message = "Numarul contului trebuie sa aiba 16 caractere.")
    private String accountNumber;

}
