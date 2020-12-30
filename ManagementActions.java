package chocan;
import java.util.*;
import java.io.*;

public class ManagementActions {
	private ArrayList<MemberInfo> listMembers = new ArrayList<MemberInfo>();
	private ArrayList<PersonInfo> listProviders = new ArrayList<PersonInfo>();
	private ArrayList<ServiceInfo> listServices = new ArrayList<ServiceInfo>();
	
	/*private void informUser(int error) {
		switch (error) {
		case 1: 
			System.out.println("Member number not found.\n");
			break;
		case 2:
			System.out.println("Provider number not found.\n");
			break;
		}	
	}*/
	
	private int findMember(String number) {
		for (int i = 0; i < listMembers.size(); ++i) {
			if (number.equals(listMembers.get(i).getNumber())) return i;
		}
		return -1;
	}
	
	private int findProvider(String number) {
		for (int i = 0; i < listProviders.size(); ++i) {
			if (number.equals(listProviders.get(i).getNumber())) return i;
		}
		return -1;
	}
	
	public ManagementActions() throws IOException {
		File file1 = new File("textfiles/datafiles/memberList.txt");
		//Path path = Paths.get("memberList.txt");
		BufferedReader members = new BufferedReader(new FileReader(file1));
		
		do {
			String name = members.readLine();
			String number = members.readLine();
			String streetAddress = members.readLine();
			String city = members.readLine();
			String state = members.readLine();
			String zipCode = members.readLine();
			String status = members.readLine();
			listMembers.add(new MemberInfo(number, name, streetAddress, state, zipCode, city, status));
		} while (members.readLine() != null);
		members.close();
		
		File file2 = new File("textfiles/datafiles/providerList.txt");
		BufferedReader providers = new BufferedReader(new FileReader(file2));
		
		do {
			String name = providers.readLine();
			String number = providers.readLine();
			String streetAddress = providers.readLine();
			String city = providers.readLine();
			String state = providers.readLine();
			String zipCode = providers.readLine();
			listProviders.add(new PersonInfo(number, name, streetAddress, state, zipCode, city));
		} while (providers.readLine() != null);	
		providers.close();
			
		File file3 = new File("textfiles/datafiles/serviceList.txt");
		BufferedReader services = new BufferedReader(new FileReader(file3));
		
		do {
			String currentDateTime = services.readLine();
			String dateOfService = services.readLine();
			String providerNum = services.readLine();
			String memberNum = services.readLine();
			String serviceCode = services.readLine();
			String serviceFee = services.readLine();
			//String comments = services.readLine();
			listServices.add(new ServiceInfo(dateOfService, currentDateTime, serviceCode, serviceFee, memberNum, providerNum));
		} while (services.readLine() != null);
		services.close();
	}
	
	public String getMemberFile(String number) throws IOException {
		int index;
		
		index = findMember(number);
		if (index < 0) return "Member number not found.";
		
		String filename = listMembers.get(index).getName() + " " + java.time.LocalDate.now();
		//File newFile = new File(filename);
		BufferedWriter writer = new BufferedWriter(new FileWriter("textfiles/reportfiles/" + filename));
		writer.write(listMembers.get(index).getName() + "\n");
		writer.write(listMembers.get(index).getNumber() + "\n");
		writer.write(listMembers.get(index).getStreetAddress() + "\n");
		writer.write(listMembers.get(index).getCity() + "\n");
		writer.write(listMembers.get(index).getState() + "\n");
		writer.write(listMembers.get(index).getZipCode() + "\n");
		
		writer.write("\nServices provided:");
		for (int i = 0; i < listServices.size(); ++i) {
			if (listServices.get(i).getMemberNumber() == listMembers.get(index).getNumber()) {
				writer.write("\n\tDate of Service: " + listServices.get(i).getDateOfService() + "\n");
				int provider = findProvider(listServices.get(i).getProviderNumber());
				writer.write("\tProvider name: " + listProviders.get(provider).getName() + "\n");
				//writer.write("\t" + listServices.get(i).getServiceName() + "\n");
			}
		}
		
		writer.close();
		
		//System.out.println("File created successfully. Filename is " + filename + ".\n");
		return "File created successfully. Filename is " + filename + "\n";
	}
	
