/**
 * Consider this incomplete Employee class to answer some questions of your exam
 *
 * @author Tassia
 * @version 0.1
 */
public class Employee{
    private String fullname;
    private int yearOfBirth;
    private boolean onLeave;
    private double hourlyWage;
    private double unpaidHours;
    private int vacationDays;

    public Employee(String fullname, int yearOfBirth, double hourlyWage){
        this.fullname = fullname;
        this.yearOfBirth = yearOfBirth;
        this.hourlyWage = hourlyWage;
        onLeave = false;
        unpaidHours = 0.0;
        vacationDays = 14;
    }
    
    /**
     * Returns true is an employee is above 16 years old
     */
    private int calculateAge(int currentYear){
        return (currentYear - yearOfBirth);
    }
    
    // Question 11
        //Setter
    public void setOnLeave(boolean isOnLeave){
        onLeave = isOnLeave;
    }
        //Getter
    public boolean getOnLeave(){
        return onLeave;
    }
    
    // Question 12
    /**
     * Returns true is an employee is above 16 years old
     */
    public boolean canDrive(){
        int age = calculateAge(2025);
        if (age >= 16) {
            System.out.println("This employee can drive.");
            return true;
        } else {
            int remainingYears = 16 - age;
            System.out.printf("The employee can start driving in %d years %n", remainingYears);
            return false;
        }
    }
    
    // Question 13
    /*
     * Returns the net pay for the outstanding unpaid hours
     */
    private double calculatePay(){
      double total = unpaidHours * hourlyWage;
      double netPay = total - (total * 0.3);
      return netPay;
    }

    // Question 14
    /*
     * Output the payment record and resets unpaid hours
     */
    public void paySalary(){
        double pay = calculatePay();
        System.out.printf("%s has received a wire transfer of %.2f + CAD %n", fullname, pay);
        unpaidHours = 0.0;
    }
    
    
    //Improvements
    
        //workShift
    public void workShift(double hoursWorked){
        unpaidHours += hoursWorked;
    }
    
        //VacationDays
    public void useVacationDays(int numberOfDays){
        if (vacationDays >= numberOfDays){
        vacationDays -= numberOfDays;
        onLeave = true;
        } else {
            System.out.printf("You only have %d vacation days remaining. %n", vacationDays);
        }
    }
    public void returnFromVacation(){
        onLeave = false;
        System.out.printf("%s has returned from vacation. They have %d vacation days remaining.%n", fullname, vacationDays);
    }
    public int getVacationDays(){
        return vacationDays;
    }
    public void setVacationDays(int numberOfDays){
        System.out.printf("Number of vacation days for %s changed from %d days to %d days.%n", fullname, vacationDays, numberOfDays);
        vacationDays = numberOfDays;
    }
}