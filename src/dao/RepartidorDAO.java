package dao;

import modelo.Repartidor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepartidorDAO {

    // =========================
    // CREATE - Guardar
    // =========================
    public void guardar(Repartidor repartidor) {

        String sql = "INSERT INTO repartidor (nombre) VALUES (?)";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, repartidor.getNombre());
            stmt.executeUpdate();

            System.out.println("Repartidor guardado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al guardar repartidor: " + e.getMessage());
        }
    }

    // =========================
    // READ - Listar todos
    // =========================
    public List<Repartidor> listarTodos() {

        List<Repartidor> lista = new ArrayList<>();
        String sql = "SELECT * FROM repartidor";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Repartidor r = new Repartidor(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
                lista.add(r);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar repartidores: " + e.getMessage());
        }

        return lista;
    }

    // =========================
    // UPDATE - Actualizar
    // =========================
    public void actualizar(Repartidor repartidor) {

        String sql = "UPDATE repartidor SET nombre=? WHERE id=?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, repartidor.getNombre());
            stmt.setInt(2, repartidor.getId());
            stmt.executeUpdate();

            System.out.println("Repartidor actualizado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al actualizar repartidor: " + e.getMessage());
        }
    }

    // =========================
    // DELETE - Eliminar
    // =========================
    public void eliminar(int id) {

        String sql = "DELETE FROM repartidor WHERE id=?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Repartidor eliminado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al eliminar repartidor: " + e.getMessage());
        }
    }
}