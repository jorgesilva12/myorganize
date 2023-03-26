package dta.myorganize.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dta_sub")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false,unique = true)
    private String subCategory;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
