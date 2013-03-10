/*
 * MediathekView
 * Copyright (C) 2008 W. Xaver
 * W.Xaver[at]googlemail.com
 * http://zdfmediathk.sourceforge.net/
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package mediathek.gui.dialogEinstellungen;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import mediathek.controller.io.IoXmlFilmlisteSchreiben;
import mediathek.daten.DDaten;
import mediathek.daten.Daten;
import mediathek.gui.PanelVorlage;
import mediathek.tool.Funktionen;
import mediathek.tool.Konstanten;
import mediathek.tool.Log;

public class PanelExportFilmliste extends PanelVorlage {

    public String ziel;

    public PanelExportFilmliste(DDaten d, Component parent) {
        super(d, parent);
        initComponents();
        init();
    }

    private void init() {
        jTextFieldPfad.setText(Daten.system[Konstanten.SYSTEM_EXPORT_DATEI_NR]);
        jTextFieldPfad.getDocument().addDocumentListener(new BeobTextFeld());
        jButtonExportieren.addActionListener(new BeobExport());
        jButtonExportPfad.addActionListener(new BeobPfad());
    }

    private void filmeExportieren() {
        int ret;
        String exporDatei = Daten.system[Konstanten.SYSTEM_EXPORT_DATEI_NR];
        if (exporDatei.equals("")) {
            JOptionPane.showMessageDialog(parentComponent, "Keine Datei angegeben", "Pfad", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                if (new File(exporDatei).exists()) {
                    ret = JOptionPane.showConfirmDialog(parentComponent, "Datei:  " + "\"" + exporDatei + "\"" + "  existiert bereits", "Überschreiben?",
                            JOptionPane.YES_NO_OPTION);
                } else {
                    ret = JOptionPane.OK_OPTION;
                }
                if (ret == JOptionPane.OK_OPTION) {
                    this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    new IoXmlFilmlisteSchreiben().filmeSchreiben(exporDatei, Daten.listeFilme);
                    if (!new File(exporDatei).exists()) {
                        JOptionPane.showMessageDialog(parentComponent, "Datei:  " + "\"" + exporDatei + "\"" + "  Konnte nicht erstellt werden!", "Fehler", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception ex) {
                Log.fehlerMeldung(464589201, Log.FEHLER_ART_PROG, "PanelExportImportDateiUrl.filmeExportieren", ex);
            }
        }
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTextFieldPfad = new javax.swing.JTextField();
        jButtonExportPfad = new javax.swing.JButton();
        jLabelDatei = new javax.swing.JLabel();
        jButtonExportieren = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonExportPfad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mediathek/res/fileopen_16.png"))); // NOI18N

        jLabelDatei.setText("Datei:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelDatei)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldPfad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExportPfad)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldPfad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDatei)
                    .addComponent(jButtonExportPfad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonExportPfad, jTextFieldPfad});

        jButtonExportieren.setText("Exportieren");

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setRows(7);
        jTextArea1.setText("Es kann die programmeigene Liste mit den Filmen exportiert werden.\n\nDabei werden Dateinamen mit einer Endung\n\".zip\" als Zip-Dateien und \n\".bz2\" als Bzip2-Dateien\n\nund alle anderen Dateien als unkomprimierte Dateien verwendet.");
        jTextArea1.setMargin(new java.awt.Insets(4, 4, 4, 4));
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonExportieren)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonExportieren)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExportPfad;
    private javax.swing.JButton jButtonExportieren;
    private javax.swing.JLabel jLabelDatei;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldPfad;
    // End of variables declaration//GEN-END:variables

    private class BeobTextFeld implements DocumentListener {

        @Override
        public void changedUpdate(DocumentEvent e) {
            tusEinfach(e);
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            tusEinfach(e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            tusEinfach(e);
        }

        void tusEinfach(DocumentEvent e) {
            Daten.system[Konstanten.SYSTEM_EXPORT_DATEI_NR] = jTextFieldPfad.getText();
        }
    }

    private class BeobPfad implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //we can use native chooser on Mac...
            if (Funktionen.isMacOSX()) {
                FileDialog chooser = new FileDialog(ddaten.mediathekGui, "Filme exportieren");
                chooser.setMode(FileDialog.SAVE);
                chooser.setVisible(true);
                if (chooser.getFile() != null) {
                    try {
                        jTextFieldPfad.setText(new File(chooser.getFile()).getAbsolutePath());
                    } catch (Exception ex) {
                        Log.fehlerMeldung(679890147, Log.FEHLER_ART_PROG, "PanelExportImportDateiUrl.BeobImport", ex);
                    }
                }
            } else {
                int returnVal;
                JFileChooser chooser = new JFileChooser();
                if (!jTextFieldPfad.getText().equals("")) {
                    chooser.setCurrentDirectory(new File(jTextFieldPfad.getText()));
                }
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                chooser.setFileHidingEnabled(false);
                returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    try {
                        jTextFieldPfad.setText(chooser.getSelectedFile().getAbsolutePath());
                    } catch (Exception ex) {
                        Log.fehlerMeldung(911025463, Log.FEHLER_ART_PROG, "PanelExportImportDateiUrl.BeobImport", ex);
                    }
                }
            }
        }
    }

    private class BeobExport implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            filmeExportieren();
        }
    }
}
