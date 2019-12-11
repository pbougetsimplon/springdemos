package fr.bouget.spring.jdbc.springdemo04.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import fr.bouget.spring.jdbc.springdemo04.Demo04Application;
import fr.bouget.spring.jdbc.springdemo04.model.Pilote;

/**
 * @author Philippe
 *
 */
@Component
@Qualifier("piloteDao")
public class PiloteDaoImpl implements PiloteDao {

	private static final Logger log = LoggerFactory.getLogger(Demo04Application.class);

	@Autowired(required=true)
	private JdbcTemplate jdbcTemplate;



	/**
	 * Méthode pour rechercher les pilotes par NOM
	 * @param nom
	 * @return
	 */
	@Override
	public Pilote findByNom (String nom){
		log.info(MessageFormat.format("Méthode findByNom() => rechercher un pilote dont le nom est {0}:", nom));
		return jdbcTemplate.queryForObject("SELECT * FROM pilote WHERE PI_NOM = ?",new Object[]{nom}, new PiloteMapper());

	}
	/**
	 * Méthode pour rechercher tous les pilotes de la table
	 * @return
	 */
	@Override
	public List<Pilote> findAll()
	{
		log.info("Méthode findAll() => recherche tous les pilotes dans la table Pilotes");
		return jdbcTemplate.query("SELECT * FROM pilote", new PiloteMapper());
	}

	@Override
	/**
	 * Méthode pour ajouter un pilote et retourner la clé auto-générée
	 * par MySQL.
	 */
	public int addPilote(Pilote pilote) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {

			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO pilote (PI_NOM, PI_SITE) VALUES (?,?) ",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pilote.getNom());
			ps.setString(2, pilote.getSite());
			return ps;
		}, keyHolder);

		return keyHolder.getKey().intValue();
	}
	
	// Voici ce que vous pouvez utiliser si la clef n'est pas auto-générée
	// il faut aussi redéfinir la méthode dans PiloteDao qui ne renvoie plus de int
	//@Override
	/**
	 * Méthode pour ajouter un pilote sans clef auto-générée
	 * par MySQL.
	 */
//	public addPilote(Pilote pilote) {
//		
//		jdbcTemplate.update(
//				"INSERT INTO pilote (PI_ID, PI_NOM, PI_SITE) VALUES (?,?,?)",
//				count()+1,
//				pilote.getNom(),
//				pilote.getSite());
//	}
	
	

	@Override
	/**
	 * Méthode pour supprimer un pilote en base de données
	 */
	public void removePilote(Pilote pilote) {
		jdbcTemplate.update(
				"DELETE FROM pilote WHERE PI_ID= ?",
				pilote.getId());
	}

	@Override
	/**
	 * Méthode pour mettre à jour des informations d'un pilote
	 * en connaissant sa clef auto-générée.
	 */
	public void updatePilote(Pilote pilote) {
		jdbcTemplate.update(
				"UPDATE pilote SET PI_NOM= ?, PI_SITE=? WHERE PI_ID = ?",
				pilote.getNom(),
				pilote.getSite(),
				pilote.getId());
	}
	

	/**
	 * Retourne l'id le pilote avec l'id le plus élevé si pas auto-généré
	 * @return
	 */
	@Override
	public int count() {
	return jdbcTemplate.queryForObject("select max(PI_ID) from pilote", Integer.class);
	}

	/**
	 * Classe privée interne
	 * avec méthode pour le Mapping des objets de type Pilote
	 * @author Philippe
	 *
	 */
	private static final class PiloteMapper implements RowMapper<Pilote> {

		public Pilote mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Pilote p = new Pilote();
			p.setId(resultSet.getInt("PI_ID"));
			p.setNom(resultSet.getString("PI_NOM"));
			p.setSite(resultSet.getString("PI_SITE"));
			return p;
		}
	}
	
}
