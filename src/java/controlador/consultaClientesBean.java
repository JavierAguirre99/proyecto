
package controlador;

import dao.*;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.ConsultaClientes;

@ManagedBean
@ViewScoped
public class consultaClientesBean {
  private ConsultaClientes cli=new ConsultaClientes();

  public ConsultaClientes getCli() {
    return cli;
  }

  public void setCli(ConsultaClientes cli) {
    this.cli = cli;
  }
  
    private List<ConsultaClientes> lstclientes;

  public List<ConsultaClientes> getLstclientes() {
    return lstclientes;
  }

  public void setLstclientes(List<ConsultaClientes> lstclientes) {
    this.lstclientes = lstclientes;
  }

    
    
    public void listar() throws Exception{
        consultaClientesDao dao = new consultaClientesDao();
        
        try{
            lstclientes=dao.listar(cli);
        }catch(Exception e){
            throw e;
        }
    }
}
