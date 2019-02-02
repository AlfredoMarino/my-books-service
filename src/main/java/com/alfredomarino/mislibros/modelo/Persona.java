package com.alfredomarino.mislibros.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Persona
 */
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @Column(name = "idpersona")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idPersona;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuario usuario;
    
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fechanacimiento")
    private Date fechaNacimiento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idpais")
    private Pais paisNacimiento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idestado")
    private Estado estadoNacimiento;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idpais")
    private Pais paisActual;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idestado")
    private Estado estadoActual;

    @Column(name = "sobremi")
    private String sobreMi;

    @Column(name = "foto")
    private String foto;


    public Persona() {
        
    }

    /**
     * @return the idPersona
     */
    public Long getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the paisNacimiento
     */
    public Pais getPaisNacimiento() {
        return paisNacimiento;
    }

    /**
     * @param paisNacimiento the paisNacimiento to set
     */
    public void setPaisNacimiento(Pais paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    /**
     * @return the estadoNacimiento
     */
    public Estado getEstadoNacimiento() {
        return estadoNacimiento;
    }

    /**
     * @param estadoNacimiento the estadoNacimiento to set
     */
    public void setEstadoNacimiento(Estado estadoNacimiento) {
        this.estadoNacimiento = estadoNacimiento;
    }

    /**
     * @return the paisActual
     */
    public Pais getPaisActual() {
        return paisActual;
    }

    /**
     * @param paisActual the paisActual to set
     */
    public void setPaisActual(Pais paisActual) {
        this.paisActual = paisActual;
    }

    /**
     * @return the estadoActual
     */
    public Estado getEstadoActual() {
        return estadoActual;
    }

    /**
     * @param estadoActual the estadoActual to set
     */
    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }

    /**
     * @return the sobreMi
     */
    public String getSobreMi() {
        return sobreMi;
    }

    /**
     * @param sobreMi the sobreMi to set
     */
    public void setSobreMi(String sobreMi) {
        this.sobreMi = sobreMi;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }


}