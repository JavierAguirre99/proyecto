package controlador;

import dao.RenovacionDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.RenovacionContratos;

@ManagedBean
@ViewScoped
public class RenovacionBean {
    private RenovacionContratos contratos = new RenovacionContratos();
    private List<RenovacionContratos> lstContratos;

    public RenovacionContratos getContratos() {
        return contratos;
    }

    public void setContratos(RenovacionContratos contratos) {
        this.contratos = contratos;
    }

    public List<RenovacionContratos> getLstContratos() {
        return lstContratos;
    }

    public void setLstContratos(List<RenovacionContratos> lstContratos) {
        this.lstContratos = lstContratos;
    }
    
    public void listar() throws Exception{
        
        RenovacionDAO dao = new RenovacionDAO();
        
        try{        
            lstContratos=dao.listar(contratos);                        
        }catch(Exception e){
            System.out.println("Error en el BEAN");
            throw e;
        }
    }
    public void leerID(RenovacionContratos pac) throws Exception{
        RenovacionDAO dao;
        RenovacionContratos temp;
        try{
            
            dao = new RenovacionDAO();
            temp =dao.leerID(pac);
            
            if(temp != null){
                this.contratos = temp;
            }
            
        }catch(Exception e){
            throw e;
        }
      
    }
    public void modificar() throws Exception{
        RenovacionDAO dao;
        
        try{
            dao = new RenovacionDAO();
            dao.modificar(contratos);
            this.listar();
        }catch(Exception e){
            throw e;
        }
    }
}
