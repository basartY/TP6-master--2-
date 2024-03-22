package fr.umontpellier.iut.partie1;

import fr.umontpellier.iut.partie2.JeuPuzzle;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.OutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ContexteTest {

    @BeforeEach
    void disableConsole() {
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int arg0) {
            }
        }));

    }

    @Disabled
    @Test
    public void test_no_exception() {
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Contexte c = new Contexte(new Taquin(data));
        assertDoesNotThrow(() -> c.resoudre());
    }



}