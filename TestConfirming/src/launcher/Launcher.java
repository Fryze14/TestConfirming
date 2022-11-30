package launcher;

import java.util.List;

import operations.OperationsConfirming;
import pojos.Supplier;
import utils.UtilsConfirming;

public class Launcher {

	public static void main(String[] args) {

		if (args.length == 1 && args[0] != null && UtilsConfirming.isNumeric(args[0])) {

			int clientId = Integer.parseInt(args[0]);
			System.out.println("Buscando datos del cliente " + clientId + "...");
			List<Supplier> supplierList = OperationsConfirming.getInstance().getSupplierList(clientId);

			if (supplierList != null && !supplierList.isEmpty()) {

				System.out.println("Datos del cliente encontrados, guardando en archivo");
				OperationsConfirming.getInstance().fileWrite(supplierList);
			} else {
				System.out.println("No se han encontrado datos para este cliente");
			}

		} else {
			System.out.println("Error en la busqueda, introduzca el parametro correcto");
		}

	}

}
