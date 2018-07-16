package Controlador;
import Modelo.ConjuntoProfesores;
import Modelo.ConjuntoTrabajos;
import Modelo.Profesor;
import Modelo.Trabajo;
import Modelo.ReporteCentros;
import Modelo.ReportePostgrados;
import Modelo.ReporteProfesores;
import java.io.*;
import Vista.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;

import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;


public class Ctrl_Reportes {
    
    private static final Ctrl_Reportes INSTANCE = new Ctrl_Reportes(); //Clase Singleton
    
    public static Ctrl_Reportes getInstance() {
        return INSTANCE;
    }
    //Instancias de ConjuntoTrabajos y ConjuntoProfesores--------
    private ConjuntoProfesores cp; 
    private ConjuntoTrabajos ct;
    //Instancias de Reportes menos la de consultar, q falta.
    private ReporteProfesores RePro;
    private ReportePostgrados RePost;
    private ReporteCentros ReCentros;
    //-----------------------------------------------------------
    
    //atributos de interfaces graficas
    private final IMenu IMen;  //Instancia de Imenu
    private final ISelectUser ISelectUs; //Instancia de seleccion de usuario
    private ICargarProfesores ICargarProf; // Instancia de Cargar Profesores
    private final ICargarTrabajos ICargarTrab; //Instancia de Cargar trabajos
    private IConsultarTrabajos IConsultarTrab; //Instancia de Iconsultar
    private I_Profesores_Postgrado IReportarPost;  //Instacia de Reportar Postrgrado
    private I_Reportar_Profesores IReportarProf; //Instancia de IReportarProf
    private I_Reportar_Centros IReportarCentro; //Instancia de Reportar Centros
    private JFrame ventanaAnterior; //Te permite retroceder la ventana
    
    public void ocultarTodo() {
        IMen.setVisible(false);
        ISelectUs.setVisible(false);
        
        ICargarProf.setVisible(false);
        IConsultarTrab.setVisible(false);
    }
    
    //MENU e ISelectUser
    public void i_Menu() {
        ocultarTodo();
        IMen.setVisible(true);
    }
    
    public void ventanaAnterior(int tipoUser) { //1 es comision
        if(tipoUser == 1) {
            ventanaAnterior = IMen;
        } else if(tipoUser == 0 ) {
            ventanaAnterior = ISelectUs;
        }
    }
    
    public ConjuntoTrabajos  get_Inst_CT (){
        return ct;
    }
    
    public ConjuntoProfesores get_Inst_CP (){
        return cp;
    }
    
    public void volver() {
        ocultarTodo();
        ventanaAnterior.setVisible(true);   
    }
    
    public void i_SelectUser() {
        ocultarTodo();
        ISelectUs.setVisible(true);
    }
    
    public boolean Hay_Conjuntos (){ //Identifica si ya fueron cargados los trabajos y los profesores
        if(ct == null || cp == null) {
            return false;
        } 
        return (ct.getListado() != null) && (cp.getListado() != null);
    }
        
    
    
    //METODOS DE LA CLASE CONTROLADORA
    public int i_copiar_archivo_prof(String dir) {
        String linea;
        cp = new ConjuntoProfesores();  //Prueba de carga de profesores en esta estructura
        Profesor P;
        
       try {
            FileReader fr = new FileReader(dir);
            BufferedReader br = new BufferedReader(fr);
                   
            while((linea = br.readLine()) != null && linea.equals("EOF") == false) {
                System.out.println("se ha leido la linea "+linea);
                
                P = new Profesor();
                P.llenarCampos(linea);
                cp.agregar(P);              
            }    
        } catch(Exception e) {
            return 0;
        } finally {} 
        return cp.getTotal();
    }
    
     public int i_copiar_archivo_trab(String dir) {
        String linea;
        ct = new ConjuntoTrabajos();        
        try {
            FileReader fr = new FileReader(dir);
            BufferedReader br = new BufferedReader(fr);
            while((linea = br.readLine()) != null && linea.equals("EOF") == false) {
                System.out.println("se ha leido la linea "+linea);
                
                Trabajo T = new Trabajo();
                if (T.llenarCampos(linea) == -1) {
                  throw new IOException();  
                }
                ct.agregar(T);
            }
            
        } catch(IOException e) {
             return 0;
        } finally {} 
        return ct.getTotal();
}
    
        private Ctrl_Reportes() {                                       //Constructor
        ICargarProf = new ICargarProfesores(this);
        ICargarTrab = new ICargarTrabajos(this);
        IReportarProf = null;
        IReportarCentro = null;
        IReportarPost = null;
        IMen = new IMenu(this);
        ISelectUs = new ISelectUser(this);
        IConsultarTrab = new IConsultarTrabajos(this);
        activarOpcionesReportesDeMenu(false);
    } 
        
