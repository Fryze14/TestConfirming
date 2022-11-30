package utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Supplier;

public class UtilsConfirming {

	public static List<Supplier> getSupplierListFromResultSet(ResultSet resultDB) {

		List<Supplier> supplierList = null;
		if (resultDB != null) {

			supplierList = new ArrayList<>();
			Supplier supplier = null;

			try {
				while (resultDB.next()) {

					supplier = new Supplier();
					supplier.setSupplierId(resultDB.getInt(1));
					supplier.setName(resultDB.getString(2));
					supplier.setActivationDate(resultDB.getDate(3));
					supplier.setClientId(resultDB.getInt(4));

					supplierList.add(supplier);
				}
			} catch (SQLException e) {

				System.out.println(e.getMessage());
				supplierList = null;
			}
		}
		return supplierList;
	}

	public static boolean isNumeric(String string) {

		boolean result;

		try {
			Integer.parseInt(string);
			result = true;
		} catch (NumberFormatException excepcion) {
			result = false;
		}

		return result;
	}
}
