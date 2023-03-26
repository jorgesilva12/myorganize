package dta.myorganize.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dta_cat")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(unique = true, nullable = false)
    private String category;
    @OneToMany(mappedBy = "category")
    private List<SubCategory> subCategory;
}
