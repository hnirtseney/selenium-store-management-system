package pos.tests.dashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
             ResultSet rs = stmt.executeQuery(
                     "with preResult\n" +
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

    public static List<Double> getSalesChartData() throws Exception {
        List<Double> data = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "WITH RECURSIVE Last7Days AS (\n" +
                             "    SELECT CURDATE() AS date\n" +
                             "    UNION ALL\n" +
                             "    SELECT date - INTERVAL 1 DAY\n" +
                             "    FROM Last7Days\n" +
                             "    WHERE date > CURDATE() - INTERVAL 6 DAY\n" +
                             ")\n" +
                             "SELECT \n" +
                             "    DATE_FORMAT(Last7Days.date, '%d-%m-%y') AS date, \n" +
                             "    IFNULL(SUM(sales.total_amount) / 100.0, 0.0) AS count\n" +
                             "FROM \n" +
                             "    Last7Days\n" +
                             "LEFT JOIN \n" +
                             "    sales ON DATE(Last7Days.date) = DATE(sales.date) AND sales.status = 'Completed'\n" +
                             "GROUP BY \n" +
                             "    Last7Days.date\n" +
                             "ORDER BY \n" +
                             "    Last7Days.date;")) {
            while (rs.next()) {
                data.add(rs.getDouble("count"));
            }
        }
        return data;
    }

    public static List<Double> getPurchasesChartData() throws Exception {
        List<Double> data = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "WITH RECURSIVE Last7Days AS (\n" +
                             "    SELECT CURDATE() AS date\n" +
                             "    UNION ALL\n" +
                             "    SELECT date - INTERVAL 1 DAY\n" +
                             "    FROM Last7Days\n" +
                             "    WHERE date > CURDATE() - INTERVAL 6 DAY\n" +
                             ")\n" +
                             "SELECT \n" +
                             "    DATE_FORMAT(Last7Days.date, '%d-%m-%y') AS date, \n" +
                             "    IFNULL(SUM(purchases.total_amount) / 100.0, 0.0) AS count\n" +
                             "FROM \n" +
                             "    Last7Days\n" +
                             "LEFT JOIN \n" +
                             "    purchases ON DATE(Last7Days.date) = DATE(purchases.date) AND purchases.status = 'Completed'\n" +
                             "GROUP BY \n" +
                             "    Last7Days.date\n" +
                             "ORDER BY \n" +
                             "    Last7Days.date;")) {
            while (rs.next()) {
                data.add(rs.getDouble("count"));
            }
        }
        return data;
    }

    public static List<Double> getCurrentMonthChartData() throws Exception {
        List<Double> data = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet salesRs = stmt.executeQuery(
                    "SELECT SUM(total_amount) / 100.0 AS currentMonthSales " +
                            "FROM sales " +
                            "WHERE status = 'Completed' " +
                            "  AND MONTH(date) = MONTH(CURDATE()) " +
                            "  AND YEAR(date) = YEAR(CURDATE());");
            if (salesRs.next()) {
                data.add(salesRs.getDouble("currentMonthSales"));
            } else {
                data.add(0.0);
            }
            salesRs.close();

            ResultSet purchasesRs = stmt.executeQuery(
                    "SELECT SUM(total_amount) / 100.0 AS currentMonthPurchases " +
                            "FROM purchases " +
                            "WHERE status = 'Completed' " +
                            "  AND MONTH(date) = MONTH(CURDATE()) " +
                            "  AND YEAR(date) = YEAR(CURDATE());");
            if (purchasesRs.next()) {
                data.add(purchasesRs.getDouble("currentMonthPurchases"));
            } else {
                data.add(0.0);
            }
            purchasesRs.close();

            ResultSet expensesRs = stmt.executeQuery(
                    "SELECT SUM(amount) / 100.0 AS currentMonthExpenses " +
                            "FROM expenses " +
                            "WHERE MONTH(date) = MONTH(CURDATE()) " +
                            "  AND YEAR(date) = YEAR(CURDATE());");
            if (expensesRs.next()) {
                data.add(expensesRs.getDouble("currentMonthExpenses"));
            } else {
                data.add(0.0);
            }
            expensesRs.close();
        }
        return data;
    }

    public static List<Double> getPaymentReceivedChartData() throws Exception {
        List<Double> data = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "WITH RECURSIVE DateRange AS (" +
                             "    SELECT DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 11 MONTH), '%m-%Y') AS month, DATE_SUB(CURDATE(), INTERVAL 11 MONTH) AS date " +
                             "    UNION ALL " +
                             "    SELECT DATE_FORMAT(DATE_ADD(date, INTERVAL 1 MONTH), '%m-%Y'), DATE_ADD(date, INTERVAL 1 MONTH) " +
                             "    FROM DateRange " +
                             "    WHERE DATE_ADD(date, INTERVAL 1 MONTH) <= CURDATE() " +
                             "), " +
                             "SalePayments AS (" +
                             "    SELECT DATE_FORMAT(date, '%m-%Y') AS month, SUM(amount) AS amount " +
                             "    FROM sale_payments " +
                             "    WHERE date >= DATE_SUB(CURDATE(), INTERVAL 11 MONTH) " +
                             "    GROUP BY month" +
                             "), " +
                             "PurchaseReturnPayments AS (" +
                             "    SELECT DATE_FORMAT(date, '%m-%Y') AS month, SUM(amount) AS amount " +
                             "    FROM purchase_return_payments " +
                             "    WHERE date >= DATE_SUB(CURDATE(), INTERVAL 11 MONTH) " +
                             "    GROUP BY month" +
                             ") " +
                             "SELECT DateRange.month, " +
                             "       COALESCE(SalePayments.amount, 0) + COALESCE(PurchaseReturnPayments.amount, 0) AS amount " +
                             "FROM DateRange " +
                             "LEFT JOIN SalePayments ON DateRange.month = SalePayments.month " +
                             "LEFT JOIN PurchaseReturnPayments ON DateRange.month = PurchaseReturnPayments.month " +
                             "ORDER BY DateRange.date ASC;"
             )) {
            while (rs.next()) {
                data.add(rs.getDouble("amount") / 100.0);
            }
        }
        return data;
    }

    public static List<Double> getPaymentSentChartData() throws Exception {
        List<Double> data = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "WITH RECURSIVE DateRange AS (" +
                             "    SELECT DATE_FORMAT(DATE_SUB(CURDATE(), INTERVAL 11 MONTH), '%m-%Y') AS month, DATE_SUB(CURDATE(), INTERVAL 11 MONTH) AS date " +
                             "    UNION ALL " +
                             "    SELECT DATE_FORMAT(DATE_ADD(date, INTERVAL 1 MONTH), '%m-%Y'), DATE_ADD(date, INTERVAL 1 MONTH) " +
                             "    FROM DateRange " +
                             "    WHERE DATE_ADD(date, INTERVAL 1 MONTH) <= CURDATE() " +
                             ") " +
                             "SELECT DateRange.month, " +
                             "       COALESCE(PurchasePayments.amount, 0) + COALESCE(SaleReturnPayments.amount, 0) + COALESCE(Expenses.amount, 0) AS amount " +
                             "FROM DateRange " +
                             "LEFT JOIN ( " +
                             "    SELECT DATE_FORMAT(date, '%m-%Y') AS month, SUM(amount) AS amount " +
                             "    FROM purchase_payments " +
                             "    WHERE date >= DATE_SUB(CURDATE(), INTERVAL 11 MONTH) " +
                             "    GROUP BY month " +
                             ") AS PurchasePayments ON DateRange.month = PurchasePayments.month " +
                             "LEFT JOIN ( " +
                             "    SELECT DATE_FORMAT(date, '%m-%Y') AS month, SUM(amount) AS amount " +
                             "    FROM sale_return_payments " +
                             "    WHERE date >= DATE_SUB(CURDATE(), INTERVAL 11 MONTH) " +
                             "    GROUP BY month " +
                             ") AS SaleReturnPayments ON DateRange.month = SaleReturnPayments.month " +
                             "LEFT JOIN ( " +
                             "    SELECT DATE_FORMAT(date, '%m-%Y') AS month, SUM(amount) AS amount " +
                             "    FROM expenses " +
                             "    WHERE date >= DATE_SUB(CURDATE(), INTERVAL 11 MONTH) " +
                             "    GROUP BY month " +
                             ") AS Expenses ON DateRange.month = Expenses.month " +
                             "ORDER BY DateRange.date ASC;"
             )) {
            while (rs.next()) {
                data.add(rs.getDouble("amount") / 100.0);
            }
        }
        return data;
    }
}
