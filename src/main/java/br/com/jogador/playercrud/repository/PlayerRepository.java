package br.com.jogador.playercrud.repository;

import br.com.jogador.playercrud.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    
    
}
