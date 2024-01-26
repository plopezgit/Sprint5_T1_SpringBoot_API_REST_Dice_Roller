package com.plopez.diceroller.microservice.player.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nickname;
    private LocalDateTime registrationTimeStamp;
    private float gameSuccessRate;

    public Player(String nickname) {
        this.nickname = nickname;
        this.registrationTimeStamp = LocalDateTime.now();
        this.gameSuccessRate = 0;
    }
}
