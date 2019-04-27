package com.obiew.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Likes")
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    private String likeId;
    @ManyToOne
    @JoinColumn(name = "obiewId")
    @JsonBackReference("likeList")
    private Obiew obiew;

    public Like() {}

    public String getLikeId() {
        return likeId;
    }

    public void setLikeId(String likeId) {
        this.likeId = likeId;
    }

    public Obiew getObiew() {
        return obiew;
    }

    public void setObiew(Obiew obiew) {
        this.obiew = obiew;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Like like = (Like) o;
        return Objects.equals(getLikeId(), like.getLikeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLikeId(), getObiew());
    }
}
