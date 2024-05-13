package eng.project.expensetracker.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @Builder.Default
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();
}
