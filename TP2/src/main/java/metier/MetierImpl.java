package metier;
import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetierImpl implements IMetier {
	@Autowired
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
