package chocan;
public class PersonInfo {
	protected String name = new String();
	protected String number = new String();
	protected String streetAddress = new String();
	protected String state = new String();
	protected String zipCode = new String();
	protected String city = new String();
	
	public PersonInfo(String setNumber, String setName, String address, String setState, String setZipCode, String setCity) {
		number = setNumber;
		name = setName;
		streetAddress = address;
		city = setCity;
		zipCode = setZipCode;
		state = setState;
	}

	public void setName(String newName)
	{
		name=newName;
	}
	public String getName()
	{
		return name;
	}	
	public void setNumber(String newNumber)
	{
		number=newNumber;
	}
	public String getNumber()
	{
		return number;
	}
	public void setStreetAddress(String newStreetAddress)
	{
		streetAddress=newStreetAddress;
	}
	public String getStreetAddress()
	{
		return streetAddress;
	}

	public void setState(String newState)
	{
		state=newState;
	}
	public String getState()
	{
		return state;
	}
	public void setZipCode(String newZipCode)
	{
		zipCode=newZipCode;
	}
	public String getZipCode()
	{
		return zipCode;
	}
	public void setCity(String newCity)
	{
		city=newCity;
	}
	public String getCity()
	{
		return city;
	}
}