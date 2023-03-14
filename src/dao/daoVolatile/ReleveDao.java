package dao.daoVolatile;

import dao.IDao;
import modele.Releve;
import lombok.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReleveDao implements IDao<Releve,Long>{
    public static Set<Releve> BDreleve(){
        return new HashSet<Releve>(
                Arrays.asList(
                        new Releve(1, "Anissa", "kheir allah",14.0,16.5,19.0,20.0,3),
                        new Releve(2, "Aya", "bellay",18.5,19.0,15.0,30.0,3),

                        new Releve(3, "Hoda", "Jate",16.5,16.0,17.0,18.0,3)


                ));


    }


    public Releve trouverParId(Long id) {
        System.out.println("[DAO-DS volatile] trouver le releve n°:"+id);
        return BDreleve()
                .stream()
                .filter(releve-> releve.getId()== id)
                .findFirst()
                .orElse(null);
    }

    public void setReleveDao(ReleveDao dao) {
    }

    public void afficher_Moyenne(long id) {
    }
}
