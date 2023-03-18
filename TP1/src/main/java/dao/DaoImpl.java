package dao;

public class DaoImpl implements IDao {
    @Override
    public double getData() {
        double v = 5;
        System.out.println("Solution DB");
        return v;
    }
}
