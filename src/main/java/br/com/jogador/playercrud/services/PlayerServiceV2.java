package br.com.jogador.playercrud.services;

import br.com.jogador.playercrud.model.Player;
import br.com.jogador.playercrud.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Service
public class PlayerServiceV2 {
    @Autowired
    private PlayerRepository repository;

    @Autowired
    private EntityManager em;

    public Player save(Player player) {
        player.setRegisterDate(new Date());
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
        // sets the nationality attribute 
        p.setNationality(player.getNationality());
        return repository.save(p);


    }

    public void delete(long id) throws Exception {
        Player p = repository.findById(id).orElseThrow(() -> new Exception("Not Found!"));
        repository.delete(p);


    }

public  List<Player> listByName(String name){
        String hql = "from Player where namePlayer like :name order by namePlayer ";
         Query query = em.createQuery(hql);
         query.setParameter("name", name + "%");
         List<Player> names = query.getResultList();
         return names;
        
}
}
