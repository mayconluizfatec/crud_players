package br.com.jogador.playercrud.controller;

import br.com.jogador.playercrud.model.Player;
import br.com.jogador.playercrud.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/names")
    public class PlayerController {

        @Autowired
        private PlayerService service;

        @PostMapping
        public Player save(@RequestBody Player player){
            return service.save(player);
        }

        @GetMapping
        public List<Player> findAll(){
            return service.findAll();
        }

        @GetMapping("/{id}")
        public Player findById(@PathVariable("id") long id) throws Exception{
            return service.findById(id);
        }

        @PutMapping
        public Player update(@RequestBody Player player) throws Exception{
            return service.update(player);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable("id") long id) throws Exception {
            service.delete(id);
        }


    }


