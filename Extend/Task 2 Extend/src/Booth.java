public class Booth {
    private int boothNumber;
    private String patientFirstName;

    public Booth(){

    }

    public Booth( String patientFirstName)
    {
        this.patientFirstName = patientFirstName;
    }


//    public int getBoothNumber() {
//        return boothNumber;
//    }

    public void setBoothNumber(int boothNumber) {
        this.boothNumber = boothNumber;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

}

