package dao;

import modele.Releve;

public interface IDao<Releve,ID>  {
    Releve trouverParId(ID id);

}


