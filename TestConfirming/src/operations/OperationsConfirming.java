package operations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import pojos.Supplier;
import utils.UtilsConfirming;

public class OperationsConfirming {

	private static OperationsConfirming instance;

	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/test_ibm";
	private final String USER = "root";
	private final String PASS = "root";
	private final String QUERY = "select * from proveedores where id_cliente=";
	private final String TAB = "\t";
	private final String HEADER = "Id \t Nombre \t Fecha Alta \t Id Cliente";

	private OperationsConfirming() {
	}

	public static OperationsConfirming getInstance() {

		if (instance == null) {
			instance = new OperationsConfirming();
		}
		return instance;
	}

	public String getQuery(int clientId) {
		return QUERY + clientId;
	}

	public List<Supplier> getSupplierList(int clientId) {

		ResultSet result = null;
		Connection connection = null;
		List<Supplier> supplierList = null;

		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASS);

			if (connection != null) {
				Statement statement = connection.createStatement();

				if (statement != null) {
					result = statement.executeQuery(getQuery(clientId));
					supplierList = UtilsConfirming.getSupplierListFromResultSet(result);
				}
				connection.close();
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());
		}
		return supplierList;
	}

	public void fileWrite(List<Supplier> supplierList) {

		try {
			String url = "suppliers.txt";
			String line = null;
			File file = new File(url);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(HEADER);
			bw.newLine();
			for (Supplier supplier : supplierList) {
				line = supplier.getSupplierId() + TAB + supplier.getName() + TAB + supplier.getActivationDate() + TAB
						+ supplier.getClientId();
				System.out.println(line);
				bw.write(line);
				bw.newLine();
			}

			bw.close();

		} catch (Exception e) {

			e.getMessage();
		}
	}

}
