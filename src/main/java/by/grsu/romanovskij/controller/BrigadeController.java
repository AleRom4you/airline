package by.grsu.romanovskij.controller;

import by.grsu.romanovskij.DataTransferObject.BrigadeDto;
import by.grsu.romanovskij.repository.BrigadeRepository;
import by.grsu.romanovskij.service.BrigadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class BrigadeController {
    @Autowired
    BrigadeRepository brigadeRepository;
    @Autowired
    private BrigadeService brigadeService;

    @RequestMapping(value = "/brigade-list")
    public String brigadeList(Model model) {
        model.addAttribute("title","Brigade list :: AirLine");
        model.addAttribute("count", brigadeRepository.count());
        model.addAttribute("brigades", brigadeRepository.findAll());
        return "brigade-list";
    }

    @RequestMapping(value = "/brigade-list/add")
    public String addBrigadePage(Model model) {
        model.addAttribute("title","Add :: Brigade list :: AirLine");
        return "brigade-list-add";
    }

    @RequestMapping(value = "/brigade-list/add", method = RequestMethod.POST)
    public String addBrigade(Model model, @ModelAttribute("brigade") @Valid BrigadeDto brigadeDto,
                             BindingResult result) {
        model.addAttribute("title","Add :: Brigade list :: AirLine");

        if (result.hasErrors()) {
            model.addAttribute("error", "Oops, error!");
            return "brigade-list-add";
        }

        brigadeService.save(brigadeDto);
        model.addAttribute("success", "Brigade successfully added!");
        return "brigade-list-add";
    }

    @RequestMapping(value = "/brigade-list/edit/{brigadeId}", method = RequestMethod.GET)
    public String editBrigade(Model model, @PathVariable("brigadeId") Integer brigadeId) {
        model.addAttribute("title","Edit :: Brigade list :: AirLine");
        model.addAttribute("brigade", brigadeRepository.findBrigadeByBrigadeId(brigadeId));

        return "brigade-list-edit";
    }

    @RequestMapping(value = "/brigade-list/edit", method = RequestMethod.POST)
    public String editBrigade(Model model, @ModelAttribute("brigadeEdit") @Valid BrigadeDto brigadeDto,
                             BindingResult result) {
        model.addAttribute("title","Edit :: Brigade list :: AirLine");

        if (result.hasErrors()) {
            model.addAttribute("error", "Oops, error!");
            return "brigade-list-edit";
        }

        brigadeService.update(brigadeDto);
        model.addAttribute("success", "Brigade successfully saved!");
        return "redirect:/brigade-list";
    }

    @RequestMapping(value = "/brigade-list/delete/{brigadeId}", method = RequestMethod.GET)
    public String deleteBrigade(Model model, @PathVariable("brigadeId") Integer brigadeId) {

        brigadeRepository.delete(brigadeRepository.findBrigadeByBrigadeId(brigadeId));
        return "redirect:/brigade-list";
    }
}
