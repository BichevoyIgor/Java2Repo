public class Main {
    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();
        book.add("8918768915", "Sidorov");
        book.add("8918748919", "Sidorov");
        book.add("8918768785", "Sidorov");
        book.add("8918779635", "Popov");
        book.get("sidorov");
    }
}
