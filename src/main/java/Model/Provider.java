package Model;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.time.Instant;

public class Provider {
    private ObjectId id;

    private String nombre;
    private String contacto;
    private String pais;

    @BsonProperty("created_In")
    private Instant createdIn;

    @BsonProperty("updated_In")
    private Instant updatedIn;

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

    public Instant getCreatedIn() {
        return createdIn;
    }

    public void setCreatedIn(Instant createdIn) {
        this.createdIn = createdIn;
    }

    public Instant getUpdatedIn() {
        return updatedIn;
    }

    public void setUpdatedIn(Instant updatedIn) {
        this.updatedIn = updatedIn;
    }
}
