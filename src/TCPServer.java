import java.io.BufferedReader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.Sys;
import org.newdawn.slick.SlickException;


public class TCPServer implements Runnable {
	
	Socket csocket;
	
	TCPServer(Socket csocket) {
	      this.csocket = csocket;
	   }

	public static ServerSocket socket;
	public static ArrayList<Socket> connectionArray = new ArrayList<Socket>();
	public static boolean gameHasBeenInitiated = false;
	
	static Board board;
	static Train train;
	static Town town;
	//static Stack stack;
	//static TrainCardStack trainCardStack;
	//static DisplayedTrainStack displayedTrainStack;
	static HandMissionStack handMissionStack;
	//static MissionCardStack missionCardStack;
	//static TrainTrashStack trainTrashStack;
	//static MissionTrashStack missionTrashStack;
	static Connection connection;
	static Connection connection2;
	static PlayerPiece playerPiece;
	
	static ArrayList<Integer> arrayTest;
	static Card mc;
	static String[] msg ,msg2, msg3, msg4, msg5;
	
	static Connection[] cn;
	static Card[] tCards;
	static Card[] dtCards;
	
	static Players[] pArray;
	
	static PlayerPiece[] pPieces;
	
	static int[] isTaken;
	
	static Turn turn;

	public static void main(String[] args) throws IOException {

		//TCPServer tcpServer = new TCPServer();

	/*	Thread threadOne = new Thread(tcpServer);
		Thread threadTwo = new Thread(tcpServer);
		Thread threadThree = new Thread(tcpServer);
		Thread threadFour = new Thread(tcpServer); */
		
	/*	threadOne.start();
		threadTwo.start();
		threadThree.start();
		threadFour.start(); */
		
		
		try {
			board = new Board(4);
			turn = new Turn();
			
			
		} catch (SlickException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		socket = new ServerSocket(2222);
		
		while (true) { 
		Socket sock = socket.accept();
		new Thread(new TCPServer(sock)).start();
		}
		

		
	}

	public void run() {
		System.out.println(Thread.currentThread().getName());
		
		
		try {
			
			while (true) {

				
				System.out.println("Server is running and a new input arrived");

				if (!connectionArray.contains(csocket)) {
					connectionArray.add(csocket);
					System.out.println("Added a player: " + csocket);
					System.out.println("Client's InetAddress: " + csocket.getInetAddress());

					PrintStream ps = new PrintStream(csocket.getOutputStream(), true);
					for (int i = 0; i < connectionArray.size(); i++) {
						if (connectionArray.get(i) == csocket) {

							//ps.println("You are player " + (i + 1) + "\n"); // Remember
																			// to
																			// add
																			// "\n"
																			// just
																			// like
																			// ";"
							//ps.println("mkay" + "\n");
						}
					}
				}

				InputStreamReader isr = new InputStreamReader(csocket.getInputStream());

				BufferedReader inFromClient = new BufferedReader(isr);

				//String msg = inFromClient.readLine();
				//String msg2 = inFromClient.readLine();
				
				//System.out.println(msg);
				//System.out.println(train.amountOfTrains);
			/*	msg = new String[100];
				msg2 = new String[87];
				msg3 = new String[5];
				msg4 = new String[4];
				msg5 = new String[100]; */
				
				
				
			/*	if(inFromClient.readLine().contains("1")) { */
					/*String messages[] = new String[10];
					int amountOfJsons = 10;
					for (int i = 0; i < amountOfJsons; i++) {
						messages[i] = inFromClient.readLine(); 
					} */
				/*	for (int i=0; i<100; i++) {
						String temp = inFromClient.readLine();	
						msg[i]=temp;
					//	System.out.println(msg[i]);
					}
					for (int i=0; i<87; i++)
					{
						String temp = inFromClient.readLine();
						msg2[i]=temp;
					//	System.out.println(msg2[i]);
					}
					for (int i = 0; i < 5; i++) {
						String temp = inFromClient.readLine();
						msg3[i] = temp;
					}
					for (int i=0; i<4; i++)
					{
						String temp = inFromClient.readLine();
						msg4[i] = temp;
					}
					for (int i = 0; i < 100; i++) {
						String temp = inFromClient.readLine();
						msg5[i] = temp;
				//		System.out.println(msg5[i]);
						//board.connections.get(i).setTakenByPlayer();
						
					} */
					
					
				//	String msg1 = inFromClient.readLine(); 
				//	String msg2 = inFromClient.readLine(); 
				//	String msg3 = inFromClient.readLine();
				//	String msg4 = inFromClient.readLine();
				/*	String msg5 = inFromClient.readLine();
					String msg6 = inFromClient.readLine();
					String msg7 = inFromClient.readLine();
					String msg8 = inFromClient.readLine();
					String msg9 = inFromClient.readLine();
					String msg10 = inFromClient.readLine(); */
					
				//	Train train = new Gson().fromJson(msg1, Train.class);
				//	Town town = new Gson().fromJson(msg2, Town.class);
				//	Card mc = new Gson().fromJson(msg2, Card.class);
				//	ArrayList<Integer> arrayTest = new Gson().fromJson(msg2, ArrayList.class);
					
					
		/*			cn = new Connection[100];
					for (int i=0; i<100; i++)
					{
						Connection temp = new Gson().fromJson(msg[i], Connection.class);
						cn[i] = temp;
				//		System.out.println(cn[i]);
									
					}
					tCards = new TrainCard[87];
					for (int i=0; i<87; i++)
					{
						TrainCard temp = new Gson().fromJson(msg2[i], TrainCard.class);
						tCards[i] = temp;
					}
					
					
					dtCards = new TrainCard[5];
					for (int i=0; i<5; i++)
					{
						TrainCard temp = new Gson().fromJson(msg3[i], TrainCard.class);
						dtCards[i] = temp;
					}
					
					pPieces = new PlayerPiece[4];
					for (int i=0; i<4; i++)
					{
						PlayerPiece temp = new Gson().fromJson(msg4[i], PlayerPiece.class);
						pPieces[i] = temp;
					} */
					
				//	isTaken = new int[100];
				/*	for (int i = 0; i < 100; i++) {
						int temp = new Gson().fromJson(msg5[i], Integer.class);
						isTaken[i]=temp;
						
					} */
					
					
					
				//	Connection connection = new Gson().fromJson(msg2, Connection.class);
				//	Connection connection2 = new Gson().fromJson(msg3, Connection.class);
					//Connection[] connection = new Gson().fromJson(msg2, Connection[].class);
					
				//	Type collectionType = new TypeToken<List<Connection>>(){}.getType();
				//	List<Connection> connection = (List<Connection>) new Gson().fromJson( msg2 , collectionType);
					
				//	PlayerPiece playerPiece = new Gson().fromJson(msg3, PlayerPiece.class);
					
					
					
					
				//	Train train = new Gson().fromJson(messages[0], Train.class);
				//	HandTrainStack handTrainStack = new Gson().fromJson(messages[1], HandTrainStack.class);
				//	TrainCardStack trainCardStack = new Gson().fromJson(messages[2], TrainCardStack.class);
				//	DisplayedTrainStack displayedTrainStack = new Gson().fromJson(messages[3], DisplayedTrainStack.class);
				//	HandMissionStack handMissionStack = new Gson().fromJson(messages[4], HandMissionStack.class);
				//	MissionCardStack missionCardStack = new Gson().fromJson(messages[5], MissionCardStack.class);
				//	TrainTrashStack trainTrashStack = new Gson().fromJson(messages[6], TrainTrashStack.class);
				//	MissionTrashStack missionTrashStack = new Gson().fromJson(messages[7], MissionTrashStack.class);
				//	Connection connection = new Gson().fromJson(messages[1], Connection.class);
				//	PlayerPiece playerPiece = new Gson().fromJson(messages[2], PlayerPiece.class);
					
					
				//	System.out.println(train);
				//	System.out.println(handTrainStack.amount);
				//	System.out.println(displayedTrainStack.xPos);
				//	System.out.println(handMissionStack.yPos);
		/*			System.out.println(cn[9].getIsTaken());
					System.out.println(cn[89].getTownA().getName());
					System.out.println(tCards[5].getColor().getColorName());
					System.out.println(tCards[6].getColor().getColorName());
					System.out.println(tCards[7].getColor().getColorName());
					System.out.println(tCards[8].getColor().getColorName());
					System.out.println(dtCards[0].getColor().getColorName());
					System.out.println(dtCards[1].getColor().getColorName());
					System.out.println(dtCards[2].getColor().getColorName());
					System.out.println(dtCards[3].getColor().getColorName());
					System.out.println(dtCards[4].getColor().getColorName());
					System.out.println(pPieces[2].getTotalPoints()); */
				
				//	System.out.println(arrayTest);
				//	System.out.println(mc.xPos);
				//	System.out.println(town.getName());
				//	System.out.println(playerPiece.getTotalPoints());
					
					
				 if(inFromClient.readLine().contains("state1")) { 
					// listen to whatever
					System.out.println("Changed to state1");
					turn.normalTurn(pArray, turn.endTurn());
				} else if(inFromClient.readLine().contains("state2")) {
					// listen to whatever
					System.out.println("Changed to state2");
					turn.normalTurn(pArray, turn.endTurn());
				} else if(inFromClient.readLine().contains("state3")) {
					
					// listen to whatever
					turn.normalTurn(pArray, turn.endTurn());
					System.out.println("Changed to state3");
				} else {
					System.out.println("Activator was not 1 nor 2 nor states");
					System.out.println("The wrongly incoming message was ----------" + inFromClient.readLine());
				}

				// CREATE ALL THE OTHER CLASS AS OBJECTS HERE, BUT MAKE SURE
				// THAT THERE IS ONLY 1 PER PLAYER
				// also make sure that InFromCleint.readLine() fits whatever
				// object is going to be changed
				// Train train = new Gson().fromJson(msg, Train.class);
				// Board board = new Gson().fromJson(msg, Board.class);

				// TrainCardStack tcs = new Gson().fromJson(msg,
				// TrainCardStack.class);

				// What is being sent back to the client

				//System.out.println(train.amountOfTrains);
				// TrainCardStack tcs = new Gson().fromJson(msg,
				// TrainCardStack.class);

				/*
				 * PrintStream ps = new PrintStream(sock.getOutputStream(),
				 * true); for (int i = 0; i <= connectionArray.size(); i++) { if
				 * (connectionArray.get(i) == sock) {
				 * 
				 * ps.println("You are player " + i + "\n"); // Remember to add
				 * "\n" just like ";" ps.println("mkay" + "\n");
				 * 
				 * } }
				 */

				// ps.println("msg received"); // Will be sent to the client

				if (connectionArray.size() == 4 && !gameHasBeenInitiated) {
					

					gameHasBeenInitiated = true;
					
			/*		Players p1 = new Players(connectionArray.get(0), 1, 255, 0, 0);
					Players p2 = new Players(connectionArray.get(1), 2, 0, 255, 0); 
					Players p3 = new Players(connectionArray.get(2), 3, 0, 0, 255);
					Players p4 = new Players(connectionArray.get(3), 4, 255, 255, 255); */
					
					Players p1 = new Players(1, board.colors[1]);
					p1.setSock(connectionArray.get(0));
					
					Players p2 = new Players(2, board.colors[2]);
					p2.setSock(connectionArray.get(1));
					
					Players p3 = new Players(3, board.colors[3]);
					p3.setSock(connectionArray.get(2));
					
					Players p4 = new Players(4, board.colors[4]);
					p4.setSock(connectionArray.get(3));
					
					
					pArray = new Players[4];
					pArray[0] = p1;
					pArray[1] = p2;
					pArray[2] = p3;
					pArray[3] = p4;
					
					turn.initialTurn(pArray);
					
					turn.normalTurn(pArray, 1); // player 1 starts
					

		/*			String playerJson1 = new Gson().toJson(p1);
					//String t = new Gson().toJson(ta);
					String playerJson2 = new Gson().toJson(p2);
					String playerJson3 = new Gson().toJson(p3);
					String playerJson4 = new Gson().toJson(p4); */

					for (int i = 0; i < connectionArray.size(); i++) {
						PrintStream ps = new PrintStream(connectionArray.get(i).getOutputStream(), true);

						

						//ps.println(t + "\n");
/*						ps.println(playerJson2 + "\n");
						ps.println(playerJson3 + "\n");
						ps.println(playerJson4 + "\n");
*/
					} 

					System.out.println("Game is ready");

					for (int i = 0; i < connectionArray.size(); i++) {
						PrintStream ps = new PrintStream(connectionArray.get(i).getOutputStream(), true);
						//ps.println("Game has begun!" + "\n");
					}

				}

				//System.out.println(msg);

				// System.out.println(board.missionCardStack.card[5].color.getColorName());

				// System.out.println(tcs);

				// System.out.println(train.amountOfTrains);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


}
