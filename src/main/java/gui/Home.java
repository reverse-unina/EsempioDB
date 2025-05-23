package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * The type Home.
 */
public class Home {
    private Controller controller;

    private JPanel panel1;
    private static JFrame frame;
    private JButton nomeDelGiocatoreButton;
    private JLabel giocatoreText;
    private JButton cittaDellaBorsaButton;
    private JLabel cittaBorsaText;
    private JButton aggiungiNuovaSocietaButton;
    private JButton leggiListinoButton;
    private JButton modificaValoreAzioneButton;
    private JButton acquistaAzioneButton;
    private JButton leggiListaAcquistiButton;
    private JLabel disponibilitaLabel;
    private JLabel bilancioLabel;
    private JButton vendiAzioneButton;

    /**
     * Instantiates a new Home.
     */
    public Home() {
        //crea un oggetto controller che gestisce le operazioni
        controller = new Controller();

        nomeDelGiocatoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = JOptionPane.showInputDialog("Inserisci il nome del giocatore");
                if (s.isBlank()) {
                    JOptionPane.showMessageDialog(frame, "Nome non valido");
                } else {
                    giocatoreText.setText("Benvenuto, " + s);
                    //salvare il nome del giocatore
                    controller.setNomeGiocatore(s);
                    cittaDellaBorsaButton.setEnabled(true);
                    aggiorna();
                }
            }
        });
        cittaDellaBorsaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = JOptionPane.showInputDialog("Inserisci la città della borsa");
                if (s.isBlank()) {
                    JOptionPane.showMessageDialog(frame, "Città non valida");
                } else {
                    cittaBorsaText.setText("Si gioca su " + s);
                    //salvare il nome della città della borsa
                    controller.setCittaBorsa(s);
                    aggiungiNuovaSocietaButton.setEnabled(true);
                    leggiListinoButton.setEnabled(true);
                    modificaValoreAzioneButton.setEnabled(true);
                    acquistaAzioneButton.setEnabled(true);
                    leggiListaAcquistiButton.setEnabled(true);
                    vendiAzioneButton.setEnabled(true);
                }

            }
        });
        aggiungiNuovaSocietaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AggiungiNuovaSocieta aggiungiNuovaSocieta = new AggiungiNuovaSocieta(controller, frame);
                aggiungiNuovaSocieta.frame.setVisible(true);
                frame.setVisible(false);

            }
        });
        leggiListinoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LeggiListino leggiListino = new LeggiListino(controller, frame);
                leggiListino.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        modificaValoreAzioneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModificaValoreAzione modificaValoreAzione = new ModificaValoreAzione(controller, frame);
                modificaValoreAzione.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        acquistaAzioneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AcquistaAzione acquistaAzione = new AcquistaAzione(controller, frame);
                acquistaAzione.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        leggiListaAcquistiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LeggiListaAcquisti leggiListaAcquisti = new LeggiListaAcquisti(controller, frame);
                leggiListaAcquisti.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        frame.addComponentListener(new ComponentAdapter() {
            public void componentHidden(ComponentEvent e) {
                /* code run when component hidden*/
            }

            public void componentShown(ComponentEvent e) {
                aggiorna();
            }
        });

        vendiAzioneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VendiAzioneDaLista vendiAzioneDaLista = new VendiAzioneDaLista(controller, frame);
                vendiAzioneDaLista.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
    }

    /**
     * Aggiorna.
     */
    void aggiorna() {
        if (!controller.isNullGiocatore()) {
            disponibilitaLabel.setText("Disponibilita': " + controller.getDisponibilita());
            bilancioLabel.setText("Bilancio: " + controller.getBilancio());
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        frame = new JFrame("Home");
        frame.setContentPane(new Home().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1, true, true));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(9, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        aggiungiNuovaSocietaButton = new JButton();
        aggiungiNuovaSocietaButton.setEnabled(false);
        aggiungiNuovaSocietaButton.setText("Aggiungi Nuova Societa");
        panel2.add(aggiungiNuovaSocietaButton, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        modificaValoreAzioneButton = new JButton();
        modificaValoreAzioneButton.setEnabled(false);
        modificaValoreAzioneButton.setText("Modifica Valore Azione");
        panel2.add(modificaValoreAzioneButton, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        leggiListinoButton = new JButton();
        leggiListinoButton.setEnabled(false);
        leggiListinoButton.setText("Leggi Listino");
        panel2.add(leggiListinoButton, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        acquistaAzioneButton = new JButton();
        acquistaAzioneButton.setEnabled(false);
        acquistaAzioneButton.setText("Acquista Azione");
        panel2.add(acquistaAzioneButton, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        leggiListaAcquistiButton = new JButton();
        leggiListaAcquistiButton.setEnabled(false);
        leggiListaAcquistiButton.setText("Leggi Lista Acquisti");
        panel2.add(leggiListaAcquistiButton, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        vendiAzioneButton = new JButton();
        vendiAzioneButton.setEnabled(false);
        vendiAzioneButton.setText("Vendi Azione");
        panel2.add(vendiAzioneButton, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cittaDellaBorsaButton = new JButton();
        cittaDellaBorsaButton.setEnabled(false);
        cittaDellaBorsaButton.setText("Città della Borsa");
        panel2.add(cittaDellaBorsaButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        nomeDelGiocatoreButton = new JButton();
        nomeDelGiocatoreButton.setText("Nome del Giocatore");
        panel2.add(nomeDelGiocatoreButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel3, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        giocatoreText = new JLabel();
        giocatoreText.setText("");
        panel3.add(giocatoreText, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        cittaBorsaText = new JLabel();
        cittaBorsaText.setText("");
        panel3.add(cittaBorsaText, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        disponibilitaLabel = new JLabel();
        disponibilitaLabel.setText("");
        panel3.add(disponibilitaLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bilancioLabel = new JLabel();
        bilancioLabel.setText("");
        panel3.add(bilancioLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
