package ClassesVersion;

public class Patient extends Booth{
    private String surName;
    private int age;
    private String city;
    private String idNumber;
    private String vaccinationRequest;

    public Patient(int boothNumber , String patientsName){
        super(boothNumber , patientsName);

    }
    public Patient(String surName,int age,String city,String idNumber,String vaccinationRequest){

        this.surName = surName;
        this.age = age;
        this.city = city;
        this.idNumber = idNumber;
        this.vaccinationRequest = vaccinationRequest;


    }

    public String getsurName() {
        return surName;
    }

    public void setsurName(String surname) {
        surName = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getIdNumber() {

        return idNumber;
    }

    public void setIdNumber(String idNumber) {

        this.idNumber = idNumber;
    }

    public String getVaccinationRequest() {

        return vaccinationRequest;
    }

    public void setVaccinationRequest(String vaccinationRequest) {
        this.vaccinationRequest = vaccinationRequest;
    }

}
