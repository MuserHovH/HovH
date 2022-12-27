package book;

public class BookList {
    private Book[] books = new Book[10];
    private int size;

    public BookList() {
        books[0] = new Book("笑嘻嘻",
                "001", "兰陵王","搞笑死你",
                999, false);
        books[1] = new Book("找老婆",
                "002", "颜部头","干死你丫",
                888, false);
        books[2] = new Book("大头娃",
                "003", "小志志","大头脚丫",
                520, false);
        books[3] = new Book("如何使",
                "004", "猪猪侠","吵吵啥啊",
                897, false);
        size = 4;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Book getBook(int index) {
        return books[index];
    }

    public void setBooks(int index, Book book) {
        books[index] = book;
    }
}
