package dz_2;

public class CaesarCipher {
    public static String caesarCipher(String text, boolean encrypt, int key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                if (encrypt) {
                    ch = (char) ((ch + key - 'A') % 26 + 'A');
                } else {
                    ch = (char) ((ch - key - 'A' + 26) % 26 + 'A');
                }
            }

            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String plaintext = "HELLO";
        int key = 3;

        String encryptedText = caesarCipher(plaintext, true, key);
        System.out.println("Зашифрованный текст: " + encryptedText);

        String decryptedText = caesarCipher(encryptedText, false, key);
        System.out.println("Расшифрованный текст: " + decryptedText);
    }
}
