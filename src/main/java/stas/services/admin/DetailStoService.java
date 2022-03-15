package stas.services.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import stas.entities.DetailEntity;
import stas.entities.StoEntity;
import stas.repositories.DetailRep;
import stas.repositories.StoRep;

@Service
@AllArgsConstructor
public class DetailStoService {

    StoRep stoRep;
    DetailRep detailRep;

    @Transactional
    public void add(String nameSto,
                    String nameDetail,
                    String operationNumber
    ) {
        var stoEntity = stoRep.findByName(nameSto).orElse(new StoEntity(nameSto));
        var detailEntity = detailRep.findByNameAndOperationNumber(nameDetail, operationNumber)
                .orElse(new DetailEntity(nameDetail, operationNumber));

        stoRep.save(stoEntity);
        detailRep.save(detailEntity);

        detailEntity.getStos().add(stoEntity);
    }

    @Transactional
    public boolean delete(String nameSto,
                          String nameDetail,
                          String operationNumber
    ) {
        try {
            var stoEntity = stoRep.findByName(nameSto).orElseThrow();
            var detailEntity = detailRep.findByNameAndOperationNumber(nameDetail, operationNumber).orElseThrow();
            if (!detailEntity.getStos().remove(stoEntity)) return false;
            detailRep.saveAndFlush(detailEntity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    public boolean deleteSto(String nameSto) {

        try {
            var stoEntity = stoRep.findByName(nameSto).orElseThrow();

            for (DetailEntity detail : stoEntity.getDetails()) {
                detail.getStos().remove(stoEntity);
            }
            stoRep.delete(stoEntity);
            stoRep.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    public boolean deleteDetail(String nameDetail, String operationNumber) {
        try {
            var detailEntity = detailRep.findByNameAndOperationNumber(nameDetail, operationNumber).orElseThrow();
            detailRep.delete(detailEntity);
            detailRep.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
