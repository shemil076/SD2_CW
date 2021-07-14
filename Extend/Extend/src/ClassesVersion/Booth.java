package ClassesVersion;

public class Booth {
    private int boothNumber;
    private String patientName;


    public Booth(){

    }

    public Booth(int boothNumber, String patientName)
    {
        this.setBoothNumber(boothNumber);
        this.setPatientName(patientName);
    }


//    public int getBoothNumber() {
//        return boothNumber;
//    }

    public void setBoothNumber(int boothNumber) {
        this.boothNumber = boothNumber;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

}

