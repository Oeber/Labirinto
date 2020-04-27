package main;

import agent.AgentMaze;
import environment.Maze;
import general.PositionXY;
import java.util.Scanner;

public class ArtificialIntelligence {

    public static void main(String[] args) throws InterruptedException {
        int posX, posY, mSize = -1;
        boolean finish = true;
        Scanner scan = new Scanner(System.in);

        while (mSize < 0) {
            System.out.println("Qual sera o tamanho do labirinto?");
            mSize = scan.nextInt();
            if (mSize < 0) {
                System.out.println("Tamanho invalido");
            }
        }
        while (finish) {
            Maze maze = new Maze(mSize);
            maze.showMaze();
            AgentMaze agent = new AgentMaze(maze);
            posX = -1;
            posY = -1;

            while (posX >= maze.getMazeSize() || posX < 0) {
                System.out.println("Qual sera a posição inicial X do Astolfo:");
                posX = scan.nextInt();
                if (posX >= maze.getMazeSize() || posX < 0) {
                    System.out.println("Posição invalida");
                }
            }
            while (posY >= maze.getMazeSize() || posY < 0) {
                System.out.println("Qual sera a posição inicial Y do Astolfo:");
                posY = scan.nextInt();
                if (posX >= maze.getMazeSize() || posX < 0) {
                    System.out.println("Posição invalida");
                }
            }
            agent.setPosition(new PositionXY(posX, posY));

            while (agent.isNotEndEaten()) {
                agent.zeroStack();
                agent.move();
                maze.showMaze();
                Thread.sleep(1500);
            }

            if (!maze.isgoodSolution()) {
                System.out.println("Solução não otima");
                System.out.println("Deseja tentar outra posição inicial?");
                System.out.println("1-Sim 2-Não");
                if (scan.nextInt() != 1) {
                    finish = false;
                }

            } else {
                System.out.println("Solução otima");
                finish = false;
            }
        }
    }
}
