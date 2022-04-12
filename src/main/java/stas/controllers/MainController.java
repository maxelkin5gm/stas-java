package stas.controllers;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import stas.repositories.CellRep;
import stas.repositories.DetailRep;
import stas.repositories.StoRep;
import stas.services.DbService;
import stas.services.admin.DetailStoService;
import stas.services.admin.StoCellService;

@CrossOrigin("*")
@Controller
@AllArgsConstructor
public class MainController {

    DetailStoService detailStoService;
    StoCellService stoCellService;

    DetailRep detailRep;
    StoRep stoRep;
    CellRep cellRep;
    DbService dbService;


    @GetMapping("/")
    @ResponseBody
    public String test() throws InterruptedException {
        Thread.sleep(500000);
        return "test";
    }


    @GetMapping("/admin/1")
    public String admin1() {
        return "stoDetail";
    }
    @GetMapping("/admin/2")
    public String admin2() {
        return "stoCell";
    }


    @PostMapping("/admin/1.1")
    @ResponseBody
    public String admin1Post(
            @RequestParam String nameSto,
            @RequestParam String nameDetail,
            @RequestParam String operationNumber
    ) {
        detailStoService.add(nameSto, nameDetail, operationNumber);
        return "ok";
    }

    @PostMapping("/admin/1.2")
    @ResponseBody
    public String admin1PostDel(
            @RequestParam String nameSto,
            @RequestParam String nameDetail,
            @RequestParam String operationNumber
    ) {
        if (!detailStoService.delete(nameSto, nameDetail, operationNumber)) return "error";
        return "ok";
    }

    @PostMapping("/admin/1.3")
    @ResponseBody
    public String admin1PostDelSto(@RequestParam String nameSto) {
        if (!detailStoService.deleteSto(nameSto)) return "error";
        return "ok";
    }

    @PostMapping("/admin/1.4")
    @ResponseBody
    public String admin1PostDelDetail(@RequestParam String nameDetail, @RequestParam String operationNumber) {
        if (!detailStoService.deleteDetail(nameDetail, operationNumber)) return "error";
        return "ok";
    }

    @PostMapping("/admin/2.1")
    @ResponseBody
    public String admin2PostAddStoInCell(@RequestParam String nameSto, @RequestParam Long cellNumber, @RequestParam Long cellRemainder) {
        if (!stoCellService.addStoInCell(nameSto, cellNumber, cellRemainder)) return "error";
        return "ok";
    }
}

