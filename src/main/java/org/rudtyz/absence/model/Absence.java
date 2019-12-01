package org.rudtyz.absence.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idx;

    @Column(unique = true)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date beginDate;

    @Column(unique = true)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date endDate;

    @Valid
    @NotNull
    @ManyToOne
    private Member member;

    public Absence(){
    }

    public Absence(Date beginDate, Date endDate, Member member) {
        this.idx = 0;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.member = member;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Absence{" +
                "idx=" + idx +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", member=" + member +
                '}';
    }
}
