package ru.netology.quamid59;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String Name) {
        super("Пользоваетль с именем" + Name + "не зарегестрирован");

    }
}
