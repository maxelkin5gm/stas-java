package stas.entities.id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import stas.entities.CellEntity;
import stas.entities.StoEntity;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoCellKey implements Serializable {

    static final long serialVersionUID = 1L;

    private StoEntity sto;

    private CellEntity cell;

}
