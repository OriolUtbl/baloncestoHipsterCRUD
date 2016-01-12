package com.example.ligabaloncesto.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;


/**
 * A Estadisticas.
 */
@Entity
@Table(name = "ESTADISTICAS")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Estadisticas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(name = "canastas")
    private Integer canastas;
    
    @Column(name = "faltas")
    private Integer faltas;

    @ManyToOne
    private Partido partido;

    @ManyToOne
    private Jugador jugador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCanastas() {
        return canastas;
    }

    public void setCanastas(Integer canastas) {
        this.canastas = canastas;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Estadisticas estadisticas = (Estadisticas) o;

        if ( ! Objects.equals(id, estadisticas.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Estadisticas{" +
                "id=" + id +
                ", canastas='" + canastas + "'" +
                ", faltas='" + faltas + "'" +
                '}';
    }
}
