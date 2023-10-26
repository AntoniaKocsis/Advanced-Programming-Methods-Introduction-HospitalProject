package Interfaces;

import java.util.Date;

public interface UpdatePersonInfoInterface {
    public boolean updateFirstName(int ID, String name);

    public boolean updateLastName(int ID, String name);

    public boolean updateContact(int ID, String contact);

    public boolean updateAddress(int ID, String address);

    public boolean updateBirthDate(int ID, Date date);

}
