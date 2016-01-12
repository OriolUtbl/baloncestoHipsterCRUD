package com.example.ligabaloncesto.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.example.ligabaloncesto.domain.util.CustomLocalDateSerializer;
import com.example.ligabaloncesto.domain.util.ISO8601LocalDateDeserializer;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;


/**
 * A Jugador.
 */
@Entity
@Table(name = "JUGADOR")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Jugador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellidos")
    private String apellidos;
    
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @JsonSerialize(using = CustomLocalDateSerializer.class)
    @JsonDeserialize(using = ISO8601LocalDateDeserializer.class)
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    
    @Column(name = "canastas")
    private Integer canastas;
    
    @Column(name = "asistencias")
    private Integer asistencias;
    
    @Column(name = "rebotes")
    private Integer rebotes;
    
    @Column(name = "posicion")
    private String posicion;

    @OneToMany(mappedBy = "jugador")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Estadisticas> estadisticass = new HashSet<>();

    @ManyToOne
    private Equipo equipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getCanastas() {
        return canastas;
    }

    public void setCanastas(Integer canastas) {
        this.canastas = canastas;
    }

    public Integer getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Integer asistencias) {
        this.asistencias = asistencias;
    }

    public Integer getRebotes() {
        return rebotes;
    }

    public void setRebotes(Integer rebotes) {
        this.rebotes = rebotes;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Set<Estadisticas> getEstadisticass() {
        return estadisticass;
    }

    public void setEstadisticass(Set<Estadisticas> estadisticass) {
        this.estadisticass = estadisticass;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Jugador jugador = (Jugador) o;

        if ( ! Objects.equals(id, jugador.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + "'" +
                ", apellidos='" + apellidos + "'" +
                ", fechaNacimiento='" + fechaNacimiento + "'" +
                ", canastas='" + canastas + "'" +
                ", asistencias='" + asistencias + "'" +
                ", rebotes='" + rebotes + "'" +
                ", posicion='" + posicion + "'" +
                '}';
    }
}
