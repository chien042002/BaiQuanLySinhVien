package KetNoi;

import java.sql.Connection;

public class TestKetNoi {
    public static void main(String[] args) {
        Connection connection=KetNoi.GetConnection();
        System.out.println(connection+"Kết Nối Thành Công");
    }
}
