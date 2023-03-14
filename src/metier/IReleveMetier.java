package metier;

import modele.Releve;

public interface IReleveMetier {
    Releve calculer_Moyenne(Long idReleve) throws Exception;
}
