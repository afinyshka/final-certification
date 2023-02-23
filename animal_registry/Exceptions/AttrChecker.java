package animal_registry.Exceptions;


public class AttrChecker {

    public void stringChecker(String str) throws NotAStringException {
        for (char ch : str.toCharArray()) {
            if (!Character.isLetter(ch)) {
                throw new NotAStringException("\n!!!Exception: The full name can contain only letters.");
            }
        }
    }

    public void dateChecker(String str) throws NotADateException, NumberFormatException {
        if (str.length() != 10) {
            throw new NotADateException("\n   !!!Declined: The wrong date formater. Example: dd.mm.yyyy.");
        }
        String[] strng = str.split("\\.");
        if (strng.length != 3) {
            throw new NotADateException("\n   !!!Declined: The wrong date format. Example: dd.mm.yyyy.");
        }
        try {
            Integer dd = Integer.parseInt(strng[0]);
            if (dd < 1 || dd > 31) {
                throw new NotADateException("You entered the wrong day of birth");
            }
            Integer mm = Integer.parseInt(strng[1]);
            if (mm < 1 || mm > 12) {
                throw new NotADateException("You entered the wrong month of birth");
            }
            Integer yyyy = Integer.parseInt(strng[2]);
            if (yyyy < 1900 || yyyy > 2023) {
                throw new NotADateException("You entered the wrong year of birth");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException(
                    "\n   !!!Declined: " + e.getMessage() + ". Only numbers are valid. Example: dd.mm.yyyy.");
        }
    }
}
