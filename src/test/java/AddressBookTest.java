import com.bridgelabz.addressbook.AddressBookMain;
import com.bridgelabz.addressbook.Contacts;
import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {

    @Test
    public void givenContact_WhenProper_ShouldReturnTrue() {
        Contacts contact = new Contacts("Abcd","AAA","0000000000");
        AddressBookMain addressBookMain = new AddressBookMain();
        boolean contactStatus = addressBookMain.createContact(contact);
        Assert.assertEquals(true, contactStatus);
    }

    @Test
    public void givenNullContact_WhenCreated_ShouldReturnFalse() {
        Contacts contacts = null;
        AddressBookMain addressBookMain = new AddressBookMain();
        boolean contactStatus = addressBookMain.createContact(contacts);
        Assert.assertEquals(false, contactStatus);
    }
}