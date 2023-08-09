package Dao;

import KetNoi.KetNoi;
import Model.DanhSachSinhVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DanhSachSinhVienDAO implements DAOInteFace<DanhSachSinhVien> {
    public static DanhSachSinhVienDAO GetInstance(){
        return new DanhSachSinhVienDAO();
    }

    @Override
    public int Insert(DanhSachSinhVien danhSachSinhVien) {
        int ketQua = 0;
        Connection conn=null;
        try {
            conn = KetNoi.GetConnection();
            String SQL = "INSERT INTO DanhSachSinhVien (Ten,Tuoi,DiaChi,HanhKiem,Diem)" +
                    "  VALUES (?, ?, ?,?,?)";
            PreparedStatement PST = conn.prepareStatement(SQL);
            PST.setString(1, danhSachSinhVien.getTen());
            PST.setInt(2, danhSachSinhVien.getTuoi());
            PST.setString(3, danhSachSinhVien.getDiachi());
            PST.setString(4, danhSachSinhVien.getHanhkiem());
            PST.setInt(5,danhSachSinhVien.getDiem());
            ketQua = PST.executeUpdate();
            System.out.println("Thực Thi :" + SQL);
            System.out.println("Có " + ketQua + " Dòng Thay Đổi");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ketQua;
    }

    @Override
    public int Update(DanhSachSinhVien danhSachSinhVien) {
         int ketQua=0;
         Connection conn=null;
        try {
            conn=KetNoi.GetConnection();
            String SQL = "UPDATE DanhSachSinhVien " +
                    " SET " +
                    " ,Tuoi=?" +
                    " ,DiaChi=?" +
                    " ,HanhKiem=?" +
                    " ,Diem=?" +
                    " WHERE Ten=?";
            PreparedStatement PST=conn.prepareStatement(SQL);
           PST.setInt(1,danhSachSinhVien.getTuoi());
           PST.setString(2,danhSachSinhVien.getDiachi());
           PST.setString(3,danhSachSinhVien.getHanhkiem());
                PST.setInt(4,danhSachSinhVien.getDiem());
            PST.setString(5,danhSachSinhVien.getTen());
            ketQua=PST.executeUpdate();
            System.out.println("Thực Thi :" + SQL);
            System.out.println("Có " + ketQua + " Dòng Bị Thay Đổi");
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (conn!=null){
                try {
                  conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }return ketQua;

    }

    @Override
    public int Delete(DanhSachSinhVien danhSachSinhVien) {
        int ketQua = 0;
        Connection conn=null;
        try {
            conn = KetNoi.GetConnection();
            String sql = "DELETE FROM DanhSachSinhVien " +
                    " WHERE ten=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, danhSachSinhVien.getTen());
            ketQua = pst.executeUpdate();
            System.out.println("Thực Thi :" + sql);
            System.out.println("Có " + ketQua + " Dòng Bị Thay Đổi ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ketQua;
    }

    @Override
    public ArrayList<DanhSachSinhVien> SelectAll() {
      ArrayList<DanhSachSinhVien>ketQua=new ArrayList<DanhSachSinhVien>();
      Connection conn=null;
        try {

            conn = KetNoi.GetConnection();

            String SQL = "SELECT * FROM DanhSachSinhVien ";
            PreparedStatement PST = conn.prepareStatement(SQL);

            ResultSet RS = PST.executeQuery();

            while (RS.next()) {
                String Ten = RS.getString("Ten");
                int Tuoi = RS.getInt("Tuoi");
                String DiaChi = RS.getString("DiaChi");
                String HanhKiem = RS.getString("Hanhkiem");
                int Diem=RS.getInt("Diem");
                DanhSachSinhVien SV = new DanhSachSinhVien(Ten, Tuoi, DiaChi, HanhKiem,Diem);
                ketQua.add(SV);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ketQua;
    }

    @Override
    public DanhSachSinhVien SelectById(DanhSachSinhVien danhSachSinhVien) {
        DanhSachSinhVien ketQua = null;
        Connection conn=null;
        try {
            conn = KetNoi.GetConnection();
            String SQL = "SELECT * FROM DanhSachSinhVien WHERE Ten LIKE ?";
            PreparedStatement PST = conn.prepareStatement(SQL);
            PST.setString(1, "%" + danhSachSinhVien.getTen() + "%");

            System.out.println(SQL);
            ResultSet RS = PST.executeQuery();

            while (RS.next()) {
                String Ten = RS.getString("Ten");
                int Tuoi = RS.getInt("Tuoi");
                String DiaChi = RS.getString("DiaChi");
                String HanhKiem = RS.getString("Hanhkiem");
                int Diem=RS.getInt("Diem");
               ketQua = new DanhSachSinhVien(Ten, Tuoi, DiaChi, HanhKiem,Diem);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } return ketQua;

    }
    }

