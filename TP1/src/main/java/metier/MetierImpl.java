package metier;
import dao.IDao;

public class MetierImpl implements IMetier {
    public IDao dao;
    @Override
    public double calcul() {
        double c = dao.getData() * 10;
        return c;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
