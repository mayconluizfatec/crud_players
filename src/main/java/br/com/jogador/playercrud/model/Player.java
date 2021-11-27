package br.com.jogador.playercrud.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "names")

public class Player implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_player", length = 30, nullable = false)
    private String namePlayer;

    @Column(name = "age_player", length = 2, nullable = false)
    private Integer agePlayer;

    @Column(name = "club_player", length = 30, nullable = false)
    private String clubPlayer;
    
    //adding attributes for version 2.0
    @Column(name = "register_date" )
    private Date registerDate;
    
    @Column(length = 30 )
    private String nationality;
//
    public Player() {
    }

    public Player(long id, String namePlayer, Integer agePlayer, String clubPlayer, Date registerDate, String nationality) {
        this.id = id;
        this.namePlayer = namePlayer;
        this.agePlayer = agePlayer;
        this.clubPlayer = clubPlayer;
        this.registerDate = registerDate;
        this.nationality = nationality;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public Integer getAgePlayer() {
        return agePlayer;
    }

    public void setAgePlayer(Integer agePlayer) {
        this.agePlayer = agePlayer;
    }

    public String getClubPlayer() {
        return clubPlayer;
    }

    public void setClubPlayer(String clubPlayer) {
        this.clubPlayer = clubPlayer;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
