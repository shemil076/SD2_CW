public class Patient extends Booth{
    private String patientLastName;
    private int patientAge;
    private String patientCity;
    private int patientIdNumber;
    private String patientVaccineType;

    public Patient(){

    }

    public Patient(String patientFirstName, String patientLastName, int patientAge, String patientCity, int patientIdNumber ,String patientVaccineType) {
        super(patientFirstName);
        this.setPatientLastName(patientLastName);
        this.setPatientAge(patientAge);
        this.setPatientCity(patientCity);
        this.setPatientIdNumber(patientIdNumber);
        this.setPatientVaccineType(patientVaccineType);
    }


    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientCity() {
        return patientCity;
    }

    public void setPatientCity(String patientCity) {
        this.patientCity = patientCity;
    }

    public int getPatientIdNumber() {
        return patientIdNumber;
    }

    public void setPatientIdNumber(int patientIdNumber) {
        patientIdNumber = patientIdNumber;
    }

    public String getPatientVaccineType() {
        return patientVaccineType;
    }

    public void setPatientVaccineType(String patientVaccineType) {
        this.patientVaccineType = patientVaccineType;
    }

    public void viewPatientDetails(){
        System.out.println("First name of the patient  : " + getPatientFirstName());
        System.out.println("Last name of the patient   : " + patientLastName);
        System.out.println("Age of the patient         : " + patientAge);
        System.out.println("Current city of the patient: " + patientCity);
        System.out.println("NIC/PASSPORT number        : " + patientIdNumber);
        System.out.println("Selected vaccination type  : " + patientVaccineType);
    }

}
