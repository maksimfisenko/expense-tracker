package eng.project.expensetracker.entities;

import eng.project.expensetracker.enums.CategoryType;
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
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String hex;

    @Enumerated(EnumType.STRING)
    CategoryType type;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @Builder.Default
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    List<Subcategory> subcategories = new ArrayList<>();
}
