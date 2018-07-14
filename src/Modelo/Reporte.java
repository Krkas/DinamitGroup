package Modelo;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
* @Autor Chritian
* @Reparada por CarlosDraftx
*/
public abstract class Reporte {
 //   protected SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    protected Date fecha_li ;//(AÑO,MES,DIA)(los meses van de 0 a 11 y es mejor ponerlos así
    protected Date fecha_ls = new Date();
    protected SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    protected ArrayList<Trabajo> ListaTrab;
    protected ArrayList <Profesor> ListaProf;
    public Reporte() throws ParseException
    {        
        fecha_li = sdf.parse("01/01/2014");
        fecha_ls = sdf.parse(sdf.format(fecha_ls));       
    }
    public boolean esValido(String fecha_li,String fecha_ls) throws ParseException
    {
        boolean fli = true;
        boolean fls = true;
        Date fecha_li_aux = sdf.parse(fecha_li);
        Date fecha_ls_aux = sdf.parse(fecha_ls);
        if ( this.fecha_li.compareTo(fecha_li_aux)<=0)
            this.fecha_li = fecha_li_aux;
        else fli = false;
        if (this.fecha_ls.compareTo(fecha_ls_aux) >= 0)
            this.fecha_ls = fecha_ls_aux;
        else fls = false;
        return (fli && fls);        
    }
     public void setList(ArrayList<Trabajo> list)throws ParseException
    {
        Date fecha_trab;
        for(int i = 0 ; i < list.size(); i++)
        {
            fecha_trab = sdf.parse(list.get(i).getFechaDefensa());
            if(this.fecha_li.compareTo(fecha_trab)<=0 && this.fecha_ls.compareTo(fecha_trab) >= 0)
            {
                ListaTrab.add(list.get(i));
            }
        }
     }
}
