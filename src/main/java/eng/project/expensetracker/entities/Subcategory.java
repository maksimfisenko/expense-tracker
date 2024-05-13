package eng.project.expensetracker.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(nullable = false)
    String name;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    Category category;

    @Builder.Default
    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();
}
