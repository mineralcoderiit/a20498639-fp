package edu.sat.itmd4515.a20498639;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "PET")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "pet_name", nullable = false, unique = true)
    private String name;

    @PastOrPresent
    private LocalDate birthDate;

    @Transient
    private Integer age;

    @Enumerated(EnumType.STRING)
    private PetType type;

    public Pet() {

    }

    public Pet(String name, LocalDate birthDate, PetType type) {
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
    }



    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public edu.sat.itmd4515.a20498639.PetType getType() {//domain.
        return type;
    }

    public void setType(edu.sat.itmd4515.a20498639.PetType type) {//domain.
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", age=" + age +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if((this.id == null) ||((Pet) o).id == null){
            return false;
        }
        Pet pet = (Pet) o;
        return id == pet.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
