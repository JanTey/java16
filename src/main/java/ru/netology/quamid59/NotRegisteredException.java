package ru.netology.quamid59;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String Name) {
        super("User named" + Name + "is not registered");

    }
}
