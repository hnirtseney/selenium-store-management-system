//package pos.tests.dashboard;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DatabaseHelper {
//    private static final String URL = "jdbc:mysql://localhost:3307/triangle_pos";
//    private static final String USER = "root";
//    private static final String PASSWORD = "13052002";
//
//    public static Connection getConnection() throws Exception {
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }
//
//    public static double getRevenue() throws Exception {
//        Connection conn = getConnection();
//        Statement stmt = conn.createStatement();
//        ResultSet sales = stmt.executeQuery("SELECT SUM(total_amount) as salesTotal FROM sales WHERE status = 'Completed'");
//        ResultSet saleReturns = stmt.executeQuery("SELECT SUM(total_amount) as saleReturnsTotal FROM sale_returns WHERE status = 'Completed'");
//
//        if (sales.next() && saleReturns.next()) {
//            return (sales.getDouble("salesTotal") - saleReturns.getDouble("saleReturnsTotal")) / 100.00;
//        }
//        return 0.0;
//    }
//
//    public static double getSalesReturn() throws Exception {
//        Connection conn = getConnection();
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT SUM(total_amount) as saleReturnsTotal FROM sale_returns WHERE status = 'Completed'");
//        if (rs.next()) {
//            return rs.getDouble("saleReturnsTotal") / 100.00;
//        }
//        return 0.0;
//    }
//
//    public static double getPurchasesReturn() throws Exception {
//        Connection conn = getConnection();
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT SUM(total_amount) as purchaseReturnsTotal FROM purchase_returns WHERE status = 'Completed'");
//        if (rs.next()) {
//            return rs.getDouble("purchaseReturnsTotal");
//        }
//        return 0.0;
//    }
//
//    public static double getProfit() throws Exception {
//        Connection conn = getConnection();
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("with preResult\n" +
//                "as (\n" +
//                "\tSELECT p.product_cost, sd.quantity \n" +
//                "\tFROM sale_details as sd\n" +
//                "\tLEFT JOIN products as p\n" +
//                "\ton sd.product_id = p.id \n" +
//                "\twhere sd.sale_id in (\n" +
//                "\t\tselect s.id from sales as s where s.status = 'Completed'\n" +
//                "\t)\n" +
//                ")\n" +
//                "select sum(product_cost * quantity) as product_cost\n" +
//                "from preResult");
//
//        double revenue = getRevenue();
//
//        if (rs.next()) {
//            return (revenue - rs.getDouble("product_cost")) / 100.00;
//        }
//        return 0.0;
//    }
//
//    public static List<Double> getSalesPurchasesChartData() throws Exception {
//        Connection conn = getConnection();
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT data_value FROM sales_purchases_chart ORDER BY date");
//        List<Double> data = new ArrayList<>();
//        while (rs.next()) {
//            data.add(rs.getDouble("data_value"));
//        }
//        return data;
//    }
//
//    public static List<Double> getCurrentMonthChartData() throws Exception {
//        Connection conn = getConnection();
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT data_value FROM current_month_chart ORDER BY date");
//        List<Double> data = new ArrayList<>();
//        while (rs.next()) {
//            data.add(rs.getDouble("data_value"));
//        }
//        return data;
//    }
//
//    public static List<Double> getPaymentChartData() throws Exception {
//        Connection conn = getConnection();
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT data_value FROM payment_chart ORDER BY date");
//        List<Double> data = new ArrayList<>();
//        while (rs.next()) {
//            data.add(rs.getDouble("data_value"));
//        }
//        return data;
//    }
//}
//

package pos.tests.dashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3307/triangle_pos";
    private static final String USER = "root";
    private static final String PASSWORD = "13052002";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static double getRevenue() throws Exception {
        double salesTotal = 0.0;
        double saleReturnsTotal = 0.0;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet sales = stmt.executeQuery("SELECT SUM(total_amount) as salesTotal FROM sales WHERE status = 'Completed'");
            if (sales.next()) {
                salesTotal = sales.getDouble("salesTotal");
            }
            sales.close(); // Close ResultSet

            ResultSet saleReturns = stmt.executeQuery("SELECT SUM(total_amount) as saleReturnsTotal FROM sale_returns WHERE status = 'Completed'");
            if (saleReturns.next()) {
                saleReturnsTotal = saleReturns.getDouble("saleReturnsTotal");
            }
            saleReturns.close(); // Close ResultSet
        }
        return (salesTotal - saleReturnsTotal) / 100.00;
    }

    public static double getSalesReturn() throws Exception {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT SUM(total_amount) as saleReturnsTotal FROM sale_returns WHERE status = 'Completed'")) {
            if (rs.next()) {
                return rs.getDouble("saleReturnsTotal") / 100.00;
            }
        }
        return 0.0;
    }

    public static double getPurchasesReturn() throws Exception {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT SUM(total_amount) as purchaseReturnsTotal FROM purchase_returns WHERE status = 'Completed'")) {
            if (rs.next()) {
                return rs.getDouble("purchaseReturnsTotal") / 100.00;
            }
        }
        return 0.0;
    }

    public static double getProfit() throws Exception {
        double revenue = getRevenue();
        double productCostTotal = 0.0;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("with preResult\n" +
                     "as (\n" +
                     "\tSELECT p.product_cost, sd.quantity \n" +
                     "\tFROM sale_details as sd\n" +
                     "\tLEFT JOIN products as p\n" +
                     "\ton sd.product_id = p.id \n" +
                     "\twhere sd.sale_id in (\n" +
                     "\t\tselect s.id from sales as s where s.status = 'Completed'\n" +
                     "\t)\n" +
                     ")\n" +
                     "select sum(product_cost * quantity) as product_cost\n" +
                     "from preResult")) {

            if (rs.next()) {
                productCostTotal = rs.getDouble("product_cost");
            }
        }
        return (revenue * 100 - productCostTotal) / 100;
    }

//    public static List<Double> getSalesPurchasesChartData() throws Exception {
//        List<Double> data = new ArrayList<>();
//        try (Connection conn = getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT data_value FROM sales_purchases_chart ORDER BY date")) {
//            while (rs.next()) {
//                data.add(rs.getDouble("data_value"));
//            }
//        }
//        return data;
//    }
//
//    public static List<Double> getCurrentMonthChartData() throws Exception {
//        List<Double> data = new ArrayList<>();
//        try (Connection conn = getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT data_value FROM current_month_chart ORDER BY date")) {
//            while (rs.next()) {
//                data.add(rs.getDouble("data_value"));
//            }
//        }
//        return data;
//    }
//
//    public static List<Double> getPaymentChartData() throws Exception {
//        List<Double> data = new ArrayList<>();
//        try (Connection conn = getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT data_value FROM payment_chart ORDER BY date")) {
//            while (rs.next()) {
//                data.add(rs.getDouble("data_value"));
//            }
//        }
//        return data;
//    }
}
