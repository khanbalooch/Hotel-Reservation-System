import java.util.*;
import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


class driver
{
	public static void main(String [] Args)
	{
		Console console = System.console();
		
		Hotel hotel = new Hotel();
		//hotel.ReserveRoom();
		Scanner input = new Scanner(System.in);
		BufferedReader mbr = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\n\n\t\t\t\t\tAdmin");
		boolean loop1 = true;
		int ch1=0;
		
		do
		{
		
			System.out.print("\t1). Initial Setting\n\t2). Reserve Room\n\t3).Check-in Room\n\t4). Check-out Room\n\t5). Generate Reports\n\t6). Exit\n\n");
			System.out.println("");
			System.out.print("Enter your choice Here: ");
			ch1 = input.nextInt();
			switch(ch1)
			{
				case 1:
					int ch11;
					boolean loop11 = true ;
					do
					{
						System.out.print("\n\t1).Create new Hotel\n\t2).Use Existing  Hotel\n\t3).add new room\n\t4).add new floor\n\t5).Main Menu\n\nEnter your choice Here: ");
						ch11 = input.nextInt();
						
						switch(ch11)
						{
						case 1:
							System.out.print("Enter Hotel Name:");
							String name;
							try
							{
								File createfile = new File("Hotel.bat");
								createfile.createNewFile();
								FileOutputStream hotelfile = new FileOutputStream(createfile);
								ObjectOutputStream writedata = new ObjectOutputStream(hotelfile);
								
								 name = mbr.readLine();
								 hotel.setNew(name);
								 writedata.writeObject(hotel);
								 writedata.close();
								 
							}catch(Exception E)
							{
								System.out.println(E);
							}
						
							 break;
						case 2:
							File checkfile = new File("Hotel.bat");
							if(checkfile.exists())
							{
								try
								{
									FileInputStream hotelfile = new  FileInputStream(checkfile);
									ObjectInputStream readdata = new ObjectInputStream(hotelfile);
									hotel = (Hotel) readdata.readObject();
									readdata.close();
									System.out.println(hotel.toString() );
									System.out.println("Data retrieved");
									
								}catch(Exception E)
								{
									System.out.print(E);
								}
							} else
							{
							System.out.println("No previous data exists..Create New Hotel");
							}
							 break;
						case 3:
							hotel.addRoom();
							 break;
						case 4:
							hotel.addFloor();
							 break;
						
						case 5: 
							loop11 = false; 
							break;
						
						}
					
					}while(loop11);
					 break;
				case 2:
					hotel.Display();
					hotel.ReserveRoom();
					
				
					 break;
				case 3: 
				
					break;
				case 4: 
				
					break;
				case 5: 
				
					break;
				case 6: 
					loop1 = false;
					break;
			}
		
		}while(loop1);	
	}
}



class Floor implements Serializable
{
	int floorNo;
	Room  Rooms[][] = new Room[5][];
	int ROOM_COUNT[] = new int[5];


