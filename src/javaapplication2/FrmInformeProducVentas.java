/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.image.BufferedImage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FrmInformeProducVentas extends javax.swing.JFrame {

    private boolean bandera = false;
    private static final String consultames = "SELECT sum(total) FROM ventas WHERE MONTH(fechaVenta)=";

    /**
     * Creates new form FrmInformeProducVentas
     */
    public FrmInformeProducVentas() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.WHITE);

    }

    public int MayorValor(
            double valor_Enero,
            double valor_Febrero,
            double valor_Marzo,
            double valor_Abril,
            double valor_Mayo,
            double valor_Junio,
            double valor_Julio,
            double valor_Agosto,
            double valor_Septiembre,
            double valor_Octubre,
            double valor_Nobriembre,
            double valor_Diciembre) {
        Double result = 0.0;
        if (valor_Diciembre > valor_Nobriembre
                && valor_Diciembre > valor_Octubre
                && valor_Diciembre > valor_Septiembre
                && valor_Diciembre > valor_Agosto
                && valor_Diciembre > valor_Julio
                && valor_Diciembre > valor_Junio
                && valor_Diciembre > valor_Mayo
                && valor_Diciembre > valor_Abril
                && valor_Diciembre > valor_Marzo
                && valor_Diciembre > valor_Febrero
                && valor_Diciembre > valor_Enero) {
            result = valor_Diciembre;
        } else if (valor_Nobriembre > valor_Octubre
                && valor_Nobriembre > valor_Septiembre
                && valor_Nobriembre > valor_Agosto
                && valor_Nobriembre > valor_Julio
                && valor_Nobriembre > valor_Junio
                && valor_Nobriembre > valor_Mayo
                && valor_Nobriembre > valor_Abril
                && valor_Nobriembre > valor_Marzo
                && valor_Nobriembre > valor_Febrero
                && valor_Nobriembre > valor_Enero) {
            result = valor_Nobriembre;
        } else if (valor_Octubre > valor_Septiembre
                && valor_Octubre > valor_Agosto
                && valor_Octubre > valor_Julio
                && valor_Octubre > valor_Junio
                && valor_Octubre > valor_Mayo
                && valor_Octubre > valor_Abril
                && valor_Octubre > valor_Marzo
                && valor_Octubre > valor_Febrero
                && valor_Octubre > valor_Enero) {
            result = valor_Octubre;
        } else if (valor_Septiembre > valor_Agosto
                && valor_Septiembre > valor_Julio
                && valor_Septiembre > valor_Junio
                && valor_Septiembre > valor_Mayo
                && valor_Septiembre > valor_Abril
                && valor_Septiembre > valor_Marzo
                && valor_Septiembre > valor_Febrero
                && valor_Septiembre > valor_Enero) {
            result = valor_Septiembre;
        } else if (valor_Agosto > valor_Julio
                && valor_Agosto > valor_Junio
                && valor_Agosto > valor_Mayo
                && valor_Agosto > valor_Abril
                && valor_Agosto > valor_Marzo
                && valor_Agosto > valor_Febrero
                && valor_Agosto > valor_Enero) {
            result = valor_Agosto;
        } else if (valor_Julio > valor_Junio
                && valor_Julio > valor_Mayo
                && valor_Julio > valor_Abril
                && valor_Julio > valor_Marzo
                && valor_Julio > valor_Febrero
                && valor_Julio > valor_Enero) {
            result = valor_Julio;
        } else if (valor_Junio > valor_Mayo
                && valor_Junio > valor_Abril
                && valor_Junio > valor_Marzo
                && valor_Junio > valor_Febrero
                && valor_Junio > valor_Enero) {
            result = valor_Junio;
        } else if (valor_Mayo > valor_Abril
                && valor_Mayo > valor_Marzo
                && valor_Mayo > valor_Febrero
                && valor_Mayo > valor_Enero) {
            result = valor_Mayo;
        } else if (valor_Abril > valor_Marzo
                && valor_Abril > valor_Febrero
                && valor_Abril > valor_Enero) {
            result = valor_Abril;
        } else if (valor_Marzo > valor_Febrero
                && valor_Marzo > valor_Enero) {
            result = valor_Marzo;
        } else if (valor_Febrero > valor_Enero) {
            result = valor_Febrero;
        } else {
            result = valor_Enero;
        }
        return result.intValue();
    }

    public void graficar() {

        if (bandera == true) {
            int string_Enero = consultMes(1),
                    string_Febrero = consultMes(2),
                    string_Marzo = consultMes(3),
                    string_Abril = consultMes(4),
                    string_Mayo = consultMes(5),
                    string_Junio = consultMes(6),
                    string_Julio = consultMes(7),
                    string_Agosto = consultMes(8),
                    string_Septiembre = consultMes(9),
                    string_Obtubre = consultMes(10),
                    string_Noviembre = consultMes(11),
                    string_Diciembre = consultMes(12);

            int valor_Mayor = MayorValor(string_Enero, string_Febrero, string_Marzo,
                    string_Abril,
                    string_Mayo,
                    string_Junio,
                    string_Julio,
                    string_Agosto,
                    string_Septiembre,
                    string_Obtubre,
                    string_Noviembre,
                    string_Diciembre);

            double prom = ((string_Enero + string_Febrero + string_Marzo + string_Abril
                    + string_Mayo
                    + string_Junio
                    + string_Julio
                    + string_Agosto
                    + string_Septiembre
                    + string_Obtubre
                    + string_Noviembre
                    + string_Diciembre) / 12);

            jTextPane1.setText(" Enero:" + string_Enero
                    + "\n Febrero:" + string_Febrero
                    + "\n Marzo:" + string_Marzo
                    + "\n Abril:" + string_Abril
                    + "\n Mayo:" + string_Mayo
                    + "\n Junio:" + string_Junio
                    + "\n Julio:" + string_Julio
                    + "\n Agosto:" + string_Agosto
                    + "\n Septiembre:" + string_Septiembre
                    + "\n Octubre:" + string_Obtubre
                    + "\n Noviembre:" + string_Noviembre
                    + "\n Diciembre:" + string_Diciembre
                    + "\n ValorMayor:" + valor_Mayor
                    + "\n ValorPromedio:" + prom
            );
//400
            double largo_Enero = string_Enero * 10 / valor_Mayor;
            double largo_Febrero = string_Febrero * 10 / valor_Mayor;
            double largo_Marzo = string_Marzo * 10 / valor_Mayor;
            double largo_Abril = string_Abril * 10 / valor_Mayor;
            double largo_Mayo = string_Mayo * 10 / valor_Mayor;
            double largo_Junio = string_Junio * 10 / valor_Mayor;
            double largo_Julio = string_Julio * 10 / valor_Mayor;
            double largo_Agosto = string_Agosto *10 / valor_Mayor;
            double largo_Septiembre = string_Septiembre *10 / valor_Mayor;
            double largo_Octubre = string_Obtubre * 10 / valor_Mayor;
            double largo_Noviembre = string_Noviembre * 10 / valor_Mayor;
            double largo_Diciembre = string_Diciembre * 10 / valor_Mayor;

            DefaultXYDataset dataset = new DefaultXYDataset();
//            dataset.addSeries("firefox", new double[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, {largo_Enero, largo_Febrero, largo_Marzo, largo_Abril, largo_Mayo, largo_Junio, largo_Julio,largo_Agosto, largo_Septiembre, largo_Octubre, largo_Noviembre, largo_Diciembre}});
//            dataset.addSeries("ie", new double[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, {largo_Enero, largo_Febrero, largo_Marzo, largo_Abril, largo_Mayo, largo_Junio, largo_Julio,largo_Agosto, largo_Septiembre, largo_Octubre, largo_Noviembre, largo_Diciembre}});
            dataset.addSeries("Porcentaje", new double[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, {largo_Enero, largo_Febrero, largo_Marzo, largo_Abril, largo_Mayo, largo_Junio, largo_Julio, largo_Agosto, largo_Septiembre, largo_Octubre, largo_Noviembre, largo_Diciembre}});

            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
            renderer.setSeriesPaint(0, Color.ORANGE);
            renderer.setSeriesPaint(1, Color.BLUE);
            renderer.setSeriesPaint(2, Color.GREEN);
            renderer.setSeriesStroke(0, new BasicStroke(2));
            renderer.setSeriesStroke(1, new BasicStroke(2));
            renderer.setSeriesStroke(2, new BasicStroke(2));

            try {
                JFreeChart chart = ChartFactory.createXYLineChart("Informe", "Meses", "Quota", dataset);
                chart.getXYPlot().getRangeAxis().setRange(0, 100);
                ((NumberAxis) chart.getXYPlot().getRangeAxis()).setNumberFormatOverride(new DecimalFormat("#'%'"));
                chart.getXYPlot().setRenderer(renderer);
                String ruta = System.getProperty("user.home");
                BufferedImage image = chart.createBufferedImage(600, 400);
                ImageIO.write(image, "png", new File(ruta + "/xy-chart.png"));
                ImageIcon imgThisImg = new ImageIcon(ruta + "/xy-chart.png");
                jLabel1.setText("");
                jLabel1.setIcon(imgThisImg);
            } catch (IOException ex) {
                Logger.getLogger(FrmInformeProducVentas.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
    }

    private int consultMes(int mes) {
        Double result = null;
        if (Basededatos.conectar() != null) {

            String sql = consultames + mes;

            try {
                Statement ps = Basededatos.conn.createStatement();
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    result = rs.getDouble("sum(total)");

                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmCliente.class.getName()).log(Level.SEVERE, null, ex);
                ClaseMensaje.miMensajeError();
            }

        }

        return result.intValue();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informe Ventas Anual");
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
            .addGap(0, 822, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("Grafica:");
        jLabel1.setDoubleBuffered(true);

        jTextPane1.setDoubleBuffered(true);
        jScrollPane1.setViewportView(jTextPane1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/graphs_46879.png"))); // NOI18N
        jButton1.setText("Graficar");
        jButton1.setDoubleBuffered(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        bandera = true;
        graficar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
          FrmPrincipal frd= new FrmPrincipal();
        frd.setEnabled(true);
        frd.setVisible(true);
        this.setEnabled(false);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(FrmInformeProducVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInformeProducVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInformeProducVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInformeProducVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInformeProducVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
