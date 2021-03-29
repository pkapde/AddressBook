import com.bridgelabz.addressbook.AddressBookMain;
import com.bridgelabz.addressbook.Contact;
import org.junit.Assert;
import org.junit.Test;


public class AddressBookTest {

    @Test
    public void givenContact_WhenProper_ShouldReturnTrue() {
        Contact contact = new Contact("Abcd","AAA","0000000000","aaa","aaaa","abc@gmail.com","aaa","aaa");
        AddressBookMain addressBookMain = new AddressBookMain();
        boolean contactStatus = addressBookMain.createContact(contact);
        Assert.assertEquals(true, contactStatus);
    }

    @Test
    public void givenNullContact_WhenCreated_ShouldReturnFalse() {
        Contact contact = null;
        AddressBookMain addressBookMain = new AddressBookMain();
        boolean contactStatus = addressBookMain.createContact(contact);
        Assert.assertEquals(false, contactStatus);
    }
}
