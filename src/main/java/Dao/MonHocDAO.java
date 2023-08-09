package Dao;

import KetNoi.KetNoi;
import Model.MonHoc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MonHocDAO implements DAOInteFace<MonHoc> {
        public static MonHocDAO GetInstance(){
            return new MonHocDAO();
        }
    @Override
    public int Insert(MonHoc monHoc) {
        int ketQua = 0;
        Connection conn=null;
        try {
            conn = KetNoi.GetConnection();
            String SQL = "INSERT INTO MonHoc (TiengAnh,NguVan,ToanHoc,LichSu)" +
                    "  VALUES (?, ?, ?,?)";
            PreparedStatement PST = conn.prepareStatement(SQL);
            PST.setString(1, monHoc.getTiengAnh());
            PST.setString(2, monHoc.getNguVan());
            PST.setString(3, monHoc.getToanHoc());
            PST.setString(4, monHoc.getLichSu());
            ketQua = PST.executeUpdate();
            System.out.println("Thực Thi :" + SQL);
            System.out.println("Có " + ketQua + " Dòng Bị Thay Đổi");

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
    public int Update(MonHoc monHoc) {
        int ketQua = 0;
        Connection conn=null;
        try {
            conn = KetNoi.GetConnection();
            String SQL ="UPDATE MonHoc " +
                    " SET " +
                    " ,NguVan=?"+
                    " ,ToanHoc=?"+
                    " ,LichSu=?"+
                    " WHERE TiengAnh=?";
            PreparedStatement PST = conn.prepareStatement(SQL);
            PST.setString(1, monHoc.getNguVan());
            PST.setString(2, monHoc.getToanHoc());
            PST.setString(3, monHoc.getLichSu());
            PST.setString(4, monHoc.getTiengAnh());
            ketQua = PST.executeUpdate();
            System.out.println("Thực Thi :" + SQL);
            System.out.println("Có " + ketQua + " Dòng Bị Thay Đổi");



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
    public int Delete(MonHoc monHoc) {
        int ketQua = 0;
        Connection conn=null;
        try {
            conn = KetNoi.GetConnection();
            String SQL ="DELETE FROM MonHoc " +
                    " WHERE ToanHoc=?";
            PreparedStatement PST = conn.prepareStatement(SQL);
            PST.setString(1, monHoc.getToanHoc());
            ketQua = PST.executeUpdate();
            System.out.println("Thực Thi :" + PST);
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
    public ArrayList<MonHoc> SelectAll() {
        ArrayList<MonHoc> ketQua = new ArrayList<MonHoc>();
        Connection conn=null;
        try {

            conn = KetNoi.GetConnection();

            String SQL = "SELECT * FROM MonHoc ";
            PreparedStatement PST = conn.prepareStatement(SQL);

            ResultSet RS = PST.executeQuery();

            while (RS.next()) {
                String TiengAnh = RS.getString("TiengANH");
                String NguVan = RS.getString("NguVan");
                String ToanHoc = RS.getString("ToanHoc");
                String LichSU=RS.getString("LichSu");
                MonHoc MH = new MonHoc(TiengAnh, NguVan,ToanHoc,LichSU);
                ketQua.add(MH);

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
    public MonHoc SelectById(MonHoc monHoc) {
        MonHoc ketQua = null;
        Connection conn=null;
        try {
            conn = KetNoi.GetConnection();

            String SQL = "SELECT * FROM MonHoc WHERE lichSu LIKE ?";
            PreparedStatement PST = conn.prepareStatement(SQL);
            PST.setString(1, "%" + monHoc.getLichSu() + "%");

            System.out.println(SQL);
            ResultSet RS = PST.executeQuery();

            while (RS.next()) {
                String TiengAnh = RS.getString("TiengANH");
                String NguVan = RS.getString("NguVan");
                String ToanHoc = RS.getString("ToanHoc");
                String LichSU=RS.getString("LichSu");
                ketQua = new MonHoc(TiengAnh, NguVan,ToanHoc,LichSU);
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
    }

