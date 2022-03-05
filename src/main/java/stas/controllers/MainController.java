package stas.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import stas.dto.Test2;
import stas.entities.DetailEntity;
import stas.entities.StoEntity;
import stas.repositories.CellRep;
import stas.repositories.DetailRep;
import stas.repositories.StoRep;
import stas.services.DbService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@AllArgsConstructor
public class MainController {

    DetailRep detailRep;
    StoRep stoRep;
    CellRep cellRep;
    DbService dbService;


    @GetMapping("/")
    @ResponseBody
    public String test() {

//        var cell = new CellEntity();
//        cell.setNumber(11L);
//
////        var cell = cellRep.findById(8L).get();
//
//        var sto = stoRep.findById(6L).get();
//
//
//        stoRep.save(sto);
//        cellRep.save(cell);
//
//        cell.addSto(sto, 5L);
//
//        detailRep.flush();
//        stoRep.flush();
//        cellRep.flush();


//        var detail = new DetailsEntity("боеголовка", "229");
//
//        var result = detailRep.findOne(Example.of(detail)).get();
//
//        var bag = new ArrayList<Result>();
//        for (StoEntity sto : result.getStos()) {
//            var res = new Result();
//            for (StoCellEntity stoCell : sto.getCells()) {
//                res.setNameDetail(result.getName());
//                res.setNumberOperation(result.getOperationNumber());
//                res.setNameSto(sto.getName());
//                res.setCellRemainder(stoCell.getCellRemainder());
//                var cell = stoCell.getCell();
//                res.setCellNumber(cell.getNumber());
//
//                bag.add(res);
//
//            }
//
//        }


//        dbService.add("detail2", "operNum1", "namSto2", 229L, 10L);

//        dbService.deleteSto("namSto1", 10L);


        var sto = stoRep.findByName("namSto1").get();
        Set<StoEntity> stos = new HashSet<>();
        stos.add(sto);

        var detail = new DetailEntity();
        detail.setStos(stos);

        var result = detailRep.findAll(Example.of(detail));

        return "test";
    }
}

