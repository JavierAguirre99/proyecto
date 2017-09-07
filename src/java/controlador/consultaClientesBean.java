
package controlador;

import dao.*;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.ConsultaClientes;

@ManagedBean
@ViewScoped
public class consultaClientesBean {
    private List<ConsultaClientes> lstpacientes;

    public List<ConsultaClientes> getLstpacientes() {
        return lstpacientes;
    }

    public void setLstpacientes(List<ConsultaClientes> lstpacientes) {
        this.lstpacientes = lstpacientes;
    }
    public void listar() throws Exception{
        consultaClientesDao dao = new consultaClientesDao();
        
        try{
            lstpacientes=dao.listar();
        }catch(Exception e){
            throw e;
        }
    }
}
