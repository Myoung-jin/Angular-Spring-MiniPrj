package com.pilot.minipr.repository.user;


import static com.pilot.minipr.util.time.DateTimeUtils.timestampOf;
import static java.util.Optional.ofNullable;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.pilot.minipr.model.users.Users;


@Repository
public class JdbcUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	@Override
	public Optional<Users> findByEmail(String email, String userId) {
        List<Users> results = jdbcTemplate.query("SELECT * FROM users WHERE EMAIL=? AND USER_ID=?",
                new Object[]{email,userId},
                mapper
        );
        return ofNullable(results.isEmpty() ? null : results.get(0));
	}
	@Override
	public Users save(Users user) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(
            		"INSERT INTO users("
            		+ "USER_ID, USER_NM, PASSWD, EMAIL, ADDRESS, TEL, REG_DATE"
            		+ ") VALUES (?,?,?,?,?,?,?)"
            		, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUserId());
            ps.setString(2, user.getUserNm());
            ps.setString(3, user.getPasswd());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getTel());
            ps.setTimestamp(7, timestampOf(user.getRegDate()));
            return ps;
        }, keyHolder);
        Number key = keyHolder.getKey();
        long generatedSeq = key != null ? key.longValue() : -1;
        return new Users.Builder(user).seq(generatedSeq).build();
	}
	
	@Override
	public List<Users> userList() {
		 return jdbcTemplate.query("SELECT USER_ID,USER_NM,PASSWD,EMAIL,ADDRESS,TEL FROM USERS"
				 , mapper);
	}
	
	static RowMapper<Users> mapper= (rs, rowNum) -> new Users.Builder()
			.userId(rs.getString("USER_ID"))
			.userNm(rs.getString("USER_NM"))
			.passwd(rs.getString("PASSWD"))
			.email(rs.getString("EMAIL"))
			.address(rs.getString("ADDRESS"))
			.tel(rs.getString("TEL"))
			.build();

	@Override
	public Optional<Users> findById(String userId) {
		List<Users> results = jdbcTemplate.query("SELECT * FROM users WHERE USER_ID=?",
	               new Object[]{userId},
	               mapper
	     );
		return ofNullable(results.isEmpty() ? null : results.get(0));
	}
	@Override
	public Users update(Users user) {
		// TODO Auto-generated method stub
		return null;
	}
}