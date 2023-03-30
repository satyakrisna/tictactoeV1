import java.util.Scanner;

public class TicTacToe {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Welcome to TicTacToeV1");

        System.out.println("Enter your name:");
        String playerName = scan.nextLine();
        Player player = new Player(playerName);


        System.out.println("Select board size:");
        System.out.println("1. 3 x 3");
        System.out.println("2. 5 x 5");
        System.out.println("3. 9 x 9");
        int boardSize = scan.nextInt();
        scan.nextLine();
        Board board =new Board(boardSize);
        board.printInstruction();

        System.out.println(player.getName() + " please enter X position:");
        int positionX = Integer.parseInt(scan.nextLine());
        System.out.println(boardSize);
        board.placePiece(positionX, "X");
        board.printBoard();

        boolean isGameInProgress = GameResolver.resolve(board.getBoard())==GameResolver.GameState.IN_PROGRESS;

        while( isGameInProgress && !board.isFull()){

            board.placePieceRandomly("O");
            board.printBoard();
            
            System.out.println(player.getName() + " please enter X position:");
            positionX = Integer.parseInt(scan.nextLine());
            board.placePiece(positionX, "X");
            board.printBoard();

            isGameInProgress = GameResolver.resolve(board.getBoard())==GameResolver.GameState.IN_PROGRESS;

        }
        if(!isGameInProgress) {
            board.printBoard();
            if(GameResolver.resolve(board.getBoard()) == GameResolver.GameState.X_WON){
                System.out.print(" GAME OVER, YOU WIN");
            }else{
                System.out.print(" GAME OVER, YOU LOSE");
            }
            
        }
        else board.printBoard();
    }
    
    

}
