package Vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import Controleur.Tableau;
import Controleur.User;

public class PanelUser extends PanelPrincipal implements ActionListener, KeyListener {
    private JPanel panelForm = new JPanel();

    private JTextField txtNom = new JTextField("Nom");
    private JTextField txtPrenom = new JTextField("Prenom");
    private JTextField txtEmail = new JTextField("Email");
    private JTextField txtAdresse = new JTextField("Adresse");
    private JTextField txtVille = new JTextField("Ville");
    private JTextField txtCp = new JTextField("Code Postal");
    private JTextField txtTel = new JTextField("Telephone");

    private JButton btAnnuler = new JButton("Annuler");
    private JButton btValider = new JButton("Valider");

    private JTable tableUser;
    private Tableau tableauUser;

    private JPanel panelFiltre = new JPanel();
    private JTextField txtFiltre = new JTextField("Filtre");
    private JButton btFiltrer = new JButton("Filtrer");
    private JButton btSupprimer = new JButton("Supprimer");

    private JLabel lbNBUser = new JLabel("Nombre d'utilisateurs : ");

    public PanelUser() {
        super("Gestion des utilisateurs");

        this.panelForm.setBounds(30,100,300,200);
        this.panelForm.setLayout(new GridLayout(8,2));
        this.panelForm.add(new JLabel("Nom :"));
        this.panelForm.add(this.txtNom);

        this.panelForm.add(new JLabel("Prenom :"));
        this.panelForm.add(this.txtPrenom);

        this.panelForm.add(new JLabel("Email :"));
        this.panelForm.add(this.txtEmail);

        this.panelForm.add(new JLabel("Adresse :"));
        this.panelForm.add(this.txtAdresse);

        this.panelForm.add(new JLabel("Ville :"));
        this.panelForm.add(this.txtVille);

        this.panelForm.add(new JLabel("Code Postal :"));
        this.panelForm.add(this.txtCp);

        this.panelForm.add(new JLabel("Telephone :"));
        this.panelForm.add(this.txtTel);

        this.panelForm.add(this.btAnnuler);
        this.panelForm.add(this.btValider);

        this.add(this.panelForm);

        this.btAnnuler.addActionListener(this);
        this.btValider.addActionListener(this);

        //rendre les champs écoutable
        this.txtNom.addKeyListener(this);
        this.txtPrenom.addKeyListener(this);
        this.txtEmail.addKeyListener(this);
        this.txtAdresse.addKeyListener(this);
        this.txtVille.addKeyListener(this);
        this.txtCp.addKeyListener(this);
        this.txtTel.addKeyListener(this);

        //installation de la Jtable
        String entetes[] = {"ID User", "Nom", "Prenom", "Email", "Adresse", "Ville", "Code Postal", "Telephone"};
        this.tableauUser = new Tableau(this.obtenirDonnees(""), entetes);
        this.tableUser = new JTable(this.tableauUser);
        JScrollPane uneScroll = new JScrollPane(this.tableUser);
        uneScroll.setBounds(350, 100, 500, 200);
        this.add(uneScroll);

        //installation du filtre
        this.panelFiltre.setBackground(Color.CYAN);
        this.panelFiltre.setBounds(370, 60, 450, 30);
        this.panelFiltre.setLayout(new GridLayout(1, 3));
        this.panelFiltre.add(new JLabel("Filtre : "));
        this.panelFiltre.add(this.txtFiltre);
        this.panelFiltre.add(this.btFiltrer);
        this.btFiltrer.addActionListener(this);
        this.add(this.panelFiltre);

        //installation du bouton supprimer
        this.btSupprimer.setBounds(70, 360, 100, 30);
        this.add(this.btSupprimer);
        this.btSupprimer.addActionListener(this);
        this.btSupprimer.setVisible(false);
        this.btSupprimer.setBackground(Color.RED);

        //installation du compteur
        this.lbNBUser.setBounds(450, 380, 400, 20);
        this.add(this.lbNBUser);
        this.lbNBUser.setText("Nombre d'utilisateurs : " + this.tableauUser.getRowCount());

         // rendre la table écoutable sur le clic de la souris
         this.tableUser.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int numLigne = 0;
                if (e.getClickCount() >= 1){
                    numLigne = tableUser.getSelectedRow();
                    txtNom.setText(tableUser.getValueAt(numLigne, 1).toString());
                    txtPrenom.setText(tableUser.getValueAt(numLigne, 2).toString());
                    txtEmail.setText(tableUser.getValueAt(numLigne, 3).toString());
                    txtAdresse.setText(tableUser.getValueAt(numLigne, 4).toString());
                    txtVille.setText(tableUser.getValueAt(numLigne, 5).toString());
                    txtCp.setText(tableUser.getValueAt(numLigne, 6).toString());
                    txtTel.setText(tableUser.getValueAt(numLigne, 7).toString());

                    btSupprimer.setVisible(true);
                    btValider.setText("Modifier");
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
            }

            
        });
    }

    public Object [][] obtenirDonnees(String filtre) {
        ArrayList<User> lesUsers;
        if (filtre.equals("")) {
            lesUsers = Controleur.User.selectAllUser();
        } else {
            lesUsers = Controleur.User.selectWhereUser(filtre);
        }

        Object matrice [][] = new Object[lesUsers.size()][8];
        int i = 0;
        for (User unUser : lesUsers) {
            matrice[i][0] = unUser.getId_user();
            matrice[i][1] = unUser.getNom();
            matrice[i][2] = unUser.getPrenom();
            matrice[i][3] = unUser.getEmail();
            matrice[i][4] = unUser.getAdresse();
            matrice[i][5] = unUser.getVille();
            matrice[i][6] = unUser.getCode_postal();
            matrice[i][7] = unUser.getTelphone();
            i++;
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    

}

