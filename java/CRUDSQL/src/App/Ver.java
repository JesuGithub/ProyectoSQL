/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author j2a0a
 */
public class Ver extends javax.swing.JFrame {
    public String nombre, cedula, fechaNacimiento, telefono, correo;
    public ImageIcon foto;

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon foto) {
        // Obtener la imagen del ImageIcon
        Image imagen = foto.getImage();

        // Obtener las dimensiones del JLabel destino
        int anchoDestino = jLabelFoto.getWidth();
        int altoDestino = jLabelFoto.getHeight();

        // Escalar 
        int altoImagen = imagen.getHeight(null);
        int anchoImagen = imagen.getWidth(null);
        
        double escalaAncho = (double) anchoDestino / anchoImagen;
        double escalaAlto = (double) altoDestino / altoImagen;
        
        double escala = Math.min(escalaAncho, escalaAlto);
        
        int anchoEscalado = (int) (anchoImagen * escala);
        int altoEscalado = (int) (altoImagen * escala);
                
        // Escalar la imagen al tamaño del JLabel destino
        Image imagenEscalada = imagen.getScaledInstance(anchoEscalado, altoEscalado, Image.SCALE_SMOOTH);

        // Crear un nuevo ImageIcon con la imagen escalada
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        
        this.foto = iconoEscalado;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = convertirFecha(fechaNacimiento);
        System.out.println(this.fechaNacimiento);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = formatearCedula(cedula);
    }

    public String getTelefono() {
        
        return telefono;
    }

    public void setTelefono(String telefono) {
        String primerosCuatroDigitos = telefono.substring(0, 4);

        // Obtener el resto del número telefónico (después de los primeros cuatro dígitos)
        String restoNumeroTelefono = telefono.substring(4);
        
        telefono = primerosCuatroDigitos + "-" + restoNumeroTelefono;
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    /**
     * Creates new form 
     */
    public Ver() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private String convertirFecha(String fecha) {
        try {
            // Formato de entrada
            DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            // Parsear la cadena de fecha a LocalDate
            LocalDate fechaLocal = LocalDate.parse(fecha, formatoEntrada);
            
            // Formato de salida
            DateTimeFormatter formatoSalida = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy");
            // Formatear la fecha en el formato deseado
            String fechaFormateada = fechaLocal.format(formatoSalida);
            
            return fechaFormateada;
        } catch (Exception e) {
            // Si hay un error al parsear la fecha, devuelve la cadena original
            return fecha;
        }
    }
    
    private String formatearCedula(String cedula){

        // Obtener la longitud total de la cadena
        int longitud = cedula.length();

        // Inicializar las partes de la cadena
        String terceraParte = "";
        String segundaParte = "";
        String primeraParte = "";

        // Determinar la posición de inicio de cada parte
        int inicioTercera = longitud - 3;
        int inicioSegunda = Math.max(inicioTercera - 3, 0);
        int inicioPrimera = 0;

        // Extraer las partes de la cadena
        terceraParte = cedula.substring(inicioTercera);
        if (inicioSegunda > 0) {
            segundaParte = cedula.substring(inicioSegunda, inicioTercera);
        }
        primeraParte = cedula.substring(inicioPrimera, inicioSegunda);
        
        cedula = primeraParte + "." + segundaParte + "." + terceraParte;
        return cedula;
    }
    
    public void colocar(){
        jLabelFoto.setIcon(foto);
        labelNombre.setText(nombre);
        labelFecha.setText(fechaNacimiento);
        labelCedula.setText(cedula);
        labelNumero.setText(telefono);
        labelCorreo.setText(correo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelFoto = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        labelNumero = new javax.swing.JLabel();
        labelCedula = new javax.swing.JLabel();
        labelCorreo = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabelFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelFotoMouseClicked(evt);
            }
        });

        labelFecha.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        labelFecha.setText("Fecha");

        labelNumero.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        labelNumero.setText("Cédula");

        labelCedula.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        labelCedula.setText("Teléfono");

        labelCorreo.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        labelCorreo.setText("Correo");

        labelTitulo.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        labelTitulo.setText("ESTUDIANTE");

        labelNombre.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        labelNombre.setText("Nombre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(labelTitulo)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFotoMouseClicked
       
    }//GEN-LAST:event_jLabelFotoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel labelCedula;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