	public void  setFloor(Floor cfloor)
	{
		this.floorNo=cfloor.floorNo;
		
		
		for(int i=0; i<5; i++)
		{
		
		this.ROOM_COUNT[i]=cfloor.ROOM_COUNT[i];
		this.Rooms[i] = new Room[]
		}
		
		this.Rooms[0] = new Standard_room[ROOM_COUNT[0]];
		this.Rooms[1] = new Moderate_room[ROOM_COUNT[1]];
		this.Rooms[2] = new Superior_room[ROOM_COUNT[2]];
		this.Rooms[3] = new JuniorSuite_room[ROOM_COUNT[3]];
		this.Rooms[4] = new Suite_room[ROOM_COUNT[4]];

		int room=0;
		for(int i=0; i<ROOM_COUNT[0]; i++)
		{ 
			Rooms[0][i] = new Standard_room( ( (flr*1000)+(100*1)+(++room) ), cfloor.Rooms[0][1].price ,flr,0);
		}
		
		
		 
		
		
		for(int i=0; i<ROOM_COUNT[1]; i++)
		{ 
			Rooms[1][i] = new Moderate_room( ( (flr*1000)+(200*1)+(++room) ), cfloor.Rooms[1][1].price ,flr,0);
		}
		
		
		
		
		for(int i=0; i<ROOM_COUNT[2]; i++)
		{ 
			Rooms[2][i] = new Superior_room(( (flr*1000)+(300*1)+(++room) ), cfloor.Rooms[2][1].price ,flr,0);
		}
		
		
		
		for(int i=0; i<ROOM_COUNT[3]; i++)
		{ 
			Rooms[3][i] = new JuniorSuite_room(( (flr*1000)+(400*1)+(++room) ), cfloor.Rooms[3][1].price ,flr,0);
		}
		
		
		
		for(int i=0; i<ROOM_COUNT[4]; i++)
		{ 
			Rooms[4][i] = new Suite_room(( (flr*1000)+(500*1)+(++room) ),cfloor.Rooms[4][1].price ,flr,0);
		}
	
	
	
	}
	
	public void setFloor(int flr, int [][]ROOM_COUNT_PRICE)
	{
	
		floorNo = flr;
		for(int  i=0;i<5 ;i++)
		{
			ROOM_COUNT[i] =  ROOM_COUNT_PRICE[i][0];
		}
		
		
		Scanner input = new Scanner(System.in);
		
		
		Rooms[0] = new Standard_room[ROOM_COUNT_PRICE[0][0]];
		Rooms[1] = new Moderate_room[ROOM_COUNT_PRICE[1][0]];
		Rooms[2] = new Superior_room[ROOM_COUNT_PRICE[2][0]];
		Rooms[3] = new JuniorSuite_room[ROOM_COUNT_PRICE[3][0]];
		Rooms[4] = new Suite_room[ROOM_COUNT_PRICE[4][0]];
		
		
		int room=0;
		for(int i=0; i<ROOM_COUNT[0]; i++)
		{ 
			Rooms[0][i] = new Standard_room( ( (flr*1000)+(100*1)+(++room) ), ROOM_COUNT_PRICE[0][1] ,flr,0);
		}
		
		
		 
		
		
		for(int i=0; i<ROOM_COUNT[1]; i++)
		{ 
			Rooms[1][i] = new Moderate_room( ( (flr*1000)+(200*1)+(++room) ), ROOM_COUNT_PRICE[1][1] ,flr,0);
		}
		
		
		
		
		for(int i=0; i<ROOM_COUNT[2]; i++)
		{ 
			Rooms[2][i] = new Superior_room(( (flr*1000)+(300*1)+(++room) ), ROOM_COUNT_PRICE[2][1] ,flr,0);
		}
		
		
		
		for(int i=0; i<ROOM_COUNT[3]; i++)
		{ 
			Rooms[3][i] = new JuniorSuite_room(( (flr*1000)+(400*1)+(++room) ), ROOM_COUNT_PRICE[3][1] ,flr,0);
		}
		
		
		
		for(int i=0; i<ROOM_COUNT[4]; i++)
		{ 
			Rooms[4][i] = new Suite_room(( (flr*1000)+(500*1)+(++room) ), ROOM_COUNT_PRICE[4][1] ,flr,0);
		}
	
	}
	
	
	 
	public Floor( int flr, int [][]ROOM_COUNT_PRICE)
	{	
		setFloor(flr,ROOM_CoUNT_PRICE);
	}

