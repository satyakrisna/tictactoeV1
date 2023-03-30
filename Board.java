import java.util.Random;

public class Board {
    
    private int boardSize;
    private int[][] board;

    public Board(int code) {
        this.boardSize = convertBoardSize(code);
        board = new int [convertBoardSize(code)][convertBoardSize(code)];
      }

    public int convertBoardSize(int code){
        int boardSize=0;
        switch (code) {
            case 1:
                boardSize= 3;
                break;
            case 2:
                boardSize= 5;
                break;
            case 3:
                boardSize= 9;
                break;
            default:
                break;
        }
        return boardSize;
    }
    
    public void printInstruction(){
        if(boardSize==3||boardSize==5||boardSize==9){
            for(int i = 0; i<boardSize;i++){
                System.out.println(printBoardLine()); 
                System.out.println(printBoardNumber(i));
            }
            System.out.println(printBoardLine());
        }else{
            System.out.println("Invalid board size!");
        }
        
    }

    public void printBoard(){
        for(int i = 0; i<boardSize;i++){
            System.out.println(printBoardLine());
            System.out.println(printBoardValue(i));
        }
        System.out.println(printBoardLine());
    }

    public String printBoardLine(){
        StringBuilder boardLine = new StringBuilder("|");
        for(int i = 0; i<boardSize;i++){
            boardLine.append(" - |");
        }
        return boardLine.toString();
    }

    public String printBoardNumber(int row){
        StringBuilder boardLine = new StringBuilder("|");
        for(int i = 0; i<boardSize;i++){
            boardLine.append(" "+(row*boardSize+i+1)+" |");
        }
        return boardLine.toString();
    }

    public String printBoardValue(int row){
        StringBuilder boardValue = new StringBuilder("| ");
        for(int i = 0; i<boardSize;i++){
            if(board[row][i] == 0) boardValue.append(" ");
            if(board[row][i] == 1) boardValue.append("X");
            if(board[row][i] == 2) boardValue.append("O");
            boardValue.append(" | ");
        }
        boardValue.deleteCharAt(boardValue.lastIndexOf(" "));
        return boardValue.toString();
    }

    public boolean placePieceRandomly(String pieceType){
        int row = new Random().nextInt(boardSize);
        int col = new Random().nextInt(boardSize);
        boolean wasPiecePlace = false;
        while(!wasPiecePlace && !isFull()){
            if(board[row][col]==0){
                wasPiecePlace=true;
                if (pieceType.equals("X")) board[row][col] = 1;
                if (pieceType.equals("O")) board[row][col] = 2;
            }else{
                row = new Random().nextInt(boardSize);
                col = new Random().nextInt(boardSize);
            }
        }
        return wasPiecePlace;
    }

    public boolean placePiece(int position, String pieceType){
        System.out.println(boardSize);
        int row = (position-1)/boardSize;
        int col = (position - (row*boardSize))-1;
        if(board[row][col] == 0) {
            if (pieceType.equals("X")) board[row][col] = 1;
            if (pieceType.equals("O")) board[row][col] = 2;
            return true;
        }
        return false;
    }

    public boolean isFull(){

        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                if(board[row][col]==0) return false;
            }
        }
        return true;
    }

    public int[][] getBoard(){
        return board;
    }

    public static class Cell{
        public int row;
        public int col;

        public Cell(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
