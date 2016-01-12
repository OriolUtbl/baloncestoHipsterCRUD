package com.example.ligabaloncesto.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;


/**
 * A Partido.
 */
@Entity
@Table(name = "PARTIDO")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Partido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(name = "localidad")
    private String localidad;

    @ManyToOne
    private Arbitro arbitro;

    @ManyToOne
    private Equipo equipoLocal;

    @ManyToOne
    private Equipo equipoVisitante;

    @ManyToOne
    private Temporada temporada;

    @OneToMany(mappedBy = "partido")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Estadisticas> estadisticass = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipo) {
        this.equipoLocal = equipo;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipo) {
        this.equipoVisitante = equipo;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    public Set<Estadisticas> getEstadisticass() {
        return estadisticass;
    }

    public void setEstadisticass(Set<Estadisticas> estadisticass) {
        this.estadisticass = estadisticass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Partido partido = (Partido) o;

        if ( ! Objects.equals(id, partido.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Partido{" +
                "id=" + id +
                ", localidad='" + localidad + "'" +
                '}';
    }
}
