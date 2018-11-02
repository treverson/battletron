package com.alltimeslucky.battletron.server.api.game;

import com.alltimeslucky.battletron.game.controller.GameController;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Stores all instances of games.
 */
public class GameRepository {

    private static GameRepository instance;
    private ConcurrentHashMap<Long, GameController> data;


    private GameRepository() {
        data = new ConcurrentHashMap<>();
    }

    /**
     * Returns the singleton instance of the Game Repository.
     * @return The singleton instance of the GameRepository.
     */
    public static GameRepository getInstance() {
        if (instance == null) {
            instance = new GameRepository();
        }
        return instance;
    }

    public void addGameEngine(long gameEngineId, GameController gameController) {
        data.put(gameEngineId, gameController);
    }

    public GameController getGameEngine(long gameEngineId) {
        return data.get(gameEngineId);
    }

    public Collection<GameController> getAllGameEngines() {
        return data.values();
    }

    public void delete(long gameEngineId) {
        data.remove(gameEngineId);
    }
}
