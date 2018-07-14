/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Ctrl_Reportes;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;


public class IConsultarTrabajos extends javax.swing.JFrame {
    private Ctrl_Reportes CTRL;
    /**
     * Creates new form IConsultarTrabajos
     * @param r
     */
    public IConsultarTrabajos(Ctrl_Reportes r) {
        CTRL = r;
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        comboProfesores = new javax.swing.JList<>();
        Consultar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaTrabajos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Trabajos por Profesor");
        setResizable(false);

        jLabel1.setText("Seleccionar Profesor");

        jScrollPane1.setViewportView(comboProfesores);

        Consultar.setText("Consultar");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        listaTrabajos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Nivel", "Autores", "Fecha"
            }
        ));
        jScrollPane2.setViewportView(listaTrabajos);
        if (listaTrabajos.getColumnModel().getColumnCount() > 0) {
            listaTrabajos.getColumnModel().getColumn(0).setPreferredWidth(270);
            listaTrabajos.getColumnModel().getColumn(2).setPreferredWidth(280);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(volver, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Consultar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Consultar)
                        .addGap(54, 54, 54)
                        .addComponent(volver)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {                                       
       CTRL.volver();
    }                                      

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {                                          
//borrar contenido de tabla
DefaultTableModel tabl = (DefaultTableModel)listaTrabajos.getModel();
int filas = listaTrabajos.getModel().getRowCount();
for(int i=1; i <= filas; ++i)  {
    tabl.removeRow(0);
}
//extraer cedula
        String cadena = (String)comboProfesores.getSelectedValue();
         if(cadena == null) {
            return;
        }
        String ci;
        int li=0, ls=1;
        while(cadena.charAt(li) != '/') {li++;}
        li++;
        while(cadena.charAt(ls) != '.') {ls++;}
        ci = cadena.substring(li, ls);
        CTRL.i_Consultar_Trab(ci);
    }                                         

    public void iniciarOpciones(DefaultListModel modelo) {
        comboProfesores.setModel(modelo);  
    }
    
    public void agregarFila(String f1, String f2, String f3, String f4) {
        DefaultTableModel tabla = (DefaultTableModel)listaTrabajos.getModel();
        tabla.addRow(new Object[]{
            f1, f2, f3, f4
        });
    }
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton Consultar;
    private javax.swing.JList<String> comboProfesores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable listaTrabajos;
    private javax.swing.JButton volver;
    // End of variables declaration                   
}
