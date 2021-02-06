import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> phoneBook = new HashMap<>();

    public void add(String phoneNumber, String family) {
        phoneBook.put(phoneNumber, family);
    }

    public void get(String family) {
        for (Map.Entry<String, String> getPhone : phoneBook.entrySet()) {
         if (getPhone.getValue().equalsIgnoreCase(family)) System.out.println(getPhone.getKey());
        }
    }
}
