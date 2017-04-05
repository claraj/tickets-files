package com.company;

import java.util.Date;

/**
 * Created by we4954cp on 4/5/2017.
 */
public class Ticket {

    int id;
    String reporter;
    String issue;
    Date reported;

    public Ticket(int id, String reporter, String issue, Date reported) {
        this.id = id;
        this.reporter = reporter;
        this.issue = issue;
        this.reported = reported;
    }

    // for humans

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", reporter='" + reporter + '\'' +
                ", issue='" + issue + '\'' +
                ", reported=" + reported +
                '}';
    }


    // for computer

    public String stringForFile() {

        return id + Main.separator + reporter + Main.separator + issue + Main.separator + reported.getTime();


    }


}
