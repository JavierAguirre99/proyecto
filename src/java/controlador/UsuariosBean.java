
package controlador;



import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Usuarios;

@ManagedBean
@ViewScoped
public class UsuariosBean {
    private Usuarios empleado = new Usuarios();
    private List<Usuarios> Usuarios;
    
    public UsuariosBean() {
        
    }

    public Usuarios getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Usuarios empleado) {
        this.empleado = empleado;
    }

    public List<Usuarios> getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(List<Usuarios> Usuarios) {
        this.Usuarios = Usuarios;
    }
    

    
   
    
}
