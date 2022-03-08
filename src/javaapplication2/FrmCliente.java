/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class FrmCliente extends javax.swing.JFrame implements ItfFrmCliente {

    public FrmCliente() {
        initComponents();
    }

    @Override
    public void carga() {
        this.getContentPane().setBackground(Color.WHITE);
        txtidcliente.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtidcliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnombres = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtapellidos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");
        setEnabled(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("IdCliente:");
        jLabel1.setDoubleBuffered(true);

        txtidcliente.setEditable(false);
        txtidcliente.setText("0");
        txtidcliente.setDoubleBuffered(true);
        txtidcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidclienteKeyTyped(evt);
            }
        });

        jLabel2.setText("Cedula:");
        jLabel2.setDoubleBuffered(true);

        txtcedula.setDoubleBuffered(true);
        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });

        jLabel3.setText("Nombres:");
        jLabel3.setDoubleBuffered(true);

        txtnombres.setDoubleBuffered(true);
        txtnombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombresKeyTyped(evt);
            }
        });

        jLabel4.setText("Apellidos:");
        jLabel4.setDoubleBuffered(true);

        txtapellidos.setDoubleBuffered(true);
        txtapellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidosKeyTyped(evt);
            }
        });

        jLabel5.setText("Correo:");
        jLabel5.setDoubleBuffered(true);

        txtcorreo.setDoubleBuffered(true);
        txtcorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcorreoFocusLost(evt);
            }
        });

        jLabel6.setText("Telefono:");
        jLabel6.setDoubleBuffered(true);

        txttelefono.setDoubleBuffered(true);
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save_78348.png"))); // NOI18N
        jButton1.setText("Registrar");
        jButton1.setDoubleBuffered(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/garbage_78344.png"))); // NOI18N
        jButton2.setText("Eliminar");
        jButton2.setDoubleBuffered(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/minimize_78340.png"))); // NOI18N
        jButton3.setText("Actualizar");
        jButton3.setDoubleBuffered(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/loupe_78347.png"))); // NOI18N
        jButton4.setText("Buscar");
        jButton4.setToolTipText("se buscara los datos del cliente a partir de la cedula");
        jButton4.setDoubleBuffered(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cashregister_106599.png"))); // NOI18N
        jButton5.setText("Ventas");
        jButton5.setToolTipText("se enviara la cedula cargada del cliente");
        jButton5.setDoubleBuffered(true);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton4))
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Cliente cl = new Cliente();
        if (Integer.parseInt(txtidcliente.getText()) == 0) {
            cl.setIdcliente(Integer.parseInt(txtidcliente.getText()));
            cl.setCedula(txtcedula.getText());
            cl.setCorreo(txtcorreo.getText());
            cl.setNombres(txtnombres.getText());
            cl.setApellidos(txtapellidos.getText());
            cl.setTelefono(txttelefono.getText());
            cl.start();
            ClaseMensaje.miMensajeAprovado();
            txtcedula.setText("");
            txtcorreo.setText("");
            txtnombres.setText("");
            txtapellidos.setText("");
            txttelefono.setText("");
            txtidcliente.setText("0");
        } else {
            ClaseMensaje.miMensajeError();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Cliente cl = new Cliente();
        if (Integer.parseInt(txtidcliente.getText()) > 0) {
            cl.setIdcliente(Integer.parseInt(txtidcliente.getText()));
            cl.start();
            ClaseMensaje.miMensajeEliminado();
            txtidcliente.setText("0");
            txtcedula.setText("");
            txtcorreo.setText("");
            txtnombres.setText("");
            txtapellidos.setText("");
            txttelefono.setText("");
        } else {
            ClaseMensaje.miMensajeError();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Cliente cl = new Cliente();
        if (Integer.parseInt(txtidcliente.getText()) > 0) {
            cl.setIdcliente(Integer.parseInt(txtidcliente.getText()));
            cl.setCedula(txtcedula.getText());
            cl.setCorreo(txtcorreo.getText());
            cl.setNombres(txtnombres.getText());
            cl.setApellidos(txtapellidos.getText());
            cl.setTelefono(txttelefono.getText());
            cl.start();
            ClaseMensaje.miMensajeActualizado();
            txtcedula.setText("");
            txtcorreo.setText("");
            txtnombres.setText("");
            txtapellidos.setText("");
            txttelefono.setText("");
            txtidcliente.setText("0");
        } else {
            ClaseMensaje.miMensajeError();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        BuscarCliente bc = new BuscarCliente();
        bc.start();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
        // TODO add your handling code here:
        evalnum(evt);
    }//GEN-LAST:event_txtcedulaKeyTyped

    private void txtapellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidosKeyTyped
        // TODO add your handling code here:
        evaltext(evt);
    }//GEN-LAST:event_txtapellidosKeyTyped

    private void txtnombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombresKeyTyped
        // TODO add your handling code here:
        evaltext(evt);
    }//GEN-LAST:event_txtnombresKeyTyped

    private void txtcorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcorreoFocusLost
        // TODO add your handling code here:
        if (!isEmail(txtcorreo.getText())) {
            JOptionPane.showMessageDialog(null, "¡Debes validar el email!", "ATENCIÓN ", JOptionPane.WARNING_MESSAGE);
            txtcorreo.requestFocus();
        }
    }//GEN-LAST:event_txtcorreoFocusLost

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        // TODO add your handling code here:
        evalnum(evt);
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String cedula = (String) txtcedula.getText();
        Preferences preferences = Preferences.userNodeForPackage(Preferences.class);
        preferences.put("cproducto2", cedula);

        if ("".equals(cedula)) {
            JOptionPane.showMessageDialog(null, "el cliente debe ser selecionado", "advertencia", 2);
        } else {
            this.setVisible(false);
            this.setEnabled(false);
            FrmVentas er = new FrmVentas();
            er.setEnabled(true);
            er.setVisible(true);

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtidclienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidclienteKeyTyped
        // TODO add your handling code here:
        evalnum(evt);
    }//GEN-LAST:event_txtidclienteKeyTyped

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        FrmPrincipal frd = new FrmPrincipal();
        frd.setEnabled(true);
        frd.setVisible(true);
        this.setEnabled(false);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosed

    @Override
    public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void evalnum(java.awt.event.KeyEvent tyea) {
        char c = tyea.getKeyChar();
        if ((c < '0' || c > '9')) {
            tyea.consume();
        }
    }

    @Override
    public void evaltext(java.awt.event.KeyEvent tyea) {
        char c = tyea.getKeyChar();
        if ((c < 'A' || c > 'Z') & (c < 'a' || c > 'z') & (c < ' ' || c > ' ')) {
            tyea.consume();
        }
    }

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
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtidcliente;
    private javax.swing.JTextField txtnombres;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
private interface ItfBuscarCliente {
        void run();
    }

    private class BuscarCliente extends Thread implements ItfBuscarCliente {

        @Override
        public void run() {
            Md5 desencrip = new Md5();
            String cript = desencrip.getEncoddedString(txtcedula.getText());
            if (Basededatos.conectar() != null) {
                String sql = "Select * from cliente where cedula ='" + cript + "'";

                try {
                    Statement ps = Basededatos.conn.createStatement();
                    ResultSet rs = ps.executeQuery(sql);
                    if (rs.next()) {
                        txtidcliente.setText(String.valueOf(rs.getInt("idcliente")));
                        txtcorreo.setText(rs.getString("correo"));
                        txtnombres.setText(rs.getString("nombres"));
                        txtapellidos.setText(rs.getString("apellidos"));
                        txttelefono.setText(rs.getString("telefono"));
                    } else {
                        ClaseMensaje.miMensajeNoEncontrado();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
                    ClaseMensaje.miMensajeError();
                }

            }
            try {
                this.stop();

            } catch (Exception ex) {
                Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
