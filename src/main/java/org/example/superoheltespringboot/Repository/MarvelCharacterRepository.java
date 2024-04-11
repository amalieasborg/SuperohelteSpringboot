package org.example.superoheltespringboot.Repository;

import org.example.superoheltespringboot.Model.MarvelCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MarvelCharacterRepository {
    private final JdbcTemplate jdbcTemplate;
    private String sql;

    @Autowired
    public MarvelCharacterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public MarvelCharacter save (MarvelCharacter marvelCharacter) {
        if (marvelCharacter.getId()==null){
            sql= "INSERT INTO marvel_characters(id,name,alias,powers,paradigm) VALUES (?,?,?,?,?)";
            jdbcTemplate.update(sql,marvelCharacter.getId(),marvelCharacter.getName(),marvelCharacter.getAlias(),marvelCharacter.getPowers(),marvelCharacter.getAlignment());
        } else{
            sql="UPDATE marvel SET name = ?, alias = ?, powers = ?, paradigm = ? WHERE id = ?";
            jdbcTemplate.update(sql,marvelCharacter.getName(),marvelCharacter.getAlias(),marvelCharacter.getPowers(),marvelCharacter.getAlignment());
        }
        return marvelCharacter;
    }

    public List<MarvelCharacter> findAll() {
        sql="SELECT * FROM marvel_characters";
        return jdbcTemplate.query(sql,marvelcharacterRowMapper());
    }

    public Optional findById(Long id) {
        sql="SELECT FROM marvelcharacters WHERE id = ?";
        MarvelCharacter marvelCharacter=jdbcTemplate.queryForObject(sql, new Object[]{id},marvelcharacterRowMapper());
        return Optional.ofNullable(marvelCharacter);
    }

    private RowMapper<MarvelCharacter> marvelcharacterRowMapper() {
        return (rs, rowNum) -> {
            MarvelCharacter marvelCharacter = new MarvelCharacter();
            marvelCharacter.setId(rs.getLong("id"));
            marvelCharacter.setName(rs.getString("name"));
            marvelCharacter.setAlias(rs.getString("alias"));
            marvelCharacter.setPowers(rs.getString("powers"));
            marvelCharacter.setAlignment(rs.getString("alignment"));
            return marvelCharacter;
        };
    }

    public void delete(Long id) {
        String sql = "DELETE FROM marvelcharacters WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


}
