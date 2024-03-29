/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.novatronic.tester.gui;

import com.novatronic.tester.log.JTextAreaAppender;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ofernandez
 */
public class Inyector extends javax.swing.JFrame {
    private static final Logger log = LoggerFactory.getLogger(Inyector.class);
    /**
     * Creates new form Inyector
     */
    public Inyector() {
        initComponents();
        JTextAreaAppender.addTextArea(jtaLog);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING:
     * Do NOT modify this code. The content of this method is always regenerated by the
     * Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelMain = new com.novatronic.tester.panel.Main();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaLog = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(810, 644));

        jTabbedPane1.addTab("Ejecutar", panelMain);

        jtaLog.setEditable(false);
        jtaLog.setColumns(20);
        jtaLog.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jtaLog.setLineWrap(true);
        jtaLog.setRows(5);
        jScrollPane1.setViewportView(jtaLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            log.error("No se pudo cargar el L&F", ex);
        } catch (InstantiationException ex) {
            log.error("No se pudo cargar el L&F", ex);
        } catch (IllegalAccessException ex) {
            log.error("No se pudo cargar el L&F", ex);
        } catch (UnsupportedLookAndFeelException ex) {
            log.error("No se pudo cargar el L&F", ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Manager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jtaLog;
    private com.novatronic.tester.panel.Main panelMain;
    // End of variables declaration//GEN-END:variables
}
