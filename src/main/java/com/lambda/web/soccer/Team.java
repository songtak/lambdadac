package com.lambda.web.soccer;



import lombok.*;

import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;


//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter(AccessLevel.PUBLIC) @ToString
@Entity @NoArgsConstructor @Component @Lazy
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamNo;

    @Column(length = 10) private String teamId;
    @Column(length = 10) private String regionName;
    @Column(length = 40) private String teamName;
    @Column(length = 50) private String eTeamName;
    @Column(length = 10) private String origYyyy;
    @Column(length = 10) private String zipCode1;
    @Column(length = 10) private String zipCode2;
    @Column(length = 80) private String address;
    @Column(length = 10) private String ddd;
    @Column(length = 10) private String tel;
    @Column(length = 10) private String fax;
    @Column(length = 50) private String homepage;
    @Column(length = 10) private String owner;

    @Builder
    private Team(
            String teamId,
            String regionName,
            String teamName,
            String eTeamName,
            String origYyyy,
            String zipCode1,
            String zipCode2,
            String address,
            String ddd,
            String tel,
            String fax,
            String homepage,
            String owner
    ){
        this.teamId = teamId;
                this. regionName=regionName;
                this. teamName=teamName;
                this. eTeamName=eTeamName;
                this. origYyyy=origYyyy;
                this. zipCode1=zipCode1;
                this. zipCode2=zipCode2;
                this. address=address;
                this. ddd=ddd;
                this. tel=tel;
                this. fax=fax;
                this. homepage=homepage;
                this. owner=owner;
    }


    @OneToMany(mappedBy = "teamOfPlayer")
    private List<Player> players;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="stadium_id")
    private Stadium stadiumOfTeam;

}
