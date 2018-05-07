package pl.jsurma.ox;

import java.util.Objects;
import java.util.Scanner;

public class Game {
    private String[][] plansza = new String[3][3];
    private int[][] wzor = new int[3][3];
    private int nrRuchu = 1;
    private String gracz;
    private Scanner wejscie = new Scanner(System.in);

    public void pierwszeWyswietleniePlanszy() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                plansza[i][j] = " ";
            }
        }
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                wzor[j][i] = count;
                count++;
            }
        }
        plansza();
        System.out.println("Kto wykonuje pierwszy ruch? (X / O)");
        gracz = wejscie.nextLine();
    }

    public void wykonajRuch() {
        System.out.println("Gracz " + gracz + ": wykonaj ruch (wskaż nr pola):");
        int pole = wejscie.nextInt();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (wzor[j][i] == pole) {
                    plansza[j][i] = gracz;
                    plansza();
                    if (nrRuchu > 5 && isGameOver()) {
                        break;
                    }
                    if (nrRuchu == 9){
                        System.out.println("Koniec gry, remis!");
                        break;
                    }
                    if (Objects.equals(gracz, "X")) {
                        gracz = "O";
                    } else {
                        gracz = "X";
                    }
                    nrRuchu++;
                    wykonajRuch();
                }
            }
        }
    }

    public boolean isGameOver() {
        if ((plansza[0][0]!=" ")&&(Objects.equals(plansza[0][0], plansza[1][0]) && Objects.equals(plansza[1][0], plansza[2][0]))) {
            System.out.println("Koniec gry! Wygrał " + gracz + " !!!");
            return true;
        }
        if ((plansza[0][1]!=" ")&&(Objects.equals(plansza[0][1], plansza[1][1]) && Objects.equals(plansza[1][1], plansza[2][1]))) {
            System.out.println("Koniec gry! Wygrał " + gracz + " !!!");
            return true;
        }
        if ((plansza[0][2]!=" ")&&(Objects.equals(plansza[0][2], plansza[1][2]) && Objects.equals(plansza[1][2], plansza[2][2]))) {
            System.out.println("Koniec gry! Wygrał " + gracz + " !!!");
            return true;
        }
        if ((plansza[0][0]!=" ")&&(Objects.equals(plansza[0][0], plansza[0][1]) && Objects.equals(plansza[0][1], plansza[0][2]))) {
            System.out.println("Koniec gry! Wygrał " + gracz + " !!!");
            return true;
        }
        if ((plansza[1][0]!=" ")&&(Objects.equals(plansza[1][0], plansza[1][1]) && Objects.equals(plansza[1][1], plansza[1][2]))) {
            System.out.println("Koniec gry! Wygrał " + gracz + " !!!");
            return true;
        }
        if ((plansza[2][0]!=" ")&&(Objects.equals(plansza[2][0], plansza[2][1]) && Objects.equals(plansza[2][1], plansza[2][2]))) {
            System.out.println("Koniec gry! Wygrał " + gracz + " !!!");
            return true;
        }
        if ((plansza[0][0]!=" ")&&(Objects.equals(plansza[0][0], plansza[1][1]) && Objects.equals(plansza[1][1], plansza[2][2]))) {
            System.out.println("Koniec gry! Wygrał " + gracz + " !!!");
            return true;
        }
        if ((plansza[0][2]!=" ")&&(Objects.equals(plansza[0][2], plansza[1][1]) && Objects.equals(plansza[1][1], plansza[2][0]))) {
            System.out.println("Koniec gry! Wygrał " + gracz + " !!!");
            return true;
        }
        return false;
    }

    public void plansza() {
        System.out.println("     |     |                         |     |     ");
        System.out.println("  " + plansza[0][0] + "  |  " + plansza[1][0] + "  |  " + plansza[2][0] + "                   1  |  2  |  3  ");
        System.out.println("_____|_____|_____               _____|_____|_____");
        System.out.println("     |     |                         |     |     ");
        System.out.println("  " + plansza[0][1] + "  |  " + plansza[1][1] + "  |  " + plansza[2][1] + "                   4  |  5  |  6  ");
        System.out.println("_____|_____|_____               _____|_____|_____");
        System.out.println("     |     |                         |     |     ");
        System.out.println("  " + plansza[0][2] + "  |  " + plansza[1][2] + "  |  " + plansza[2][2] + "                   7  |  8  |  9  ");
        System.out.println("     |     |                         |     |     ");
    }
}
