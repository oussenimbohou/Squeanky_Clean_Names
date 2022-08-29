public class SqueakyClean{
public static String clean(String identifier) {		
    if (hasEmptySpaces(identifier)) {			
        identifier = replaceByUnderscore(identifier, '_'); 		
    }		
    if (hasCtrlChars(identifier)) {			
        identifier = replaceByCtrlStr(identifier); 		
        }				
    if (hasKebabCase(identifier)) {			
        identifier = replaceByCamelCase(identifier); 		
        }				
    if(hasNonLetter(identifier)) {			
        identifier = removeNonLetter(identifier);		
        }		
    if(hasGreekLowerCase(identifier)) {			
        identifier = removeGreekLowerCase(identifier);		
        }		
    return identifier;			
    }
    private static String removeGreekLowerCase(String identifier) {			
        StringBuilder sb = new StringBuilder();		
        for(char c : identifier.toCharArray()) {			
            if (!(c >= 945 && c <=969)) sb.append(c); 		
            }		
        return sb.toString();	
        }	
    private static boolean hasGreekLowerCase(String identifier) {		
        for (int i = 0; i < identifier.length(); i++) {		
            char c = identifier.charAt(i);		
            if (c >= 945 && c <=969 ) return true;	
            }		
        return false;		
        }	
    private static String removeNonLetter(String identifier) {		
        StringBuilder sb = new StringBuilder();		
        for(char c:identifier.toCharArray()) {		
            if(Character.isLetter(c) || c == '_' || (c >= 128 && c <= 165))                                sb.append(c);		
            }		
        return sb.toString();	
        }
    private static boolean hasNonLetter(String identifier) {			
        for(int i = 0;i <identifier.length();i++ ) {		
            char c = identifier.charAt(i);			
            if(!Character.isLetter(c) || c != '_') {				
                return true;			
                }		
            }		
        return false;	
        }	
    private static boolean hasKebabCase(String identifier) {	
        if (identifier.startsWith("-")) 
            identifier = identifier.substring(1);		
        return identifier.indexOf('-') > 0;
        }	
    private static String replaceByCamelCase(String identifier) {	
        identifier = identifier.replaceAll("-", " ");		
        StringBuilder sb = new StringBuilder();		
        String[] strs = identifier.split(" ");			
        for (int i = 0; i < strs.length; i++) {		
            if (i > 0) {			
                Character.toUpperCase(strs[i].charAt(0));		
                strs[i] = Character.toUpperCase(strs[i].charAt(0)) +strs[i].substring(1);			
                }			
            sb.append(strs[i]);		
            }		
        return sb.toString();	
        }	
    private static boolean hasEmptySpaces(String identifier) {		
        return identifier.indexOf(' ') >= 0;	
        }	
    private static String replaceByUnderscore(String identifier, char underscore) {		           StringBuilder sb = new StringBuilder();		
          for (char c : identifier.toCharArray()) {			
              if (c == ' ') sb.append(underscore);			
              else sb.append(c);		
              }		
        return sb.toString();	
        }
    	private static boolean hasCtrlChars(String identifier) {		
            for (int i = 0; i < identifier.length(); i++) {		
                char ch = identifier.charAt(i);		
                if ((ch >= 0 && ch <=32) || ch == 127) return true;		
                }		
            return false;	
            }		
    private static String replaceByCtrlStr(String identifier) {		
        StringBuilder sb = new StringBuilder();		
        for (int i = 0; i < identifier.length(); i++) {		
            char ch = identifier.charAt(i);			
            if ((ch >= 0 && ch <=32) || ch == 127) {			
                sb.append("CTRL");		
            } else {				
                sb.append(ch);			
                }		
            }			
        return sb.toString();	
        }
}
