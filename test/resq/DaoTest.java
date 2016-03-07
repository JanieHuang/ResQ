package resq;

import org.junit.Test;

import ca.ljz.resq.dao.AppUserDao;
import ca.ljz.resq.dao.impl.AppUserDaoImpl;
import ca.ljz.resq.domain.AppUser;

public class DaoTest {
	@Test
	public void testQuery(){
		
		AppUserDao dao = new AppUserDaoImpl();
		AppUser user = dao.find("1a");
		
		System.out.println(user.getEmail());
	}
}
