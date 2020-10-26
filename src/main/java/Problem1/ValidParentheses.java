package Problem1;

public class ValidParentheses {

    // Do not change signature (function name, parameters, return type)
    public static boolean isValid(String str) {
        // homework
        // !!! must use ArrayStack or LinkedListStack from problem 1
        //with help from: https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/

        if(str == null){    //if null is passed, this is true
            return true;
        }

        int length = str.length();                              //length of string
        ArrayStack<String> charStack = new ArrayStack(length);  //stack of chars for open parentheses

        //create a character stack
        for(int i = 0; i < length; i++){                        //for the length of the string
            char par = str.charAt(i);                           //single char in string at index i

            if (par == '(' || par == '[' || par == '{'){        //if a valid OPEN parentheses, continues if closing
                charStack.push(String.valueOf(par));            //add to the stack
                continue;                                       //skip the rest of the for loop and reiterate
            }

            if(charStack.size() == 0){                      //checks if the stack is empty
                return false;                               //if an odd number, the string is unbalanced
            }

            //switch case to check for CLOSING brackets
            //continues if par is not a closing bracket
            char open;     //holds the open bracket
            switch(par){
                case ')':
                    open = charStack.pop().charAt(0);   //takes the last item in the stack
                    if (open == '[' || open == '{'){    //invalid opens are '{' and '['
                        return false;
                    }
                    break;
                case ']':
                    open = charStack.pop().charAt(0);
                    if (open == '(' || open == '{'){    //invalid opens are '(' and '{'
                        return false;
                    }
                    break;
                case '}':
                    open = charStack.pop().charAt(0);
                    if (open == '[' || open == '('){    //invalid opens are '(' and '['
                        return false;
                    }
                    break;
                default:                                //if not a valid char
                    return false;
            }
        }

        return (charStack.size() == 0); // if the stack is empty and all valid pairs are found
    }
}