	public void Reserve(int roomno,int type)
	{
		Rooms[type][roomno].Reserve();
	}
	public Floor()
	{
	
	}
	public void Display()
	{
		
		for(int j=0 ; j<ROOM_COUNT[0]; j++)
		{
			System.out.println(Rooms[0][j].toString()+ "   Standard Room   floor"+floorNo);
		} 
		
		for(int j=0 ; j<ROOM_COUNT[1]; j++)
		{
			System.out.println(Rooms[1][j].toString()+ "   Moderate Room   floor"+floorNo);
		}	
		
		for(int j=0 ; j<ROOM_COUNT[2]; j++)
		{
			System.out.println(Rooms[2][j].toString()+ "   Superior Room   floor"+floorNo);
		}
		
		for(int j=0 ; j<ROOM_COUNT[3]; j++)
		{
			System.out.println(Rooms[3][j].toString()+ "   junior suite Room   floor"+floorNo);
		}
		
		for(int j=0 ; j<ROOM_COUNT[4]; j++)
		{
			System.out.println(Rooms[4][j].toString()+ "   Suite Room   floor"+floorNo);
		}
	}
	
}

class Hotel implements Serializable
{
	String Name;
	//ArrayList<Floor> floors = new ArrayList<Floor>();
	Floor floors;
	int NO_OF_FLOORS;
	int  [][] ROOM_COUNT_PRICE = new int[5][2]; 
	
	
	public void ReserveRoom()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Room Number to  reserve:");
		int room = input.nextInt();
		int type =  (room%1000)/100;
		int roomno = room%100;
		int flrno = room/1000;
		System.out.println("   "+ roomno+"   "+flrno+"   "+type );
		floors[flrno-1].Rooms[type-1][roomno-1];//.Reserve(roomno-2,type-2);
		//System.out.println("Room No "+room+ "Reserved successfully");
	
	
	}
	public void addRoom()
	{
		int [] moreroom = new int[5];
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("How many");
		System.out.print("No of Standard Rooms:     " );
		moreroom[0] = input.nextInt();
		
		System.out.print("No of Moderate Rooms:     " );
		moreroom[1] = input.nextInt();
		
		System.out.print("No of Superior Rooms:     " );
		moreroom[2] = input.nextInt();
		
		System.out.print("No of Junior Suite Rooms: " );
		moreroom[3] = input.nextInt();
		
		System.out.print("No of Suite Rooms:        " );
		moreroom[4] = input.nextInt();
		
		for(int i=0; i<5 ; i++)
		{
			ROOM_COUNT_PRICE[i][0] = ROOM_COUNT_PRICE[i][0] + moreroom[i];
		
		}
		
		floors=null;
		floors = new Floor[NO_OF_FLOORS];
		
		for(int i=0; i<NO_OF_FLOORS; i++)
		{
			floors.setFloor(i+1,ROOM_COUNT_PRICE);
		System.out.println("Required No of Rooms added Successfully");	
		
	} 
	public String getName()
	{
	
		return this.Name;
	
	}
	public String toString()
	{
		return Name;
	}
	public void Display()
	{
	
		for(int i=0; i<NO_OF_FLOORS; i++)
		{
			floors[i].Display();
			
		
		}
	}
	
	public void addFloor()
	{
		//floors.add(new Floor(NO_OF_FLOORS,ROOM_COUNT_PRICE));
		Floor []temp = new Floor[NO_OF_FLOORS];

		for(int i=0; i<NO_OF_FLOORS; i++)
		{
		
		temp[i].setFloor(floors[i]);
		}
		floors =null;
		floors = new Floor[NO_OF_FLOORS+1];
		NO_OF_FLOORS++;
		for(int i=0; i<NO_OF_FLOORS; i++)
		{
		
		floors[i].setFloor(i,ROOM_COUNT_PRICE);
		}
		System.out.println("New Floor Added succefully");
	}
	Hotel(){}
	Hotel(Hotel Chotel)
	{
	
		this.setNew(Chotel);
	}
	Hotel(String HName)
	{
		setNew(HName);
		System.out.println("Hotel  constructed succeefully");
	}

	public void setNew(Hotel Chotel)
	{
		this.Name = Chotel.Name;
		this.NO_OF_FLOORS = Chotel.NO_OF_FLOORS;
		for(int i=NO_OF_FLOORS-1 ; i>=0;i--)
		{
			this.floors.add(Chotel.floors.get(i));
		}
	}
	public void setNew(String HName)
	{
	this.Name = HName;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter No of floors: ");
		NO_OF_FLOORS = input.nextInt();
		System.out.println("No of Rooms in Each floor ");
		
		System.out.print("No of Standard Rooms:     " );
		ROOM_COUNT_PRICE[0][0] = input.nextInt();
		
		System.out.print("No of Moderate Rooms:     " );
		ROOM_COUNT_PRICE[1][0] = input.nextInt();
		
		System.out.print("No of Superior Rooms:     " );
		ROOM_COUNT_PRICE[2][0] = input.nextInt();
		
		System.out.print("No of Junior Suite Rooms: " );
		ROOM_COUNT_PRICE[3][0] = input.nextInt();
		
		System.out.print("No of Suite Rooms:        " );
		ROOM_COUNT_PRICE[4][0] = input.nextInt();
		
		
		
		
		System.out.print("Price of Standard Room: ");
		ROOM_COUNT_PRICE[0][1] = input.nextInt();
		
		System.out.print("Price of Moderate Room: ");
		ROOM_COUNT_PRICE[1][1] = input.nextInt();
		 
		 System.out.print("Price of Superior Room: ");
		 ROOM_COUNT_PRICE[2][1] = input.nextInt();
		 
		 System.out.print("Price of Junior Suite Room: ");
		 ROOM_COUNT_PRICE[3][1] = input.nextInt();
		 
		 
		 System.out.print("Price of Suite Room: ");
		 ROOM_COUNT_PRICE[4][1] = input.nextInt();
		
		
		for(int i=0; i<NO_OF_FLOORS; i++)
		{
			
			floors.add(new Floor(i+1,ROOM_COUNT_PRICE));
		}
		System.out.println("Hotel  constructed succeefully");
	}
	
}



