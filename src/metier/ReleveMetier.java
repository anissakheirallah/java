package metier;

import dao.IDao;
import dao.daoVolatile.ReleveDao;

import lombok.*;


import modele.Releve;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReleveMetier implements IReleveMetier{
IDao<Releve,Long> releveLongIDao;
    ReleveDao releveDao;
    @Override
    public Releve calculer_Moyenne(Long idReleve) throws Exception{
        var releve=releveDao.trouverParId(idReleve);
        if(releve==null)
            throw new Exception("L'id du releve est incorrecte::[Releve non trouvé]");
    else {

          Double Moyenne= releve.getNote1()+releve.getNote2()+releve.getNote3()/ releve.getNbre_note();
           releve.setMoyenne_notes(Moyenne);
                return releve;
            }

        }


}

