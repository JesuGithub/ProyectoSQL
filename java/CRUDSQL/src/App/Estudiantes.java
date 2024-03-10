/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
//import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;

/**
 *
 * @author j2a0a
 */
public class Estudiantes extends javax.swing.JFrame {
    InputStream fis;
    int longitud;
    ArrayList<Integer> listaIdEstudiantes;
    
    /**
     * Creates new form 
     */
    public Estudiantes() {
        initComponents();
        cargarTabla();
        estado(false);
   }
    
    private void cargarTabla(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tblEstudiantes.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        listaIdEstudiantes = new ArrayList<>();

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConexion();
            ps = con.prepareStatement(
                    "SELECT id, \"Nombre\", \"Apellido\", \"Cedula\" FROM public.\"TABLA_ESTUDIANTES\";"
            );

            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next()) {
                // Guardar el ID del estudiante en la lista
                int idEstudiante = rs.getInt("id");
                listaIdEstudiantes.add(idEstudiante);

                // Crear una fila para la tabla con los datos del estudiante, excluyendo el idEstudiante
                Object[] fila = new Object[columnas - 1]; // -1 para excluir el idEstudiante
                for (int indice = 0; indice < columnas - 1; indice++) {
                    fila[indice] = rs.getObject(indice + 2); // +2 para compensar el índice y excluir el idEstudiante
                }
                modeloTabla.addRow(fila);
            }
       } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void limpiar(){
        jLabelFoto.setIcon(null); jLabelFoto.updateUI();
        jTextFieldNombre.setText("");
        jTextFieldApellido.setText("");
        jTextFieldCedula.setText("");
        JDateFecha.setDate(null);
        jTextFieldTelefono.setText("");
        jTextFieldCorreo.setText("");
            
        estado(false);
        //btnModificar.setEnabled(false);
    }
    
    private void estado(boolean state){
        jButtonEditar.setEnabled(state);
        jButtonEliminar.setEnabled(state);
        jButtonVer.setEnabled(state);
    }
    
    private String estadoError(){
        // Expresión regular para validar un correo electrónico
        String regex = "^(.+)@(.+)\\.(.+)$";
        
        if(jLabelFoto.getIcon() == null){
            return "Imagen faltante";
        }
        else if("".equals(jTextFieldNombre.getText())){
            return "Nombre incompleto";
        }
        else if("".equals(jTextFieldApellido.getText())){
            return "Apellido incompleto";
        }
        else if("".equals(jTextFieldCedula.getText()) || jTextFieldCedula.getText().length() < 7){
            return "Cedula imcompleta";
        }
        else if("".equals(jTextFieldTelefono.getText()) || jTextFieldTelefono.getText().length() < 7){
            return "Numero incompleto";
        }
        else if("".equals(jTextFieldCorreo.getText()) || !jTextFieldCorreo.getText().matches(regex)){
            return "Correo incompleto";
        }
        else{
            return null;
        }
    }
    
            
    private boolean segundaCondicionError(){
        return estadoError() == null;
    }
    
    public static Image escalarImagen(BufferedImage imagen, int ancho, int alto) {
        int nuevaAnchura;
        int nuevaAltura;
        int imagenAncho = imagen.getWidth();
        int imagenAlto = imagen.getHeight();

        // Calcula la relación de aspecto para mantenerla
        double relacionAspecto = (double) imagenAncho / imagenAlto;

        // Calcula las nuevas dimensiones
        if (imagenAncho > imagenAlto) {
            nuevaAnchura = ancho;
            nuevaAltura = (int) (nuevaAnchura / relacionAspecto);
        } else {
            nuevaAltura = alto;
            nuevaAnchura = (int) (nuevaAltura * relacionAspecto);
        }

        // Escala la imagen manteniendo su relación de aspecto
        Image imagenEscalada = imagen.getScaledInstance(nuevaAnchura, nuevaAltura, Image.SCALE_SMOOTH);

        return imagenEscalada;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelClick = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jLabelCedula = new javax.swing.JLabel();
        jTextFieldCedula = new javax.swing.JTextField();
        jLabelFecha = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jComboBoxNumero = new javax.swing.JComboBox<>();
        jTextFieldTelefono = new javax.swing.JTextField();
        jLabelCorreo = new javax.swing.JLabel();
        jTextFieldCorreo = new javax.swing.JTextField();
        jLabelTitleTabla = new javax.swing.JLabel();
        jButtonGuardar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonVer = new javax.swing.JButton();
        JDateFecha = new com.toedter.calendar.JDateChooser();
        jLabelFoto = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEstudiantes = new javax.swing.JTable();
        jButtonEditar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelClick.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelClick.setText("Click aquí para insertar");
        getContentPane().add(jLabelClick, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 160, 20));

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitulo.setText("Estudiantes");
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelNombre.setText("Nombre");
        getContentPane().add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabelApellido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelApellido.setText("Apellido");
        getContentPane().add(jLabelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jTextFieldNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });
        jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombreKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 250, -1));

        jTextFieldApellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldApellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldApellidoMouseClicked(evt);
            }
        });
        jTextFieldApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidoActionPerformed(evt);
            }
        });
        jTextFieldApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldApellidoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 250, -1));

        jLabelCedula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCedula.setText("Cédula");
        getContentPane().add(jLabelCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jTextFieldCedula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCedulaActionPerformed(evt);
            }
        });
        jTextFieldCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCedulaKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 250, -1));

        jLabelFecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelFecha.setText("Fecha de nacimiento");
        getContentPane().add(jLabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabelTelefono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTelefono.setText("Teléfono móvil");
        getContentPane().add(jLabelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jComboBoxNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxNumero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0412", "0414", "0416", "0424", "0426" }));
        jComboBoxNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNumeroActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 70, -1));

        jTextFieldTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelefonoActionPerformed(evt);
            }
        });
        jTextFieldTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelefonoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 140, -1));

        jLabelCorreo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCorreo.setText("Correo electrónico");
        getContentPane().add(jLabelCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        jTextFieldCorreo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldCorreo.setText("examplename@example.com");
        jTextFieldCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldCorreoMouseClicked(evt);
            }
        });
        jTextFieldCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCorreoActionPerformed(evt);
            }
        });
        jTextFieldCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCorreoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 190, -1));

        jLabelTitleTabla.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTitleTabla.setText("Tabla de registros");
        getContentPane().add(jLabelTitleTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, -1, -1));

        jButtonGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        jButtonEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, -1, -1));

        jButtonVer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonVer.setText("Ver");
        jButtonVer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, -1, -1));

        JDateFecha.setDateFormatString("dd-MM-yyyy");
        getContentPane().add(JDateFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 167, -1));

        jLabelFoto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabelFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelFotoMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 160, 100));

        tblEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Cedula"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEstudiantes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblEstudiantes.setDragEnabled(true);
        tblEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEstudiantesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblEstudiantes);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 350, 340));

        jButtonEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, -1, -1));

        jButtonLimpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jTextFieldApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidoActionPerformed

    private void jTextFieldCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCedulaActionPerformed

    private void jComboBoxNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNumeroActionPerformed

    }//GEN-LAST:event_jComboBoxNumeroActionPerformed

    private void jTextFieldTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelefonoActionPerformed

    private void jTextFieldCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCorreoActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String nombre = jTextFieldNombre.getText();
        String apellido = jTextFieldApellido.getText();
        String cedula = jTextFieldCedula.getText();
        String fecha = null;
        try {
            fecha = dateFormat.format(JDateFecha.getDate());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El error se debe a que: la fecha está incorrecta", "error", JOptionPane.ERROR_MESSAGE);
            return; // Detiene la ejecución del método
        }
        String telefono = jComboBoxNumero.getSelectedItem() + jTextFieldTelefono.getText();
        String correo = jTextFieldCorreo.getText();
        
        if(segundaCondicionError()){
            try {
                Conexion conexion = new Conexion();
                Connection con = conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO public.\"TABLA_ESTUDIANTES\"(\n" +
                                "\"Foto\", \"Nombre\", \"Apellido\", \"Cedula\", \"Fecha\", \"Telefono\", \"Correo\")\n" +
                                "	VALUES (?, ?, ?, ?, ?, ?, ?);"
                );

                ps.setBinaryStream(1, fis, longitud);
                ps.setString(2, nombre);
                ps.setString(3, apellido);
                ps.setString(4, cedula);
                ps.setString(5, fecha);
                ps.setString(6, telefono);
                ps.setString(7, correo);
                ps.execute();
                ps.close();

                cargarTabla();
                JOptionPane.showMessageDialog(null, "¡Guardado exitosamente!");
                limpiar();
                //btnModificar.setEnabled(false);
                estado(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "El error se debe a que: " + estadoError(), "error", JOptionPane.ERROR_MESSAGE);
                System.out.println("Error al guardar: " + e.getMessage());
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El error se debe a que: " + estadoError(), "error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:
        int fila = tblEstudiantes.getSelectedRow();
        int id = listaIdEstudiantes.get(fila);
        
            
        try{
            Conexion conexion = new Conexion();
            Connection con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("DELETE FROM public.\"TABLA_ESTUDIANTES\" WHERE \"id\"=?");
                
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            
            cargarTabla();
            JOptionPane.showMessageDialog(null, "listoooooooooo");
            limpiar();
            //activar();
            estado(false);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerActionPerformed
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Ver ver = new Ver();
        ver.setFoto((ImageIcon)(jLabelFoto.getIcon()));
        ver.setNombre(jTextFieldNombre.getText() + " " + jTextFieldApellido.getText());
        ver.setFechaNacimiento((dateFormat.format(JDateFecha.getDate())));
        ver.setCedula(jTextFieldCedula.getText());
        ver.setTelefono(jComboBoxNumero.getSelectedItem() + jTextFieldTelefono.getText());
        ver.setCorreo(jTextFieldCorreo.getText());
        ver.colocar();
        ver.setVisible(true);
    }//GEN-LAST:event_jButtonVerActionPerformed

    private void jLabelFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFotoMouseClicked
        // TODO add your handling code here:
        jLabelFoto.setIcon(null);
        JFileChooser buscadorImagenes = new JFileChooser();
        buscadorImagenes.setFileSelectionMode(JFileChooser.FILES_ONLY);
        // Filtrar extensiones de imagen
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("IMÁGENES", "jpg", "jpeg", "png", "webp");
        buscadorImagenes.setFileFilter(filtro);
        int showOpenDialogue = buscadorImagenes.showOpenDialog(null);

        if(showOpenDialogue == JFileChooser.APPROVE_OPTION){
            try {
                fis = new FileInputStream(buscadorImagenes.getSelectedFile());
                this.longitud = (int) buscadorImagenes.getSelectedFile().length();
                try{
                    BufferedImage imagenOriginal = ImageIO.read(buscadorImagenes.getSelectedFile());
                    Image imagenEscalada = escalarImagen(imagenOriginal, jLabelFoto.getWidth(), jLabelFoto.getHeight());
                    jLabelFoto.setIcon(new ImageIcon(imagenEscalada));
                    jLabelFoto.updateUI();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Imagen: " + e.getMessage());
                }
            } 
            catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jLabelFotoMouseClicked

    private void tblEstudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEstudiantesMouseClicked
        // TODO add your handling code here:
        try{
            // Desactivar
            //desactivar();
            
            int fila = tblEstudiantes.getSelectedRow();
            int id = listaIdEstudiantes.get(fila);
            
            PreparedStatement ps;
            ResultSet rs;
            
            BufferedImage bi;
            ImageIcon foto;
            
            Conexion conexion = new Conexion();
            Connection con = conexion.getConexion();
            ps = con.prepareStatement("SELECT \"Foto\", \"Nombre\", \"Apellido\", \"Cedula\", \"Fecha\", \"Telefono\", \"Correo\" FROM public.\"TABLA_ESTUDIANTES\" WHERE \"id\"=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                // Obtener los datos de la imagen del ResultSet
                InputStream inputStream = rs.getBinaryStream("foto");

                // Convertir la imagen en un array de bytes
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    baos.write(buffer, 0, bytesRead);
                }
                byte[] imagenBytes = baos.toByteArray();

                // Obtener la longitud de bytes de la imagen
                int longitudBytes = imagenBytes.length;

                bi = ImageIO.read(new ByteArrayInputStream(imagenBytes));

                foto = new ImageIcon(bi);

                Image img = foto.getImage();
                Image newImg = img.getScaledInstance(jLabelFoto.getWidth(), jLabelFoto.getHeight(), java.awt.Image.SCALE_SMOOTH);

                ImageIcon newIcon = new ImageIcon(newImg);

                // Establecer la imagen en el JLabel
                jLabelFoto.setIcon(newIcon);
                
                // Nombre
                jTextFieldNombre.setText(rs.getString("nombre"));
                
                // Apellido
                jTextFieldApellido.setText(rs.getString("apellido"));
                
                // Cedula
                String cedulaCompleta = rs.getString("cedula");
                //cedulaCompleta = cedulaCompleta.replace(".", "");
                
                jTextFieldCedula.setText(cedulaCompleta);
                
                // Fecha
                String fechaStr = rs.getString("fecha");
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                Date fecha = formato.parse(fechaStr);
                JDateFecha.setDate(fecha);
                
                // Telefono
                String numeroTelefonoCompleto = rs.getString("telefono");

                // Obtener los primeros cuatro dígitos del número telefónico
                String primerosCuatroDigitos = numeroTelefonoCompleto.substring(0, 4);

                // Obtener el resto del número telefónico (después de los primeros cuatro dígitos)
                String restoNumeroTelefono = numeroTelefonoCompleto.substring(4);
                
                // Establecer los primeros cuatro dígitos en el JComboBox
                jComboBoxNumero.setSelectedItem(primerosCuatroDigitos); // Establecer la selección en los primeros cuatro dígitos

                // Establecer el resto del número telefónico en el JTextField
                jTextFieldTelefono.setText(restoNumeroTelefono);

                // Correo
                jTextFieldCorreo.setText(rs.getString("correo"));
                
                fis = new ByteArrayInputStream(imagenBytes);
                this.longitud = longitudBytes;
                
                jButtonEliminar.setEnabled(true);
                jButtonEditar.setEnabled(true);
                jButtonVer.setEnabled(true);
            }
        }
        catch(Exception e){
            System.out.println(e);;
        }
    }//GEN-LAST:event_tblEstudiantesMouseClicked

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
        if(segundaCondicionError()){
            try {
                int fila = tblEstudiantes.getSelectedRow();
                int id = listaIdEstudiantes.get(fila);

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String nombre = jTextFieldNombre.getText();
                String apellido = jTextFieldApellido.getText();
                String cedula = jTextFieldCedula.getText();
                String fecha = dateFormat.format(JDateFecha.getDate());
                String telefono = jComboBoxNumero.getSelectedItem() + jTextFieldTelefono.getText();
                String correo = jTextFieldCorreo.getText();

                // Establece la conexión con la base de datos
                Conexion conexion = new Conexion();
                Connection con = conexion.getConexion();

                // Prepara la consulta de actualización excluyendo la columna "idEstudiante"
                PreparedStatement ps = con.prepareStatement("UPDATE public.\"TABLA_ESTUDIANTES\" SET \"Foto\"=?, \"Nombre\"=?, \"Apellido\"=?, \"Cedula\"=?, \"Fecha\"=?, \"Telefono\"=?, \"Correo\"=? WHERE \"id\"=?");
                ps.setBinaryStream(1, fis, longitud);
                ps.setString(2, nombre);
                ps.setString(3, apellido);
                ps.setString(4, cedula);
                ps.setString(5, fecha);
                ps.setString(6, telefono);
                ps.setString(7, correo);
                ps.setInt(8, id);

                // Ejecuta la consulta
                ps.executeUpdate();
                ps.close();

                // Actualiza la tabla y muestra un mensaje de éxito
                cargarTabla();
                JOptionPane.showMessageDialog(null, "¡Modificación exitosa!");
                limpiar();
                estado(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "El error se debe a que: " + estadoError(), "error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El error se debe a que: " + estadoError(), "error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jTextFieldCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldCorreoMouseClicked
        // TODO add your handling code here:
        if("examplename@example.com".equals(jTextFieldCorreo.getText())){
            jTextFieldCorreo.setText("");
        }
        
    }//GEN-LAST:event_jTextFieldCorreoMouseClicked

    private void jTextFieldCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCedulaKeyTyped
        // TODO add your handling code here:
        int teclaPulsada = evt.getKeyChar();
        boolean numero = teclaPulsada >= '0' && teclaPulsada <= '9';
        if(!numero) evt.consume();
        
        char tecla = evt.getKeyChar();
        JTextField entry = (JTextField) evt.getSource();
        String textoActual = entry.getText();

        // Verificar si el primer caracter es del 4 al 9
        if (textoActual.isEmpty()) {
            if (tecla >= '4' && tecla <= '9') {
                // Permitir solo 7 caracteres si el primer caracter es del 4 al 9
                if (textoActual.length() >= 7) {
                    evt.consume();
                    return;
                }
            } else if (tecla >= '1' && tecla <= '3') {
                // Permitir solo 8 caracteres si el primer caracter es del 1 al 3
                if (textoActual.length() >= 8) {
                    evt.consume();
                    return;
                }
            }
        } else {
            // Permitir solo números después del primer carácter
            if (!Character.isDigit(tecla)) {
                evt.consume();
                return;
            }

            // Permitir 7 caracteres si el primer caracter es del 4 al 9
            // Permitir 8 caracteres si el primer caracter es del 1 al 3
            if ((textoActual.charAt(0) >= '4' && textoActual.charAt(0) <= '9' && textoActual.length() >= 7) ||
                (textoActual.charAt(0) >= '1' && textoActual.charAt(0) <= '3' && textoActual.length() >= 8)) {
                evt.consume();
                return;
            }
        }
    }//GEN-LAST:event_jTextFieldCedulaKeyTyped

    private void jTextFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreKeyTyped
        // TODO add your handling code here:
        JTextComponent c = (JTextComponent) evt.getSource();
        int tecla = evt.getKeyChar();
        char ch = evt.getKeyChar();
        
        boolean numero = tecla > 95 && tecla < 122;
        boolean espacio = tecla == 32;
        JTextField entry = ((JTextField) (evt.getSource()));
        boolean primeraLetra = "".equals(entry.getText());
        if(primeraLetra){
            if(Character.isLowerCase(ch) == false){
                return;
            }
            try{
                c.getDocument().insertString(c.getCaretPosition(), "" + Character.toUpperCase(ch), null);
                evt.consume();
            }
            catch(BadLocationException e){

            }
        }
        boolean longitudBooleana = entry.getText().length() >= 20;
        if(!numero || longitudBooleana || espacio) evt.consume();
    }//GEN-LAST:event_jTextFieldNombreKeyTyped

    private void jTextFieldTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoKeyTyped
        // TODO add your handling code here:
        int tecla = evt.getKeyChar();
        boolean numero = tecla >= '0' && tecla <= '9';
        JTextField entry = ((JTextField) (evt.getSource()));
        boolean longitudBooleana = entry.getText().length() >= 7;
        if(!numero || longitudBooleana) evt.consume();
    }//GEN-LAST:event_jTextFieldTelefonoKeyTyped

    private void jTextFieldApellidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldApellidoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidoMouseClicked

    private void jTextFieldApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidoKeyTyped
        // TODO add your handling code here:
        // TODO add your handling code here:
        JTextComponent c = (JTextComponent) evt.getSource();
        int tecla = evt.getKeyChar();
        char ch = evt.getKeyChar();
        
        boolean numero = tecla > 95 && tecla < 122;
        boolean espacio = tecla == 32;
        JTextField entry = ((JTextField) (evt.getSource()));
        boolean primeraLetra = "".equals(entry.getText());
        if(primeraLetra){
            if(Character.isLowerCase(ch) == false){
                return;
            }
            try{
                c.getDocument().insertString(c.getCaretPosition(), "" + Character.toUpperCase(ch), null);
                evt.consume();
            }
            catch(BadLocationException e){

            }
        }
        boolean longitudBooleana = entry.getText().length() >= 20;
        if(!numero || longitudBooleana || espacio) evt.consume();
    }//GEN-LAST:event_jTextFieldApellidoKeyTyped

    private void jTextFieldCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCorreoKeyTyped
        // TODO add your handling code here:
        int tecla = evt.getKeyChar();
        boolean numero = tecla == 32;
        if(numero) evt.consume();
    }//GEN-LAST:event_jTextFieldCorreoKeyTyped

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
            java.util.logging.Logger.getLogger(Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estudiantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JDateFecha;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonVer;
    private javax.swing.JComboBox<String> jComboBoxNumero;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelCedula;
    private javax.swing.JLabel jLabelClick;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTitleTabla;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldCedula;
    private javax.swing.JTextField jTextFieldCorreo;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTelefono;
    private javax.swing.JTable tblEstudiantes;
    // End of variables declaration//GEN-END:variables
}
