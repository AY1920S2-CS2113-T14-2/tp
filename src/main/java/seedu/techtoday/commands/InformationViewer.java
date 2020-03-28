package seedu.techtoday.commands;

import seedu.techtoday.api.apiviewjobs.JsonJobsReader;
import seedu.techtoday.api.apiviewnews.JsonNewsReader;
import seedu.techtoday.articlelist.ArticleListPrinter;
import seedu.techtoday.articlelist.SavedArticleList;
import seedu.techtoday.common.Messages;
import seedu.techtoday.joblist.JobListPrinter;
import seedu.techtoday.joblist.SavedJobList;
import seedu.techtoday.storage.InBuiltArticleListGenerator;
import seedu.techtoday.storage.InBuiltJobListGenerator;

import java.io.IOException;

/** Class representing the viewing of articles, jobs and notes from their respective lists. */
public class InformationViewer {

    /**
     * Executes the viewing of a note/article/job.
     * @param userResponse - Input of the user in the command line.
     */
    public static void execute(String userResponse) {
        try {
            String type = userResponse.split(" ")[1];
            System.out.println("Loading information from the internet... \n");
            if (type.equals("job")) {
                try {
                    JsonJobsReader.viewNewJobs();
                } catch (IOException e) {
                    System.out.println("Your device is not connected to the internet, "
                            + "we will load pre-existing jobs");
                    InBuiltJobListGenerator.execute();
                    JobListPrinter.execute(SavedJobList.savedJobList);
                }
            } else if (type.equals("article")) {
                try {
                    JsonNewsReader.viewNewNews();
                } catch (IOException e) {
                    System.out.println("Your device is not connected to the internet, "
                            + "we will load pre-existing articles \n");
                    InBuiltArticleListGenerator.execute();
                    ArticleListPrinter.execute(SavedArticleList.savedArticleList);
                }
            } else {
                System.out.print("Sorry! You can only view article/job! "
                        + "Your command format is incorrect. Try again \n");
                return;
            }
            return;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("View command is incorrect. It should be of the following form: \n");
            Messages.printInCenter("1. view [article / job]");
            return;
        }
    }
}