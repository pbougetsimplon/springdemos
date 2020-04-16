package co.simplon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.simplon.exception.ExistingUsernameException;
import co.simplon.exception.InvalidCredentialsException;
import co.simplon.model.AppUser;

@Service
public interface AppUserService {

    /**
     * Methode qui permet à un utilisateur de se connecter.
     * @param username : nom de l'utilisateur.
     * @param password : mot de passe de l'utilisateur.
     * @return the JWT if credentials are valid, throws InvalidCredentialsException otherwise.
     * @throws InvalidCredentialsException
     */
    String signin(String username, String password) throws InvalidCredentialsException;

    /**
     * Methode qui permet de s'inscrire.
     * @param user nouvel utilisateur.
     * @return the JWT if user username is not already existing.
     * @throws ExistingUsernameException
     */
    String signup(AppUser user) throws ExistingUsernameException;

    /**
     * Method that finds all users from the application database.
     * @return the list of all application users.
     */
    List<AppUser> findAllUsers();

    /**
     * Method that finds a user based on its username.
     * @param username the username to look for.
     * @return an Optional object containing user if found, empty otherwise.
     */
    Optional<AppUser> findUserByUserName(String username);
}
