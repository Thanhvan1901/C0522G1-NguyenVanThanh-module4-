package codegym.model;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_book")
    private String nameBook;

    @Column(name = "amount_book")
    private int amountBook;

    @Column(name = "sumBook")
    private int sumBook ;

    public Book() {
    }

    public Book(int id, String nameBook, int amountBook, int sumBook) {
        this.id = id;
        this.nameBook = nameBook;
        this.amountBook = amountBook;
        this.sumBook = sumBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getAmountBook() {
        return amountBook;
    }

    public void setAmountBook(int amountBook) {
        this.amountBook = amountBook;
    }

    public int getSumBook() {
        return sumBook;
    }

    public void setCodeBook(String codeBook) {
        this.sumBook = sumBook;
    }

}
