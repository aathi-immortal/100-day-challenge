package service;

public interface IAuthenticationService {
    public boolean isValidCredentials(int customerId, String password);
}
