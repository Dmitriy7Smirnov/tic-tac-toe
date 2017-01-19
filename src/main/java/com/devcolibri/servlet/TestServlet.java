package com.devcolibri.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Created by PMY Archon on 04.01.2017.
 */

@WebServlet(urlPatterns = "/test1", name = "TestServlet")
public class TestServlet extends HttpServlet {

    private static int counter = 0;
    private static int[][] gameArray = new int[3][3];

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter = 0;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                gameArray[i][j]=0;
            }
        }
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if (id.equals("777")){
            counter = 0;
            for (int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    gameArray[i][j]=0;
                }
            }
            return;
        }

        //String pwd = req.getParameter("password");
        String id1 = "12";

        final PrintWriter out = resp.getWriter();



        resp.setContentType("application/json");

        String symbol = "X";
        String symbol1 = "0";


        JsonData jsonData = new JsonData();
        jsonData.setId(id);
        jsonData.setId1(id1);
        jsonData.setSymbol(symbol);
        jsonData.setSymbol1(symbol1);
        jsonData.setisWon(false);
        jsonData.setMsg("X won!");

        ObjectMapper objectMapper = new ObjectMapper();


        //game logic


        //new game partition


        //choose the best step
        int idNumber = Integer.parseInt(id);
        int indexV = idNumber / 10;
        int indexH = idNumber % 10;
        if (gameArray[indexV][indexH] !=0){
            return;
        }

        //step player 1
        gameArray[indexV][indexH] = 1;
        counter++;
        if (counter == 9){
            jsonData.setId1(id);
            jsonData.setSymbol1("X");
            jsonData.setMsg("Draw");
            jsonData.setisWon(true);
            out.print(objectMapper.writeValueAsString(jsonData));
            return;
        }
        //check for win
        if ((gameArray[0][0] + gameArray[0][1] + gameArray[0][2] == 3) ||
                (gameArray[1][0] + gameArray[1][1] + gameArray[1][2] == 3) ||
                (gameArray[2][0] + gameArray[2][1] + gameArray[2][2] == 3) ||
                (gameArray[0][0] + gameArray[1][0] + gameArray[2][0] == 3) ||
                (gameArray[0][1] + gameArray[1][1] + gameArray[2][1] == 3) ||
                (gameArray[0][2] + gameArray[1][2] + gameArray[2][2] == 3) ||
                (gameArray[0][0] + gameArray[1][1] + gameArray[2][2] == 3) ||
                (gameArray[0][2] + gameArray[1][1] + gameArray[2][0] == 3)
                ) {

            jsonData.setId1(id);
            jsonData.setSymbol1("X");
            jsonData.setMsg("Congratulation, X won!");
            jsonData.setisWon(true);
            out.print(objectMapper.writeValueAsString(jsonData));
            return;
        }


        //find the best step
        boolean isPlayer2Won = false;

        if (gameArray[0][0] + gameArray[0][1] + gameArray[0][2] == 20){
            indexV = 0;
            indexH = (30-gameArray[0][1]-2*gameArray[0][2])/10;
            isPlayer2Won = true;
        }
        else if (gameArray[1][0] + gameArray[1][1] + gameArray[1][2] == 20){
            indexV = 1;
            indexH = (30-gameArray[1][1]-2*gameArray[1][2])/10;
            isPlayer2Won = true;
        }
        else if (gameArray[2][0] + gameArray[2][1] + gameArray[2][2] == 20){
            indexV = 2;
            indexH = (30-gameArray[2][1]-2*gameArray[2][2])/10;
            isPlayer2Won = true;
        }
        else if (gameArray[0][0] + gameArray[1][0] + gameArray[2][0] == 20){
            indexV = (30-gameArray[1][0]-2*gameArray[2][0])/10;
            indexH = 0;
            isPlayer2Won = true;
        }
        else if (gameArray[0][1] + gameArray[1][1] + gameArray[2][1] == 20){
            indexV = (30-gameArray[1][1]-2*gameArray[2][1])/10;
            indexH = 1;
            isPlayer2Won = true;
        }
        else if (gameArray[0][2] + gameArray[1][2] + gameArray[2][2] == 20){
            indexV = (30-gameArray[1][2]-2*gameArray[2][2])/10;
            indexH = 2;
            isPlayer2Won = true;
        }
        else if (gameArray[0][0] + gameArray[1][1] + gameArray[2][2] == 20){
            indexV = (30-gameArray[1][1]-2*gameArray[2][2])/10;
            indexH = indexV;
            isPlayer2Won = true;
        }
        else if (gameArray[0][2] + gameArray[1][1] + gameArray[2][0] == 20){
            indexV = (30-gameArray[1][1]-2*gameArray[2][0])/10;
            indexH = (30-gameArray[1][1]-2*gameArray[0][2])/10;
            isPlayer2Won = true;
        }

        boolean isTheBestStepFound = isPlayer2Won;

        if (!isTheBestStepFound) {
            if (gameArray[0][0] + gameArray[0][1] + gameArray[0][2] == 2) {
                indexV = 0;
                indexH = (3 - gameArray[0][1] - 2 * gameArray[0][2]);
                isTheBestStepFound = true;
            } else if (gameArray[1][0] + gameArray[1][1] + gameArray[1][2] == 2) {
                indexV = 1;
                indexH = (3 - gameArray[1][1] - 2 * gameArray[1][2]);
                isTheBestStepFound = true;
            } else if (gameArray[2][0] + gameArray[2][1] + gameArray[2][2] == 2) {
                indexV = 2;
                indexH = (3 - gameArray[2][1] - 2 * gameArray[2][2]);
                isTheBestStepFound = true;
            } else if (gameArray[0][0] + gameArray[1][0] + gameArray[2][0] == 2) {
                indexV = (3 - gameArray[1][0] - 2 * gameArray[2][0]);
                indexH = 0;
                isTheBestStepFound = true;
            } else if (gameArray[0][1] + gameArray[1][1] + gameArray[2][1] == 2) {
                indexV = (3 - gameArray[1][1] - 2 * gameArray[2][1]);
                indexH = 1;
                isTheBestStepFound = true;
            } else if (gameArray[0][2] + gameArray[1][2] + gameArray[2][2] == 2) {
                indexV = (3 - gameArray[1][2] - 2 * gameArray[2][2]);
                indexH = 2;
                isTheBestStepFound = true;
            } else if (gameArray[0][0] + gameArray[1][1] + gameArray[2][2] == 2) {
                indexV = (3 - gameArray[1][1] - 2 * gameArray[2][2]);
                indexH = indexV;
                isTheBestStepFound = true;
            } else if (gameArray[0][2] + gameArray[1][1] + gameArray[2][0] == 2) {
                indexV = (3 - gameArray[1][1] - 2 * gameArray[2][0]);
                indexH = (3 - gameArray[1][1] - 2 * gameArray[0][2]);
                isTheBestStepFound = true;
            }
        }

        if (!isTheBestStepFound){
            if (gameArray[1][1] == 0){
                indexV = 1;
                indexH = 1;
            }else{
                Random random = new Random();
                do {
                    indexV = random.nextInt(3);
                    indexH = random.nextInt(3);
                }while (gameArray[indexV][indexH] != 0);
            }
        }
        gameArray[indexV][indexH] = 10;



        if (isPlayer2Won) {
            jsonData.setisWon(true);
            jsonData.setMsg("0 won!");
        }
        jsonData.setId1(Integer.toString((indexV*10+indexH)));
        counter++;
        out.print(objectMapper.writeValueAsString(jsonData));
    }
}
