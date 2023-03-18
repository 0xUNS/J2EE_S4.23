package pres;

import dao.IDao;
import metier.IMetier;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

// Dynamic Instence
public class Presentation {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("config.txt"));
        String daoClassName = scanner.nextLine();
        Class cDoa = Class.forName(daoClassName);
        IDao dao = (IDao) cDoa.newInstance();
        System.out.println("Get data DAO : " + dao.getData());

        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.newInstance();
        Method method = cMetier.getMethod("setDao", IDao.class);
        // static : metier.setDao(dao)
        method.invoke(metier, dao);

        System.out.println("Calcul metier : " + metier.calcul());
    }
}
