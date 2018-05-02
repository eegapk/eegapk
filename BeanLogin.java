package net.itss.kahm.eegappv3;

/**
 * Created by katerina Hurtado on 3/22/2018.
 */

public class BeanLogin {

    protected String User;
    protected String Clave;
    protected int id;
    protected String tipo_user;

    public BeanLogin(String user, String clave, int id, String tipo_user) {
        User = user;
        Clave = clave;
        this.id = id;
        this.tipo_user = tipo_user;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(String tipo_user) {
        this.tipo_user = tipo_user;
    }
}
