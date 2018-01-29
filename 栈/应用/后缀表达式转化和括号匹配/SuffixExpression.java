import java.util.Stack;

public class SuffixExpression {
    public static int priority(char c){
        if(c=='^')   //幂运算优先级最高为3
            return 3;
        else if(c=='*'||c=='/'||c=='%')//乘、除、求余优先级为2
            return 2;
        else if(c=='+'||c=='-')//加、减优先级为1
            return 1;
        else //其他字符为0
            return 0;
    }
    public static boolean isLeftParentheses(char c){

        return c=='('||c=='['||c=='{';
    }
    public static boolean isRightParentheses(char c){

        return c==')'||c==']'||c=='}';
    }
    public static String turnToSuffixExpression(String expression){  //转化为后缀表达式
        StringBuffer suffixExpression = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        char[] charArray = expression.toCharArray();
        for(char c : charArray){
            if(isLeftParentheses(c))   //等于（ 入栈
                stack.push(c);
            if(isRightParentheses(c)){ //等于 ） 把栈中（ 后边的元素弹出
                if(stack.peek()!='('){
                    suffixExpression.append(stack.pop().charValue());  //除了括号都进入后缀表达式
                }
                stack.pop();
            }
            if(!isRightParentheses(c)&&!isLeftParentheses(c)){ //当不是括号的时候
                int i = priority(c);
                if(i==0)  //当为字符的时候直接写入后缀表达式
                    suffixExpression.append(c);
                else {   //1.当前优先级比栈顶元素优先级高入栈 2.当前优先级小于等于栈顶元素优先级弹出栈顶元素
                    if(stack.isEmpty()||priority(c)>priority(stack.peek()))
                        stack.push(c);
                    else{
                        while(!stack.isEmpty()&&priority(c)<=priority(stack.peek())){//弹出栈中所有比当前字符优先级高的符号
                            suffixExpression.append(stack.pop().charValue());//弹出后加入到后缀表达式中
                        }
                        stack.push(c);  //所有比当前字符优先级大的被弹出后，当前字符入栈
                    }
                }
            }
        }
        while (!stack.isEmpty())   //等到遍历完一遍字符串后将栈中的所有符号按顺序加入到后缀表达式中
            suffixExpression.append(stack.pop().charValue());
        return suffixExpression.toString();
    }
    public static boolean isTrueParentheses(String expression){  //括号匹配
        char[] chararray = expression.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : chararray){
            if(isLeftParentheses(c))  //左括号直接压入栈中
                stack.push(c);
            if(isRightParentheses(c)){  //右括号的时候与栈顶元素进行匹配
                if(stack.empty())   //如果栈为空，匹配失败
                    return false;
                if((c==')'&&stack.peek().equals('('))||(c==']'&&stack.peek().equals('['))||(c=='}'&&stack.peek().equals('{'))){
                    stack.pop();  // 匹配成功，栈顶元素的左括号出栈，匹配下一个括号
                }
            }
        }
        if(!stack.empty())  //匹配完毕后，栈中如果还有左括号匹配失败
            return false;
        return true;
    }
    public static void main(String args[]){
        System.out.println(turnToSuffixExpression("(A+B)*(C-D)/E^F+G%H"));
        System.out.print(isTrueParentheses("a=(b+c)*[a+d]"));
    }
}
