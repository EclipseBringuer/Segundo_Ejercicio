package cesur.examen.domain.client;

import cesur.examen.common.HibernateUtil;
import cesur.examen.domain.car.Car;
import cesur.examen.domain.car.CarDAO;
import org.hibernate.Session;

import java.util.*;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno:Gabriel Rincón López
 * Fecha:11/12/2023
 */

public class ClientService {

    /**
     * Return a List of Client entities that have one or more cars of the given manufacturer.
     * If a client has more than one car of the manufacturer, it only appears once in
     * the list (similar to a Set). Tip: start querying to Car entities...
     *
     * @param manufacturer
     * @return the list of clients
     */
    public static List<Client> hasManufacturer(String manufacturer){
        var out= new ArrayList<Client>(0);

        var clientDAO = new ClientDAO();
        var clients = clientDAO.getAll();

        for(Client client: clients){
            var cars = client.getCars();
            for(Car car : cars){
                if(Objects.equals(car.getManufacturer(), manufacturer )&& !out.contains(client)){
                    out.add(client);
                }
            }
        }

        return out;
    }
}
