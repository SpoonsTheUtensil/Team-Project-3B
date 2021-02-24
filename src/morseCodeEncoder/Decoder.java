
  /**
     * decodes a String of morse code to English text
     * @param str: String of morse code
     * @return: String of English text
     */
    public String decode(String str) {
        String sign = "";
        StringBuffer result = new StringBuffer("");
        MorseNode current = root;
         
        for (int i = 0; i < str.length(); i++) {
            signal = str.substring(i, i + 1);
            if (sign.equals(".")) {
                if (current.getLeft() != null) {
                    current = current.getLeft();
                } else {
                    current.setLeft(new MorseNode());
                    current = current.getLeft();
                }
            } else if (sign.equals("-")) {
                if (current.getRight() != null) {
                    current = current.getRight();
                } else {
                    current.setRight(new MorseNode());
                    current = current.getRight();
                }
            } else {
                result = result.append(current.getLetter());
                current = root;
            }
        }
        result = result.append(current.getLetter());
 
        return result.toString();
    }