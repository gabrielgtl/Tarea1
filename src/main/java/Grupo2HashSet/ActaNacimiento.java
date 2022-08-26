/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grupo2HashSet;

public class ActaNacimiento {
    String nroActa;
    String nroTomoLibro;
    String folio;
    String nombreCompleto;
    String sexo;
    int departamento;
    int costoDocumentoEmitido;

    public String getNroActa() {return nroActa;}

    public void setNroActa(String nroActa) {this.nroActa = nroActa;}

    public String getNroTomoLibro() {return nroTomoLibro;}

    public void setNroTomoLibro(String nroTomoLibro) {this.nroTomoLibro = nroTomoLibro;}

    public String getFolio() {return folio;}

    public void setFolio(String folio) {this.folio = folio;}

    public String getNombreCompleto() {return nombreCompleto;}

    public void setNombreCompleto(String nombreCompleto) {this.nombreCompleto = nombreCompleto;}

    public String getSexo() {return sexo;}

    public void setSexo(String sexo) {this.sexo = sexo;}

    public int getDepartamento() {return departamento;}

    public void setDepartamento(int departamento) {this.departamento = departamento;}

    public int getCostoDocumentoEmitido() {return costoDocumentoEmitido;}

    public void setCostoDocumentoEmitido(int costoDocumentoEmitido) {this.costoDocumentoEmitido = costoDocumentoEmitido;}
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nroActa == null) ? 0 : nroActa.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ActaNacimiento other = (ActaNacimiento) obj;
        if (nroTomoLibro == null) {
            if (other.nroActa != null)
                return false;
            } else if (!nroActa.equals(other.nroActa))
                return false;
        
        if (nroActa == null) {
            if (other.nroActa != null)
                return false;
            } else if (!nroActa.equals(other.nroActa))
                return false;
            return true;
        }

    
}
