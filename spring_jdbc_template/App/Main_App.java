package App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDao;
import dao.UserDaoImp;
import pojo.User;

public class Main_App {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		UserDaoImp userdaoi = (UserDaoImp)context.getBean("userDao");
		
		
		int choice = 1;
		String username="", fullname="", password="", email="";
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(choice != 0 )
		{
			System.out.println(" -------------  MENU ----------");
			System.out.println("1. Insert user");
			System.out.println("2. update user");
			System.out.println("3. delte user");
			System.out.println("4. select user");
			System.out.println("5. view users");
			
			choice = Integer.parseInt(br.readLine());
			
			switch(choice)
			{
			case 1 : System.out.println("Enter the fullname");
					 fullname = br.readLine();
					 System.out.println("Enter the email");
					 email = br.readLine();
					 System.out.println("Enter the username");
					 username = br.readLine();
					 System.out.println("Enter the password");
					 password = br.readLine();
					 
					 userdaoi.create(fullname, email, username, password);
				break;
				
			case 2 : System.out.println("Enter the username");
					 username = br.readLine();
					 System.out.println("Enter the password");
					 password = br.readLine();
					 userdaoi.update(username, password);
				break;
			case 3 : System.out.println("Enter the username to be deleted");
					 username = br.readLine();
					 
					 userdaoi.delete(username);
			    break;
			case 4 : System.out.print("Enter the username");
					 username = br.readLine();
					 User user1= userdaoi.getUser(username);
		        	 System.out.println("Full name "+user1.getFullname());
		        	 System.out.println("Email "+user1.getEmail());
		        	 System.out.println("Username "+user1.getUsername());
		        	 System.out.println("Password "+user1.getPassword());
			    break;
			case 5 : List<User> user = userdaoi.ListUser();
			         for (User record: user)
			         {
			        	 System.out.println("Full name "+record.getFullname());
			        	 System.out.println("Email "+record.getEmail());
			        	 System.out.println("Username "+record.getUsername());
			        	 System.out.println("Password "+record.getPassword());
			         }
			break;
				
			}
			
			
			
		}

	}

}
