package presentation;

import lombok.*;
import metier.IReleveMetier;
import metier.ReleveMetier;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReleveControleur {
    IReleveMetier releveMetier;

    public void afficher_Moyenne(Long idreleve) throws Exception {
        var releveAvecMoyenne = releveMetier.calculer_Moyenne(idreleve);
        System.out.println(releveAvecMoyenne);
    }

}