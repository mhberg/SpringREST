package com.webapp.states.application;

import com.webapp.states.data.entity.State;
import com.webapp.states.data.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/states")
public class StateRestController {

    @Autowired
    private StateRepository stateRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<State> getAllStates(){
        return stateRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{stateId}")
    public Optional<State> getStateById(@PathVariable(value="stateId") String stateId){
        Long id = Long.parseLong(stateId);
        return stateRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{param}")
    public State getStateByParam(@PathVariable(value="param") String param){
        State targetState = new State();
        Iterable<State> stateData = stateRepository.findAll();

        for(State state : stateData){
            if (state.getName().equalsIgnoreCase(param) || state.getCode().equalsIgnoreCase(param)){
                targetState = state;
            }
        }
        return targetState;
    }
}