package hu.nive.ujratervezes.zarovizsga.peoplesql;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    MariaDbDataSource dataSource = new MariaDbDataSource();

    public PeopleDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("select ip_address from people where first_name=? and last_name=?")
        ) {
                ps.setString(1, firstName);
                ps.setString(2, lastName);

            return getString(ps);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Cannot select", e);
        }
    }

    private String getString(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery())
        {
            if (rs.next()) {
                String ipAddress = rs.getString("ip_address");
                return ipAddress;
            }
            throw new IllegalArgumentException("No result");
        } catch (SQLException e) {
            throw new IllegalArgumentException("Cannot query", e);
        }
    }
}