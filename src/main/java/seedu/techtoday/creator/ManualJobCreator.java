package seedu.techtoday.creator;

import seedu.techtoday.joblist.JobPrinter;
import seedu.techtoday.joblist.SavedJobList;

import seedu.techtoday.objects.Job;
import seedu.techtoday.ui.Ui;

/** Class representing a method used to create a job based on user input. */
public class ManualJobCreator {

    /** Executes the creation of a job object from user input. */
    public static void execute() {
        String title = getTitle();
        String text = getText();
        String category = getCategory();
        String extract = getExtract();
        String epochSecond = CurrentTimeFetcher.execute();
        Job job = new Job(title, text, category);
        job.setExtract(extract);
        job.setTime(epochSecond);
        SavedJobList.savedJobList.add(job);
        System.out.println("Done, we have added the job to your list of saved jobs");
        JobPrinter.printIsolatedJob(job);
    }

    /**
     * Function that asks and gets job title
     * @return String representation of title from user input
     */
    public static String getTitle() {
        System.out.println("Enter the title of the job?");
        return Ui.getCommand();
    }

    /**
     * Function that asks and gets job description
     * @return String representation of job description given by user.
     */
    public static String getText() {
        System.out.println("What is the job description/details?");
        return Ui.getCommand();
    }

    /**
     * Function that asks and gets job category
     * @return String representation of job category given by user
     */
    public static String getCategory() {
        System.out.println("What is the category (type \"default\" if you don't know it)");
        return Ui.getCommand();
    }

    public static String getExtract() {
        System.out.println("Would you like to add any extract?");
        return Ui.getCommand();
    }
}
