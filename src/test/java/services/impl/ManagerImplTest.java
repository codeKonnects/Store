package services.impl;

import model.Applicant;
import model.Manager;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerImplTest {
    Applicant qualifiedApplicant;
    Applicant unqualifiedApplicant;
    Manager manager;
    ManagerImpl managerImpl;

    @BeforeEach
    void setUp() {
        qualifiedApplicant = new Applicant("Oye", 4, 25);
        unqualifiedApplicant = new Applicant("Jude", 1, 21);
        manager = new Manager("Leke", "23-01");
        managerImpl = new ManagerImpl(manager);

    }

    @Test
    void hireApplicant() {
        String hired = managerImpl.hireApplicant(qualifiedApplicant);
        String notHired = managerImpl.hireApplicant(unqualifiedApplicant);
        Assert.assertEquals("congratulation Oye you're hired",hired);

        Assert.assertEquals("Sorry Jude application unsuccessful", notHired);

    }
}