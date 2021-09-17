package sheridan.mislim.Rock_Paper_Scissors.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import sheridan.mislim.Rock_Paper_Scissors.domain.Player;

@Controller
public class GameController {
    private final Logger logger = LoggerFactory.getLogger(GameController.class);

    @GetMapping(value = {"/", "Input"})
    public ModelAndView input(){
        logger.trace("input() is called");
        return new ModelAndView("Input", "user", new Player());
    }
    @PostMapping("/Process")
    public ModelAndView process(@ModelAttribute Player user, Model model){
        Player computer = new Player();
        user.setChoice(user.getChoice());
        logger.trace("process() is called");
        logger.debug("user = " + user);
        logger.debug("computer = " + computer);
        model.addAttribute("computer", computer);
        if(computer.getChoice() == user.getChoice()){
            computer.setWinner(false);
            user.setWinner(false);
        }
        if (computer.getChoice() == 2 && user.getChoice() == 0){
            user.setWinner(false);
        }
        if (computer.getChoice() == 0 && user.getChoice() == 2){
            computer.setWinner(false);
        }
        if (computer.getChoice()==1 && user.getChoice()== 2){
            user.setWinner(false);
        }
        if (computer.getChoice() == 2 && user.getChoice()== 1){
            computer.setWinner(false);
        }
        if (computer.getChoice() == 0 && user.getChoice() == 1){
            user.setWinner(false);
        }
        if (computer.getChoice() == 1 && user.getChoice() == 0){
            computer.setWinner(false);
        }
        return new ModelAndView("Output", "user", user);
    }

}
