package dta.myorganize.model;

import dta.myorganize.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dta_entry")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Enumerated(EnumType.STRING)
    private Type type;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private Double value;
    private Date date;
    private boolean effected;
    private int recurrent;
    private String entry;

}
