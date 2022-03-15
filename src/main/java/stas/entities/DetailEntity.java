package stas.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "details")
@Data
@NoArgsConstructor
public class DetailEntity implements Serializable {

    // change name class

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "operation_number")
    private String operationNumber;

    @ManyToMany()
    private Set<StoEntity> stos = new HashSet<>();


    public void addSto(StoEntity sto) {
        stos.add(sto);
    }

    public DetailEntity(String name, String operationNumber) {
        this.name = name;
        this.operationNumber = operationNumber;
    }

    @Override
    public String toString() {
        return "DetailsEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", operationNumber='" + operationNumber + '\'' +
                '}';
    }
}