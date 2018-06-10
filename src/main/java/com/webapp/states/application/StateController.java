package com.webapp.states.application;

import com.webapp.states.data.entity.State;
import com.webapp.states.data.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="")
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getStates(Model model){
        Iterable<State> stateData = this.stateRepository.findAll();
        model.addAttribute("stateList", stateData);
        return "states";
    }
}
