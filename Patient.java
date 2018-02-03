import java.util.Random;

/**
 * Patient is a class that holds data pertinent to a hospital patient inside of
 * a health system
 * 
 * @author Prince Duepa
 *
 */
public class Patient {
	private static Random rand = new Random();
	private static int lastMRN;
	private String firstName;
	private String lastName;
	private String middleName;
	private String dob;
	private String address;
	private int mrn;

	/**
	 * CONSTRUCTOR: Create a new patient with the specified info
	 * 
	 * @param first
	 *            first-name of the patient
	 * @param last
	 *            last-name of the patient
	 * @param dob
	 *            Date of Birth for the patient in MM/DD/YYYY format
	 */
	public Patient(String first, String last, String dob) {
		this.dob = dob;
		firstName = first;
		lastName = last;

		int newMRN = Math.abs(rand.nextInt());
		while (newMRN == lastMRN) {
			newMRN = Math.abs(rand.nextInt());
		}
		mrn = newMRN;
		lastMRN = newMRN;
	}

	/**
	 * CONSTRUCTOR: Create a new patient with the specified info
	 * 
	 * @param first
	 *            first-name of the patient
	 * @param last
	 *            last-name of the patient
	 * @param middle
	 *            middle-name of the patient
	 * @param dob
	 *            Date of Birth for the patient in MM/DD/YYYY format
	 */
	public Patient(String first, String last, String middle, String dob) {
		this.dob = dob;
		firstName = first;
		lastName = last;
		middleName = middle;

		int newMRN = Math.abs(rand.nextInt());
		while (newMRN == lastMRN) {
			newMRN = Math.abs(rand.nextInt());
		}
		mrn = newMRN;
		lastMRN = newMRN;
	}

	/**
	 * Update the address of this patient
	 * 
	 * @param address
	 *            new patient address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Get the address of the this patient
	 * 
	 * @return the address of this patient
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Get the date of birth for this patient
	 * 
	 * @return date of birth of this patient
	 */
	public String getDOB() {
		return dob;
	}

	/**
	 * Get the patient's first name
	 * 
	 * @return first name of the patient
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Get the patient's last name
	 * 
	 * @return last name of the patient
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Get the patient's middle name
	 * 
	 * @return middle name of the patient
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Get the full name of the patient
	 * 
	 * @return patient's full legal name
	 */
	public String getFullName() {
		StringBuilder b = new StringBuilder();
		b.append(firstName).append(" ");
		if (middleName != null) {
			b.append(middleName).append(" ");
		}
		b.append(lastName);

		return b.toString();
	}

	/**
	 * Get the Medical Record Number for this patient
	 * 
	 * @return the patient's MRN.
	 */
	public int getMRN() {
		return mrn;
	}

	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("MRN #: ").append(getMRN());
		b.append("\nName: ").append(getFullName());
		b.append("\nDOB: ").append(getDOB());
		if (address != null) 
		{
			b.append("\nAddress: ").append(getAddress());
		} else {
			b.append("\nNo address available");
		}
		return b.toString();
	}
}