	public String getProviderFile(String number) throws IOException{
		int index;
		int totalConsultations = 0;
		int totalFee = 0;
		
		index = findProvider(number);
		if (index < 0) return "Provider number not found.";
		
		String filename = listProviders.get(index).getName() + " " + java.time.LocalDate.now() + ".txt";
		//String filename = listProviders.get(index).getName();  ////** add date *****/////
		//File newFile = new File(filename);
		BufferedWriter writer = new BufferedWriter(new FileWriter("textfiles/reportfiles/" + filename));
		writer.write(listProviders.get(index).getName() + "\n");
		writer.write(listProviders.get(index).getNumber() + "\n");
		writer.write(listProviders.get(index).getStreetAddress() + "\n");
		writer.write(listProviders.get(index).getCity() + "\n");
		writer.write(listProviders.get(index).getState() + "\n");
		writer.write(listProviders.get(index).getZipCode() + "\n");
		
		writer.write("\nServices provided:\n");
		for (int i = 0; i < listServices.size(); ++i) {
			if (listServices.get(i).getProviderNumber().equals(listProviders.get(index).getNumber())) {
				writer.write("\tDate of Service: " + listServices.get(i).getDateOfService() + "\n");
				writer.write("\tReceived by Computer: " + listServices.get(i).getCurrentDateTime() + "\n");
				int member = findMember(listServices.get(i).getMemberNumber());
				writer.write("\tMember name: " + listMembers.get(member).getName() + "\n");
				writer.write("\tMember number: " + listServices.get(i).getMemberNumber() + "\n");
				writer.write("\tService Code: " + listServices.get(i).getServiceCode() + "\n");
				writer.write("\tFee: " + listServices.get(i).getServiceFee() + "\n\n");
				totalConsultations++;;
				totalFee += Integer.parseInt(listServices.get(i).getServiceFee());
			}
		}
		
		writer.write("Number of Consultations: " + totalConsultations + "\n");;
		writer.write("Total fees: " + totalFee + "\n");
		
		writer.close();
		
		//System.out.println("File created successfully. Filename is " + filename + ".\n");
		return "File created successfully. Filename is " + filename + "\n";
	}
	
	public String getManagerFile() throws IOException {
		int numProviders = 0;
		int totalConsultations = 0;
		int totalFee = 0;
		
		String filename = "managerFile " + java.time.LocalDate.now() + ".txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter("textfiles/reportfiles/" + filename));
		
		for (int i = 0; i < listProviders.size(); ++i) {
			//String provider = listProviders.get(i).getNumber();
			numProviders++;
			int providerConsultations = 0;
			int providerFee = 0;
			
			writer.write("Provider: " + listProviders.get(i).getName() + "\n");
			
			for (int j = 0; j < listServices.size(); ++j) {
				if (listServices.get(j).getProviderNumber().equals(listProviders.get(i).getNumber())) {
					providerFee += Integer.parseInt(listServices.get(j).getServiceFee());
					providerConsultations++;
				}
			}
			
			writer.write("Number of Consultatoins: " + providerConsultations + "\n");
			writer.write("Total fees: " + providerFee + "\n\n");
			totalConsultations += providerConsultations;
			totalFee += providerFee;
		}
		
		writer.write("Number of providers: " + numProviders + "\n");
		writer.write("Total Number of Consultations: " + totalConsultations + "\n");
		writer.write("Overal fees: " + totalFee + "\n");
		writer.close();
		
		return "File created successfully. Filename is " + filename + "\n";
	}
	
	/*public void test() throws IOException {
		//String filename = "textfiles/reportfiles/" + listProviders.get(2).getName() + ".txt";
		//File newFile = new File(filename);
		//BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		int i = findProvider("356794815");
		if (i == -1) {
			System.out.println("Fail");
			return;
		}
		System.out.println(listProviders.get(i).getName());
		System.out.println(listProviders.get(i).getNumber());
		System.out.println(listProviders.get(i).getStreetAddress());
		System.out.println(listProviders.get(i).getCity());
		System.out.println(listProviders.get(i).getState());
		System.out.println(listProviders.get(i).getZipCode());
		/*writer.write(listProviders.get(2).getName());
		writer.write(listProviders.get(2).getNumber());
		writer.write(listProviders.get(2).getStreetAddress());
		writer.write(listProviders.get(2).getCity());
		writer.write(listProviders.get(2).getState());
		writer.write(listProviders.get(2).getZipCode());
		writer.close();
	}*/
}