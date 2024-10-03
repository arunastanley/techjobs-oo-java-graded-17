package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId(){
    Job job1 = new Job();
    Job job2 = new Job();
        assertNotEquals(job1.getId(),job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job newJob = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals(newJob.getName(),"Product tester");
        assertEquals(newJob.getEmployer().getValue(),"ACME");
        assertEquals(newJob.getLocation().getValue(),"Desert");
        assertEquals(newJob.getPositionType().getValue(),"Quality control");
        assertEquals(newJob.getCoreCompetency().getValue(),"Persistence");

        assertTrue(newJob.getEmployer() instanceof Employer);
        assertTrue(newJob.getLocation() instanceof Location);
        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(newJob.getName() instanceof String);


    }
    @Test
    public void testJobsForEquality(){
        Job jobA = new Job("Data Base", new Employer("Citi"),
                new Location("Kentucky"),
                new PositionType("Data Analyst"),
                new CoreCompetency("Persistence"));
        Job jobB = new Job("Data Base", new Employer("Citi"),
                new Location("Kentucky"),
                new PositionType("Data Analyst"),
                new CoreCompetency("Persistence"));
        assertNotEquals(jobA, jobB);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job jobA = new Job("Data Base", new Employer("Citi"),
                new Location("Kentucky"),
                new PositionType("Data Analyst"),
                new CoreCompetency("Persistence"));
        assertEquals(jobA.toString().startsWith(System.lineSeparator()),true);
        assertEquals(jobA.toString().endsWith(System.lineSeparator()),true);

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job jobA = new Job("Data Base", new Employer("Citi"),
                new Location("Kentucky"),
                new PositionType("Data Analyst"),
                new CoreCompetency("Persistence"));

        int id= jobA.getId();

        assertTrue(jobA.toString().contains("ID: " + id + System.lineSeparator()));
        assertTrue(jobA.toString().contains("Name: Data Base"+ System.lineSeparator()));
        assertTrue(jobA.toString().contains("Employer: Citi"+ System.lineSeparator()));
        assertTrue(jobA.toString().contains("Location: Kentucky"+ System.lineSeparator()));
        assertTrue(jobA.toString().contains("Position Type: Data Analyst"+ System.lineSeparator()));
        assertTrue(jobA.toString().contains("Core Competency: Persistence"));

    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job jobA = new Job("", new Employer(""),
                new Location(""),
                new PositionType(""),
                new CoreCompetency(""));

        assertTrue(jobA.toString().contains("Name: Data not available"+ System.lineSeparator()));
        assertTrue(jobA.toString().contains("Employer: Data not available"+ System.lineSeparator()));
        assertTrue(jobA.toString().contains("Location: Data not available"+ System.lineSeparator()));
        assertTrue(jobA.toString().contains("Position Type: Data not available"+ System.lineSeparator()));
        assertTrue(jobA.toString().contains("Core Competency: Data not available"));


    }

    @Test
    public void testToCheckJobWithJustID(){
        Job emptyJob = new Job();
        assertTrue(emptyJob.toString().contains("OOPS! This job does not seem to exist"));
    }
}
