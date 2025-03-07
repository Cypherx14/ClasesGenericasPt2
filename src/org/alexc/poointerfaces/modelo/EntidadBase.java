package org.alexc.poointerfaces.modelo;

import java.util.Objects;

public class EntidadBase {
    protected Integer id;
    private static int ultimoId;

    public EntidadBase() {
        this.id = ++ultimoId;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EntidadBase eb = (EntidadBase) o;
        return Objects.equals(id, eb.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
