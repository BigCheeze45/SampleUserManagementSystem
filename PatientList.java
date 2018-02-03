import java.util.ArrayList;

public class PatientList extends ArrayList<Patient> {

	/**
	 * Get a the list of patient's last, first names
	 * @return the list of patient names
	 */
	public String[] getNameArray() {
		String[] ret = new String[size()];

		for (int i = 0; i < ret.length; i++) {
			StringBuilder b = new StringBuilder();
			b.append(get(i).getLastName()).append(", ").append(get(i).getFirstName());
			ret[i] = b.toString();
		}
		return ret;
	}
}
