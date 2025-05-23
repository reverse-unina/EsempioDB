package GUI;

import Controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The type Leggi listino.
 */
public class LeggiListino {
    private JPanel panel1;
    private JTable table1;
    private JButton returnToHomeButton;
    /**
     * The Frame.
     */
    JFrame frame;

    /**
     * Instantiates a new Leggi listino.
     *
     * @param controller     the controller
     * @param frameChiamante the frame chiamante
     */
    public LeggiListino(Controller controller, JFrame frameChiamante) {
        frame = new JFrame("Leggi Listino societa");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(frameChiamante);
        returnToHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frameChiamante.setVisible(true);
                frame.dispose();
            }
        });

        //crea la tabella
        //table1 = new JTable();
        table1.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Societa", "Valore Azione"
                }
        ));
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        ArrayList listaNomiSocieta = controller.getNomiSocietaDaListino();
        ArrayList listaValoriAzione = controller.getValoriAzionedaListino();
        if (listaNomiSocieta != null && listaValoriAzione != null)
            for (int i = 0; i < listaNomiSocieta.size(); i++)
                model.addRow(new Object[]{listaNomiSocieta.get(i), listaValoriAzione.get(i)});
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
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        table1 = new JTable();
        panel1.add(table1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        returnToHomeButton = new JButton();
        returnToHomeButton.setText("Return to Home");
        panel1.add(returnToHomeButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
