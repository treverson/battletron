package com.alltimeslucky.battletron.server.game.api.dto;

import com.alltimeslucky.battletron.game.model.Game;
import com.alltimeslucky.battletron.game.model.GameStatus;
import com.alltimeslucky.battletron.player.model.Player;

import java.util.Arrays;

public class GameDto {

    //The unique identifier of this instance of a gamestate
    private long id;
    // The width of the playing field.
    private int width;
    // The height of the playing field.
    private int height;
    //The current phase in the lifecycle of the game
    private GameStatus gameStatus;
    private int tickCount;
    private Player playerOne;
    private Player playerTwo;
    //Keeps track of players trails
    private int[][] playingField;
    //The winner of the current game is there is one.
    private Player winner;

    /**
     * Non-parameterised constructor for serialisation.
     */
    public GameDto() {}

    /**
     * Constructor used to create this Data Transfer Object based on a Game.
     * @param game The Game used to build this DTO.
     */
    public GameDto(Game game) {
        setId(game.getId());
        setWidth(game.getWidth());
        setHeight(game.getHeight());
        setPlayerOne(game.getPlayerOne());
        setPlayerTwo(game.getPlayerTwo());
        setTickCount(game.getTickCount());
        setPlayingField(game.getPlayingField());
        setGameStatus(game.getGameStatus());
        setWinner(game.getWinner());
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getTickCount() {
        return tickCount;
    }

    public void setTickCount(int tickCount) {
        this.tickCount = tickCount;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public int[][] getPlayingField() {
        return playingField;
    }

    public void setPlayingField(int[][] playingField) {
        this.playingField = playingField;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GameDto{"
                + "id=" + id
                + ", width=" + width
                + ", height=" + height
                + ", gameStatus=" + gameStatus
                + ", tickCount=" + tickCount
                + ", playerOne=" + playerOne
                + ", playerTwo=" + playerTwo
                + ", playingField=" + Arrays.toString(playingField)
                + ", winner=" + winner
                + '}';
    }
}
