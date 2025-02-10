package Controleur;
 
import javax.swing.table.AbstractTableModel;
 
public class Tableau extends AbstractTableModel  {
 
    private Object donnees[][];
    private String entetes[];
 
    public Tableau(Object donnees[][], String entetes[]) {
        super();
        this.donnees = donnees;
        this.entetes = entetes;
    }
 
    @Override
    public int getRowCount() {
        return this.donnees.length; //nb lignes
 
    }
 
    @Override
    public int getColumnCount() {
        return this.entetes.length; //nb colonnes
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.donnees[rowIndex][columnIndex];
    }
 
    @Override
    public String getColumnName(int column) {
        return this.entetes[column];
    }
 
    public void setDonnees (Object donnees[][]) {
        this.donnees = donnees;
        this.fireTableDataChanged(); //Actualiser les données
    }
}