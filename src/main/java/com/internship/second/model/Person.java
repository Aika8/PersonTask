package com.internship.second.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "persons")
@Getter
@Setter
@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name = "name", nullable = false)
    @NotEmpty
    @Size(max = 128)
    private String name;

    @Column(name = "age", nullable = false)
    @NotEmpty
    @Range(min = 1, max = 120, message = "age must be 1-120")
    private int age;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person")
    @JsonManagedReference
    private List<Phone> phones;

}
