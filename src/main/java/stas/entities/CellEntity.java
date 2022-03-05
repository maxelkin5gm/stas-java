package stas.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "cells")
@Data
@NoArgsConstructor
public class CellEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private Long number;

    @OneToMany(
            mappedBy = "cell",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<StoCellEntity> stos = new HashSet<>();


    public CellEntity(Long number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "CellEntity{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
