package SERVICES;

import CONTROLLER.CaminhaoController;
import CONTROLLER.CarroController;
import CONTROLLER.MotoController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Service {
    public static void exportaTxt(String arquivo,String texto){
        try{
            FileWriter file1 = new FileWriter("c:\\SAIDAJAVA\\"+arquivo+".txt",false);
            BufferedWriter buff2 = new BufferedWriter(file1);
            buff2.write(texto);
            buff2.close();
        } catch (IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public static String descobreVeiculo(String tipo,int id){
        switch (tipo){
            case "Carro":
                return CarroController.achaModeloPorId(id);
            case "Moto":
                return MotoController.achaModeloPorId(id);
            case "Caminhão":
                return CaminhaoController.achaModeloPorId(id);
        }
        return "";
    }
}
