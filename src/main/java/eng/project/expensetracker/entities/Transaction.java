package eng.project.expensetracker.entities;

import eng.project.expensetracker.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @CreationTimestamp
    Instant date;

    @Enumerated(EnumType.STRING)
    TransactionType type;

    @Column(nullable = false)
    BigDecimal amount;

    @Column(nullable = false)
    BigDecimal balanceAfter;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    Account account;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    Subcategory subcategory;

}