class Customer implements Serializable
{

	String FullName;
	int Age;
	String Gender;
	String CNIC;
	int Balance;
	int TotalDaysReserve;
	int FloorNumber;// on which reserved room is
	String RoomType;
	int RoomNumber;
	Date Checkin_time;
	Date Checkout_time;// and date;
	long TimeRemaining;// in the Hotel (in Hours, should be calculated onruntime, Automatically)

	Customer()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner input = new Scanner(System.in);
		
		
		try
		{
			System.out.print("Full Name:");
			FullName = br.readLine();
			
			System.out.print("Age:");
			Age = input.nextInt();
			
			System.out.print("Gender: ");
			Gender = br.readLine();
		
			System.out.print("CNIC: ");
			CNIC = br.readLine();
			
			System.out.print("Total days to resrve: ");
			TotalDaysReserve = input.nextInt();
			
			System.out.print("Room No: ");
			RoomNumber = input.nextInt();
			
			System.out.print("Room Type: ");
			RoomType = br.readLine();
			
			System.out.print("Floor No: ");
			FloorNumber = input.nextInt();
			
			SimpleDateFormat formatt = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			System.out.print("Chech in Time formate(dd-MM-yyyy HH:mm):");
			String CheckinTime = br.readLine();
			Checkin_time = formatt.parse(CheckinTime);
			
			
			System.out.print("Chech out Time formate(dd-MM-yyyy HH:mm):");
			String CheckoutTime = br.readLine();
			Checkout_time = formatt.parse(CheckoutTime);
			
			this.setRemainingTime();
			//long space = Checkout_time.getTime() - Checkin_time.getTime();
			
			
			
		}catch(Exception e)
		{
		System.out.println("Error in Customer constructor");
		}	
	}


	public void setRemainingTime()
	{
		Date CurrentdateNtime = new Date();

		TimeRemaining = ( Checkout_time.getTime() - CurrentdateNtime.getTime() )/(60*60*1000);
		
		 
	}
	
}









