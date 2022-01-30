/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookManager;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Yahya
 */
public class CommonBook extends Book implements IDateExceedable {

    String Owner;
    Date GivenDate;
    Date ReturnDate;
    static String Status;

    public CommonBook() {

    }

    public CommonBook(String Owner) {
        this.Owner = Owner;
    }

    public CommonBook(String Owner, Date GivenDate, Date ReturnDate, String Status) {
        this.Owner = Owner;
        this.GivenDate = GivenDate;
        this.ReturnDate = ReturnDate;
        this.Status = Status;
    }

    @Override
    public void isExceeded() {
        LocalDate localDate = LocalDate.now();
        Date thisdate = java.sql.Date.valueOf(localDate);
        if (ReturnDate.before(thisdate)) {
            CommonBook.Status = "Time Exceeded";
        } else {
            CommonBook.Status = "Time Remains";
        }
    }

}
