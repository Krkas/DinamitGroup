import Modelo.*;
import java.util.ArrayList;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ReporteProfesores extends Reporte {
    private boolean ord;
    //----------Constructor-------------------------
    public ReporteProfesores() throws ParseException
    {
        super();
        ord = false;
    }
    //-----------Metodos---------------------------
      public void Ordenar()
    {
        
    }
    public boolean existeProf(String ci_t1o2, ArrayList<Profesor> listado)
    {
        for(int index = 0; index < listado.size() ; index++)
        {
            if(listado.get(index).getCi().equalsIgnoreCase(ci_t1o2))
                return true;            
        }
        return false;
    }
}
