package br.com.jogador.playercrud.services;

import br.com.jogador.playercrud.model.Player;
import br.com.jogador.playercrud.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository repository;

    public Player save(Player player) {
        return repository.save(player);
    }

    public Player findById(long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Not Found!"));
    }

    public List<Player> findAll() {
        return repository.findAll();
    }

    public Player update(Player player) throws Exception {
        Player p = repository.findById(player.getId()).orElseThrow(() -> new Exception("Not Found"));
        p.setNamePlayer(player.getNamePlayer());
        p.setAgePlayer(player.getAgePlayer());
        p.setClubPlayer(player.getClubPlayer());
        return repository.save(p);

        
        }
    public void delete(long id) throws  Exception{
        Player p = repository.findById(id).orElseThrow( () -> new Exception("Not Found!") );
        repository.delete(p);


    }
}
