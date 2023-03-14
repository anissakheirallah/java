import dao.IDao;
import dao.daoVolatile.ReleveDao;
import metier.IReleveMetier;
import metier.ReleveMetier;
import modele.Releve;
import presentation.IReleveControleur;
import presentation.ReleveControleur;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;

public class SimulateurDeNote {
    static IReleveControleur releveControleur;
    static Scanner clavier = new Scanner(System.in);

    private static boolean estUnNombre(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void test1() {
        var dao = new ReleveDao();
        var metier = new ReleveDao();
        var controleur = new ReleveDao();

        metier.setReleveDao(dao);
        controleur.setReleveDao(metier);
        //tester
        String rep = "";
        do {
            System.out.println("=>[Test1] Calcule de moyenne de releve <=\n");

            try {
                String inpuut = "";
                while (true) {
                    System.out.print("=>Entrez l'id du releve:");
                    inpuut = clavier.nextLine();
                    if (estUnNombre(inpuut)) break;
                    System.err.println("Entrée non valide!!!");
                }
                long id = Long.parseLong(inpuut);
                controleur.afficher_Moyenne(id);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            System.out.print("Voulez vous quittez(oui/non)?");
            rep = clavier.nextLine();
        } while (!rep.equalsIgnoreCase("oui"));
        System.out.println("Au revoir ^_^");
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test2() throws Exception {

        String daoClass;
        String serviceClass;
        String controllerClass;
        Properties properties = new Properties();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream("config.properties");


        if (propertiesFile == null) throw new Exception("fichier config introuvable !!!");
        else {
            try {
                properties.load(propertiesFile);
                daoClass = properties.getProperty("DAO");
                serviceClass = properties.getProperty("SERVICE");
                controllerClass = properties.getProperty("CONTROLLER");
                propertiesFile.close();
            } catch (IOException e) {
                throw new Exception("Probleme de chargement des propriétés du fichier config");
            } finally {
                properties.clear();
            }
        }
        try {
            Class cDao = Class.forName(daoClass);
            Class cMetier = Class.forName(serviceClass);
            Class cControleur = Class.forName(controllerClass);

            var dao = (IDao<Releve, Long>) cDao.getDeclaredConstructor(IDao.class).newInstance(cDao);
            var metier = (IReleveMetier) cMetier.getDeclaredConstructor().newInstance();
           var ReleveControleur = (IReleveControleur) cControleur.getDeclaredConstructor().newInstance();
            Method setDao = cMetier.getMethod("setReleveDao", ReleveDao.class);
            setDao.invoke(metier, dao);
            Method setMetier = cControleur.getMethod("setCreditMetier", ReleveMetier.class);
            setMetier.invoke(ReleveControleur, metier);
            ReleveControleur.afficher_Moyenne(1L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        }

