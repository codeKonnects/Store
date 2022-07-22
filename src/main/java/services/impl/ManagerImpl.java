package services.impl;

import model.Applicant;
import model.Manager;
import services.ManagerService;

public class ManagerImpl implements ManagerService {
    Manager manager;

    public ManagerImpl(Manager manager) {
        this.manager = manager;
    }

    String hiredMessage ="", notHiredMessage = "";
    @Override
    public String hireApplicant(Applicant applicant) {
        /*
    the applicant should only be hired if
    the age is >= to the minimum age required
    and the years of experience >= experience required
     */

        int minimumAge = 23;
        int requiredYearsOfExperience = 3;
        int applicantAge = applicant.getAge();
        int applicantExperience = applicant.getYearsOfExperience();
        if (applicantAge >= minimumAge && applicantExperience >= requiredYearsOfExperience){
            return hiredMessage = "congratulation " + applicant.getName() + " you're hired";
        }

        return notHiredMessage = "Sorry " + applicant.getName() + " application unsuccessful";
    }
}

