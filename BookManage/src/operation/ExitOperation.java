package operation;

import book.BookList;

public class ExitOperation implements  IOperation {
    public void work(BookList bookList) {
        System.out.println("GoodBye!");
        System.exit(0);
    }
}
