class EnglishAlphabet {

    public static StringBuilder createEnglishAlphabet() {
        // write your code here
        StringBuilder builder = new StringBuilder();
        for (char i = 'A'; i < 'Z'; i++) {
            builder.append(i).append(' ');
        }
        builder.append('Z');
        return builder;
    }
}