import java.util.Scanner;

public class TicTacToe
{

	private static char[][] board = new char[3][3];

	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to Alex's TicTacToe game!");
		displayBoard2();
		game();
		//initBoard();
		//displayBoard();
		

	}
	
	public static boolean istaken(int x,int y){
		if((board[x][y])=='X'||(board[x][y]=='O')){
			return true;
		}
		return false;
	}
	
	public static boolean iscrossed(){
		int countrowO=0;
		int countrowX=0;
		int	countcolO=0;
		int countcolX=0;
		// check row
		for(int x=0;x<3;x++){
			countcolO=0;
			countcolX=0;
			for(int y=0;y<3;y++){
				if(board[x][y]=='O'){
					countcolO++;
				}
				if(board[x][y]=='X'){
					countcolX++;
				}
				if(countcolO==3||countcolX==3){
					return true;
				}
			}
		}
		//check col
		for(int y=0;y<3;y++){
			countrowO=0;
			countrowX=0;
			for(int x=0;x<3;x++){
				if(board[x][y]=='O'){
					countrowO++;
				}
				if(board[x][y]=='X'){
					countrowX++;
				}
				if(countrowO==3||countrowX==3){
					return true;
				}
			}
		}
		//check diagonal
		if(board[0][0]=='O'&&board[1][1]=='O'&&board[2][2]=='O'){
			return true;
		}
		if(board[0][2]=='O'&&board[1][1]=='O'&&board[2][0]=='O'){
			return true;
		}
		if(board[0][2]=='X'&&board[1][1]=='X'&&board[2][0]=='X'){
			return true;
		}
		if(board[0][0]=='X'&&board[1][1]=='X'&&board[2][2]=='X'){
			return true;
		}
		return false;
	}
	public static boolean isfull(){
		for(int x=0;x<3;x++){
			for(int y=0;y<3;y++){
				if(board[x][y]!='X'&&board[x][y]!='O'){
					return false;
				}
			}
		}
		return true;
	}
	public static void game(){
		int counter=0;
		int keeptrack=0;
		Scanner scan = new Scanner(System.in);
		boolean winner=false;
		int ans;
		int ans1;
		while(winner==false){
			if(counter==0){
				System.out.println("'O', Choose your location(row,column): ");
				ans=scan.nextInt();
				ans1=scan.nextInt();
				try{
					if(istaken(ans,ans1)){
						System.out.println("you entered a space already taken, try again");
						continue;
					}
					board[ans][ans1]='O';
				}catch(IndexOutOfBoundsException e){
					System.out.println("you entered a location outside the area, try again");
					continue;
				}
				displayBoard2();
				counter++;
				if(iscrossed()){
					keeptrack=1;
					break;
				}
				if(isfull()){
					break;
				}
				continue;
			}
			if(counter==1){
				System.out.println("'X', Choose your location(row,column): ");
				ans=scan.nextInt();
				ans1=scan.nextInt();
				try{
					if(istaken(ans,ans1)){
						System.out.println("you entered a space already taken, try again");
						continue;
					}
					board[ans][ans1]='X';
				}catch(IndexOutOfBoundsException e){
					System.out.println("you entered a location outside the area, try again");
					continue;
				}
				displayBoard2();
				counter--;
				if(iscrossed()){
					keeptrack=1;
					break;
				}
				if(isfull()){
					break;
				}
				continue;
			}
		}
		if(keeptrack==1){
			if(counter==1)
				System.out.println("player 1 wins!");
			if(counter==0){
				System.out.println("player 2 wins!");
			}
		}
		if(keeptrack==0){
			System.out.println("The game is a tie");
		}
	}
	
	/*public static void initBoard()
	{
		// fills up the board with blanks
		for ( int r=0; r<3; r++ )
			for ( int c=0; c<3; c++ )
				board[r][c] = ' ';
	}
*/


	public static void displayBoard2()
	{
		for ( int r=0; r<3; r++ )
		{
			for ( int c=0; c<3; c++ )
			{
				System.out.print( board[r][c] + " " );
			}
			System.out.println();
		}
	}
}