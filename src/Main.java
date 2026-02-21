package main;

import dao.ConexionDB;
import vista.VentanaPrincipal;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        // 1️⃣ Probamos conexión (opcional, puedes dejarlo)
        try {
            Connection con = ConexionDB.conectar();
            System.out.println("Conexión exitosa 🎉");
        } catch (Exception e) {
            System.out.println("Error de conexión");
            e.printStackTrace();
        }

        // 2️⃣ Abrimos la interfaz gráfica
        new VentanaPrincipal().setVisible(true);
    }
}