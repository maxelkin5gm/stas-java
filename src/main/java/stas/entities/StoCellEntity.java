package stas.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import stas.entities.id.StoCellKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sto_cell")
@Data
@NoArgsConstructor
public class StoCellEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    private StoEntity sto;

    @ManyToOne(cascade = CascadeType.ALL)
    private CellEntity cell;

    @Column(name = "cell_remainder")
    private Long cellRemainder;


    public StoCellEntity(StoEntity sto, CellEntity cell, Long cellRemainder) {
        this.sto = sto;
        this.cell = cell;
        this.cellRemainder = cellRemainder;
    }

    @Override
    public String toString() {
        return "StoCellEntity{" +
                "stoEntity=" + sto +
                ", cellEntity=" + cell +
                ", cellRemainder=" + cellRemainder +
                '}';
    }
}
