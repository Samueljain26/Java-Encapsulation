// Main class
public class HospitalManagement {
    public static void main(String[] args) {
        Patient inPatient = new InPatient(101, "Alice", 45, 5, 2000);
        Patient outPatient = new OutPatient(102, "Bob", 30, 1500);

        processPatient(inPatient);
        processPatient(outPatient);
    }

    public static void processPatient(Patient patient) {
        patient.getPatientDetails();
        System.out.println("Total Bill: $" + patient.calculateBill());
        System.out.println("---------------------------------");
    }
}

// Abstract class
abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = "Not Available";  // Default value
    }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }

    public abstract double calculateBill();

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
}

// Interface: MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}

// Subclass: InPatient
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;
    private String medicalHistory;

    public InPatient(int patientId, String name, int age, int daysAdmitted, double dailyCharge) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
        this.medicalHistory = "No records";
    }

    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    public void addRecord(String record) {
        this.medicalHistory = record;
    }

    public String viewRecords() {
        return "Medical History: " + medicalHistory;
    }
}

// Subclass: OutPatient
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String medicalNotes;

    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalNotes = "No records";
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        this.medicalNotes = record;
    }

    public String viewRecords() {
        return "Medical Notes: " + medicalNotes;
    }
}
/*Patient ID: 101, Name: Alice, Age: 45
Total Bill: $10000.0
---------------------------------
Patient ID: 102, Name: Bob, Age: 30
Total Bill: $1500.0
---------------------------------
 */