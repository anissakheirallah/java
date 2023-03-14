package modele;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Releve {
    private int id;
    private String nom_etud;
    private String prenom_etud;
    private Double note1;
    private Double note2;
    private Double note3;
    private Double Moyenne_notes;
      private  int nbre_note=3;

    public String toString() {
        return "releve{" +
                "id=" + id +
                "nom_etud =" + nom_etud +          "\n"+
                "prenom_etud =" + prenom_etud+     "\n" +
                "note1="  +note1+                   "\n"+
                "note2="  +note2+                   "\n"+
                "note3="  +note3+                   "\n"+
                "Moyenne_notes=" + Moyenne_notes+   "\n";
    }




}