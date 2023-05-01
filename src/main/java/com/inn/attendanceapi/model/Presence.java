package com.inn.attendanceapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "presence")
public class Presence implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "entry_time", columnDefinition = "TIME DEFAULT '00:00:00'")
    @JsonFormat(pattern = "HH:mm:ss")
    private Time Entrytime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seance_fk", nullable = false)
    private Seance seance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_fk", nullable = false)
    private User user;
}