    //METODOS DE INTERFACES
    public void i_CargarProfesores() {
        if(ICargarProf == null) {
            ICargarProf = new ICargarProfesores(this);
        }   
        ICargarProf.setVisible(true);
    }
    
    public void i_CargarTrabajos() {
        ICargarTrab.setVisible(true);
    }
    
    public void i_Reporte_Profesores(){
        if(IReportarProf == null){
            IReportarProf = new I_Reportar_Profesores(this);
        }
        IReportarProf.setVisible(true);
    }
    
    public void i_ReportePostgrados() {
        if(IReportarPost == null) {
            IReportarPost = new I_Profesores_Postgrado(this);
        }
        IReportarPost.setVisible(true);
    }
    
    //uc6
    public void i_ConsultarTrabajos() {
        if(IConsultarTrab == null) {
            IConsultarTrab = new IConsultarTrabajos(this);
        }
        
        //preparar lista de opciones (comboProfesores) para el cliente
        DefaultListModel modelo = new DefaultListModel();
         
        Iterator<Profesor> I = cp.getListado().iterator();
        Profesor p;
         p = I.next();
        while(I.hasNext()) {
          
            modelo.addElement(p.getNombre()+" "+p.getApellido()+" /"+p.getCi()+".");
              p = I.next();
        }
        
        
        IConsultarTrab.iniciarOpciones(modelo);
        IConsultarTrab.setVisible(true);
    }
    
    public void activarOpcionesReportesDeMenu(boolean f){ // Activa/Desactiva botones de Imenu
        
        IMen.activarPostgrados(f);
        IMen.activarRepProfesor(f);
        IMen.activarConsultar(f); 
        IMen.activarCentro(f);
        
    }
    
    //METODOS DE REPORTES
    public boolean Es_Valido(Date Fecha_Periodo) throws ParseException{//para ver si la fecha del trabajo está dentro del período
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//definiendo el formato de dato
        
        Date Fecha_Minima = sdf.parse("01/02/2014"); //Fecha Tope
        Date Fecha_Actual = new Date(); //Fecha Actual
        
        if( Fecha_Periodo.after(Fecha_Minima) && Fecha_Periodo.before(Fecha_Actual) ) //Si esta en el rango
            return true;
        
        else if( Fecha_Periodo.equals(Fecha_Minima) )
            return true;
        
        else if( Fecha_Periodo.equals(Fecha_Actual) )
            return true;
        
        return false;
        
    }
  //Reportar Trabajos Profesores  
  public void i_Consultar_Prof(Date fech_li,Date fech_ls,int ord) throws ParseException{
       //-------------Instancia--------------
        RePro= new ReporteProfesores();
       //------------------------------------
         //para que solo lo haga una vez por carga de trabajos y profesores
         
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

             Date Fecha_Minima = sdf.parse("01/02/2014"); //Fecha mínima
             Date Fecha_Actual = new Date(); //Fecha Actual

             Date Fecha_Inicial = null; //Para almacenar las fechas a tomar
             Date Fecha_Final = null; //Para almacenar las fechas a tomar
               
             if( fech_li == null) //si la fecha inferior del periodo esta vacia, poner en ella la fecha minima
                 fech_li = Fecha_Minima;

             if( fech_ls == null) //Si la fecha superior del periodo esta vacia, poner en ella la fecha actual
                 fech_ls = Fecha_Actual;

             if( !Es_Valido(fech_li) ){ //Si la fecha inferior del periodo esta fuera de los valores limites
                 //System.out.println("entro al !Esvalido");
                 if( fech_li.before(Fecha_Minima) ) //si esta antes que la fecha m¡Minima, poner la fecha Minima
                     Fecha_Inicial = Fecha_Minima;

                 else if( fech_li.after(Fecha_Actual) ) //si esta despues de la fecha Actual, poner la fecha actual
                     Fecha_Inicial = Fecha_Actual;
             }
             else
                 Fecha_Inicial = fech_li;

             if( !Es_Valido(fech_ls) ){// si la fecha superior del periodo NO esta dentro del rango

                 if( fech_ls.before(Fecha_Minima) )//si esta antes de la fecha minima fecha Final = fecha Minima
                     Fecha_Final = Fecha_Minima;

                 else if( fech_ls.after(Fecha_Actual)) //si esta despues de la fecha actual fecha final= fecha actual
                     Fecha_Final = Fecha_Actual;
             }else{
                 Fecha_Final = fech_ls;
             }

            //--------------------------
            boolean Evita_add_2vecesTrab; // Evita q un trabajo se agregue dos veces
            //--------------------------
            Date fechaDefensa;
            for(int k=0; k<cp.getListado().size(); k++){
                RePro.listarProf(cp.getListado().get(k));
            }
                for (int i=0; i < ct.getListado().size(); i++){ //Para cada Trabajo para sumar los trabajos
                //-------------------
               // System.out.println("entro al for "+i+" veces");
                //....................Agarra la fecha.....................
                    fechaDefensa = sdf.parse(ct.getListado().get(i).getFechaDefensa());
                //q solo lo haga una vez por carga de trabajos y profesores
                    if(fechaDefensa.before(fech_ls) && fechaDefensa.after(fech_li)){
                         if(RePro.existeProf(ct.getListado().get(i).getCi_t(), RePro.getListaProf())){ //si el tutor es de la escuela
                             
                             for(int j=0; j<RePro.getListaProf().size() ;j++){ //encotrar profesor y sumarle 1 a su cant_Trab
                                 if(RePro.getListaProf().get(j).getCi().equals(ct.getListado().get(i).getCi_t()) ){
                                     RePro.getListaProf().get(j).setCant_Trab(RePro.getListaProf().get(j).getCantTrab() + 1);
                                     break;
                                 }
                             }
                         }
                         if(RePro.existeProf(ct.getListado().get(i).getCi_t2(), RePro.getListaProf())){ //
                             // if(Evita_add_2vecesTrab = false){
                             //   RePro.getListaTrab().add(ct.getListado().get(i));
                             //}
                            for(int j=0; j<RePro.getListaProf().size() ;j++){ //encotrar profesor y sumarle 1 a su cant_Trab
                                if(RePro.getListaProf().get(j).getCi().equals(ct.getListado().get(i).getCi_t2()) ){
                                    RePro.getListaProf().get(j).setCant_Trab(RePro.getListaProf().get(j).getCantTrab() + 1);
                                    break;
                                }
                            }
                        }
                    }
                }

                       
        RePro.ordenar(ord);
       
        ArrayList<Profesor> P=RePro.getListaProf();
       
        String[][] matriz1= new String[P.size()][2]; 
        
        for(int l=0; l<P.size() ;l++){ //for para ListaProf                  
            //if(ord==0){
            // posicion izquierda                                                 Posicion derecha
             matriz1[l][0]=P.get(l).getApellido()+" "+P.get(l).getNombre() ; matriz1[l][1]= Integer.toString(P.get(l).getCantTrab());
            //}else if(ord==1){
                
           // }
            
               
        }IReportarProf.agregarMatriz(matriz1);
        System.out.println("terminó");
        
    }
    
