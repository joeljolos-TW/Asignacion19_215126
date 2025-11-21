package Model;

import org.bson.types.ObjectId;

public class Provider {
    private ObjectId id;

    private String nombre;
    private String contacto;
    private String pais;

    public Provider() {
    }

    public Provider(ObjectId id, String nombre, String contacto, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.pais = pais;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
