package com.alfredomarino.mislibros.modelo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Pais
 */
@Entity
@Table(name = "pais")
public class Pais {

    @Id
    @Column(name = "idpais")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idPais;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    private Set<Estado> estados;

    public Pais() {
        
    }


    /**
     * @return the idPais
     */
    public Long getIdPais() {
        return idPais;
    }

    /**
     * @param idPais the idPais to set
     */
    public void setIdPais(Long idPais) {
        this.idPais = idPais;
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

    /**
     * @return the estados
     */
    public Set<Estado> getEstados() {
        return estados;
    }

    /**
     * @param estados the estados to set
     */
    public void setEstados(Set<Estado> estados) {
        this.estados = estados;
    }
}