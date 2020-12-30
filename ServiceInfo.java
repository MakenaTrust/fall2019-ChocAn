package chocan;
public class ServiceInfo {
	private String dateOfService = new String();
	private String currentDateTime = new String();
	private String serviceCode = new String();
	private String serviceFee = new String();
	private String memberNumber = new String();
	private String providerNumber = new String();
	private String comment = new String();
	
	public ServiceInfo (String setDateOfService, String setCurrentDateTime, String setServiceCode, String setServiceFee, String setMemberNum, String setProviderNum, String setComment) {
		dateOfService = setDateOfService;
		currentDateTime = setCurrentDateTime;
		serviceCode = setServiceCode;
		serviceFee = setServiceFee;
		memberNumber = setMemberNum;
		providerNumber = setProviderNum;
		comment = setComment;
	}

	public void setDateOfService(String newDateOfService)
	{
		dateOfService=newDateOfService;
	}
	public String getDateOfService()
	{
		return dateOfService;
	}
	public void setCurrentDateTime(String newCurrentDateTime)
	{
		currentDateTime=newCurrentDateTime;
	}
	public String getCurrentDateTime()
	{
		return currentDateTime;
	}
	public void setServiceCode(String newServiceCode)
	{
		serviceCode=newServiceCode;
	}
	public String getServiceCode()
	{
		return serviceCode;
	}
	public void setServiceFee(String newServiceFee)
	{
		serviceFee=newServiceFee;
	}
	public String getServiceFee()
	{
		return serviceFee;
	}
	public void setMemberNumber(String newMemberNumber)
	{
		memberNumber=newMemberNumber;
	}
	public String getMemberNumber()
	{
		return memberNumber;
	}
	public void setProviderNumber(String newProviderNumber)
	{
		providerNumber=newProviderNumber;
	}
	public String getProviderNumber()
	{
		return providerNumber;
	}
	public void setComment(String newComment)
	{
		comment=newComment;
	}
	public String getComment()
	{
		return comment;
	}
}
