package DAO;


public class dataAccess {
	
	private static String db = "access";
	public static GuitarDAO getGuitarDAOInstance()
	{
		GuitarDAO result = null;
		switch (db) {
		case "access":
			result = new accessDao.GuitarDAOImpl();
			break;
		case "mysql":
			result = new mysqlDao.GuitarDAOImpl();
			break;

		}
		return result;
	}
}
