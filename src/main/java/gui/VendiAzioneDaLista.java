package GUI;

import Controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The type Vendi azione da lista.
 */
public class VendiAzioneDaLista {
    /**
     * The Frame.
     */
    JFrame frame;
    private JPanel panel1;
    private JTable ListaAcquistiTable;
    private JButton vendiAzioneButton;
    private JButton annullaButton;

    /**
     * Instantiates a new Vendi azione da lista.
     *
     * @param controller     the controller
     * @param frameChiamante the frame chiamante
     */
    public VendiAzioneDaLista(Controller controller, JFrame frameChiamante) {
        frame = new JFrame("Vendi Azione");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(frameChiamante);
        frame.setVisible(true);
        frameChiamante.setVisible(false);
        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frameChiamante.setVisible(true);
                frame.dispose();
            }
        });


        //crea la tabella
        ListaAcquistiTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Societa", "Valore Azione", "Quantita"
                }
        ));
        DefaultTableModel model = (DefaultTableModel) ListaAcquistiTable.getModel();
        ArrayList listaNomiSocieta = controller.getNomiSocietaDaListino();
        ArrayList listaValoriAzione = controller.getValoriAzionedaListino();
        ArrayList listaQuantita = controller.getQuantitaAcquisti();
        if (listaNomiSocieta != null && listaValoriAzione != null && listaQuantita != null)
            for (int i = 0; i < listaNomiSocieta.size(); i++)
                model.addRow(new Object[]{listaNomiSocieta.get(i), listaValoriAzione.get(i), listaQuantita.get(i)});


        vendiAzioneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = ListaAcquistiTable.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(frame, "Selezionare una riga");
                    return;
                }
                String societa = (String) ListaAcquistiTable.getValueAt(row, 0);
                Double valoreAzione = Double.parseDouble(ListaAcquistiTable.getValueAt(row, 1).toString());
                Double quantitaMax = Double.parseDouble(ListaAcquistiTable.getValueAt(row, 2).toString());
                int quantita = Integer.parseInt(JOptionPane.showInputDialog(frame, "Inserire la quantita da vendere (max " + quantitaMax + ")"));
                if (quantita > quantitaMax) {
                    JOptionPane.showMessageDialog(frame, "Quantita non valida");
                    return;
                }
                if (quantita <= 0) {
                    JOptionPane.showMessageDialog(frame, "Quantita non valida");
                    return;
                }

                controller.vendiAzione(societa, valoreAzione, quantita);
                JOptionPane.showMessageDialog(frame, "Azione venduta");
                frame.setVisible(false);
                frameChiamante.setVisible(true);
                frame.dispose();
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        ListaAcquistiTable = new JTable();
        panel1.add(ListaAcquistiTable, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        vendiAzioneButton = new JButton();
        vendiAzioneButton.setText("Vendi Azione");
        panel1.add(vendiAzioneButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        annullaButton = new JButton();
        annullaButton.setText("Annulla");
        panel1.add(annullaButton, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
