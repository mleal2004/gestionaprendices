package com.gestionaprendices.dao;

import com.gestionaprendices.ConexionBD;
import com.gestionaprendices.modelo.Aprendiz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AprendizDAO {

    public boolean agregarAprendiz(Aprendiz aprendiz) {
        String sql = "INSERT INTO Aprendices (nombre, apellido, documento_identidad, correo, telefono) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, aprendiz.getNombre());
            stmt.setString(2, aprendiz.getApellido());
            stmt.setString(3, aprendiz.getDocumentoIdentidad());
            stmt.setString(4, aprendiz.getCorreo());
            stmt.setString(5, aprendiz.getTelefono());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar aprendiz: " + e.getMessage());
            return false;
        }
    }

    public List<Aprendiz> listarAprendices() {
        String sql = "SELECT * FROM Aprendices";
        List<Aprendiz> aprendices = new ArrayList<>();

        try (Connection con = ConexionBD.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Aprendiz aprendiz = new Aprendiz(
                        rs.getInt("id_aprendiz"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("documento_identidad"),
                        rs.getString("correo"),
                        rs.getString("telefono")
                );
                aprendices.add(aprendiz);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar aprendices: " + e.getMessage());
        }
        return aprendices;
    }

    public boolean actualizarAprendiz(Aprendiz aprendiz) {
        String sql = "UPDATE Aprendices SET nombre = ?, apellido = ?, documento_identidad = ?, correo = ?, telefono = ? WHERE id_aprendiz = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, aprendiz.getNombre());
            stmt.setString(2, aprendiz.getApellido());
            stmt.setString(3, aprendiz.getDocumentoIdentidad());
            stmt.setString(4, aprendiz.getCorreo());
            stmt.setString(5, aprendiz.getTelefono());
            stmt.setInt(6, aprendiz.getIdAprendiz());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar aprendiz: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarAprendiz(int idAprendiz) {
        String sql = "DELETE FROM Aprendices WHERE id_aprendiz = ?";
        try (Connection con = ConexionBD.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idAprendiz);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar aprendiz: " + e.getMessage());
            return false;
        }
    }
}
