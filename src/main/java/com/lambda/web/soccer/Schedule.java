package com.lambda.web.soccer;


import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;



@Getter @Setter(AccessLevel.PUBLIC) @ToString
@Entity @NoArgsConstructor @Component @Lazy
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleNo;

    @Column(length = 10) private String scheDate;
    @Column(length = 10) private String gubun;
    @Column(length = 10) private String hometeamId;
    @Column(length = 10) private String awayteamId;
    @Column(length = 10) private String homeScore;
    @Column(length = 10) private String awayScore;

    @Builder
    private Schedule(
            String scheDate,
            String gubun,
            String hometeamId,
            String awayteamId,
            String homeScore,
            String awayScore){
        this.scheDate = scheDate;
        this.gubun =gubun;
        this.hometeamId = hometeamId;
        this.awayteamId = awayteamId;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="stadium_id")
    private Stadium stadiumOfSchedule;


}