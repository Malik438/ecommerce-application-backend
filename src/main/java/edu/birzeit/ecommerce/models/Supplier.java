package edu.birzeit.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "Supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    @OneToMany(mappedBy = "supplier")
    @JsonIgnore
    private List<Product> products=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "workhouse_id")
    private Workhouse workhouse;


}
