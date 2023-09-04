package dev.sebastian.library_system.exception;

public class PatronNotFoundException extends Exception
{
    public PatronNotFoundException(String errorMessage)
    {
        super(errorMessage);
    }
}
