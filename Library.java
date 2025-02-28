import java.util.Scanner;

class Book{
    int id;
    String tittle;
    String author;
    boolean isIssued;

    public Book(int id, String tittle, String author) {
        this.id       = id;
        this.tittle   = tittle;
        this.author   = author;
        this.isIssued = false;
    }
}
public class Library {
    static Book[] books=new Book[100];
    static int bookCount=0;
    public static void addBook(int id,String tittle,String author){
        books[bookCount]=new Book(id,tittle,author);
        bookCount++;
        System.out.println("Book added successfully");
    }
    public static void issueBook(int id){
        for(int i=0;i<bookCount;i++){
            if(books[i].id==id){
                if(!books[i].isIssued){
                    books[i].isIssued=true;
                    System.out.println("Book issued successfully");
                }else{
                    System.out.println("Book is already issued");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }
    public static void returnBook(int id){
        for(int i=0;i<bookCount;i++){
            if(books[i].id==id){
                if(!books[i].isIssued){
                    books[i].isIssued=false;
                    System.out.println("Book returned successfully");
                }else{
                    System.out.println("Book was not issued");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }
    public static void displayBooks(){
        if(bookCount==0){
            System.out.println("No books available");
        }else{
            System.out.println("ID | Tittle | Author | status");
            for (int i=0;i<bookCount;i++){
                String status=books[i].isIssued ? "Issued" : "Available";
                System.out.println(books[i].id+" | "+books[i].tittle+" | "+books[i].author+" | "+status);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");
            int choice= sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter book ID: ");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter book tittle: ");
                    String tittle=sc.nextLine();
                    System.out.println("Enter book author: ");
                    String author=sc.nextLine();
                    addBook(id,tittle,author);
                    break;
                case 2:
                    System.out.println("Enter book ID to issue: ");
                    id=sc.nextInt();
                    issueBook(id);
                    break;
                case 3:
                    System.out.println("Enter book ID to return: ");
                    id= sc.nextInt();
                    returnBook(id);
                    break;
                case 4:
                    displayBooks(); break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}