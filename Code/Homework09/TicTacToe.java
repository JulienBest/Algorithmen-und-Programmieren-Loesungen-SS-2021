
package tictactoe;

import java.util.Scanner;

/**
 *
 * @author david
 */

public class TicTacToe {
    
    /**
     * To read user input from the console.
     */
    public static final Scanner input = new Scanner(System.in);
    
    /**
     * Squares on the board, each of which is '.', 'X', or 'O'.
     */
    private char[][] board = new char[3][3];
    
    
    /**
     * The board is initially empty.
     */
    public TicTacToe (){
        board = new char[][]{{'.', '.', '.'},
                               {'.', '.', '.'},
                               {'.', '.', '.'}};
    }
    
    /**
     * Returns the opponent player for a given player.
     */
    public static char opponentOf(char player) {
        if(player == 'X') return 'O';
        else return 'X';
    }
    
    /**
     * Play one game, human vs. human.
     */
    public void playHumanVsHuman(){
        char currentPlayer = 'X';
        while(isGameOver() != true){
            playHuman(currentPlayer);
            System.out.println(this);
            currentPlayer = opponentOf(currentPlayer);
        }
        printResult();
    }
    
    /**
     * Reads user input and makes a move.
     */
    private void playHuman(char player){
        int row = -1;
        int column = -1;
        while(row == -1 && column == -1 || board[row][column] != '.'){
            System.out.println("User: " + player);
            System.out.print("Enter row: ");
            row = input.nextInt();
            System.out.print("Enter column: ");
            column = input.nextInt();
            System.out.println("");
        }
        board[row][column] = player;
    }
    
    
    /**
     * Play one game, human vs. AI.
     */
    public void playHumanVsAI(){
        char currentPlayer = 'X';
        while(isGameOver() != true){
            if(currentPlayer == 'X'){
                playAI();
            } else{
                System.out.println(this);
                playHuman(currentPlayer);
            }
            currentPlayer = opponentOf(currentPlayer);
        }
        System.out.println(this);
        printResult();
    }
    
    
    /**
     * Finds the best move for X and plays it on the board.
     */
    private void playAI(){
        int score;
        int bestScore = -2;
        int bestRow = -1;
        int bestColumn = -1;
        
        for(int row = 0; row < 3; row++){
            for(int column = 0; column < 3; column++){
                if(board[row][column] == '.'){
                    board[row][column] = 'X';
                    score = minimaxForO();
                    if(score > bestScore){
                        bestScore = score;
                        bestRow = row;
                        bestColumn = column;
                    }
                    board[row][column] = '.';
                }
            }
        }
        board[bestRow][bestColumn] = 'X';
    }
    
    
    /**
     * Returns the value of the current position if it is O's turn.
     * Looks for the MINIMUM score rather than the maximum score.
     * In case the game is over it returns the current score.
     * Otherwise it tries every square and calculates the score using minimaxForX.
     */
    private int minimaxForO(){
        int score = score();
        if(isGameOver()){
            return score;
        }
        int bestScore = 2;
        for(int row = 0; row < 3; row++){
            for(int column = 0; column < 3; column++){
                if(board[row][column] == '.'){
                    board[row][column] = 'O';
                    score = minimaxForX();
                    if(score < bestScore){
                        bestScore = score;
                    }
                    board[row][column] = '.';
                }
            }
        }
        return bestScore;
    }
    
    
    /**
     * Returns the value of the current position if it is X's turn.
     * Looks for the MAXIMUM score.
     * In case the game is over it returns the current score.
     * Otherwise it tries every square and calculates the score using minimaxForO.
     */
    private int minimaxForX(){
        int score = score();
        if(isGameOver()){
            return score;
        }
        int bestScore = -2;
        for(int row = 0; row < 3; row++){
            for(int column = 0; column < 3; column++){
                if(board[row][column] == '.'){
                    board[row][column] = 'X';
                    score = minimaxForO();
                    if(score > bestScore){
                        bestScore = score;
                    }
                    board[row][column] = '.';
                }
            }
        }
        return bestScore;
    }
    
    
    /**
     * Returns true if the game is over.
     * Game is over when score is not equal to 0 or there is no free square left.
     */
    private boolean isGameOver(){
        if(score() != 0){
            return true;
        }
        
        for(int row = 0; row < 3; row++){
            for(int column = 0; column < 3; column++){
                if(board[row][column] == '.'){
                    return false;
                }
            }
        }
        return true;
    }
    
    
    /**
     * Returns 1 if X has won, -1 if O has won, and 0 otherwise.
     * Makes use of the scoreLine function to calculate the score 
     * for every possible line.
     */
    public int score(){
        int lineScore = 0;
        for(int i = 0; i < 3; i++){
            lineScore = scoreLine(board[i][0], board[i][1], board[i][2]);
            if(lineScore != 0){
                return lineScore;
            }
            
            lineScore = scoreLine(board[0][i], board[1][i], board[2][i]);
            if(lineScore != 0){
                return lineScore;
            }
        }
        
        lineScore = scoreLine(board[0][0], board[1][1], board[2][2]);
        if(lineScore != 0){
            return lineScore;
        }
        
        return scoreLine(board[2][0], board[1][1], board[0][2]);
    }
    
    
    /**
     * Returns 1 if all three characters are 'X', -1 if they are all 'O', and 0
     * otherwise.
     */
    private int scoreLine(char a, char b, char c){
        if(a == 'X' && b == 'X' && c == 'X'){
            return 1;
        }
        if(a == 'O' && b == 'O' && c == 'O'){
            return -1;
        }
        return 0;
    }
    
    
    /**
     * Prints the result of the game.
     */
    private void printResult(){
        switch (score()) {
            case -1:
                System.out.println("Player O wins!");
                break;
            case 1:
                System.out.println("Player X wins!");
                break;
            default:
                System.out.println("Draw!");
                break;
        }
    }
    
    
    /**
     *  Writes the board to a string.
     *  Used to write the board to the console.
     */
    @Override
    public String toString(){
        String result = "";
        for(int row = 0; row < 3; row++){
            for(int column = 0; column < 3; column++){
                result += board[row][column];
            }
            result += "\n";
        }
        return result;
    }
    
    
    /**
     * Create and play the game.
     */
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        System.out.println("Welcome to Tic Tac Toe. \n");
        System.out.println(game);
        //game.playHumanVsHuman();
        game.playHumanVsAI();
    }
    
    
}
