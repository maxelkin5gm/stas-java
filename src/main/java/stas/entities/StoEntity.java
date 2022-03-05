package stas.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import stas.entities.CellEntity;
import stas.entities.StoCellEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "stos")
@Data
@NoArgsConstructor
public class StoEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(
            mappedBy = "sto",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<StoCellEntity> cells = new HashSet<>();


    public StoEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StoEntity{ name='" + name + "' }";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
