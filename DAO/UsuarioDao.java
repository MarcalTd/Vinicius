/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.UsuarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Marçal
 */
public class UsuarioDao {

    Connection conn;

    public ResultSet autenticacaoUsuario(UsuarioDTO objusuariodto) {
        conn = new ConexaoDao().conectaBD();

        try {
            String sql = "select * from usuario where nome_usuraio = ? and senha_usuario = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objusuariodto.getNome_usuario());
            pstm.setString(2, objusuariodto.getSenha_usuario());

            ResultSet rs = pstm.executeQuery();


            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao: " + erro);
            return null;

        }

    }
    
    public ResultSet autenticacaoUsuario2(UsuarioDTO objusuariodto) {
        conn = new ConexaoDao().conectaBD();

        try {
            String sql = "select * from usuario1 where usuario = ? and senha = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objusuariodto.getNome_usuario());
            pstm.setString(2, objusuariodto.getSenha_usuario());

            ResultSet rs = pstm.executeQuery();
            
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao: " + erro);
            return null;

        }

    }

    public int userinsert(UsuarioDTO objusuariodto) {
        conn = new ConexaoDao().conectaBD();

        try {
            String sql = "INSERT INTO usuario1 (usuario, senha) VALUES(?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objusuariodto.getCadastrar_user());
            pstm.setString(2, objusuariodto.getCadastrar_senha());

            int rs = pstm.executeUpdate();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao: " + erro);
            return 0;

        }

    }
    public ResultSet usuarioRepetido(UsuarioDTO objusuariodto){
        conn = new ConexaoDao().conectaBD();

        try {
            String sql = "select * from usuario1 where usuario = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objusuariodto.getCadastrar_user());

            ResultSet rs = pstm.executeQuery();
            
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao: " + erro);
            return null;

        }

    }

    public int adminInsert(UsuarioDTO objusuariodto) {
        conn = new ConexaoDao().conectaBD();

        try {
            String sql = "INSERT INTO usuario (nome_usuraio, senha_usuario) VALUES(?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objusuariodto.getCadastrar_user());
            pstm.setString(2, objusuariodto.getCadastrar_senha());

            int rs = pstm.executeUpdate();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao: " + erro);
            return 0;

        }

    }
    
    public ResultSet adminRepetido(UsuarioDTO objusuariodto){
        conn = new ConexaoDao().conectaBD();

        try {
            String sql = "select * from usuario where nome_usuraio = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objusuariodto.getCadastrar_user());

            ResultSet rs = pstm.executeQuery();
            
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao: " + erro);
            return null;

        }

    }



}
