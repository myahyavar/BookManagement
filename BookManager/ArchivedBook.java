/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookManager;

import java.util.Date;

/**
 *
 * @author Yahya
 */
public class ArchivedBook extends Book {

    String Donater;
    Date ArchiveDate;

    public ArchivedBook() {
    }

    public ArchivedBook(String Donater, Date ArchiveDate) {
        this.Donater = Donater;
        this.ArchiveDate = ArchiveDate;
    }

}
