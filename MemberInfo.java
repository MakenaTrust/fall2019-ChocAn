package chocan;
public class MemberInfo extends PersonInfo{
	private String status = new String();
	
	public MemberInfo(String setNumber, String setName, String address, String setState, String setZipCode, String setCity, String setStatus) {
		super(setNumber, setName, address, setCity, setZipCode, setState);
		status = setStatus;
	}
//
//	public void setName(String newName)
//	{
//		name=newName;
//	}	
//	public String getName()
//	{
//		return name;
//	}	
//	public void setNumber(String newNumber)
//	{
//		number=newNumber;
//	}
//	public String getNumber()
//	{
//		return number;
//	}
//	public void setStreetAddress(String newStreetAddress)
//	{
//		streetAddress=newStreetAddress;
//	}
//	public String getStreetAddress()
//	{
//		return streetAddress;
//	}
//	public void setState(String newState)
//	{
//		state=newState;
//	}
//	public String getState()
//	{
//		return state;
//	}
//	public void setZipCode(String newZipCode)
//	{
//		zipCode=newZipCode;
//	}
//	public String getZipCode()
//	{
//		return zipCode;
//	}
//	public void setCity(String newCity)
//	{
//		city=newCity;
//	}
//	public String getCity()
//	{
//		return city;
//	}	
	public void setStatus(String newStatus)
	{
		status=newStatus;
	}	
	public String getStatus()
	{
		return status;
	}
}