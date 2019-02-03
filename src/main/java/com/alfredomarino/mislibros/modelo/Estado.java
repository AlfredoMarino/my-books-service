package com.alfredomarino.mislibros.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Estado
 */
@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @Column(name = "idestado")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idEstado;

    @ManyToOne
    @JoinColumn(name = "idpais")
    @JsonIgnore
    private Pais pais;

    @Column(name = "nombre")
    private String nombre;

    public Estado() {
        
    }

    /**
     * @return the idEstado
     */
    public Long getIdEstado() {
        return idEstado;
    }

    /**
     * @param idEstado the idEstado to set
     */
    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }


    /**
     * @return the pais
     */
    public Pais getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(Pais pais) {
        this.pais = pais;
    }


    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}