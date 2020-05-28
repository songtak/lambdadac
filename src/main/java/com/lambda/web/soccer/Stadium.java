package com.lambda.web.soccer;


import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.List;


//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity @Lazy
public class Stadium {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stadiumNo;

    @Column(length = 10) private String stadiumId;
    @Column(length = 10) private String stadiumName;
    @Column(length = 10) private String hometeamId;
    @Column(length = 10) private String seatCount;
    @Column(length = 10) private String address;
    @Column(length = 10) private String ddd;
    @Column(length = 10) private String tel;

    @Builder
    private Stadium(
            String stadiumId,
            String stadiumName,
            String hometeamId,
            String seatCount,
            String address,
            String ddd,
            String tel
    ){
        this.stadiumId = stadiumId;
        this.stadiumName = stadiumName;
        this.hometeamId = hometeamId;
        this.seatCount = seatCount;
        this.address = address;
        this.ddd = ddd;
        this.tel = tel;
    }

    @OneToMany(mappedBy = "stadiumOfTeam")
    private List<Team> teams;

    @OneToMany(mappedBy = "stadiumOfSchedule")
    private List<Schedule> schedules;

    public Long getStadiumNo() {
        return stadiumNo;
    }

    public void setStadiumNo(Long stadiumNo) {
        this.stadiumNo = stadiumNo;
    }

    public String getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(String stadiumId) {
        this.stadiumId = stadiumId;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getHometeamId() {
        return hometeamId;
    }

    public void setHometeamId(String hometeamId) {
        this.hometeamId = hometeamId;
    }

    public String getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(String seatCount) {
        this.seatCount = seatCount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
