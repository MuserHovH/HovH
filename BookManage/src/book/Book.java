package book;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Book {
    private String name;
    private String id;
    private String author;
    private String type;
    private int price;
    private boolean isBorrow;

    public Book(String name, String id, String author, String type, int price, boolean isBorrow) {
        this.name = name;
        this.id = id;
        this.author = author;
        this.type = type;
        this.price = price;
        this.isBorrow = isBorrow;
    }

    public String getId() {
        return id;
    }

    public boolean isBorrow() {
        return isBorrow;
    }

    public void setBorrow(boolean borrow) {
        isBorrow = borrow;
    }

    public String getName() {
        return name;
    }
    public String toString() {
        System.out.println("书名:" +"\t"+"书本id:" +"\t"+ "作者:" +"\t"+ "书本类型:" +"\t" +"书本价格:" + "\t"+"是否借出:");
        //System.out.println(name + "\t" + id + "\t" + author + "\t" +  type + "\t" + price + "\t" +isBorrow);
        return  name + "\t" + id + "\t\t" + author + "\t" +  type + "\t\t" + price + "\t\t\t" +isBorrow ;
    }
}
