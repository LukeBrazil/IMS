
# IMS Project

Inventory Management System Made for QA.


## Deployment

Clone repository and compile on Terminal or Eclipse using the Runner.java file.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

J2SE - 1.5

## Created By

Luke Brazil


## Code Snippets

 # Read All Customers
```
{
	public void showAllCustomers() {
		Statement stmt = null;
		ResultSet rslt = null;

		try {

			Connection con = null;

			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			rslt = stmt.executeQuery("SELECT * FROM customers");
			while (rslt.next()) {
				int id = rslt.getInt("customer_id");
				String firstName = rslt.getString("first_name");
				String lastName = rslt.getString("last_name");
				int age = rslt.getInt("age");
				String response = "ID: " + id + " First Name: " + firstName + " Last Name: " + lastName + " age: "
						+ age;
				System.out.println(response);

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
```

# Method to Initiate Portal

```
static void initiatePortal() {
		char option = '\0';
		menuMessage();
		
		do {
			SqlCon myCon = new SqlCon();
			Scanner myInput = new Scanner(System.in);
			char chosenInput = myInput.next().charAt(0);
			option = Character.toUpperCase(chosenInput);
			switch(option) {
			case 'A':
				Scanner myObj = new Scanner(System.in);
				System.out.println("Enter First Name: ");
				String first_name = myObj.next();
				System.out.println(first_name);
				System.out.println("Enter Last Name: ");
				String last_name = myObj.next();
				System.out.println(last_name);
				System.out.println("Enter Age: ");
				int age = myObj.nextInt();
				System.out.println(age);
				myCon.addCustomer(first_name, last_name, age);
				menuMessage();
				break;
			case 'B':
				myCon.showAllCustomers();
				menuMessage();
				break;
			case 'C':
				myCon.showItems();
				menuMessage();
				break;
			case 'D':
				myCon.createOrder();
				menuMessage();
				break;
			case 'E':
				myCon.addItemsToOrder();
				menuMessage();
				break;
			case 'F':
				myCon.showOrders();
				menuMessage();
				break;
			case 'G':
				myCon.addItem();
				menuMessage();
				break;
			case 'H':
				myCon.updateItem();
				menuMessage();
				break;
			case 'I':
				myCon.deleteItem();
				menuMessage();
				break;
			default:
				System.out.println("Please Choose a valid option: A, B, C, D, E, or F.");
				menuMessage();
				break;
			}
		} while(option != 'M');
		System.out.println("Thank you for using the inventory managment system!");
		
	}
```