    /*

        //Reportar Trabajos Centros
    public void i_Consultar_Cent(String centro, Date fech_li, Date fech_ls) {
           
        for(int i=0;i<Size(ConjuntoTrabajos);i++){
        if(Trabajo.getfechaDefensa() <= fech_ls ^ Trabajo.getFechaDefensa() >= fech_li)
            if(PerteneceMismoCentro(centro, ConjuntoTrabajos.listado[i].getCi_t1,ConjuntoTrabajos.listado[i].getCi_t2)){ 
                ReporteCentros.lista.Centro.add();
            }else{
                ReporteCentros.lista.Centro1.add();
                ReporteCentros.lista.Centro2.add()
            }
                    
        }
        desplegar(ReporteCentros)
    }
    
    public boolean PerteneceMismoCentro(String centro,int c1, int c2){
        for(int i=0; i<co.getSize(); i++){
            if (cp[i].getCi()== c1 || cp[i].getCi()== c2){
                if(cp[i].getCentro()==centro)
                    return true;
            }
        }
        return false;
     }
    }
    
        //
    
       //Conusltar Postgrados
    */
     public void i_Consultar_Post(String fecha_li, String fecha_ls) {
         
         
     }
    
        //Consultar Trabajos profesores
    public void i_Consultar_Trab(String ci_prof) {
      
        Trabajo t;
        Iterator<Trabajo> Ind = ct.getListado().iterator();
        t = Ind.next();
        while(Ind.hasNext()) {      
            System.out.println(ci_prof+" es igual a"+t.getCi_t()+" o"+t.getCi_t2()+"?");
            if(ci_prof.equals(t.getCi_t()) || ci_prof.equals(t.getCi_t2()) ||ci_prof.equals(t.getCi())) {
                  IConsultarTrab.agregarFila(t.getTitulo(), t.getNivel(), t.getAutor1()+" - " +t.getAutor2(), t.getFechaDefensa());
            }
            t = Ind.next();
        }
      
       
    }
      
}
